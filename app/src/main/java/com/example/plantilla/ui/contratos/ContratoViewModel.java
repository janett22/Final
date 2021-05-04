package com.example.plantilla.ui.contratos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Contrato;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

public class ContratoViewModel extends ViewModel {

    public MutableLiveData<Contrato> contratoMutable;

    public LiveData<Contrato> getContratoMutable() {
        if (contratoMutable == null) {
            contratoMutable = new MutableLiveData<>();
        }
        return contratoMutable;
    }

    public void cargarContrato(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        ApiClient apiClient = ApiClient.getApi();
        Contrato contrato = apiClient.obtenerContratoVigente(inmueble);
        this.contratoMutable.setValue(contrato);
    }
}