package com.informaltratom;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class InfoMaltratoMApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(getApplicationContext());

        // Add your initialization code here
        Parse.initialize(this, "TQNaufudyFIbC3GHIF4LsNQ3xgOP3mAZxeDbCOMH", "KdikjziuWjWzEwePylYWUCRLnAM7rSpVxmkkr8wH");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
