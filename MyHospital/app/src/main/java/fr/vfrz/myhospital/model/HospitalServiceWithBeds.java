package fr.vfrz.myhospital.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class HospitalServiceWithBeds {

    @Embedded
    public HospitalService service;

    @Relation(
            parentColumn = "id",
            entityColumn = "serviceId"
    )
    public List<HospitalBed> beds;
}
