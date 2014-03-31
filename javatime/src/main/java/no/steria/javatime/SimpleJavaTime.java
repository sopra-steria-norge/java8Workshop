package no.steria.javatime;

import no.steria.javatime.quarter.Quarter;
import no.steria.javatime.quarter.QuarterQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;

public class SimpleJavaTime {

    public LocalDateTime findEarliestDate(LocalDateTime date, LocalDateTime anotherDate) {
        return null;
    }

    public Period createPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    public LocalDate getFirstDayOfNextMonth(LocalDate date) {
        return null;
    }

    public LocalDate lastThursdayOfMonth(LocalDate date) {
        return null;
    }

    public Year nextLeapYear(LocalDate date) {
        return null;
    }

    public LocalDate nextPayday(LocalDate date) {
        return null;
    }

    public Quarter findQuarterOf(LocalDate date) {
        return date.query(new QuarterQuery());
    }

}
