package fr.vfrz.myhospital.model;

import androidx.room.Entity;

@Entity(tableName = "services")
public class HospitalService extends HospitalModel {

    public String name;

    public HospitalService(String name) {
        this.name = name;
    }

}
