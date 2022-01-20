package com.splio.examples.people.mysql;

import com.splio.examples.people.People;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Repository {

    @Inject
    MySQLPool pool;

    /*
    The MySQL reactive client allows you to query MySQL database while using smallrye Mutiny reactive library !
    There's also option for non-reactive MySQL client
    https://quarkus.io/guides/reactive-sql-clients
     */

    public Uni<People> fetchByID(Long ID) {
        return pool
                .preparedQuery("SELECT id, name, birthday FROM peoples WHERE id=?")
                .execute(Tuple.of(ID))
                .onItem()
                .transform(RowSet::iterator)
                .onItem()
                .transform(iterator -> iterator.hasNext() ? People.From(iterator.next()) : null);
    }
}
