package br.ufac.adotapet.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import br.ufac.adotapet.dto.requests.QuestionAnswerDTO;
import br.ufac.adotapet.dto.requests.RequestAdoptionDTO;
import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.Answer;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.repository.AnswerRepository;
import br.ufac.adotapet.repository.UserAdoptionPetRepository;

@Service
public class UserAdoptionPetService {

    UserAdoptionPetRepository userAdoptionPetRepository;
    AnswerRepository answerRepository;

    public UserAdoptionPetService(
            UserAdoptionPetRepository userAdoptionPetRepository,
            AnswerRepository answerRepository) {
        this.userAdoptionPetRepository = userAdoptionPetRepository;
        this.answerRepository = answerRepository;
    }

    /**
     * Checks if the user already requested to adopts this specific animal.
     * 
     * @param user_id
     * @param pet_id
     * @return
     */
    public Boolean existsByUserAndPet(Long user_id, Long pet_id) {
        return userAdoptionPetRepository.existsByUserOwner_IdAndPetAdopted_Id(user_id, pet_id);
    }

    public List<Adoption> findAdoptionByUserOwner(User userOwner) {
        return userAdoptionPetRepository.findByUserOwner(userOwner);
    }

    @Transactional
    public Adoption createAdoption(User user, Pet pet, RequestAdoptionDTO requestAdoption) {

        List<QuestionAnswerDTO> questionAnswer = requestAdoption.getQuestionAnswer();

        try {
            Adoption adoption = new Adoption();
            adoption.setUserOwner(user);
            adoption.setPetAdopted(pet);
            adoption.setReqCode(UUID.randomUUID().toString());
            adoption.setReqStatus("ENVIADO");

            for (QuestionAnswerDTO qAnswer : questionAnswer) {
                Answer answer = new Answer();
                answer.setAdoption(adoption);
                answer.setQuestion(qAnswer.getQuestion());
                answer.setText(qAnswer.getText());

                answerRepository.save(answer);

                adoption.addAnswer(answer);
            }

            return userAdoptionPetRepository.save(adoption);

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return null;
    }

}
