package br.ufac.adotapet.repository.criteria.params;

import java.util.ArrayList;
import java.util.List;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.EPetSex;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import lombok.Data;

@Data
public class PetFilterMultiParam {

    private List<EPetSex> sex = new ArrayList<>();
    private List<Color> color = new ArrayList<>();
    private List<Size> size = new ArrayList<>();
    private List<Race> race = new ArrayList<>();
    private List<Specie> specie = new ArrayList<>();
}
