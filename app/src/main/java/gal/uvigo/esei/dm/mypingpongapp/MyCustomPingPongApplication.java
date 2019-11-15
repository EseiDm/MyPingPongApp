package gal.uvigo.esei.dm.mypingpongapp;

import android.app.Application;

public class MyCustomPingPongApplication extends Application {

    private String myCustomValue;

    public String getMyCustomValue() {
        return myCustomValue;
    }

    public void setMyCustomValue(String myCustomValue) {
        this.myCustomValue = myCustomValue;
    }
}
