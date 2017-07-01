package com.topguide.topguide.dao;

import com.topguide.topguide.model.Tourist;
import com.topguide.topguide.model.User;

import java.util.ArrayList;

/**
 * Created by Igor on 6/30/2017.
 */

public class PersonDao {

    private Tourist currentTourist;
    private ArrayList<Tourist> tourists;


    public PersonDao() {
        currentTourist = null;
        tourists = null;
    }

    public PersonDao(Tourist currentTourist, ArrayList<Tourist> tourists) {
        this.currentTourist = currentTourist;
        this.tourists = tourists;
    }

    public Tourist getCurrentTourist() {
        return currentTourist;
    }

    public void setCurrentTourist(Tourist currentTourist) {
        this.currentTourist = currentTourist;
    }

    public ArrayList<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(ArrayList<Tourist> tourists) {

    }

    public Tourist searchPerson(String username){
        for (Tourist t: tourists){
            if (t.getUser().getUsername().compareTo(username) == 0){
                return t;
            }
        }
        return null;
    }

    public void writePerson(String textUsername, String textName, String textLastName, String textEmail) {
    }
}
