package com.griesba.kata.bankaccount.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public class DateMapper {
    OffsetDateTime toOffsetDateTime(Timestamp timestamp) {
        return OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
    }

    Timestamp toTimestamp(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? Timestamp.from(offsetDateTime.toInstant()) : null;
    }
}
