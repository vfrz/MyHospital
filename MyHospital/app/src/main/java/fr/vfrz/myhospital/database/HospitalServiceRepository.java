package fr.vfrz.myhospital.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.vfrz.myhospital.model.HospitalService;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;

public class HospitalServiceRepository extends HospitalBaseRepository {

    private HospitalServiceDao serviceDao;
    private LiveData<List<HospitalServiceWithBeds>> servicesWithBeds;

    public HospitalServiceRepository(Application application) {
        HospitalDatabase db = HospitalDatabase.getDatabase(application);
        serviceDao = db.serviceDao();
        servicesWithBeds = serviceDao.getAllWithBeds();
    }

    public LiveData<List<HospitalServiceWithBeds>> getServicesWithBeds() {
        return servicesWithBeds;
    }

    public void insert(HospitalService service) {
        new insertAsyncTask<>(serviceDao).execute(service);
    }

    public void delete(HospitalService service) {
        new deleteAsyncTask<>(serviceDao).execute(service);
    }
}
