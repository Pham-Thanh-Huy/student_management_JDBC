package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.dao.StudentDao;
import com.example.lib.InputLib;
import com.example.model.StudentModel;

public class StudentController {
    public static void addStudent(Scanner sc) {
        System.out.println("Nhập mã số sinh viên: ");
        String idStudent = sc.nextLine();
        System.out.println("Nhập vào tên sinh viên");
        String nameStudent = sc.nextLine();
        int studentAge = 0;
        String gender = "";
        Date studentDate = null;
        String academicPerformance = "";

        // nhập tuổi của sinh viên
        while (true) {
            System.out.println("Nhập vào tuổi của sinh viên: ");
            String ageInput = sc.nextLine();
            // Kiểm tra nếu là số hợp lệ
            if (InputLib.isNumber(ageInput)) {
               studentAge = Integer.parseInt(ageInput);
                break; // Thoát khỏi vòng lặp khi đã có số hợp lệ
            } else {
                System.out.println("Tuổi không hợp lệ, phải là số. Vui lòng nhập lại.");
            }
        }

        // nhập giới tính sinh viên
        while(true){
            System.out.println("Nhập vào giới tính sinh viên");
            String genderInput = sc.nextLine();
            if(InputLib.isValidGender(genderInput)){
              gender = genderInput;
                break;
            }else{
                System.out.println("Vui lòng nhập đúng 'nam' hoặc 'nữ'");
            }
        }


        // Nhập vào tuổi của sinh viên

        while(true){
            System.out.println("Nhập vào ngày sinh(Theo đúng định dạng dd/mm/yyyy): ");
            String dateInput = sc.nextLine();
            if(InputLib.isValidDateOfBirth(dateInput)){
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(dateInput, timeFormatter);
                studentDate = Date.valueOf(localDate); // Chuyển đổi thành java.sql.Date

                break;
            }else{
                System.out.println("Vui lòng nhập đúng ngày sinh kiểu định dạng (dd/mm/yyyy) và k được nhập quá thời gian thời điểm hiện tại");
            }
        }

        while(true){
            System.out.println("Nhập vào học lực của sinh viên (trung bình, khá, giỏi, xuất sắc)");
            String acdemicPerformanceInput = sc.nextLine();
            if(InputLib.isAcademicPerformance(acdemicPerformanceInput)){
             academicPerformance = acdemicPerformanceInput;
                break;
            }else{
                System.out.println("Vui lòng nhập đúng 'trung bình', 'Khá', 'giỏi', 'xuất sắc'");
            }
        }

        StudentModel t = new StudentModel(null, idStudent, nameStudent, studentAge, gender, studentDate, academicPerformance);
        StudentDao std  = new StudentDao();
      boolean check =   std.addStudent(t);
      if(check == true){
          System.out.println("Add sinh viên thành công");
      }else{
          System.out.println("Add sinh viên thất bại");
      }

    }


    public static void deleteStudent(Scanner sc){
        System.out.println("Nhập vào mã số sinh viên bạn muốn xóa");
        String studentId = sc.nextLine();
        StudentDao std  = new StudentDao();
        StudentModel student =  std.getStudentByStudentId(studentId);
        if(student == null){
            System.out.println("Không có sinh viên nào có mã số: "+ studentId);
            return;
        }
        System.out.println("Thông tin sinh viên bạn chuẩn bị xóa: ");
        System.out.println(student.toString());
        int choose = 0;
        System.out.println("Bạn có chắc chắn muốn xóa không? Ấn 1 để xóa, Ấn 0 để không xóa");
        while(true){
            String check = sc.nextLine();
            if(InputLib.isChoose(check)){
                 choose = Integer.parseInt(check);
                break;
            }else{
                System.out.println("Vui lòng nhập chọn 1(xóa) hoặc 2(không xóa)");
            }
        }

        if(choose == 1){
            std.deleteStudent(studentId);
            System.out.println("Xóa thành công");
        }else{
            System.out.println("Bạn chọn không xóa,đữ liệu sinh viên đấy sẽ vẫn còn ");
        }

    }


