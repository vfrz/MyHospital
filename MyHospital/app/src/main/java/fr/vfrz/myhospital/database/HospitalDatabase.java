package fr.vfrz.myhospital.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.vfrz.myhospital.model.HospitalBed;
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
}
