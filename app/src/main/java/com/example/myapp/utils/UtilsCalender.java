package com.example.myapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtilsCalender {

//    public static String convertDateToHebrewDate(int year, int month, int day){
//
//    }



    public static int[] catStringData(String date){
        char [] charDateInts = date.toCharArray();
        int [] mIntDate = new int[3];
        int placeInArray = 0;
        String mDate ="";
        for (int i = 0; i <charDateInts.length ; i++) {
            String mChar = String.valueOf(charDateInts[i]);
            if (mChar.equals("0") && mDate.length()==0){
                continue;
            }
            if (mChar.equals("/")){
                mIntDate [placeInArray] = Integer.parseInt(mDate);
                placeInArray ++;
                mDate = "";
            }else {
                mDate += String.valueOf(charDateInts[i]);
            }
        }
        mIntDate [placeInArray] = Integer.parseInt(mDate);
        return mIntDate;
    }

    public static String dateStringFormat(Calendar c){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(c.getTime());
    }
}
