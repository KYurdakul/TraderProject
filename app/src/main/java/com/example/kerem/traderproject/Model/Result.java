package com.example.kerem.traderproject.Model;

public class Result{
    private String Description;
    private String State;

    public String getDescription() {
        return Description;
    }

    public boolean getState() {
        return Boolean.parseBoolean(State);
    }
}
