package com.example.recyclerobserver;


import java.util.ArrayList;
import java.util.HashMap;

public class UserDataModel {

    HashMap<Integer, User> userList;

    ArrayList<CustomView> views;

    private UserDataModel() {
        this.userList = new HashMap<>();
        this.views = new ArrayList<>();
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

        updateViews();
    }

    private void updateViews() {
        for (CustomView view: views) {
            view.update(this);
        }
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
        userList = new HashMap<>();
        if (!userList.containsKey(userID)) {
            userList.put(userID, new User(userID));
        }
    }

    public void addView(CustomView view) {
        if (!views.contains(view)) {
            views.add(view);
        }
    }

    public void deleteView(CustomView view) {
        if (views.contains(view)) {
            views.remove(view);
        }
    }
}
