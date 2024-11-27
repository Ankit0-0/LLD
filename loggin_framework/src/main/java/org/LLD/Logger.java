package org.LLD;

import org.LLD.logger.AbstractLogger;

import java.io.Serializable;

import static org.LLD.logger.LogManager.buildChainOfLogger;

public class Logger implements Cloneable, Serializable {
    private volatile static Logger loggerObject;
    private volatile static AbstractLogger chainOfLogger;

    private Logger() {
        if (loggerObject != null) {
            throw new IllegalStateException("Object already created!");
        }
    }

    public static Logger getInstance() {
        if (loggerObject == null) {
            synchronized (Logger.class) {
                if (loggerObject == null) {
                    loggerObject = new Logger();
                    chainOfLogger = buildChainOfLogger();
                }
            }
        }
        return loggerObject;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolver() {
        return loggerObject;
    }

    private void createLog(int level, String msg) {
        chainOfLogger.logMessage(level, msg);
    }

    public void info(String msg) {
        createLog(1, msg);
    }

    public void error(String msg) {
        createLog(2, msg);
    }

    public void debug(String msg) {
        createLog(3, msg);
    }

}