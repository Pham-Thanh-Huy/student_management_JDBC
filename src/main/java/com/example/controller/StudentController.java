package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.example.lib.InputLib;

public class StudentController {
    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã số sinh viên: ");
        String idStudent = sc.nextLine();
        System.out.println("Nhập vào tên sinh viên");
        String nameStudent = sc.nextLine();

        // nhập tuổi của sinh viên
        while (true) {
            System.out.println("Nhập vào tuổi của sinh viên: ");
            String ageInput = sc.nextLine();
            // Kiểm tra nếu là số hợp lệ
            if (InputLib.isNumber(ageInput)) {
                int studentAge = Integer.parseInt(ageInput);
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
                String gender = genderInput;
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
                break;
            }else{
                System.out.println("Vui lòng nhập đúng ngày sinh kiểu định dạng (dd/mm/yyyy) và k được nhập quá thời gian thời điểm hiện tại");
            }
        }

        while(true){
            System.out.println("Nhập vào giới tính sinh viên");
            String acdemicPerformanceInput = sc.nextLine();
            if(InputLib.isValidGender(acdemicPerformanceInput)){
                String academicPerformance = acdemicPerformanceInput;
                break;
            }else{
                System.out.println("Vui lòng nhập đúng 'trung bình', 'Khá', 'giỏi', 'xuất sắc' ");
            }
        }


    }
}
