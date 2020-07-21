package com.example.myapp.utils;

public class UtilsCalender {

//    public static String convertDateToHebrewDate(int year, int month, int day){
//
//    }

    public static String fixFormatDate(int num){
        if (num < 10){
            return  "0" + num;
        }else {
            return num+"";
        }
    }

}
