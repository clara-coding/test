package ca.mcgill.ecse.coolsupplies.controller;

import java.util.ArrayList;
import java.util.List;
import ca.mcgill.ecse.coolsupplies.application.CoolSuppliesApplication;
import ca.mcgill.ecse.coolsupplies.model.CoolSupplies;
import ca.mcgill.ecse.coolsupplies.model.Student;

public class CoolSuppliesFeatureSet2Controller {

    public static String addStudent(String name, String gradeLevel) {
        if (name == null || name.trim().isEmpty()) {
            return "Error: Student name cannot be empty";
        }
        if (gradeLevel == null || gradeLevel.trim().isEmpty()) {
            return "Error: Grade level cannot be empty";
        }
      
    try {
        CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
        for (Student existingStudent : coolSupplies.getStudents()) {
            if (existingStudent.getName().equals(name)) {
                return "Error: A student with the same name already exists";
            }
        Grade grade = findGradeByLevel(gradeLevel);
        if (grade == null) {
            return "Error: Grade with the specified level does not exist";
        }

        
            Student newStudent = new Student(name, gradeLevel);
            coolSupplies.addStudent(newStudent);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "";
    }

    public static String updateStudent(String name, String newName, String newGradeLevel) {
        if (newName == null || newName.trim().isEmpty()) {
            return "Error: New student name cannot be empty";
        }
        if (newGradeLevel == null || newGradeLevel.trim().isEmpty()) {
            return "Error: New grade level cannot be empty";
        }
      
      try {
        CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
        Student student = findStudentByName(name);
        if (student == null) {
            return "Error: Student with the specified name does not exist";
        }

        
            student.setName(newName);
            student.setGradeLevel(newGradeLevel);
        } catch (RuntimeException e) {
            return e.getMessage();
        }

        return "";
    }

    public static String deleteStudent(String name) {
        Student student = findStudentByName(name);
        if (student == null) {
            return "Error: Student with the specified name does not exist";
        }

        try {
          Grade grade = bundle.getGrade();
          if (grade != null) {
            grade.setBundle(null);
            student.delete();

        }    
        } catch (RuntimeException e) {
            return e.getMessage();
        }

        return "";
    }

    public static TOStudent getStudent(String name) {
        Student student = findStudentByName(name);
        if (student == null) {
            throw new IllegalArgumentException("Error: Student with the specified name does not exist");
        }

        return new TOStudent(student.getName(), student.getGradeLevel());
    }

    public static List<TOStudent> getStudents() {
        List<TOStudent> studentList = new ArrayList<>();
        CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
        for (Student student : coolSupplies.getStudents()) {
            studentList.add(new TOStudent(student.getName(), student.getGradeLevel()));
        }
        return studentList;
    }

    // ____________________________________Helper Function____________________________________

    private static Student findStudentByName(String name) {
        CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
        for (Student student : coolSupplies.getStudents()) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}
