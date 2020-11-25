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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HospitalService service);

    @Delete
    void delete(HospitalService service);
}
