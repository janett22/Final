package com.example.plantilla.ui.Inquilinos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.ui.Inmuebles.InmueblesViewModel;
import com.example.plantilla.ui.Inmuebles.ListaAdapter;
import com.example.plantilla.ui.Perfil.PerfilViewModel;

import java.util.ArrayList;
import java.util.List;


public class InquilinosFragment extends Fragment {

    private InmueblesViewModel vm;
    private ListView listaInmuebles;
    private List<Inmueble> lista;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);

        inicializarVista(root);
        vm.getlistaMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {

            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                lista = inmuebles;
                ArrayAdapter<Inmueble> adapter = new InquilinoAdapter(getContext(), R.layout.fragment_inqu, lista, getLayoutInflater());
                listaInmuebles.setAdapter(adapter);
            }
        });
        vm.leerInmuebles();
        return root;
    }

    private void inicializarVista(View root) {
        listaInmuebles = root.findViewById(R.id.listaInmuebles);
    }
}

