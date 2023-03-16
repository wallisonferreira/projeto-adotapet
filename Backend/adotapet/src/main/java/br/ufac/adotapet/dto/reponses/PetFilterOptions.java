package br.ufac.adotapet.dto.reponses;

import java.util.List;

import br.ufac.adotapet.model.Color;
import br.ufac.adotapet.model.EPetSex;
import br.ufac.adotapet.model.Race;
import br.ufac.adotapet.model.Size;
import br.ufac.adotapet.model.Specie;
import lombok.Data;

@Data
public class PetFilterOptions {

    List<EPetSex> sex;

    List<Specie> specie;

    List<Race> race;

    List<Size> size;

    List<Color> color;

    public PetFilterOptions() {
    }

    public PetFilterOptions(
            List<EPetSex> sex,
            List<Specie> specie,
            List<Race> race,
            List<Size> size,
            List<Color> color) {

        this.sex = sex;
        this.specie = specie;
        this.race = race;
        this.size = size;
        this.color = color;
    }
}
