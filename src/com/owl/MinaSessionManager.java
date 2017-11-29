package com.owl;

import org.apache.mina.core.session.IoSession;

/**
 * Created by Imagine Owl on 2017/7/25.
 */

public class MinaSessionManager {

    private static MinaSessionManager sInstance = null;
    private IoSession mSession;
    private MsgPushThread mThread;

    public static MinaSessionManager getInstance() {
        if (sInstance == null) {
            synchronized (MinaSessionManager.class) {
                if (sInstance == null) {
                    sInstance = new MinaSessionManager();
                }
            }
        }
        return sInstance;
    }

    public void setSession(IoSession session) {
        System.out.println("MinaSessionManager.setSession 26: ");
        mSession = session;
        mThread = new MsgPushThread();
        mThread.start();
    }

    public void sendToClient(Object msg) {
        System.out.println("MinaSessionManager.sendToClient 31: " + msg);
        if (mSession != null) {
            mSession.write(msg);
        }
    }

    public void closeSession() {
        System.out.println("MinaSessionManager.closeSession 38: ");
        if (mThread != null && mThread.isRunning()) {
            mThread.stopThread();
            mThread = null;
        }
        if (mSession != null) {
            mSession.closeOnFlush();
        }
        mSession = null;

    }
}
