package br.ufac.adotapet.dto.reponses;

import java.util.List;

import br.ufac.adotapet.model.VaccinationRecord;

public class ResponseDataVaccine {

    private final List<VaccinationRecord> vaccinationRecords;
    private final String message;

    public ResponseDataVaccine(List<VaccinationRecord> vaccinationRecords, String message) {
        this.vaccinationRecords = vaccinationRecords;
        this.message = message;
    }

    public List<VaccinationRecord> getVaccinationRecords() {
        return vaccinationRecords;
    }

    public String getMessage() {
        return message;
    }
}
