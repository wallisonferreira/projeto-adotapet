package br.ufac.adotapet.dto.mappers;

import org.modelmapper.PropertyMap;

import br.ufac.adotapet.dto.reponses.PetRegisteredDTO;
import br.ufac.adotapet.model.Pet;

public class PetRegisteredPropertyMap extends PropertyMap<Pet, PetRegisteredDTO> {
    @Override
    protected void configure() {
        map().setOwner(source.getUser());
    }
}
