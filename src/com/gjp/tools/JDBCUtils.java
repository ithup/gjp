package com.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
/**
 * ���ݿ����ӹ�����
 * Created by �˻�Ҫ on 2017/7/15.
 */
public class JDBCUtils {
    public static final  String DRIVER= "com.mysql.jdbc.Driver";
    public static final  String URL = "jdbc:mysql://localhost:3306/gjp";
    public static final  String USER = "root";
    public static final  String PASSWORD = "tiger";
    /*
	 * �������ӳ�BasicDataSource
	 */
    public static BasicDataSource dataSource=new BasicDataSource();

    static {
        //�����ӳض��� ���л���������
        dataSource.setDriverClassName(DRIVER);//// ����Ҫ���ӵ����ݿ������
        dataSource.setUrl(URL);//ָ��Ҫ���ӵ����ݿ��ַ
        dataSource.setUsername(USER);//ָ��Ҫ�������ݵ��û���
        dataSource.setPassword(PASSWORD);//ָ��Ҫ�������ݵ�����
    }
    /*
	 * �������ӳض���
	 */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
