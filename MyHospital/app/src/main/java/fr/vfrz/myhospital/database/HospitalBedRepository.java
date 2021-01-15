package fr.vfrz.myhospital.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

import fr.vfrz.myhospital.model.HospitalBed;
import fr.vfrz.myhospital.model.HospitalBedState;
import fr.vfrz.myhospital.model.HospitalService;

public class HospitalBedRepository extends HospitalBaseRepository {

    private final HospitalBedDao bedDao;

    public HospitalBedRepository(Application application) {
        HospitalDatabase db = HospitalDatabase.getDatabase(application);
        bedDao = db.bedDao();
    }

    public LiveData<List<HospitalBed>> getForService(long serviceId) {
        return bedDao.getForService(serviceId);
    }

    public Long insert(HospitalBed bed) {
        try {
            return new insertAsyncTask<>(bedDao).execute(bed).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(HospitalBed bed) {
        new deleteAsyncTask<>(bedDao).execute(bed);
    }
}
