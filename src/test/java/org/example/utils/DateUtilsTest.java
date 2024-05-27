package org.example.utils;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class DateUtilsTest {

    @Test
    public void shouldReturnTrueIfDateIsToday() {

        Date date = Date.from(Instant.now());
        boolean isToday = DateUtils.isToday(date);

        assertThat(isToday).isTrue();
    }

    @Test
    public void shouldReturnFalseIfDateIsNotToday() {

        Date date = Date.from(Instant.now());
        boolean isToday = DateUtils.isToday(date);

        assertThat(isToday).isTrue();
    }

}