package fr.vfrz.myhospital.model;

import androidx.room.PrimaryKey;

public abstract class HospitalModel {

    @PrimaryKey(autoGenerate = true)
    public long id;
}
