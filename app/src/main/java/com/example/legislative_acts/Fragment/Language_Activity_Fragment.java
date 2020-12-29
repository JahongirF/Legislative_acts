package com.example.legislative_acts.Fragment;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.example.legislative_acts.DialogDismisListener;
import com.example.legislative_acts.R;
import com.google.android.material.navigation.NavigationView;
import com.idrok.a3003.data.LanguageChanger;
import com.idrok.a3003.model.local.LocalStorage;

import java.util.Locale;

public class Language_Activity_Fragment extends DialogFragment {

    private Button button_uzb;
    private Button button_rus;
    private Button button_kir;
    private String text;
    private NavigationView navigationView;
    private DialogDismisListener listener;


    public Language_Activity_Fragment(DialogDismisListener dialogDismisListener) {
        this.listener = dialogDismisListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        Dialog dialog = getDialog();
        dialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.button_lang_bg));


        final View view = inflater.inflate(R.layout.dialog_fragment_language, container, false);

        button_uzb = view.findViewById(R.id.button_uzb);
        button_rus = view.findViewById(R.id.button_rus);
        button_kir = view.findViewById(R.id.button_kir);
        navigationView = view.findViewById(R.id.nav_view);


        final Bundle bundle = new Bundle();

        SharedPreferences sharedPreferences_lang = PreferenceManager.getDefaultSharedPreferences(getContext());
        String lang = sharedPreferences_lang.getString("language", "kir");
        button_uzb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("hello", "uz");
                sharedPreferences_lang.edit().putString("lang", "uz").apply();
                LocalStorage.instance.setLanguage("uz");
                LanguageChanger languageChanger = new LanguageChanger(requireActivity());
                languageChanger.setLanguage();

                Fragment_Main_Activity main_activity_fragment = new Fragment_Main_Activity();
                main_activity_fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, main_activity_fragment).commit();
                listener.dialogDismiss();
                dismiss();

            }
        });

        button_rus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("hello", "rus");

                sharedPreferences_lang.edit().putString("lang", "rus").apply();
                LocalStorage.instance.setLanguage("rus");
                LanguageChanger languageChanger = new LanguageChanger(requireActivity());
                languageChanger.setLanguage();

                Fragment_Main_Activity main_activity_fragment = new Fragment_Main_Activity();
                main_activity_fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, main_activity_fragment).commit();
                listener.dialogDismiss();
                dismiss();
            }
        });

        button_kir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("hello", "kir");
                sharedPreferences_lang.edit().putString("lang", "kir").apply();
                LocalStorage.instance.setLanguage("kir");
                LanguageChanger languageChanger = new LanguageChanger(requireActivity());
                languageChanger.setLanguage();
                Fragment_Main_Activity main_activity_fragment = new Fragment_Main_Activity();
                main_activity_fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, main_activity_fragment).commit();
                listener.dialogDismiss();
                dismiss();
            }
        });


        return view;
    }

    private void setLang() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String lang = sharedPreferences.getString("lang", "rus");
        Locale locale = new Locale(lang);

        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        getContext().createConfigurationContext(configuration);
    }


}
