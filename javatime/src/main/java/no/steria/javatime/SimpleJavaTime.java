package no.steria.javatime;

import no.steria.javatime.quarter.Quarter;
import no.steria.javatime.quarter.QuarterQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;

import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

public class SimpleJavaTime {

    public LocalDateTime findEarliestDate(LocalDateTime date, LocalDateTime anotherDate) {
        return date.isBefore(anotherDate) ? date : anotherDate;
    }

    public Period createPeriod(LocalDate fromDate, LocalDate toDate) {
        return Period.between(fromDate, toDate);
    }

    public LocalDate getFirstDayOfNextMonth(LocalDate date) {
        return date.with(firstDayOfNextMonth());
    }

    public LocalDate lastThursdayOfMonth(LocalDate date) {
        return date.with(lastInMonth(THURSDAY));
    }

    public Year nextLeapYear(LocalDate date) {
        if (date.isLeapYear()) return Year.from(date);

        LocalDate nextYear = date.plusYears(1);
        return nextLeapYear(nextYear);
    }

    public LocalDate nextPayday(LocalDate date) {
        LocalDate payDay = date.getDayOfMonth() <= 15 ? date.withDayOfMonth(15) : date.withDayOfMonth(15).plusMonths(1);

        if (payDay.getDayOfWeek() == SATURDAY || payDay.getDayOfWeek() == SUNDAY) {
            payDay = payDay.with(previous(FRIDAY));
        }
        return payDay;
    }

    public Quarter findQuarterOf(LocalDate date) {
        return date.query(new QuarterQuery());
    }

}
