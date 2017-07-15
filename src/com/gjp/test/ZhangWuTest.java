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
//            //����ִ��SQL���Ķ���
//            QueryRunner qr = new QueryRunner();
//            String sql = "insert into user values(?,?,?)";
//            Object params[] = {"1001", "tom", "��"};
//            Connection conn = JDBCUtils.getConn();
//            int line = qr.update(conn, sql, params);// ������ɱ����ݵ����ӡ�ɾ�������²���
//            //���������
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
//            Object params[] = {"����", "1001"};
//            Connection conn = JDBCUtils.getConn();
//            int update = qr.update(conn, sql, params);
//            System.out.print(update);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * ?ArrayHandler����������еĵ�һ����¼��װ��һ��Object[]�����У�
//     * �����е�ÿһ��Ԫ�ؾ���������¼�е�ÿһ���ֶε�ֵ
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
//        //���������
//        for (Object o : query) {
//            System.out.println(o);
//        }
//        conn.close();
//    }
//
//    /**
//     * ?ArrayListHandler����������е�ÿһ����¼����װ��һ��Object[]�����У�
//     * ����Щ�����ڷ�װ��List�����С�
//     */
//    @Test
//    public void findUser2() throws Exception {
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from user where id=?";
//        Object[] params = {1001};
//        Connection conn = JDBCUtils.getConn();
//        List<Object[]> list = qr.query(conn, sql, new ArrayListHandler(), params);
//        //���������
//        for (Object[] o : list) {
//            System.out.println(Arrays.toString(o));
//        }
//        conn.close();
//    }
//
//    /**
//     * ?BeanHandler	����������е�һ����¼��װ��һ��ָ����javaBean�С�
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
//        //���������
//        System.out.print(user.getId() + user.getUsername() + user.getSex());
//        conn.close();
//    }
//
//    /**
//     * ?BeanListHandler	�����������ÿһ����¼��װ��ָ����javaBean�У�
//     * ����ЩjavaBean�ڷ�װ��List������
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
//     * ColumnListHandler�����������ָ�����е��ֶ�ֵ��
//     * ��װ��һ��List������
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
//     * ��ʾʹ��DBUtils����  ������ݿ������Ӳ���
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
 * ������
 */
public class ZhangWuTest{
    /*
     * ��ʾʹ��DBUtils����  ������ݿ������Ӳ���
     */
    @Test
    public void insert() throws SQLException {
        //���빦��
        //��ȡһ��QueryRunner����
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        String sql="insert into user values(?,?,?)";
        Object[] params={"1005","�ܲ�ͨ","��"};
        int update = qr.update(sql, params);
        System.out.print(update);
    }
    @Test
    public void delete() throws SQLException {
        //ɾ������
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
    //��ѯ����,��������е�һ����¼��װ��һ��ָ����javaBean�С�
    @Test
    public void findUser() throws Exception {
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from user";
        Object[] params={};
        //User query = qr.query(sql, new BeanHandler<User>(User.class), params);
        List<User> query = qr.query(sql, new BeanListHandler<User>(User.class), params);
        //������Ĵ���
        //System.out.println(query.getId()+query.getUsername()+query.getSex());
        for (User user:query) {
            System.out.println(user.getId()+user.getUsername()+user.getSex());
        }
    }
}