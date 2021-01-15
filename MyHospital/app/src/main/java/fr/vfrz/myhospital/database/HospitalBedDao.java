package fr.vfrz.myhospital.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import fr.vfrz.myhospital.model.HospitalBed;

@Dao
public interface HospitalBedDao extends HospitalBaseDao<HospitalBed> {

    @Query("SELECT * FROM beds WHERE id = :id")
    LiveData<HospitalBed> get(long id);

    @Query("SELECT * FROM beds WHERE serviceId = :serviceId")
    LiveData<List<HospitalBed>> getForService(long serviceId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(HospitalBed bed);

    @Delete
    void delete(HospitalBed bed);
}
