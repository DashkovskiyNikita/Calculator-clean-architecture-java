package com.androiddev.calculator.calculator.result;

public class Result {

    private Success<String> success;
    private Error<Throwable> error;

    private final Object result;

    public Result(Object result) {
        this.result = result;
    }

    public static Result success(String result) {
        return new Result(result);
    }

    public static Result error(Throwable result) {
        return new Result(result);
    }

    public String getOrNull(){
        return result instanceof String ? (String) result : null;
    }

    public Result onSuccess(Success<String> success) {
        if (result instanceof String)
            success.apply((String) result);
        return this;
    }
    public Result onError(Error<Throwable> error) {
        if (result instanceof Throwable)
            error.apply((Throwable) result);
        return this;
    }
}
