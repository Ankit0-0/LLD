package org.LLD.logger;

import org.LLD.LogSubject;

public class ErrorLogger extends AbstractLogger  {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
        String message = "ERROR: " + msg;
        logSubject.notifyAllObserver(1, message);
    }
}
