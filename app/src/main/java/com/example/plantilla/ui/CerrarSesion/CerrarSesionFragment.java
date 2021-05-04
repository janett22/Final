package com.example.plantilla.ui.CerrarSesion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.plantilla.R;

public class CerrarSesionFragment extends Fragment {

    private CerrarSesionViewModel cerrarSesionViewModelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cerrarSesionViewModelViewModel =
                new ViewModelProvider(this).get(CerrarSesionViewModel.class);
        ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication()).create(CerrarSesionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cerrar_sesion, container, false);
        cerrarSesion();

        return root;
    }


    private void cerrarSesion(){
        new AlertDialog.Builder(getContext())
                .setTitle("Cerrar Sesion")
                .setMessage("Esta seguro, que desea salir de la aplicación?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                        //  System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();


    }
}
