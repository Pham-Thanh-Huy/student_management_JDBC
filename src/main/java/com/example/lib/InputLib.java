package com.example.lib;

public class InputLib {
    
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
}

