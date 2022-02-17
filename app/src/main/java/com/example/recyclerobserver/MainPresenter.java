package com.example.recyclerobserver;

import java.util.Observer;

public class MainPresenter {

    public void addNewCode(ScannableCode code) {
        UserDataModel model = UserDataModel.getInstance();
        model.addCode(code);
    }

    public void setUpUser(int userID) {
        UserDataModel model = UserDataModel.getInstance();
        model.setUserID(userID);
    }

    public void setUpView(CustomView view) {
        UserDataModel model = UserDataModel.getInstance();
        model.addView(view);
    }

    public void removeView(CustomView view) {
        UserDataModel model = UserDataModel.getInstance();
        model.deleteView(view);
    }
}
