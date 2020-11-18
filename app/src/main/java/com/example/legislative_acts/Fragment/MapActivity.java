package com.example.legislative_acts.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.legislative_acts.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng latLng = new LatLng(41.317680, 69.272164);
        map.addMarker(new MarkerOptions().position(latLng).title("Tashkent"));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));
    }
}