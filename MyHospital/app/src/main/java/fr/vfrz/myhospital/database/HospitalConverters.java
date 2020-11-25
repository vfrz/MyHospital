package fr.vfrz.myhospital.database;

import androidx.room.TypeConverter;

import java.util.Date;

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

    @TypeConverter
    public static Date toDate(long time) {
        return new Date(time);
    }

    @TypeConverter
    public static long fromDate(Date date) {
        return date == null ? 0 : date.getTime();
    }
}
