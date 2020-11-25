package fr.vfrz.myhospital.model;

public abstract class HospitalPerson extends HospitalModel {

    public String firstname;
    public String lastname;

    public HospitalPerson(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
