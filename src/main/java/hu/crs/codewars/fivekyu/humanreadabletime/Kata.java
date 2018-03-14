package hu.crs.codewars.fivekyu.humanreadabletime;

public class Kata {
    public static String makeReadable(int seconds) {

        int hour = 0;
        int minute = 0;

        if (seconds > 59) {
            minute = seconds / 60;
            seconds -= minute * 60;
        }

        if (minute > 59) {
            hour = minute / 60;
            minute -= hour * 60;
        }


        return String.format("%s:%s:%s", leading0(hour), leading0(minute), leading0(seconds));
    }

    private static String leading0(int integer) {
        return String.format("%02d", integer);
    }
}
