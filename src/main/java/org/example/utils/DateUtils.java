package org.example.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }

        Calendar currentDate = Calendar.getInstance();
        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(date);

        return currentDate.get(Calendar.YEAR) == givenDate.get(Calendar.YEAR) &&
                currentDate.get(Calendar.DAY_OF_YEAR) == givenDate.get(Calendar.DAY_OF_YEAR);
    }
}
