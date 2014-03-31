package no.steria.javatime;

import no.steria.javatime.quarter.Quarter;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

import static java.time.Month.*;
import static org.fest.assertions.Assertions.assertThat;

public class SimpleJavaTimeTest {

    @Test
    public void should_return_first_date() {
        LocalDateTime oneDate = LocalDateTime.of(2014, Month.JULY, 1, 0, 0);
        LocalDateTime anotherDate = LocalDateTime.of(2014, Month.AUGUST, 1, 0, 0);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.findEarliestDate(oneDate, anotherDate)).isEqualTo(oneDate);
    }

    @Test
    public void should_create_a_period() {
        LocalDate december = LocalDate.of(2013, DECEMBER, 1);
        LocalDate march = LocalDate.of(2014, MARCH, 1);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();
        assertThat(simpleJavaTime.createPeriod(december, march).getMonths()).isEqualTo(3);
    }

    @Test
    public void should_find_first_day_of_next_month() {
        LocalDate date = LocalDate.of(2014, APRIL, 5);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.getFirstDayOfNextMonth(date)).isEqualTo(LocalDate.of(2014, MAY, 1));

    }

    @Test
    public void should_find_last_thursday_of_month() {
        LocalDate date = LocalDate.of(2014, Month.APRIL, 5);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.lastThursdayOfMonth(date)).isEqualTo(LocalDate.of(2014, Month.APRIL, 24));
    }

    @Test
    public void should_return_next_payday() {
        LocalDate date = LocalDate.of(2014, APRIL, 5);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.nextPayday(date)).isEqualTo(LocalDate.of(2014, APRIL, 15));
    }

    @Test
    public void payday_does_not_occur_on_weekends() {
        LocalDate february = LocalDate.of(2014, FEBRUARY, 26);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        //hint: february.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)) gir 24.februar;
        assertThat(simpleJavaTime.nextPayday(february)).isEqualTo(LocalDate.of(2014, MARCH, 14));
    }

    @Test
    public void should_find_next_leap_year() throws ParseException {
        LocalDate date = LocalDate.of(2014, APRIL, 5);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.nextLeapYear(date)).isEqualTo(Year.of(2016));
    }

    @Test
    public void should_find_correct_quarter_for_date() {
        LocalDate date = LocalDate.of(2014, APRIL, 5);

        SimpleJavaTime simpleJavaTime = new SimpleJavaTime();

        assertThat(simpleJavaTime.findQuarterOf(date)).isEqualTo(Quarter.SECOND);
    }
}
