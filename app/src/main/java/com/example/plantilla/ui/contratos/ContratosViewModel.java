package com.example.plantilla.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class ContratosViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Inmueble>> listaMutable;

    public LiveData<ArrayList<Inmueble>> getListaMutable(){
        if (listaMutable == null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }


    public void LeerPropiedadesAlquiladas(){
        ApiClient api= new ApiClient();
        ArrayList<Inmueble> lista=api.obtenerPropiedadesAlquiladas();

        listaMutable.setValue(lista);
    }
}
