package fr.vfrz.myhospital.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.AndroidViewModel;

public class AddServiceViewModel extends AndroidViewModel {

    public String name;
    public String beds = "1";

    public AddServiceViewModel(@NonNull Application application) {
        super(application);
    }
}