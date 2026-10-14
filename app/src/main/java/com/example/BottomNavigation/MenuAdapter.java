
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

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lamafia.R;

import java.util.List;

        public class MenuAdapter extends RecyclerView.Adapter<com.example.BottomNavigation.MenuAdapter.MenuViewHolder> {

            private final List<MenuItem> menuItems;
            private final OnItemClickListener onItemClickListener;

            public MenuAdapter(List<MenuItem> menuItems, OnItemClickListener onItemClickListener) {
                this.menuItems = menuItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext(); // Obtener el contexto del ViewGroup
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        holder.bind(menuItem);

        // Agregar OnClickListener al ImageView
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext(); // Obtener el contexto desde la vista
                Log.d("MenuAdapter", "Image clicked"); // Depuración
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_image, null);

                // Obtener el ImageView del diseño del diálogo
                ImageView imageViewAmpliada = dialogView.findViewById(R.id.expanded_image);
                Log.d("MenuAdapter", "Dialog view inflated"); // Depuración

                // Cargar la imagen en el ImageView
                Glide.with(context)
                        .load(menuItem.getImagen())
                        .into(imageViewAmpliada);

                // Configurar el diálogo
                builder.setView(dialogView);
                builder.setPositiveButton("Cerrar",(dialog, which) -> dialog.dismiss());

                // Mostrar el diálogo
                AlertDialog dialog = builder.create();
                Log.d("MenuAdapter", "Dialog created"); // Depuración
                dialog.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuItems.size();
    }

   public static class MenuViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        MenuViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);

            // Manejar clics en las miniaturas
            itemView.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(position);
                }
            });
        }

        void bind(MenuItem menuItem) {
            Glide.with(imageView.getContext())
                    .load(menuItem.getImagen())
                    .into(imageView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
