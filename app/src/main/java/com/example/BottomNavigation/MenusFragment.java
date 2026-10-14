
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

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lamafia.R;

import java.util.ArrayList;
import java.util.List;


public class MenusFragment extends Fragment implements MenuAdapter.OnItemClickListener{

    private List<MenuItem> menuItems;


    public MenusFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_menus, container, false);


        // Inicializar los datos del menú
        initializeMenuItems();


        // Configurar el RecyclerView

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
         MenuAdapter adapter = new MenuAdapter(menuItems, this);
         recyclerView.setAdapter(adapter);

         return view;

    }
    private void initializeMenuItems() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(R.drawable.menu1));
        menuItems.add(new MenuItem(R.drawable.menu2));
        menuItems.add(new MenuItem(R.drawable.menu3));
        menuItems.add(new MenuItem(R.drawable.menu4));
        menuItems.add(new MenuItem(R.drawable.menu5));
    }

    @Override
    public void onItemClick(int position) {
        // Crear un diálogo para mostrar la imagen ampliada
        Dialog dialog = new Dialog(requireActivity());

        dialog.setContentView(R.layout.large_image);

        ImageView expandedImage = dialog.findViewById(R.id.expanded_image);
        expandedImage.setImageResource(menuItems.get(position).getImageResId());
        dialog.show();

    }
}

