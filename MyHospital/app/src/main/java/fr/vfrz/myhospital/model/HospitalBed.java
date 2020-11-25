package fr.vfrz.myhospital.model;

import androidx.room.Entity;
import androidx.room.TypeConverters;

import fr.vfrz.myhospital.database.HospitalConverters;

@Entity(tableName = "beds")
@TypeConverters({HospitalConverters.class})
public class HospitalBed extends HospitalModel {

    public long serviceId;
    public HospitalBedState state;

    public Long staffId;
    public Long patientId;

}
