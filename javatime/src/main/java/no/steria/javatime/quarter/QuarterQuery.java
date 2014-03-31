package no.steria.javatime.quarter;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class QuarterQuery implements TemporalQuery<Quarter> {

    @Override
    public Quarter queryFrom(TemporalAccessor temporal) {
        return null;
    }
}
