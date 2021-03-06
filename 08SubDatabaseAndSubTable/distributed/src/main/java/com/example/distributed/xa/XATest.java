package com.example.distributed.xa;

import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class XATest {
    private static String configFile = "/META-INF/sharding-databases.yaml";
//    private static String configFile = "/META-INF/sharding-databases-tables-postgresql.yaml";
//    private static String configFile = "/META-INF/master-slave.yaml";

    private static final String MYSQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, address_id BIGINT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))";

//    private static final String POSTGRESQL_CREATE_TABLE =
//        "CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT PRIMARY KEY NOT NULL, user_id INT NOT NULL, address_id BIGINT NOT NULL, status VARCHAR(50))";

    public static void main(final String[] args) throws SQLException, IOException {
        //获取数据源
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(getFile(configFile));
        //创建jdbc连接
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //初始化sql
        initEnvironment(jdbcTemplate);
        //执行事务
        process(jdbcTemplate);
    }

    private static File getFile(final String fileName) {
        return new File(Thread.currentThread().getClass().getResource(fileName).getFile());
    }

    private static void initEnvironment(final JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("TRUNCATE TABLE t_order");
        jdbcTemplate.execute(MYSQL_CREATE_TABLE);
    }

    private static void process(final JdbcTemplate jdbcTemplate) {
        TransactionTypeHolder.set(TransactionType.XA);
        System.out.println("############### start commit transaction ################");
        jdbcTemplate.execute(new ConnectionCallback<Object>() {
            @Override
            public Object doInConnection(final Connection connection) throws SQLException, DataAccessException {
                connection.setAutoCommit(false);
                int result;
                try {
                    result = doInsert(connection);
                    printData(jdbcTemplate, "----------------- query all before commit ------------------");
                    connection.commit();
                    printData(jdbcTemplate, "----------------- query all after  commit ------------------");
                } catch (final SQLException ex) {
                    connection.rollback();
                    throw ex;
                }
                return result;
            }
        });
        System.out.println("############### start rollback transaction ################");
        TransactionTypeHolder.set(TransactionType.XA);
        jdbcTemplate.execute(new ConnectionCallback<Object>() {
            @Override
            public Object doInConnection(final Connection connection) throws SQLException, DataAccessException {
                connection.setAutoCommit(false);
                doInsert(connection);
                connection.rollback();
                printData(jdbcTemplate, "----------------- query all after rollback ------------------");
                return null;
            }
        });
    }

    private static int doInsert(final Connection connection) throws SQLException {
        int updateCount = 0;
        String sql = "INSERT INTO t_order (user_id, address_id, status) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setLong(2, i);
                preparedStatement.setString(3, "INIT");
                updateCount += preparedStatement.executeUpdate();
            }
            return updateCount;
        }
    }

    private static void printData(final JdbcTemplate jdbcTemplate, final String title) {
        System.out.println(title);
        List<Map<String, Object>> data = jdbcTemplate.queryForList("SELECT * FROM t_order");
        if (data.isEmpty()) {
            System.out.println("t_order is empty");
            return;
        }
        for (Map<String, Object> each : data) {
            System.out.println(each.toString());
        }
    }
}
