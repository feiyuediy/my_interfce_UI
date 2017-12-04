package com.xaa.Module;

import java.util.List;
import java.util.Map;

public class HttpMoudle {
    private String name;
    private Map<String, Object> request;
    private Map<String, Object> validators;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public Map<String, Object> getValidators() {
        return validators;
    }

    public void setValidators(Map<String, Object> validators) {
        this.validators = validators;
    }

    @Override
    public String toString() {
        return "Me{" +
                "name=" + name +
                ", request='" + request + '\'' +
                ", validators=" + validators;
    }
}
