package com.splio.examples.people;

import io.vertx.mutiny.sqlclient.Row;

import java.time.LocalDate;

public record People(
        String Name,
        Long ID,
        LocalDate Birthday
) {

    public static People From(Row row) {
        return new People(
                row.getString("name"),
                row.getLong("id"),
                row.getLocalDate("birthday")
        );
    }
}
