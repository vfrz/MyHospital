package fr.vfrz.myhospital.database;

import androidx.room.TypeConverter;

import fr.vfrz.myhospital.model.HospitalBedState;

public class HospitalConverters {

    @TypeConverter
    public static String hospitalBedStateToString(HospitalBedState state) {
        return state.toString();
    }

    @TypeConverter
    public static HospitalBedState stringToHospitalBedState(String value) {
        return HospitalBedState.valueOf(value);
    }
}
