package com.example.controller;

import java.util.Scanner;

import com.example.lib.InputLib;

public class PersonController {
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
    }
}
