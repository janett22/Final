package com.example.plantilla.ui.Ubicacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.plantilla.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UbicacionFragment extends Fragment implements OnMapReadyCallback{

    private GoogleMap mapa;

    private static final LatLng INMOBILIARIA = new LatLng(-33.2962201, -66.3379856);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        View view = inflater.inflate(R.layout.fragment_ubicacion, container, false);
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_home)).getMapAsync( this);


        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        CameraPosition camPos =  new CameraPosition.Builder()
                .target(INMOBILIARIA)
                .zoom(19)
                .bearing(90)
                .tilt(70)
                .build();

        CameraUpdate camUpdICT = CameraUpdateFactory.newCameraPosition(camPos);

        mapa.animateCamera(camUpdICT);

        mapa.addMarker(
                new MarkerOptions()
                        .position(INMOBILIARIA))
                .setTitle("Inmobiliaria AGV");

    }
}
