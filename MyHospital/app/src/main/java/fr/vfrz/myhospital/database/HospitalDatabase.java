package fr.vfrz.myhospital.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import fr.vfrz.myhospital.model.HospitalBed;
import fr.vfrz.myhospital.model.HospitalBedState;
import fr.vfrz.myhospital.model.HospitalPatient;
import fr.vfrz.myhospital.model.HospitalService;
import fr.vfrz.myhospital.model.HospitalStaff;

@Database(version = 1, entities = {
        HospitalBed.class,
        HospitalPatient.class,
        HospitalService.class,
        HospitalStaff.class
}, exportSchema = false)
public abstract class HospitalDatabase extends RoomDatabase {

    public abstract HospitalServiceDao serviceDao();

    public abstract HospitalBedDao bedDao();

    // Singleton access
    private static HospitalDatabase instance;

    public static HospitalDatabase getDatabase(Context context) {
        if (instance == null) {
            synchronized (HospitalDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            HospitalDatabase.class, "my-hospital.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

    // Populate for testing purposes
    private void populateDatabase() {
        long oncologie = serviceDao().insert(new HospitalService("Oncologie"));
        insertBeds(7, oncologie, HospitalBedState.Free);

        long programmee = serviceDao().insert(new HospitalService("Radiologie programmée"));
        insertBeds(12, programmee, HospitalBedState.Free);

        long urgence = serviceDao().insert(new HospitalService("Radiologie urgence"));
        insertBeds(4, urgence, HospitalBedState.Free);
    }

    private void insertBeds(int bedCount, long serviceId, HospitalBedState state) {
        for (int i = 0; i < bedCount; i++) {
            bedDao().insert(new HospitalBed(serviceId, state));
        }
    }

    public void populate() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(this::populateDatabase);
    }

    public void clear() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> instance.clearAllTables());
    }
}
