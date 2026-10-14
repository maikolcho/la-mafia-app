/*
 * Copyright (c)
 *  * "La Mafia se Sienta en la Mesa,Cordoba" - Todos los derechos reservados.
 *  * Título:       [La Mafia se Sienta en la Mesa,Cordoba]
 *  * Descripción:  [Restaurante Italiano]
 *  * Autor:        [Nelson Villalba Vergara]
 *  * Sitio web:    [La Mafia se Sienta en la Mesa,Cordoba]
 *  * Contacto:     [nelson_ariel@hotmail.es]
 *  * Fecha:        [2024]
 *  * Aviso Legal:
 *  * Este archivo y el código fuente adjunto son parte de [La Mafia se Sienta en la Mesa,Cordoba].
 *  * Todos los derechos sobre el código fuente, diseño y recursos visuales
 *  * pertenecen a [Nelson Villalba Vergara].
 *  * Queda prohibida la reproducción, distribución o modificación no autorizada
 *  * de este código fuente o cualquier otro componente de la aplicación.
 *  * [La Mafia se Sienta en la Mesa,Cordoba] es una marca registrada de [Nelson Villalba Vergara].
 *
 *
 */

package com.example.BottomNavigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lamafia.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;

public class InformacionFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private EditText txtLatitud, txtLongitud;


    public InformacionFragment() {

    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_informacion, container, false);


        // Inicializar las vistas
        txtLatitud = rootView.findViewById(R.id.txtLatitud);
        txtLongitud = rootView.findViewById(R.id.txtLongitud);

        // Configurar el botón de enviar email
        rootView.findViewById(R.id.btnemail).setOnClickListener(this::sendEmail);

        rootView.findViewById(R.id.btncall).setOnClickListener(this::callRestaurant);

        rootView.findViewById(R.id.btnmap).setOnClickListener(this::showRestaurantLocation);

        // Initialize the map fragment
        initializeMap();
        return rootView;
    }

    private void initializeMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }


    private void showRestaurantLocation(View view) {
        Uri uri = Uri.parse("https://www.google.com/maps?ll=37.89269,-4.783037&amp;z=16&amp;t=m&amp;hl=es-ES&amp;gl=ES&amp;mapclient=embed&amp;daddr=La+Mafia+se+Sienta+a+la+Mesa+Av.+del+Gran+Capit%C3%A1n,+46+14008+C%C3%B3rdoba@37.8926904,-4.7830366");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void callRestaurant(View view) {
        Uri uri = Uri.parse("tel:+34957401168");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    private void sendEmail(View view) {
        Uri uri = Uri.parse("mailto:cordoba@lamafia.es");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(intent);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(String.valueOf(latLng.latitude));
        txtLongitud.setText(String.valueOf(latLng.longitude));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(String.valueOf(latLng.latitude));
        txtLongitud.setText(String.valueOf(latLng.longitude));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


// Set map type to normal or satellite
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); // or MAP_TYPE_SATELLITE, etc.

        // Set initial zoom level
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.892702, -4.783039), 10));

        // Enable UI controls
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        // Add a marker in Córdoba and move the camera
        LatLng cordoba = new LatLng(37.892702, -4.783039);
        googleMap.addMarker(new MarkerOptions().position(cordoba).title("Restaurante la Mafia Se Sienta en la Mesa"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cordoba,

                15));

        // Set listeners for click and long click events
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        googleMap.setOnMapClickListener(this);
        googleMap.setOnMapLongClickListener(this);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }
}




