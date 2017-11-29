package com.owl;

import com.owl.test.Test;

/**
 * Created by Imagine Owl on 2017/7/25.
 */

public class MsgPushThread extends Thread {

    private boolean isRunning = false;

    public void stopThread() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning && isAlive();
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            try {
                sleep(5 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MinaSessionManager.getInstance().sendToClient(Test.getSingleMessage().toString());
        }
    }
}
