package br.ufac.adotapet.repository.criteria;

import java.util.List;

import br.ufac.adotapet.model.Pet;
import br.ufac.adotapet.repository.criteria.params.PetFilterMultiParam;
import br.ufac.adotapet.repository.criteria.params.PetFilterParam;

public interface PetRepositoryCustom {

    List<Pet> getWithFilter(PetFilterParam params);

    List<Pet> getWithMultiFilter(PetFilterMultiParam params);
}