    public static void updateStudent(Scanner sc){
        System.out.println("Nhập vào mã số sinh viên bạn muốn sửa");
        String studentId = sc.nextLine();
        StudentDao std  = new StudentDao();
        StudentModel student =  std.getStudentByStudentId(studentId);
        if(student == null){
            System.out.println("Không có sinh viên nào có mã số: "+ studentId);
            return;
        }
        System.out.println("Thông tin sinh viên bạn chuẩn bị sửa: ");
        System.out.println(student.toString());
        int choose = 0;
        System.out.println("Bạn có chắc chắn muốn sửa không? Ấn 1 để sửa, Ấn 0 để không sửa");
        while(true){
            String check = sc.nextLine();
            if(InputLib.isChoose(check)){
                choose = Integer.parseInt(check);
                break;
            }else{
                System.out.println("Vui lòng nhập chọn 1(xóa) hoặc 2(không xóa)");
            }
        }

        if(choose == 1){
            System.out.println("Nhập vào tên sinh viên");
            String nameStudent = sc.nextLine();
            int studentAge = 0;
            String gender = "";
            Date studentDate = null;
            String academicPerformance = "";

            // nhập tuổi của sinh viên
            while (true) {
                System.out.println("Nhập vào tuổi của sinh viên: ");
                String ageInput = sc.nextLine();
                // Kiểm tra nếu là số hợp lệ
                if (InputLib.isNumber(ageInput)) {
                    studentAge = Integer.parseInt(ageInput);
                    break; // Thoát khỏi vòng lặp khi đã có số hợp lệ
                } else {
                    System.out.println("Tuổi không hợp lệ, phải là số. Vui lòng nhập lại.");
                }
            }

            // nhập giới tính sinh viên
            while(true){
                System.out.println("Nhập vào giới tính sinh viên");
                String genderInput = sc.nextLine();
                if(InputLib.isValidGender(genderInput)){
                    gender = genderInput;
                    break;
                }else{
                    System.out.println("Vui lòng nhập đúng 'nam' hoặc 'nữ'");
                }
            }


            // Nhập vào tuổi của sinh viên

            while(true){
                System.out.println("Nhập vào ngày sinh(Theo đúng định dạng dd/mm/yyyy): ");
                String dateInput = sc.nextLine();
                if(InputLib.isValidDateOfBirth(dateInput)){
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.parse(dateInput, timeFormatter);
                    studentDate = Date.valueOf(localDate); // Chuyển đổi thành java.sql.Date
                    break;
                }else{
                    System.out.println("Vui lòng nhập đúng ngày sinh kiểu định dạng (dd/mm/yyyy) và k được nhập quá thời gian thời điểm hiện tại");
                }
            }

            while(true){
                System.out.println("Nhập vào học lực của sinh viên (trung bình, khá, giỏi, xuất sắc)");
                String acdemicPerformanceInput = sc.nextLine();
                if(InputLib.isAcademicPerformance(acdemicPerformanceInput)){
                    academicPerformance = acdemicPerformanceInput;
                    break;
                }else{
                    System.out.println("Vui lòng nhập đúng 'trung bình', 'Khá', 'giỏi', 'xuất sắc'");
                }
            }

            // sửa  bằng StudentDao
            StudentModel t = new StudentModel(null,studentId , nameStudent, studentAge, gender, studentDate, academicPerformance);
          boolean check =  std.updateStudent(t);
          if(check){
              System.out.println("Update thành công");
          }else{ System.out.println("Update thất bại");}

        }else{
            System.out.println("Bạn chọn không sửa thông tin sinh viên");
        }

    }


    public static void getAllStudent(){
        List<StudentModel> listStudent = new ArrayList<>();
        StudentDao std =  new StudentDao();
        listStudent = std.getAllStudents();
        for(StudentModel student : listStudent){
            System.out.println(student.toString());
        }

    }

    public  static void getStudentById(Scanner sc){

        System.out.println("Nhập vào mã số sinh viên bạn muốn tìm kiếm");
        String studentId = sc.nextLine();
        StudentDao std  = new StudentDao();
        StudentModel student =  std.getStudentByStudentId(studentId);
        if(student == null){
            System.out.println("Không có sinh viên nào có mã số: "+ studentId);
            return;
        }
        System.out.println("Thông tin sinh viên bạn vừa tìm kiếm ");
        System.out.println(student.toString());
    }
}
