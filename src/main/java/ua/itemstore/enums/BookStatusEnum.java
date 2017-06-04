package ua.itemstore.enums;

/**
 * Created by xnx_ on 01.06.2017.
 */
public enum  BookStatusEnum {
    CREATED,ERROR;

    private String error = null;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
