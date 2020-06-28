package com.example.model;

public class Daf {
    private String masechet;
    private int pageNumber;
    private boolean isLearning;
    private int chazara;
    private boolean isLearningPage1;
    private boolean isLearningPage2;

    public Daf(String masechet, int pageNumber) {
        this.masechet = masechet;
        this.pageNumber = pageNumber;
    }

    public String getMasechet() {
        return masechet;
    }

    public void setMasechet(String masechet) {
        this.masechet = masechet;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isLearning() {
        return isLearning;
    }

    public void setLearning(boolean learning) {
        isLearning = learning;
    }

    public int getChazara() {
        return chazara;
    }

    public void setChazara(int chazara) {
        this.chazara = chazara;
    }

    public boolean isLearningPage1() {
        return isLearningPage1;
    }

    public void setLearningPage1(boolean learningPage1) {
        isLearningPage1 = learningPage1;
    }

    public boolean isLearningPage2() {
        return isLearningPage2;
    }

    public void setLearningPage2(boolean learningPage2) {
        isLearningPage2 = learningPage2;
    }
}
