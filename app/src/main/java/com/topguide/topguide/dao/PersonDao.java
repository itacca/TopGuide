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
    private TourDao tourDao;
    
    public PersonDao(UserDao ud, TourDao tourDao) {
        this.currentTourist = null;
        this.userDao = ud;
        this.tourDao = tourDao;
        setUpTourists();
        setUpUsers();
        setUpTours();
    }

    public PersonDao(Tourist currentTourist, ArrayList<Tourist> tourists) {
        this.currentTourist = currentTourist;
        this.tourists = tourists;
    }

    private void setUpUsers() {
        for (Tourist t : tourists) {
            userDao.addUser(t.getUser());
        }
    }

    private void setUpTourists() {
        tourists = new ArrayList<>();
        tourists.add(new Tourist("Ana", "AnicTurista", "ana@gmail.com", new User("ana", "12345", 0)));
        tourists.add(new Guide("Ana", "BanicVodic", "ana@gmail.com", new User("bana", "12345", 1)));
        tourists.add(new Tourist("Ana", "CanicTurista", "ana@gmail.com", new User("cana", "12345", 0)));
    }

    private void setUpTours() {
        Guide someGuide = (Guide) tourists.get(1);
        int number = 0;
        for (Tour t : tourDao.getTours()) {
            t.setGuide(someGuide);
            someGuide.addCreatedTour(t);
            currentGuide = someGuide;
            tourists.get(number%3).signUpForTour(t);
            tourists.get((number+1)%3).signUpForTour(t);
            number++;
        }
    }

    public void setUpCurrentTourist(String username) {
        for (Tourist t : tourists) {
            if (t.getUser().getUsername().equals(username)) {
                currentTourist = t;
            }
        }
    }

    public Guide getCurrentGuide() {
        return currentGuide;
    }

    public void setCurrentGuide(Guide currentGuide) {
        this.currentGuide = currentGuide;
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
        this.tourists = tourists;
    }

    public void writePerson(String textUsername, String textPassword, String textName, String textLastName, String textEmail, int role) {
        Tourist t = new Tourist(textName, textLastName, textEmail, new User(textUsername, textPassword, role));
        tourists.add(t);
        userDao.addUser(t.getUser());
    }
}
