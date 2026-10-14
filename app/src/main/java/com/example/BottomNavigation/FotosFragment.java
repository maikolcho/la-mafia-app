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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.lamafia.R;


public class FotosFragment extends Fragment {

    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6;
    ImageView imageView;

    public FotosFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_fotos, container, false);

        imageView = view.findViewById(R.id.image_view);
        imageButton1 = view.findViewById(R.id.imageButton1);
        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton4 = view.findViewById(R.id.imageButton4);
        imageButton5 = view.findViewById(R.id.imageButton5);
        imageButton6 = view.findViewById(R.id.imageButton6);

        int thumbRadius = dpToPx(24);
        int previewRadius = dpToPx(32);

        loadPhoto(imageButton1, R.drawable.la_mafia, thumbRadius);
        loadPhoto(imageButton2, R.drawable.la_mafia_cordoba_2, thumbRadius);
        loadPhoto(imageButton3, R.drawable.la_mafia_cordoba_3, thumbRadius);
        loadPhoto(imageButton4, R.drawable.la_mafia_cordoba_4, thumbRadius);
        loadPhoto(imageButton5, R.drawable.la_mafia_cordoba_5, thumbRadius);
        loadPhoto(imageButton6, R.drawable.la_mafia_cordoba_7, thumbRadius);

        // Foto por defecto en el visor grande, antes de tocar ninguna miniatura
        loadPhoto(imageView, R.drawable.la_mafia, previewRadius);

        imageButton1.setOnClickListener(v -> loadPhoto(imageView, R.drawable.la_mafia, previewRadius));
        imageButton2.setOnClickListener(v -> loadPhoto(imageView, R.drawable.la_mafia_cordoba_2, previewRadius));
        imageButton3.setOnClickListener(v -> loadPhoto(imageView, R.drawable.la_mafia_cordoba_3, previewRadius));
        imageButton4.setOnClickListener(v -> loadPhoto(imageView, R.drawable.la_mafia_cordoba_4, previewRadius));
        imageButton5.setOnClickListener(v -> loadPhoto(imageView, R.drawable.la_mafia_cordoba_5, previewRadius));
        imageButton6.setOnClickListener(v -> loadPhoto(imageView, R.drawable.la_mafia_cordoba_7, previewRadius));

        return view;

    }

    @SuppressWarnings("unchecked")
    private void loadPhoto(ImageView target, int drawableRes, int radiusPx) {
        Glide.with(this)
                .load(drawableRes)
                .transform(new CenterCrop(), new RoundedCorners(radiusPx))
                .into(target);
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

}
