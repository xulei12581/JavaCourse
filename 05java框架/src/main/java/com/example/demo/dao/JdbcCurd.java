package com.example.demo.dao;

import java.sql.*;

public class JdbcCurd {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection connetction = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");

        /**
         * 使用 JDBC 原生接口，实现数据库的增删改查操作
         */
        //获取sql语句的执行对象
        Statement state = connetction.createStatement();
        //书写sql语句保证其正确性
        String selectsql = "select * from user ";
        String insertsql = "insert into user (id,username,password) VALUE (2,\"2\",3)";
        String updatesql = "UPDATE user SET username = '李四' WHERE id = 2";
        String deletesql = "delete from user where id = 2";
        //执行sql语句,增、删、改都是executeUpdate()方法,查是executeQuery(方法)
        int insertresult = state.executeUpdate(insertsql);
        System.out.println("表user新增成功");
        int updateresult = state.executeUpdate(updatesql);
        System.out.println("表user修改成功");
        int deleteresult = state.executeUpdate(deletesql);
        System.out.println("表user删除修改成功");
        ResultSet selectresult = state.executeQuery(selectsql);
        //处理sql语句的执行结果
        while (selectresult.next()) {
            Long id = selectresult.getLong(1);
            String username = selectresult.getString(2);
            int password = selectresult.getInt(3);

            System.out.println("id=" + id + " username=" + username + " password=" + password);
        }

        /**
         *使用事务，PrepareStatement 方式 改进上述操作
         */
        //事务方式改进
        //connetction.commit();
        //PrepareStatement方式改进
        Integer password = 10;
        String sql = "SELECT * FROM user WHERE password = ?" ;
        PreparedStatement preparedStatement = connetction.prepareStatement(sql);
        preparedStatement.setInt(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        //处理sql语句的执行结果
        if(resultSet.next()) {
            String name = resultSet.getString(2);
            System.out.println(name);
        }

        //释放资源
        state.close();
        connetction.close();

    }
}
