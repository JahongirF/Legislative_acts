package com.example.legislative_acts.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.legislative_acts.R;

public class About_Activity_Fragment extends Fragment {

    private ImageView imageView;
    private ImageView imageView_phone;
    private static final int REQUEST_CALL = 1;
    private TextView textView_phone;
    private TextView textView_phone_2;
    private LinearLayout call_id;
    private LinearLayout call_id_2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_fragment, container, false);



        imageView = view.findViewById(R.id.mapID);
        imageView_phone = view.findViewById(R.id.phone_id);
        textView_phone = view.findViewById(R.id.phone_number_id);
        textView_phone_2 = view.findViewById(R.id.phone_2_number_id);
        call_id = view.findViewById(R.id.call_id);
        call_id_2 = view.findViewById(R.id.call_2_id);
        call_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneCall();
            }
        });
        call_id_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneCall_2();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MapActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

    private void phoneCall() {

        String phone = textView_phone.getText().toString().trim();
        if (phone.length() > 0)
        {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            else {
                String dial = "tel:" + phone;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        }
        else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    private void phoneCall_2() {

        String phone = textView_phone_2.getText().toString().trim();
        if (phone.length() > 0)
        {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            else {
                String dial = "tel:" + phone;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        }
        else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                phoneCall();
            }
            else {
                Toast.makeText(getContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
