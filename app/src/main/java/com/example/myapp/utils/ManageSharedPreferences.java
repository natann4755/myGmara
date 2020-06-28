package com.example.myapp.utils;

import android.content.Context;
import com.example.model.Daf;
import com.example.model.Profile;


import java.util.ArrayList;

public class ManageSharedPreferences {
    public static String KEY_haveProfile = "KEYisConnected";
    public static String KEY_ListLearning = "ListLearning";


    public static void setProfile (Profile profile, Context context) {

        InstanceSharedPreferences.getInstance(context).setProperty(KEY_haveProfile, profile);

    }

    public static Profile getProfile(Context context) {
        Profile profile = InstanceSharedPreferences.getInstance(context)
                .getProfile(KEY_haveProfile);
        return profile;

    }

    public static void saveArrayList (ArrayList<Daf> list, Context context) {
        InstanceSharedPreferences.getInstance(context)
                .setArrayList(list, KEY_ListLearning);
    }

    public ArrayList<Daf> getArrayList(Context context){
        ArrayList mArrayList =  InstanceSharedPreferences.getInstance(context)
                .getArrayList(KEY_ListLearning);
        return mArrayList;
    }

}
