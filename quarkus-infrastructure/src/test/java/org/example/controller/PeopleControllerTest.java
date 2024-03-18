package org.example.controller;

import com.google.common.collect.Lists;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit5.virtual.ShouldNotPin;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
@QuarkusTest
class PeopleControllerTest {
@Inject @Any
MySQLPool pool;
//@QuarkusTest
//@VirtualThreadUnit
@Test
//@ShouldNotPin
void test_4() throws SQLException, InterruptedException {
    for (int i = 0; i < 1000; i++) {
        int finalI = i;
        final Thread start = Thread.ofVirtual().start(() -> {
            // create a Statement
           /*     var result = pool.preparedQuery("select * from data_alfounet.loyalty_status where id=1")
                        .mapping(row -> row.getInteger("id"))
                        .execute()
                        .map(r -> Lists.newArrayList(r.iterator()).getFirst()).await().indefinitely();
                System.out.println(result);*/
        });
    }
}

/*    @Test
    @Benchmark
    @ShouldPin
    void test1() throws InterruptedException {
        record Test(SelectField<String> id) {

        }

        final Thread start = Thread.ofVirtual().start(() -> {
            final Optional<Record1<Integer>> id = dsl
                    .select(DSL.field("id", Integer.class))
                    .from("data_alfounet.loyalty_status")
                    .where("id=3")
                    .stream()
                    .findFirst();
            Assertions.assertEquals(id.get().component1(), 3);
        });
        start.join();
    }*/

    /*    @Test
        @Benchmark
        @ShouldPin
        void test2() throws InterruptedException {
            record Test(SelectField<String> id) {

            }
            final Thread start = Thread.ofVirtual().start(() -> {
                final Optional<Record1<Integer>> id = dsl
                        .select(DSL.field("id", Integer.class))
                        .from("data_alfounet.loyalty_status")
                        .where("id=3")
                        .stream()
                        .findFirst();
                Assertions.assertEquals(id.get().component1(), 3);
            });
            start.join();
        }*/
    @Test
    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    //@ShouldNotPin
    void test_3() throws SQLException, InterruptedException, ClassNotFoundException {
        var hikari = new HikariCPDataSource();

        try (var exe = Executors.newVirtualThreadPerTaskExecutor()) {
                try {
                    hikari.createConnections();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                    try (Connection connx = hikari.pool.getConnection()){
                for (int i = 0; i < 1000; i++) {
                    int finalI = i;
                    exe.execute(() -> {
                    // create a Statement
                    //execute query
                    Statement stmt = null;
                    try {
                        stmt = connx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try (ResultSet rs = stmt.executeQuery("SELECT 1" + finalI)) {
                                //position result to first
                                rs.first();
                                System.out.println(rs.getInt(1));
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                    });
                   }
                    exe.awaitTermination(20, TimeUnit.SECONDS);
                }
        }

}
    @Test
    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @ShouldNotPin
    void test_33() throws SQLException, InterruptedException {
        final ArrayList<Supplier<Integer>> subtasks = new ArrayList<>();
        try (var scope = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                int finalI = i;
                scope.execute(() -> {
                    // create a Statement
                    final Integer indefinitely = pool.preparedQuery("select "+finalI)
                            .mapping(row -> row.getInteger(0))
                            .execute()
                            .map(r -> Lists.newArrayList(r.iterator()).getFirst())
                            .await()
                            .indefinitely();
                    System.out.println(indefinitely);
                });
            }
            scope.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.getMessage();
        }
        subtasks.forEach(element -> System.out.println("this is the th: " + element.get()));
    }


}
