package fr.vfrz.myhospital.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddServiceViewModel extends AndroidViewModel {

    public String name;
    public int beds;

    public AddServiceViewModel(@NonNull Application application) {
        super(application);
    }

    public void onAdd() {
        Log.i("OUE", name + " : " + beds);
    }
}