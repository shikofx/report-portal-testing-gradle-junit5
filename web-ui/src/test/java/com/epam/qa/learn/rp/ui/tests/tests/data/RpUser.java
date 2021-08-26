package com.epam.qa.learn.rp.ui.tests.tests.data;

import com.epam.qa.learn.rp.ui.tests.model.User;

public enum RpUser {

    ADMIN("superadmin", "erebus"),
    REGULAR("default", "1q2w3e");


    private final User user;

    RpUser(String username, String password) {
        this.user = new User(username, password);
    }


    public User getUser() {
        return user;
    }
}
