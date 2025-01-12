package service;

import model.Student;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    
    // 添加学生信息
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (name, gender, class_name, math_score, java_score) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGender());
            pstmt.setString(3, student.getClassName());
            pstmt.setDouble(4, student.getMathScore());
            pstmt.setDouble(5, student.getJavaScore());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("添加学生信息失败: " + e.getMessage());
            return false;
        }
    }
    
    // 根据ID查询学生
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return extractStudentFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("查询学生信息失败: " + e.getMessage());
        }
        return null;
    }
    
    // 获取所有学生信息
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                students.add(extractStudentFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("获取学生列表失败: " + e.getMessage());
        }
        return students;
    }
    
    // 计算平均分
    public void calculateAverageScores() {
        String sql = "SELECT AVG(math_score) as avg_math, AVG(java_score) as avg_java FROM students";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                double avgMath = rs.getDouble("avg_math");
                double avgJava = rs.getDouble("avg_java");
                System.out.printf("数学平均分: %.2f\n", avgMath);
                System.out.printf("Java平均分: %.2f\n", avgJava);
            }
        } catch (SQLException e) {
            System.err.println("计算平均分失败: " + e.getMessage());
        }
    }
    
    // 从ResultSet提取学生信息的辅助方法
    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setGender(rs.getString("gender"));
        student.setClassName(rs.getString("class_name"));
        student.setMathScore(rs.getDouble("math_score"));
        student.setJavaScore(rs.getDouble("java_score"));
        student.setCreatedAt(rs.getTimestamp("created_at"));
        student.setUpdatedAt(rs.getTimestamp("updated_at"));
        return student;
    }
} 