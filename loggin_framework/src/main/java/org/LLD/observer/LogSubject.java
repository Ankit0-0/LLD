package org.LLD.observer;

import java.util.*;

public class LogSubject {
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

    public void addObserver(int level, LogObserver logObserver) {
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, new ArrayList<>());
        logObserverList.add(logObserver);
        logObservers.put(level, logObserverList);
    }

    public void notifyAllObserver(int level, String msg) {
        for (Map.Entry<Integer, List<LogObserver>> entry : logObservers.entrySet()) {
            if (entry.getKey() == level) {
                entry.getValue().forEach(observer -> observer.log(msg));
            }
        }
    }

}
