package com.example.recyclerobserver;

import java.util.ArrayList;

public class User {

    Integer userID;

    ArrayList<ScannableCode> userCodeList;

    public User(int id) {
        this.userID = id;
        this.userCodeList = new ArrayList<>();
    }

    public ArrayList<ScannableCode> getUserCodeList() {
        return userCodeList;
    }

    // equals() and hashCode implementations are necessary for use by Hash Map
    // To compare if two Users are equal, use the String equals() method to compare the Song.title String
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof User) {
            User s = (User)obj;
            result = this.userID.equals(s.userID);
        }
        return result;
    }

    // Use the Integer hashCode() from User.userID
    @Override
    public int hashCode() {
        return this.userID.hashCode();
    }
}
