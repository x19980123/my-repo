import model.Student;
import service.StudentManager;
import java.util.Scanner;

public class Main {
    private static final StudentManager manager = new StudentManager();
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    queryStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    showAverageScores();
                    break;
                case 0:
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择，请重试！");
            }
        }
    }
    
    private static void showMenu() {
        System.out.println("\n=== 学生管理系统 ===");
        System.out.println("1. 添加学生");
        System.out.println("2. 查询学生");
        System.out.println("3. 显示所有学生");
        System.out.println("4. 显示平均分");
        System.out.println("0. 退出");
        System.out.print("请选择操作: ");
    }
    
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void addStudent() {
        System.out.println("\n=== 添加学生 ===");
        System.out.print("姓名: ");
        String name = scanner.nextLine();
        
        System.out.print("性别 (男/女): ");
        String gender = scanner.nextLine();
        
        System.out.print("班级: ");
        String className = scanner.nextLine();
        
        System.out.print("数学成绩: ");
        double mathScore = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Java成绩: ");
        double javaScore = Double.parseDouble(scanner.nextLine());
        
        Student student = new Student(name, gender, className, mathScore, javaScore);
        if (manager.addStudent(student)) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }
    
    private static void queryStudent() {
        System.out.println("\n=== 查询学生 ===");
        System.out.print("请输入学生ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Student student = manager.getStudentById(id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("未找到该学生！");
            }
        } catch (NumberFormatException e) {
            System.out.println("无效的ID格式！");
        }
    }
    
    private static void showAllStudents() {
        System.out.println("\n=== 所有学生信息 ===");
        manager.getAllStudents().forEach(System.out::println);
    }
    
    private static void showAverageScores() {
        System.out.println("\n=== 课程平均分 ===");
        manager.calculateAverageScores();
    }
}