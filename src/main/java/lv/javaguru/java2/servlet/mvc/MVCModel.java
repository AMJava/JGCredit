package lv.javaguru.java2.servlet.mvc;

public class MVCModel {

    private Object data;
    private String viewName;
    private String message;

    public MVCModel(Object data, String viewName, String message) {
        this.data = data;
        this.viewName = viewName;
        this.message = message;
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
}
