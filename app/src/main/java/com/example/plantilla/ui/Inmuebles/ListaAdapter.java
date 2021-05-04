package com.example.plantilla.ui.Inmuebles;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.io.Serializable;
import java.util.List;

public class ListaAdapter  extends ArrayAdapter<Inmueble> {
    private Context context;
    private List<Inmueble> lista;
    private LayoutInflater li;

    public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects,LayoutInflater li) {
        super(context, resource, objects);
        this.context=context;
        this.li=li;
        this.lista=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if (itemView==null){
            itemView=li.inflate(R.layout.item_inmuebles,parent,false);
        }
        Inmueble immueble=lista.get(position);
        ImageView foto=itemView.findViewById(R.id.foto);
        Glide.with(getContext())
                .load(immueble.getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(foto);
        TextView direccion=itemView.findViewById(R.id.direccion);
        direccion.setText(immueble.getDireccion());
        TextView precio=itemView.findViewById(R.id.precio);
        precio.setText("$"+immueble.getPrecio());


          itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    b.putSerializable("inmueble", (Serializable) lista);
                   // Navigation.findNavController((Activity)context, R.id.nav_host_fragment).navigate(R.id.frag, b);
                }
            });
          return itemView;
    }
                                    }

