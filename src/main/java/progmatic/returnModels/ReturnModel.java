package progmatic.returnModels;

import org.springframework.http.HttpStatus;

public class ReturnModel<T> {

    private boolean success;
    private HttpStatus statusCode;

    private T object;

    public ReturnModel() {
    }

    public ReturnModel(boolean success, HttpStatus statusCode, T object) {
        this.success = success;
        this.statusCode = statusCode;
        this.object = object;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
