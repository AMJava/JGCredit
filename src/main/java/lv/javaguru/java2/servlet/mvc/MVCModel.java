package lv.javaguru.java2.servlet.mvc;

public class MVCModel {

    private Object data;
    private String viewName;
    private String message;
    private Object error;

    public MVCModel(Object data, String viewName, String message, Object error) {
        this.data = data;
        this.viewName = viewName;
        this.message = message;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public String getViewName() {
        return viewName;
    }

    public String getMessage() {
        return message;
    }

    public Object getError() {
        return error;
    }

}
