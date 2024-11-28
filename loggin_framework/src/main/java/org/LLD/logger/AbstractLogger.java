package org.LLD.logger;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    public void logMessage(int level, String msg) {
        if (this.level <= level) {
            display(msg);
        }
        if (nextLoggingLevel != null) {
            nextLoggingLevel.logMessage(level, msg);
        }
    }

    protected abstract void display(String msg);

}
