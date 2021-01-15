package fr.vfrz.myhospital.database;

import fr.vfrz.myhospital.model.HospitalModel;

public interface HospitalBaseDao<T extends HospitalModel> {

    long insert(T model);

    void delete(T model);
}
