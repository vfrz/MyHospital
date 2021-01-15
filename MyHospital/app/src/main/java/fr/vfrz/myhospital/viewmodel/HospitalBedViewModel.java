package fr.vfrz.myhospital.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.vfrz.myhospital.database.HospitalBedRepository;
import fr.vfrz.myhospital.model.HospitalBed;

public class HospitalBedViewModel extends AndroidViewModel {

    private final HospitalBedRepository repository;

    public HospitalBedViewModel(Application application) {
        super(application);
        repository = new HospitalBedRepository(application);
    }

    public Long insert(HospitalBed bed) {
        return repository.insert(bed);
    }

    public LiveData<List<HospitalBed>> getForService(long serviceId) {
        return repository.getForService(serviceId);
    }

}
