package com.company.AfsanaHussainU1Capstone.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordUtil {

    //managerr - manager
    //staff - staff
    //admin - admin

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = "staff";

        String passwordd = encoder.encode(password);

        System.out.println(passwordd);
    }


}

