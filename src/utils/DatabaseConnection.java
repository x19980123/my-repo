package src.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnection {
    private static Properties props = new Properties();
    
    static {
        try {
            props.load(DatabaseConnection.class.getResourceAsStream("/resources/database.properties"));
        } catch (IOException e) {
            System.err.println("无法加载数据库配置文件: " + e.getMessage());
        }
    }
    
    private static final String URL = props.getProperty("db.url");
    private static final String USER = props.getProperty("db.user");
    private static final String PASSWORD = props.getProperty("db.password");
    
    private static Connection connection = null;
    
    // 私有构造函数防止实例化
    private DatabaseConnection() {}
    
    // 获取数据库连接
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // 注册 MySQL 驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // 建立连接
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL 驱动加载失败: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("数据库连接失败: " + e.getMessage());
            }
        }
        return connection;
    }
    
    // 关闭数据库连接
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                System.err.println("关闭数据库连接失败: " + e.getMessage());
            }
        }
    }
} 