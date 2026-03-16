package org.groupe4;

public class ExceptionManager {
    public static void handleException(Throwable e) {
        Logger.getInstance().exception(e);
    }
}
