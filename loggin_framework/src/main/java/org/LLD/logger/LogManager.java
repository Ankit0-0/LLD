package org.LLD.logger;

import org.LLD.ConsoleLogger;
import org.LLD.FileLogger;
import org.LLD.LogSubject;

public class LogManager {
    public static AbstractLogger buildChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);

        return infoLogger;
    }

    public static LogSubject buildSubject() {
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();


        logSubject.addObserver(1, consoleLogger);
        logSubject.addObserver(2, consoleLogger);
        logSubject.addObserver(3, consoleLogger);

        logSubject.addObserver(1, fileLogger);
        logSubject.addObserver(3, fileLogger);


        return logSubject;
    }
}
