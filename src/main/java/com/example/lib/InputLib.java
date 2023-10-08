package com.example.lib;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputLib {
    // tạo thuộc tính ép nhập ngày tháng năm


    public static boolean isNumber(String input){

        try {
            // Sử dụng phương thức parseDouble để kiểm tra xem chuỗi có phải là số hay không
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // Nếu có ngoại lệ NumberFormatException, chuỗi không phải là số
            return false;
        }
    }
    public static boolean isValidGender(String input) {
       String check = input.toLowerCase();
      if(check.equals("nam") || check.equals("nữ")){
        return true;
      }
        return false;
    }


    // hỗ trợ nhập ngày sinh
    public static boolean isValidDateOfBirth(String input) {
        try {
            // Định dạng ngày tháng
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // Cố gắng phân tích chuỗi thành LocalDate
            LocalDate date = LocalDate.parse(input, formatter);
            // Kiểm tra xem ngày tháng có hợp lệ không (ví dụ: không phải tương lai)
            LocalDate currentDate = LocalDate.now();
            return !date.isAfter(currentDate);
        } catch (DateTimeParseException e) {
            return false; // Không thể phân tích được hoặc không hợp lệ
        }
    }

    public static boolean isAcademicPerformance(String input) {
        String check = input.toLowerCase();
        if(check.equals("trung bình") || check.equals("khá")|| check.equals("giỏi") || check.equals("xuất sắc")){
            return true;
        }
        return false;
    }

    public static boolean isChoose(String input) {
        String check = input.toLowerCase();
        if(check.equals("1") || check.equals("0")){
            return true;
        }
        return false;
    }
}

