package no.steria.javatime.quarter;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

import static java.time.Month.*;
import static no.steria.javatime.quarter.Quarter.*;

public class QuarterQuery implements TemporalQuery<Quarter> {

    @Override
    public Quarter queryFrom(TemporalAccessor temporal) {
        int month = LocalDate.from(temporal).getMonthValue();

        if (month < APRIL.getValue()){
            return FIRST;
        }else if (month < JULY.getValue()) {
            return SECOND;
        } else if (month < OCTOBER.getValue()) {
            return THIRD;
        }
        return FOURTH;
    }
}
