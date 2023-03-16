package br.ufac.adotapet.model;

public enum AdoptionStatus {
    submitted("ENVIADO"),
    in_analysis("EM ANÁLISE"),
    accepted("ACEITO"),
    rejected("NÃO ACEITO");

    private final String description;

    AdoptionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
