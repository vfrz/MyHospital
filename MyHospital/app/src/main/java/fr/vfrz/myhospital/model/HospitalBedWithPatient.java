package fr.vfrz.myhospital.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class HospitalBedWithPatient {

    @Embedded
    public HospitalBed bed;

    @Relation(
            parentColumn = "id",
            entityColumn = "bedId"
    )
    public HospitalPatient patient;
}
