package fr.vfrz.myhospital.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import fr.vfrz.myhospital.model.HospitalBed;

@Dao
public interface HospitalBedDao {

    @Query("SELECT * FROM beds WHERE id = :id")
    LiveData<HospitalBed> get(long id);

    @Query("SELECT * FROM beds WHERE serviceId = :serviceId")
    LiveData<List<HospitalBed>> getForService(long serviceId);
}
