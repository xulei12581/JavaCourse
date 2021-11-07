package geektime.spring.data.multidatasourcedemo.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 使用PreparedStatement实现批量数据的操作
 *
 * update、delete本身具有批量操作的效果
 * 此时的批量操作主要指的是批量插入。使用PreparedStatement如何实现更高效的批量操作？
 *
 * 题目：向goods表中插入两万条数据
 * 方式一：使用Statement
 */
public class InsertTest {

    public static void main(String[] args) throws SQLException {
        //这种方式
        //InsertTest.testInsert1();
        //InsertTest.testInsert2();
        InsertTest.testInsert3();
    }
    //批量插入的方式一：使用PreparedStatement 几十分钟
    public static void testInsert1() throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/spring?rewriteBatchedStatements = true","root","root");
            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();

            //connection = JDBCUtils.getConnection();
            String sql = "insert into jike_order (order_no) values(?)";
            preparedStatement = connection.prepareStatement(sql);
//            connection.close();
            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setObject(1, "name_" + i);
                preparedStatement.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//20000:49918
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    /**
     * 批量插入的方式二：拼接sql 一次插入  18S
     */
    public static void testInsert2() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long start = System.currentTimeMillis();
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/spring?rewriteBatchedStatements = true","root","root");
            //设置不允许自动提交数据
            connection.setAutoCommit(false);
            String sql = "insert into jike_order (order_no) values(?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setObject(1, "name_" + i);
                //拼接sql
                preparedStatement.addBatch();
                preparedStatement.executeBatch();

            }
            //提交数据
            connection.commit();
            preparedStatement.clearBatch();
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//20000:49918 -- 1153 1000000：17204 -- 8511
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    /**
     * 批量插入的方式三：拼接sql 一次五万条批量插入 10S左右
     */
    public static void testInsert3() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long start = System.currentTimeMillis();
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/spring?rewriteBatchedStatements = true","root","root");
            connection.setAutoCommit(false);
            String sql = "insert into jike_order (order_no) values(?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setObject(1, i);
                //1.sql
                preparedStatement.addBatch();
                if (i % 50000 == 0){
                    //2.执行
                    preparedStatement.executeBatch();
                    //3.清空
                    connection.commit();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//20000:49918 -- 1153   1000000：17204
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}