package com.mycomp.mq.demo.helper;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ExecutionDelay {
    private Logger logger = Logger.getLogger(ExecutionDelay.class.getName());
    public boolean forMillieSec(final int timeout) {
        final Sleeper sleeper = new Sleeper(TimeUnit.MILLISECONDS, timeout);
        return sleeper.sleep();
    }

    public boolean forSec(final int timeout) {
        final Sleeper sleeper = new Sleeper(TimeUnit.SECONDS, timeout);
        return sleeper.sleep();
    }

    public boolean forMin(final int timeout) {
        final Sleeper sleeper = new Sleeper(TimeUnit.MINUTES, timeout);
        return sleeper.sleep();
    }

    class Sleeper {
        private final TimeUnit timeUnit;
        private final int timeout;

        public Sleeper(TimeUnit timeUnit, int timeout) {
            this.timeUnit = timeUnit;
            this.timeout = timeout;
        }

        public boolean sleep() {
            try {
                logger.log(Level.INFO, String.format("Sleeping for %d %s", timeout, timeUnit));
                timeUnit.sleep(timeout);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return false;
            }
            return true;
        }
    }
}
