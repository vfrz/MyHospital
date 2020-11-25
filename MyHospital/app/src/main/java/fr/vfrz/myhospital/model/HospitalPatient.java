package fr.vfrz.myhospital.model;

import androidx.room.Entity;

@Entity(tableName = "patients")
public class HospitalPatient extends HospitalPerson {

    public Long bedId;

    public HospitalPatient(String firstname, String lastname) {
        super(firstname, lastname);
    }

}
