package com.example.plantilla.ui.CerrarSesion;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CerrarSesionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CerrarSesionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cerrar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}