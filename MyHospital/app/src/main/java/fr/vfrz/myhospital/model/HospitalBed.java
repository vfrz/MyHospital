package fr.vfrz.myhospital.model;

import androidx.room.Entity;

@Entity(tableName = "beds")
public class HospitalBed extends HospitalModel {

    public long serviceId;
    public HospitalBedState state;

}
