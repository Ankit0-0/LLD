package org.LLD.logger;

import org.LLD.LogSubject;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

<<<<<<< HEAD
    public void logMessage(int level, String msg, LogSubject logSubject) {
        if (this.level == level) {
            display(msg, logSubject);
=======
    public void logMessage(int level, String msg) {
        if (this.level == level) {
            display(msg);
>>>>>>> 4d24e4185b510cbf055601b2961b32f42071b5ea
        }
        if (nextLoggingLevel != null) {
            nextLoggingLevel.logMessage(level, msg, logSubject);
        }
    }

    protected abstract void display(String msg, LogSubject logSubject);

}
