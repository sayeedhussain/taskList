package org.example.Tasks;

import java.time.LocalDate;
import java.util.Comparator;

public class Comparators {

    public static class DateComparator implements Comparator<LocalDate> {
        @Override
        public int compare(LocalDate date1, LocalDate date2) {
            return date1.isBefore(date2) ? -1 : 1;
        }
    }

    public static class NameComparator implements Comparator<String> {
        @Override
        public int compare(String name1, String name2) {
            return name1.compareTo(name2);
        }
    }
}