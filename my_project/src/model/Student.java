package model;

import java.sql.Timestamp;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String className;
    private double mathScore;
    private double javaScore;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    // 构造函数
    public Student() {}
    
    public Student(String name, String gender, String className, double mathScore, double javaScore) {
        this.name = name;
        this.gender = gender;
        this.className = className;
        this.mathScore = mathScore;
        this.javaScore = javaScore;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public double getMathScore() {
        return mathScore;
    }
    
    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }
    
    public double getJavaScore() {
        return javaScore;
    }
    
    public void setJavaScore(double javaScore) {
        this.javaScore = javaScore;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                ", mathScore=" + mathScore +
                ", javaScore=" + javaScore +
                '}';
    }
} 