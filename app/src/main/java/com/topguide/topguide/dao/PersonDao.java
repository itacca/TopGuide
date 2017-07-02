package com.topguide.topguide.dao;

import com.topguide.topguide.model.Guide;
import com.topguide.topguide.model.Tour;
import com.topguide.topguide.model.Tourist;
import com.topguide.topguide.model.User;

import java.util.ArrayList;

/**
 * Created by Igor on 6/30/2017.
 */

public class PersonDao {

    private Tourist currentTourist;
    private Guide currentGuide;
    private ArrayList<Tourist> tourists;
    private UserDao userDao;
    
    public PersonDao(UserDao ud) {
        this.currentTourist = null;
        this.currentGuide = new Guide("MARKO", "MARKOVIC", "ADS",new User("bana", "12345", 1));
        this.userDao = ud;
        setUpTourists();
        setUpUsers();
    }

    private void setUpUsers() {
        for (Tourist t : tourists) {
            userDao.addUser(t.getUser());
        }
    }

    private void setUpTourists() {
        tourists = new ArrayList<>();
        tourists.add(new Tourist("Ana", "AnicTurista", "ana@gmail.com", new User("ana", "12345", 0)));
        tourists.add(new Tourist("Ana", "BanicVodic", "ana@gmail.com", new User("bana", "12345", 1)));
        tourists.add(new Tourist("Ana", "CanicTurista", "ana@gmail.com", new User("cana", "12345", 0)));
    }

    public PersonDao(Tourist currentTourist, ArrayList<Tourist> tourists) {
        this.currentTourist = currentTourist;
        this.tourists = tourists;
    }

    public Tourist getCurrentTourist() {
        return currentTourist;
    }

    public void setUpCurrentTourist(String username) {
        for (Tourist t : tourists) {
            if (t.getUser().getUsername().equals(username)) {
                currentTourist = t;
            }
        }
    }

    public void setCurrentTourist(Tourist currentTourist) {
        this.currentTourist = currentTourist;
    }

    public Guide getCurrentGuide() {
        return currentGuide;
    }

    public void setCurrentGuide(Guide currentGuide) {
        this.currentGuide = currentGuide;
    }

    public ArrayList<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(ArrayList<Tourist> tourists) {
        this.tourists = tourists;
    }

    public void writePerson(String textUsername, String textPassword, String textName, String textLastName, String textEmail, int role) {
        Tourist t = new Tourist(textName, textLastName, textEmail, new User(textUsername, textPassword, role));
        tourists.add(t);
        userDao.addUser(t.getUser());
    }
}
