package fr.vfrz.myhospital.model;

import androidx.room.Entity;
import androidx.room.TypeConverters;

import java.util.Date;

import fr.vfrz.myhospital.database.HospitalConverters;

@Entity(tableName = "patients")
@TypeConverters({HospitalConverters.class})
public class HospitalPatient extends HospitalPerson {

    public Date arrivalDate;
    public Date departureDate;

    public HospitalPatient(String firstname, String lastname) {
        super(firstname, lastname);
    }

}
