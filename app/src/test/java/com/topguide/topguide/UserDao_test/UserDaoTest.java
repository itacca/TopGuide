package com.topguide.topguide.UserDao_test;

import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.dao.PersonDao;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.dao.UserDao;
import com.topguide.topguide.model.User;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Vanja on 9.7.2017..
 */

public class UserDaoTest {

    private static TopGuideApp app;
    private static UserDao userDao;
    private static TourDao tourDao;
    private static PersonDao personDao;

    @BeforeClass
    public static void setUpClass(){

        app = new TopGuideApp();
        userDao = new UserDao(app);
        tourDao = new TourDao();
        personDao = new PersonDao(userDao, tourDao);
        app.setUserDao(userDao);
        app.setTourDao(tourDao);
        app.setPersonDao(personDao);
        userDao.getUsers().add(new User("ana", "12345", 0));
        userDao.getUsers().add(new User("bana", "12345", 1));
        userDao.getUsers().add(new User("cana", "12345", 0));
    }

    @Test
    public void validateUserCorrectTest() {

        assertTrue(userDao.validateUser("ana", "12345"));
    }

    @Test
    public void validateUserFalseTest() {

        assertFalse(userDao.validateUser("hana", "123"));
    }

    @Test
    public void userExistsTrueTest() {

        assertTrue(userDao.userExists("bana"));
    }

    @Test
    public void userExistsFalseTest() {

        assertFalse(userDao.userExists("hana"));
    }
}
