package com.example.kerem.traderproject.Model;

import com.google.gson.annotations.SerializedName;


public class Item {
    @SerializedName("Symbol")
    private String Symbol;
    private int Qty_T2;
    private double LastPx;

    public String getSymbol() {
        return Symbol;
    }

    public int getQty_T2() {
        return Qty_T2;
    }

    public double getLastPx() {
        return LastPx;
    }
}
