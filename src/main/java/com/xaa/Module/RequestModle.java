package com.xaa.Module;

public class RequestModle {
    private String url;
    private String mothod;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMothod() {
        return mothod;
    }

    public void setMothod(String mothod) {
        this.mothod = mothod;
    }

    public String getHeadrs() {
        return headrs;
    }

    public void setHeadrs(String headrs) {
        this.headrs = headrs;
    }

    public String getAgent() {
        return Agent;
    }

    public void setAgent(String agent) {
        Agent = agent;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    private String headrs;
    private String Agent;
    private String json;
}
