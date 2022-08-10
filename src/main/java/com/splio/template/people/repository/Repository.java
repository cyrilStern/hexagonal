/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.people.repository;

import com.splio.template.people.model.People;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository {

  private final MySQLPool pool;

  public Repository(final MySQLPool pool) {
    this.pool = pool;
  }
  /*
  The MySQL reactive client allows you to query MySQL database while using smallrye Mutiny reactive library !
  There's also option for non-reactive MySQL client
  https://quarkus.io/guides/reactive-sql-clients
   */

  public Uni<People> fetchByID(Long ID) {
    return pool.preparedQuery("SELECT id, name, birthday FROM peoples WHERE id=?")
        .execute(Tuple.of(ID))
        .onItem()
        .transform(RowSet::iterator)
        .onItem()
        .transform(iterator -> iterator.hasNext() ? People.from(iterator.next()) : null);
  }
}
