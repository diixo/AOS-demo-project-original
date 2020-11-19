package edu.ttu;

public class GenericResult {
    private int statusCode = 0;
    private String message;

    public GenericResult(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
