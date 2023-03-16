package br.ufac.adotapet.dto.mappers;

import org.modelmapper.PropertyMap;

import br.ufac.adotapet.dto.reponses.PetWithOwnerDTO;
import br.ufac.adotapet.model.Pet;

public class PetPropertyMap extends PropertyMap<Pet, PetWithOwnerDTO> {
    @Override
    protected void configure() {
        map().setOwner(source.getUser());
    }
}
