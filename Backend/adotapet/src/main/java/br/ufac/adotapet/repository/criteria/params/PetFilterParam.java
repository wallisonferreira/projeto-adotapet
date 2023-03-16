package br.ufac.adotapet.repository.criteria.params;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.EPetSex;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import lombok.Data;

@Data
public class PetFilterParam {

    private EPetSex sex;
    private Color color;
    private Size size;
    private Race race;
    private Specie specie;
}
