package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
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
                System.out.println("数据库连接成功！");
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
                System.out.println("数据库连接已关闭！");
            } catch (SQLException e) {
                System.err.println("关闭数据库连接失败: " + e.getMessage());
            }
        }
    }
} 