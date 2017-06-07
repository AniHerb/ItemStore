package ua.itemstore.enums;

public enum StatusEnum {
    CREATED,ERROR;

    private String error = null;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
