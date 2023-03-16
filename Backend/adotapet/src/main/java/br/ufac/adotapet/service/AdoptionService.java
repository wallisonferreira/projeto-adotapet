package br.ufac.adotapet.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import br.ufac.adotapet.dto.reponses.ResponseAdoptionDTO;
import br.ufac.adotapet.dto.requests.QuestionAnswerDTO;
import br.ufac.adotapet.dto.requests.RequestAdoptionDTO;
import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.model.AdoptionStatus;
import br.ufac.adotapet.model.Answer;
import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.model.User;
import br.ufac.adotapet.repository.AdoptionRepository;
import br.ufac.adotapet.repository.AnswerRepository;

@Service
public class AdoptionService implements ICrudService<Adoption> {

    private final AdoptionRepository adoptionRepository;
    private final AnswerRepository answerRepository;

    public AdoptionService(
            AdoptionRepository adoptionRepository,
            AnswerRepository answerRepository) {

        this.adoptionRepository = adoptionRepository;
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
        return adoptionRepository.existsByUserOwner_IdAndPetAdopted_Id(user_id, pet_id);
    }

    /**
     * Get a list of adoption requests of a specified user.
     * 
     * @param userOwner
     * @return
     */
    public List<Adoption> findAdoptionByUserOwner(User userOwner) {
        return adoptionRepository.findByUserOwner(userOwner);
    }

    /**
     * User requests adoption of a specific animal/pet.
     * 
     * @param user
     * @param pet
     * @param requestAdoption
     * @return
     */
    @Transactional
    public ResponseAdoptionDTO createAdoption(User user, Pet pet, RequestAdoptionDTO requestAdoption) {

        List<QuestionAnswerDTO> questionAnswer = requestAdoption.getQuestionAnswer();

        try {
            Adoption adoption = new Adoption();
            adoption.setUserOwner(user);
            adoption.setPetAdopted(pet);
            adoption.setReqCode(UUID.randomUUID().toString());
            adoption.setReqStatus("ENVIADO");

            Adoption adoptionSaved = adoptionRepository.save(adoption);

            for (QuestionAnswerDTO qAnswer : questionAnswer) {
                Answer answer = new Answer();
                answer.setAdoption(adoptionSaved);
                answer.setQuestion(qAnswer.getQuestion());
                answer.setText(qAnswer.getText());
                answerRepository.save(answer);
            }

            Adoption adoptionPersisted = adoptionRepository.findById(adoptionSaved.getId()).orElse(adoptionSaved);

            ResponseAdoptionDTO responseAdoptionDTO = new ResponseAdoptionDTO();
            responseAdoptionDTO.setId(adoptionPersisted.getId());
            responseAdoptionDTO.setAdoptionActive(adoptionPersisted.getAdoptionActive());
            responseAdoptionDTO.setAdoptionDate(adoptionPersisted.getAdoptionDate());
            responseAdoptionDTO.setReqCode(adoptionPersisted.getReqCode());
            responseAdoptionDTO.setReqStatus(adoptionPersisted.getReqStatus());
            responseAdoptionDTO.setPetAdopted(adoptionPersisted.getPetAdopted());
            responseAdoptionDTO.setUserOwner(adoptionPersisted.getUserOwner());
            responseAdoptionDTO.setAnswers(adoptionPersisted.getAnswers());
            responseAdoptionDTO.setReason(adoptionPersisted.getReason());

            return responseAdoptionDTO;

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return null;
    }

    /**
     * Mapeia o valor da string para o enum
     * 
     * @param statusString
     * @return
     */
    public static String getAdoptionStatusFromString(String statusString) {
        for (AdoptionStatus status : AdoptionStatus.values()) {
            if (status.name().toString().equals(statusString)) {
                return status.getDescription();
            }
        }
        // Se chegou aqui, a string não corresponde a nenhum item do enum
        throw new IllegalArgumentException("Status inválido: " + statusString);
    }

    public ResponseAdoptionDTO changeStatusOfRequestAdoption(
            Long adoptionId,
            String newStatus,
            String reason) {

        try {
            Adoption adoption = adoptionRepository.findById(adoptionId).orElseThrow(null);

            adoption.setReqStatus(getAdoptionStatusFromString(newStatus));
            adoption.setReason(reason);

            Adoption adoptionSaved = adoptionRepository.save(adoption);

            ResponseAdoptionDTO responseAdoptionDTO = new ResponseAdoptionDTO();
            responseAdoptionDTO.setId(adoptionSaved.getId());
            responseAdoptionDTO.setAdoptionActive(adoptionSaved.getAdoptionActive());
            responseAdoptionDTO.setAdoptionDate(adoptionSaved.getAdoptionDate());
            responseAdoptionDTO.setReqCode(adoptionSaved.getReqCode());
            responseAdoptionDTO.setReqStatus(adoptionSaved.getReqStatus());
            responseAdoptionDTO.setPetAdopted(adoptionSaved.getPetAdopted());
            responseAdoptionDTO.setUserOwner(adoptionSaved.getUserOwner());
            responseAdoptionDTO.setAnswers(adoptionSaved.getAnswers());
            responseAdoptionDTO.setReason(adoptionSaved.getReason());

            return responseAdoptionDTO;

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return null;
    }

    public Page<Adoption> findAllFromOng(Long userId, Pageable pageable) {

        return adoptionRepository.findByPetUser_Id(userId, pageable);
    }

    @Override
    public List<Adoption> getAll() {
        return adoptionRepository.findAll();
    }

    @Override
    public Adoption getById(Long id) {
        return adoptionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Adoption> getByAll(String term) {
        return null;
    }

    @Override
    public Adoption save(Adoption object) {

        return adoptionRepository.save(object);
    }

    @Override
    public Adoption save(Adoption object, Long id) {
        object.setId(id);
        return adoptionRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        adoptionRepository.deleteById(id);
    }

}
