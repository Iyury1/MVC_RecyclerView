package com.example.recyclerobserver;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class UserDataModel extends Observable {

    HashMap<Integer, User> userList;
    
    CustomView view;

    private UserDataModel() {
        this.userList = new HashMap<>();
    }

    private static final UserDataModel userDataModel = new UserDataModel();


    private Integer userID;

    public static UserDataModel getInstance() {
        return userDataModel;
    }

    public ArrayList<ScannableCode> getLocalData() {
        return userList.get(userID).getUserCodeList();
    }

    public void addCode(ScannableCode code) {
        userList.get(this.userID).getUserCodeList().add(code);
        setChanged();
        notifyObservers();
//        updateViews();
    }

    private void updateViews() {
        if (view != null) {
            view.update();
        }
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
        userList = new HashMap<>();
        if (!userList.containsKey(userID)) {
            userList.put(userID, new User(userID));
        }
//        setChanged();
//        notifyObservers();
//        view.update();
    }

    public void addView(CustomView view) {
        this.view = view;
    }
}
