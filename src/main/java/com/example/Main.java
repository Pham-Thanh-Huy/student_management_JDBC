package com.example;

import java.util.Scanner;
import com.example.controller.StudentController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("--------Quản lý sinh viên ----------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. In ra danh sách sinh viên");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("6. Thoát");
            System.out.println("Tìm kiếm sinh viên theo mã số sinh viên");
            int choose = sc.nextInt();
            sc.nextLine(); // Đọc dòng trống

            switch (choose){
                case 1:
                    StudentController.addStudent(sc);
                    break;
                case 2:
                    StudentController.updateStudent(sc);
                    break;
                case 3:
                    StudentController.deleteStudent(sc);
                    break;
                case 4:
                    StudentController.getAllStudent();
                    break;
                case 5:
                    StudentController.getStudentById(sc);
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập không nhập hợp lệ");
            }
        }
    }
}
