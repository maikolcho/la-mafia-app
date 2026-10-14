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

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.lamafia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {


    private BottomNavigationView bottomNavigationView;
    VideoView video1;
    MediaController mediaController;
    int position = 0;
    private static final String SELECTION = "selection";


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTION, bottomNavigationView.getSelectedItemId());

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBottomMenu();

        video1 = findViewById(R.id.video1);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(this);
        InicioFragment fragment = new InicioFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();


        String path = "android.resource://" + getPackageName() + "/" + R.raw.videomafiaoriginal;

        video1.setVideoURI(Uri.parse(path));
        video1.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                video1.setVisibility(View.GONE);
                return true;
            }
        });
        video1.start();

        if (this.mediaController == null) {
            this.mediaController = new MediaController(MainActivity.this);

            this.mediaController.setAnchorView(video1);

            this.video1.setMediaController(mediaController);
        }


        this.video1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                video1.seekTo(position);
                if (position == 0) {
                    video1.start();
                }

                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {


                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(video1);


                    }


                });

            }
        });


    }


    private void setupBottomMenu() {

    }


    public void openPedirOnlineWebsite(View view) {

        Uri uri = Uri.parse("https://lamafia.es/cordoba/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }


    public void openGlovoWebsite(View view) {
        Uri uri = Uri.parse("https://glovoapp.com/es/es/cordoba/la-mafia-se-sienta-a-la-mesa-9/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openJustEatWebsite(View view) {
        Uri uri = Uri.parse("https://www.just-eat.es/restaurants-lamafiacordoba/menu?utm_source=button&utm_medium=tr-activation&utm_campaign=lamafiacordoba&utm_term=menucard");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openUberEatsWebsite(View view) {
        Uri uri = Uri.parse("https://www.ubereats.com/es/store/la-mafia-se-sienta-a-la-mesa-cordoba/RvWEFc6zT5KN2Acn9zz4Mw");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    // Código para llamar al restaurante
    public void callRestaurant(View view) {
        Uri uri = Uri.parse("tel:+34957401168");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }


    public void openReservaTuMesaWebsite(View view) {
        Uri uri = Uri.parse("https://lamafia.es/cordoba/reservar-mesa/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    InformacionFragment informacionFragment = new InformacionFragment();
    MenusFragment menusFragment = new MenusFragment();
    FotosFragment fotosFragment = new FotosFragment();
    CartaFragment cartaFragment = new CartaFragment();
    InicioFragment inicioFragment = new InicioFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();


        // Realizar el cambio del fragmento correspondiente aquí

        if (itemId == R.id.informacion) {
            video1.pause();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, informacionFragment).commit();
        } else if (itemId == R.id.fotos) {
            video1.pause();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fotosFragment).commit();
        } else if (itemId == R.id.menus) {
            video1.pause();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, menusFragment).commit();
        } else if (itemId == R.id.carta) {
            video1.pause();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cartaFragment).commit();
        } else if (itemId == R.id.inicio) {
            video1.start();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, inicioFragment).commit();
        }


        // Cambiar dinámicamente el color del ícono al seleccionar
        int selectedColor = ContextCompat.getColor(this, R.color.grey);
        Objects.requireNonNull(item.getIcon()).setTint(selectedColor);

        // Restaurar el color predeterminado para otros elementos
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.getItemId() != item.getItemId()) {
                int defaultColor = ContextCompat.getColor(this, R.color.defaultIconColor);
                Objects.requireNonNull(menuItem.getIcon()).setTint(defaultColor);
            }
        }
        return true;


    }
}








































