package com.example.myapp.utils;

import android.content.Context;

import com.example.model.Profile;

public class ManageSharedPreferences {
    public static String KEY_haveProfile = "KEYisConnected";


    public static void setProfile (Profile profile, Context context) {

        InstanceSharedPreferences.getInstance(context).setProperty(KEY_haveProfile, profile);

    }

    public static Profile getProfile(Context context) {
        Profile profile = InstanceSharedPreferences.getInstance(context)
                .getProfile(KEY_haveProfile);
        return profile;

    }

}
