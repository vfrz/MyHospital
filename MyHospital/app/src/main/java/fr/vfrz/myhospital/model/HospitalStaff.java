package fr.vfrz.myhospital.model;

import androidx.room.Entity;

@Entity(tableName = "staffs")
public class HospitalStaff extends HospitalPerson {

    public HospitalStaff(String firstname, String lastname) {
        super(firstname, lastname);
    }

}
