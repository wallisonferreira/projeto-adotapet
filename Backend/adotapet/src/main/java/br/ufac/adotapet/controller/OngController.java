package br.ufac.adotapet.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.adotapet.dto.reponses.ResponseAdoptionDTO;
import br.ufac.adotapet.dto.requests.AnswerDTO;
import br.ufac.adotapet.model.Adoption;
import br.ufac.adotapet.projections.CountPetByOng;
import br.ufac.adotapet.projections.FeedPets;
import br.ufac.adotapet.security.services.UserDetailsImpl;
import br.ufac.adotapet.service.AdoptionService;
import br.ufac.adotapet.service.OngService;

@RestController
@RequestMapping("/ong")
public class OngController {

    private final OngService ongService;
    private final AdoptionService adoptionService;

    public OngController(OngService ongService, AdoptionService adoptionService) {
        this.ongService = ongService;
        this.adoptionService = adoptionService;
    }

    @GetMapping("/countpets")
    public ResponseEntity<List<CountPetByOng>> getCountPetsByOng() {
        List<CountPetByOng> users = ongService.getCountPetsByOng();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/feedpets")
    public ResponseEntity<List<FeedPets>> getFeedPets() {
        List<FeedPets> feedPets = ongService.getFeedPets();
        return new ResponseEntity<>(feedPets, HttpStatus.OK);
    }

    @GetMapping("/list-status")
    public ResponseEntity<List<String>> getListStatus() {
        return new ResponseEntity<>(List.of(
                "submitted",
                "in_analysis",
                "accepted",
                "rejected"), HttpStatus.OK);
    }

    @RequestMapping(value = "/adoption/{adoptionId}/change-status", method = RequestMethod.POST)
    public ResponseEntity<ResponseAdoptionDTO> changeStatus(
            @RequestParam("status") String status,
            @PathVariable("adoptionId") Long adoptionId,
            Authentication authentication,
            @RequestBody AnswerDTO object) {

        try {
            UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResponseAdoptionDTO adoption = adoptionService.changeStatusOfRequestAdoption(
                adoptionId, status, object.getText());

        return new ResponseEntity<>(adoption, HttpStatus.OK);
    }

    // TODO: creates a route to activate a adoption

    @GetMapping("/list-adoption-requests")
    public ResponseEntity<Page<Adoption>> findAllFromOng(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort,
            Authentication authentication) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        Page<Adoption> adoptions = adoptionService.findAllFromOng(userDetailsImpl.getId(), pageable);

        return new ResponseEntity<>(adoptions, HttpStatus.OK);
    }
}
