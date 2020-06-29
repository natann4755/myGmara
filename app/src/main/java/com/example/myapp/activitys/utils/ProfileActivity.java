package com.example.myapp.activitys.utils;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.model.Daf;
import com.example.model.Profile;
import com.example.myapp.R;
import com.example.myapp.databinding.ActivityProfileBinding;
import com.example.myapp.utils.Language;
import com.example.myapp.utils.ManageSharedPreferences;

import java.util.ArrayList;


import static com.example.myapp.activitys.utils.SplashActivity.KEY_EXTRA_List1;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    private ArrayList <Daf> mListLearning = new ArrayList<>();
    private Profile mProfile = new Profile(0);
    private String mStringTypeOfStudy;

    private RecyclerView myRecyclerViewStudyOptions;


    private Button changeLanguageButton;
    private RadioGroup changeLanguageRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initListener();
    }

    private void initViews() {
        myRecyclerViewStudyOptions = binding.myRecyclerView;
//      changeLanguageButton = binding.profileChangeLanguageBU;
//      changeLanguageRadioGroup = binding.ProfileChangeLanguageRG;
    }

    private void initListener() {
//        changeLanguageButton.setOnClickListener(v -> onRadioButtonLanguageClicked(v));
        binding.profileDLETEBU.setOnClickListener(v -> DLETEButtonTypeOfStudyClicked(v));
        binding.ProfileCreateLearningBU.setOnClickListener(v -> createLearningClicked(v));
    }

    private void createLearningClicked(View v) {
        onRadioNumberOfReps();
        initListLearning();
        alertDialogAreYouSure();
    }

    private void initListLearning() {
        for (int i = 2; i <158 ; i++) {
            mListLearning.add(new Daf("שבת",i));
        }
        ManageSharedPreferences.saveArrayList(mListLearning,getBaseContext());
    }

    private void alertDialogAreYouSure() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        ManageSharedPreferences.setProfile(mProfile,getBaseContext());
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        intent.putExtra(KEY_EXTRA_List1, mListLearning);
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.dismiss();
                        break;
                }
            }
        };

        String typeOfStudy =  "מסוג: " + mStringTypeOfStudy;
        String numberOfReps =  "חזרות: " + mProfile.getNumberOfReps();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ברצונך ליצור לימוד יומי");
        builder.setMessage(typeOfStudy +"\n"+ numberOfReps);
        builder.setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    private void DLETEButtonTypeOfStudyClicked(View v) {
        mProfile.setTypeOfStudy("שבת");
        mStringTypeOfStudy = "שבת";
    }

    private void setAppLanguage(String language) {
        Language.setAppLanguage(language,getApplicationContext());
        Toast.makeText(getBaseContext(),getBaseContext().getString(R.string.profile_choose_language) , Toast.LENGTH_SHORT).show();
    }


//    public void onRadioButtonLanguageClicked(View view) {
//        int selectedId = changeLanguageRadioGroup.getCheckedRadioButtonId();
//        switch (selectedId) {
//            case R.id.radio_Hebrew:
//                    setAppLanguage("he");
//                    mProfile.setLanguage("he");
//                    break;
//            case R.id.radio_English:
//                    setAppLanguage("en");
//                    mProfile.setLanguage("en");
//                    break;
//        }
//    }

    public void onRadioNumberOfReps () {
        int selectedId = binding.ProfileNumberOfRepsRG.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.radio_No_thanks:
                mProfile.setNumberOfReps(0);
                break;
            case R.id.radio_Once:
                mProfile.setNumberOfReps(1);
                break;
            case R.id.radio_Twice:
                mProfile.setNumberOfReps(2);
                break;
            case R.id.radio_3_times:
                mProfile.setNumberOfReps(3);
                break;
        }
    }





}