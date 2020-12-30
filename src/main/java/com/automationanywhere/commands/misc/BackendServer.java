package com.automationanywhere.commands.misc;

public class BackendServer {
    public String getURL() {
        return URL;
    }

    private String URL;

    public BackendServer(String BackendURL){
        this.URL = BackendURL;
    }
}
