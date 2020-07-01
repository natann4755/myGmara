package com.example.model.shas_masechtot_list_models;

import java.util.List;

public class SederItem {

//    @SerializedName("name")
    private String name;

//    @SerializedName("masechet")
    private List<MasechetItem> masechtot;

    public String getName() {
        return name;
    }

    public SederItem(String name, List<MasechetItem> masechet) {
        this.name = name;
        this.masechtot = masechet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MasechetItem> getMasechet() {
        return masechtot;
    }

    public void setMasechet(List<MasechetItem> masechet) {
        this.masechtot = masechet;
    }
}
