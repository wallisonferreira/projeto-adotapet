package br.ufac.adotapet.dto.reponses;

public class ResponseDataGeneral<T> {

    private final T data;
    private final String message;

    public ResponseDataGeneral(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getAdoption() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
