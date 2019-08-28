package com.example.kerem.traderproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSON {
    @SerializedName("DefaultAccount")
    private String account;

    @SerializedName("Result")
    Result result;

    @SerializedName("Item")
    List<Item> items;

    public List<Item> getItems() {  return items;  }

    public String getAccount() {
        return account;
    }

    public Result getResult() { return result; }


}
