package ca.mcgill.ecse.coolsupplies.controller;

import java.util.List;
import java.util.ArrayList;
// Do I need to import the application?
//import ca.mcgill.ecse.coolsupplies.application.CoolSuppliesApplication;
import ca.mcgill.ecse.coolsupplies.application.CoolSuppliesApplication;
// I added the two three imports
import ca.mcgill.ecse.coolsupplies.model.CoolSupplies;
import ca.mcgill.ecse.coolsupplies.model.Grade;
import ca.mcgill.ecse.coolsupplies.model.GradeBundle;


public class CoolSuppliesFeatureSet4Controller {

  public static String addBundle(String name, int discount, String gradeLevel) {

    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Error: Bundle name cannot be empty");
    }
    if (discount < 0) {
        throw new IllegalArgumentException("Error: Discount cannot be negative");
    }
    if (gradeLevel == null || gradeLevel.trim().isEmpty()) {
        throw new IllegalArgumentException("Error: Grade level cannot be empty");
    }

    CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
    for (GradeBundle existingBundle : coolSupplies.getBundles()) {
        if (existingBundle.getName().equals(name)) {
            throw new IllegalArgumentException("Error: A bundle with the same name already exists");
        }
    }

    Grade grade = findGradeByLevel(gradeLevel);
    if (grade == null) {
        throw new IllegalArgumentException("Error: Grade with the specified level does not exist");
    }

    GradeBundle newBundle = new GradeBundle(name, discount, coolSupplies, grade);
    grade.setBundle(newBundle);
    coolSupplies.addBundle(newBundle);
  }


  public static String updateBundle(String name, String newName, int newDiscount, String newGradeLevel) {

    if (newName == null || newName.trim().isEmpty()) {
      throw new IllegalArgumentException("Error: New bundle name cannot be empty");
    }
    if (newDiscount < 0) {
        throw new IllegalArgumentException("Error: Discount cannot be negative");
    }
    if (newGradeLevel == null || newGradeLevel.trim().isEmpty()) {
        throw new IllegalArgumentException("Error: New grade level cannot be empty");
    }
    

    GradeBundle bundle = findBundleByName(name);
    if (bundle == null) {
        throw new IllegalArgumentException("Error: Bundle with the specified name does not exist");
    }

    Grade newGrade = findGradeByLevel(newGradeLevel);
    if (newGrade == null) {
        throw new IllegalArgumentException("Error: Grade with the specified level does not exist");
    }

    bundle.setName(newName);
    bundle.setDiscount(newDiscount);
    newGrade.setBundle(bundle);

  }

  public static String deleteBundle(String name) {
    CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
    GradeBundle bundle = findBundleByName(name);
    if (bundle == null) {
        throw new IllegalArgumentException("Error: Bundle with the specified name does not exist.");
    }

    Grade grade = bundle.getGrade();
    if (grade != null) {
        grade.setBundle(null);
    }

    coolSupplies.removeBundle(bundle);
  }



  public static TOGradeBundle getBundle(String name) {

    GradeBundle bundle = findBundleByName(name);
    if (bundle == null) {
        throw new IllegalArgumentException("Error: Bundle with the specified name does not exist.");
    }
    return new TOGradeBundle(bundle.getName(), bundle.getDiscount(), bundle.getGrade().getLevel());
  }

  public static List<TOGradeBundle> getBundles() {

        List<TOGradeBundle> bundleList = new ArrayList<>();
        for (GradeBundle bundle : CoolSuppliesApplication.getBundles()) {
            bundleList.add(new TOGradeBundle(bundle.getName(), bundle.getDiscount(), bundle.getGrade().getLevel()));
        }
        return bundleList;
  }
// ____________________________________Helper Functions____________________________________

    private static Grade findGradeByLevel(String gradeLevel) {
        CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
        for (Grade grade : coolSupplies.getGrades()) {
            if (grade.getLevel().equals(gradeLevel)) {
                return grade;
            }
        }
        return null;
    }

    private static GradeBundle findBundleByName(String name) {
        CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
        for (GradeBundle bundle : coolSupplies.getBundles()) {
            if (bundle.getName().equals(name)) {
                return bundle;
            }
        }
        return null;
    }
}