package lv.javaguru.java2.dto;

public class MVCModel {

    private Object data;
    private Object error;

    public MVCModel(Object data, Object error) {
        this.data = data;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public Object getError() {
        return error;
    }

}
