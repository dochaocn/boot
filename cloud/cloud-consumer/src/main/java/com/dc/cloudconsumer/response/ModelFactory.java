package com.dc.cloudconsumer.response;

public class ModelFactory {

    public static ResponseModel newResponseModel() {
        return new ResponseModel();
    }

    public static ResponseModel newSuccessResponseModel() {
        return newResponseModel().setCode(ResponseStatus.SUCCESS.getCode());
    }

    public static ResponseModel newErrorResponseModel() {
        return newResponseModel().setCode(ResponseStatus.ERROR.getCode());
    }

}
