package com.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
/**
 * 数据库连接工具类
 * Created by 顾怀要 on 2017/7/15.
 */
public class JDBCUtils {
    public static final  String DRIVER= "com.mysql.jdbc.Driver";
    public static final  String URL = "jdbc:mysql://localhost:3306/gjp";
    public static final  String USER = "root";
    public static final  String PASSWORD = "tiger";
    /*
	 * 创建连接池BasicDataSource
	 */
    public static BasicDataSource dataSource=new BasicDataSource();

    static {
        //对连接池对象 进行基本的配置
        dataSource.setDriverClassName(DRIVER);//// 这是要连接的数据库的驱动
        dataSource.setUrl(URL);//指定要连接的数据库地址
        dataSource.setUsername(USER);//指定要连接数据的用户名
        dataSource.setPassword(PASSWORD);//指定要连接数据的密码
    }
    /*
	 * 返回连接池对象
	 */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
