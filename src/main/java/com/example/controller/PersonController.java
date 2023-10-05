package com.example.controller;

import java.util.Scanner;

public class PersonController {
    public void addStudent(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Nhập mã số sinh viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập vào tuổi của sinh viên: ");
        int age = sc.nextInt();
        System.out.println("Nhập vào ggiới tính của sinh viên: ");
    }
}
