package com.gjp.test;
//
//import com.gjp.pojo.User;
//import com.gjp.tools.JDBCUtils;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.*;
import com.gjp.pojo.User;
import com.gjp.tools.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
//
//import java.sql.Connection;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by acer on 2017/7/15.
// */
//public class ZhangWuDao {
//    @Test
//    public void insert() {
//        try {
//            //用来执行SQL语句的对象，
//            QueryRunner qr = new QueryRunner();
//            String sql = "insert into user values(?,?,?)";
//            Object params[] = {"1001", "tom", "男"};
//            Connection conn = JDBCUtils.getConn();
//            int line = qr.update(conn, sql, params);// 用来完成表数据的增加、删除、更新操作
//            //结果集处理
//            System.out.println(line);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void update() {
//        try {
//            QueryRunner qr = new QueryRunner();
//            String sql = "update user set username=? where id=?";
//            Object params[] = {"郭靖", "1001"};
//            Connection conn = JDBCUtils.getConn();
//            int update = qr.update(conn, sql, params);
//            System.out.print(update);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * ?ArrayHandler：将结果集中的第一条记录封装到一个Object[]数组中，
//     * 数组中的每一个元素就是这条记录中的每一个字段的值
//     *
//     * @throws Exception
//     */
//    @Test
//    public void findUser1() throws Exception {
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from user";
//        Object[] params = {};
//        Connection conn = JDBCUtils.getConn();
//        Object[] query = qr.query(conn, sql, new ArrayHandler(), params);
//        //结果集处理
//        for (Object o : query) {
//            System.out.println(o);
//        }
//        conn.close();
//    }
//
//    /**
//     * ?ArrayListHandler：将结果集中的每一条记录都封装到一个Object[]数组中，
//     * 将这些数组在封装到List集合中。
//     */
//    @Test
//    public void findUser2() throws Exception {
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from user where id=?";
//        Object[] params = {1001};
//        Connection conn = JDBCUtils.getConn();
//        List<Object[]> list = qr.query(conn, sql, new ArrayListHandler(), params);
//        //结果集处理
//        for (Object[] o : list) {
//            System.out.println(Arrays.toString(o));
//        }
//        conn.close();
//    }
//
//    /**
//     * ?BeanHandler	：将结果集中第一条记录封装到一个指定的javaBean中。
//     *
//     * @throws Exception
//     */
//    @Test
//    public void findUser3() throws Exception {
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from user where id=?";
//        Object[] params = {1003};
//        Connection conn = JDBCUtils.getConn();
//        User user = qr.query(conn, sql, new BeanHandler<User>(User.class), params);
//        //结果集处理
//        System.out.print(user.getId() + user.getUsername() + user.getSex());
//        conn.close();
//    }
//
//    /**
//     * ?BeanListHandler	：将结果集中每一条记录封装到指定的javaBean中，
//     * 将这些javaBean在封装到List集合中
//     *
//     * @throws Exception
//     */
//    @Test
//    public void findUser4() throws Exception {
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from user";
//        Connection conn = JDBCUtils.getConn();
//        Object[] params = {};
//        List<User> userList = qr.query(conn, sql, new BeanListHandler<User>(User.class), params);
//        for (User user : userList) {
//            System.out.println(user.getId() + ":" + user.getUsername() + ":" + user.getSex());
//        }
//        conn.close();
//    }
//
//    /**
//     * ColumnListHandler：将结果集中指定的列的字段值，
//     * 封装到一个List集合中
//     */
//    @Test
//    public void findUser5() throws Exception {
//        QueryRunner qr = new QueryRunner();
//        String sql = "select username from user";
//        Object[] params = {};
//        Connection conn = JDBCUtils.getConn();
//        List<String> query = qr.query(conn, sql, new ColumnListHandler<String>(), params);
//        for (String s : query) {
//            System.out.println(s);
//        }
//        conn.close();
//    }
//
//    /*
//     * 演示使用DBUtils工具  完成数据库表的增加操作
//     */
//    @Test
//    public void findUser6() {
//        QueryRunner qr = new QueryRunner();
//    }
//}

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * 测试类
 */
public class ZhangWuTest{
    /*
     * 演示使用DBUtils工具  完成数据库表的增加操作
     */
    @Test
    public void insert() throws SQLException {
        //插入功能
        //获取一个QueryRunner对象
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        String sql="insert into user values(?,?,?)";
        Object[] params={"1005","周伯通","男"};
        int update = qr.update(sql, params);
        System.out.print(update);
    }
    @Test
    public void delete() throws SQLException {
        //删除功能
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        String sql="delete from user where id=?";
        Object[] params={1005};
        int update = qr.update(sql, params);
        System.out.print(update);
    }
    @Test
    public  void update() throws SQLException {
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        String sql="update user set username=? where id=?";
        Object[] params={"tom","1001"};
        int update = qr.update(sql, params);
        System.out.print(update);
    }
    //查询功能,将结果集中第一条记录封装到一个指定的javaBean中。
    @Test
    public void findUser() throws Exception {
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from user";
        Object[] params={};
        //User query = qr.query(sql, new BeanHandler<User>(User.class), params);
        List<User> query = qr.query(sql, new BeanListHandler<User>(User.class), params);
        //结果集的处理
        //System.out.println(query.getId()+query.getUsername()+query.getSex());
        for (User user:query) {
            System.out.println(user.getId()+user.getUsername()+user.getSex());
        }
    }
}