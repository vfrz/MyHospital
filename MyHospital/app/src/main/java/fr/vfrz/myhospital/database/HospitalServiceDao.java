package fr.vfrz.myhospital.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.vfrz.myhospital.model.HospitalService;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;

@Dao
public interface HospitalServiceDao extends HospitalBaseDao<HospitalService> {

    @Transaction
    @Query("SELECT * FROM services")
    LiveData<List<HospitalServiceWithBeds>> getAllWithBeds();

    @Query("SELECT * FROM services WHERE id = :serviceId")
    HospitalServiceWithBeds getByIdWithBeds(long serviceId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(HospitalService service);

    @Delete
    void delete(HospitalService service);
}
