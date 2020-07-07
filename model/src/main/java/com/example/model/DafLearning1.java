package com.example.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DafLearning1 implements Parcelable {
    @PrimaryKey
    private int id;
    private String masechet;
    private int pageNumber;
    private boolean isLearning;
    private int chazara;
    private boolean isLearningPage1;
    private boolean isLearningPage2;

    public DafLearning1(String masechet, int pageNumber, int id ) {
        this.masechet = masechet;
        this.pageNumber = pageNumber;
        this.id = id;
    }


    protected DafLearning1(Parcel in) {
        id = in.readInt();
        masechet = in.readString();
        pageNumber = in.readInt();
        isLearning = in.readByte() != 0;
        chazara = in.readInt();
        isLearningPage1 = in.readByte() != 0;
        isLearningPage2 = in.readByte() != 0;
    }

    public static final Creator<DafLearning1> CREATOR = new Creator<DafLearning1>() {
        @Override
        public DafLearning1 createFromParcel(Parcel in) {
            return new DafLearning1(in);
        }

        @Override
        public DafLearning1[] newArray(int size) {
            return new DafLearning1[size];
        }
    };

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(masechet);
        dest.writeInt(pageNumber);
        dest.writeByte((byte) (isLearning ? 1 : 0));
        dest.writeInt(chazara);
        dest.writeByte((byte) (isLearningPage1 ? 1 : 0));
        dest.writeByte((byte) (isLearningPage2 ? 1 : 0));
    }
}
