-- 创建数据库
CREATE DATABASE IF NOT EXISTS student_management;

-- 使用数据库
USE student_management;

-- 创建学生表
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    gender ENUM('男', '女') NOT NULL,
    class_name VARCHAR(20) NOT NULL,
    math_score DECIMAL(5,2),
    java_score DECIMAL(5,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 添加索引
CREATE INDEX idx_class ON students(class_name);
CREATE INDEX idx_name ON students(name);

-- 添加一些测试数据
INSERT INTO students (name, gender, class_name, math_score, java_score) VALUES 
('张三', '男', '计算机1班', 85.5, 90.0),
('李四', '女', '计算机1班', 92.0, 88.5),
('王五', '男', '计算机2班', 78.5, 85.0); 