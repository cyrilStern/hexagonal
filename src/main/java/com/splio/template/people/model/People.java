/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.people.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.vertx.mutiny.sqlclient.Row;
import java.time.LocalDate;

@RegisterForReflection // needed for native
public record People(String Name, Long ID, LocalDate Birthday) {

  public static People from(Row row) {
    return new People(row.getString("name"), row.getLong("id"), row.getLocalDate("birthday"));
  }
}
