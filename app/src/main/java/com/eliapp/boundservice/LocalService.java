package com.eliapp.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import java.util.*;

public class LocalService extends Service {
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        LocalService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalService.this;
        }
    }

    public LocalService() {
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
