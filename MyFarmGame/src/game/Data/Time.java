package game.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Time implements Serializable {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private Timestamp time;

    public Time() {
        time = new Timestamp(System.currentTimeMillis());
    }

    public Time(Time startTime, int addSeconds) {
        time = new Timestamp(startTime.getTimeMilliseconds() + (addSeconds * 1000));
    }

    public Time(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTimestamp() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time.setTime(time.getTime());
    }

    public void setTime(Time time, int addSeconds) {
        this.time.setTime(time.getTimestamp().getTime() + (addSeconds * 1000));
    }

    public long getTimeMilliseconds() {
        return time.getTime();
    }

    public static String getTimeLeft(long millisecondsLeft) {

        long seconds = (millisecondsLeft / 1000) % 60;
        long minutes = ((millisecondsLeft / 1000) / 60) % 60;
        long hours = (((millisecondsLeft / 1000) / 60) / 60) % 24;
        long days = (((millisecondsLeft / 1000) / 60) / 60) / 24;

        String time = "";
        if (days > 0) {
            time = days + "d:";
        }
        if (hours > 0) {
            time += hours + "h:";
        } else if (hours == 0 && days > 0) {
            time += hours + ":";
        }
        if (minutes > 0) {
            time += minutes + "m:";
        } else if (minutes == 0 && (hours > 0 || days > 0)) {
            time += minutes + ":";
        }
        if (seconds > 0) {
            time += seconds + "s";
        } else if (seconds == 0 && (minutes > 0 || hours > 0 || days > 0)) {
            time += seconds + "s";
        }

        return time;

    }

    public static boolean checkFinishTime(Time finishTime) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return currentTime.equals(finishTime) || currentTime.after(finishTime.getTimestamp());
    }

    public String getTimeString() {
        return SDF.format(time);
    }

}
