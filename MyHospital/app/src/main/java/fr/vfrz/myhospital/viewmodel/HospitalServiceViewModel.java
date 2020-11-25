package fr.vfrz.myhospital.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.vfrz.myhospital.database.HospitalServiceRepository;
import fr.vfrz.myhospital.model.HospitalService;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;

public class HospitalServiceViewModel extends AndroidViewModel {

    private final HospitalServiceRepository repository;

    private final LiveData<List<HospitalServiceWithBeds>> servicesWithBeds;

    public HospitalServiceViewModel(Application application) {
        super(application);
        repository = new HospitalServiceRepository(application);
        servicesWithBeds = repository.getServicesWithBeds();
    }

    public LiveData<List<HospitalServiceWithBeds>> getServicesWithBeds() {
        return servicesWithBeds;
    }

    public void insert(HospitalService service) {
        repository.insert(service);
    }

    public void delete(HospitalService service) {
        repository.delete(service);
    }
}
