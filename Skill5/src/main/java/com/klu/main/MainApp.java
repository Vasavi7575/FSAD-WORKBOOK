package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.klu.model.Student;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean(Student.class);
        student.displayDetails();
    }
}
