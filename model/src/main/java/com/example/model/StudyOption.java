package com.example.model;

public class StudyOption {
    private String nameStudyOption;
    private boolean isOpen = false;

    public StudyOption(String nameStudyOption) {
        this.nameStudyOption = nameStudyOption;
    }

    public String getNameStudyOption() {
        return nameStudyOption;
    }

    public void setNameStudyOption(String nameStudyOption) {
        this.nameStudyOption = nameStudyOption;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
