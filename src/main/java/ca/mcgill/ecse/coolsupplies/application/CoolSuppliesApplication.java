package ca.mcgill.ecse.coolsupplies.application;

import ca.mcgill.ecse.coolsupplies.model.CoolSupplies;
import ca.mcgill.ecse.coolsupplies.controller.CoolSuppliesFeatureSet4Controller;


public class CoolSuppliesApplication {

  private static CoolSupplies coolSupplies;

  public static void main(String[] args) {
    // TODO Start the application user interface here
    System.out.println("testing print");
    getCoolSupplies();
    // The following is meant to test featureSet4 of the controller:


    // creating grades
    System.out.println("Test 1: Setting up grades");
    coolSupplies.addGrade("Grade 1");
    coolSupplies.addGrade("Grade 2");
    coolSupplies.addGrade("Grade 3");
    System.out.println(coolSupplies.getGrades() + "\n");

    // Creating bundles
    System.out.println("Test 2a: addBundle");
    CoolSuppliesFeatureSet4Controller.addBundle("Bundle1", 15, "Grade 1");
    CoolSuppliesFeatureSet4Controller.addBundle("Bundle2", 20, "Grade 2");
    System.out.println(coolSupplies.getBundles() + "\n");


    // Trying to add a bundle that has a negative discount
    System.out.println("Test 2b: addBundle with negative discount");
    System.out.println(CoolSuppliesFeatureSet4Controller.addBundle("Bundle3", -5, "Grade 3") + "\n");

    System.out.println("Test 2b: addBundle with empty name");
    System.out.println(CoolSuppliesFeatureSet4Controller.addBundle("", -5, "Grade 3") + "\n");

    // Trying to add a bundle that has a negative discount
    System.out.println("Test 2b: addBundle with negative discount");
    System.out.println(CoolSuppliesFeatureSet4Controller.addBundle("Bundle3", -5, "Grade 3") + "\n");

    // Retrieving bundle information
    System.out.println("Test 3: getBundle");
    System.out.println(CoolSuppliesFeatureSet4Controller.getBundle("Bundle1"));


    // Listing all bundles
    System.out.println("\nTest 4: getBundles");
    System.out.println(CoolSuppliesFeatureSet4Controller.getBundles());

    // Updating a bundle
    System.out.println("\nTest 5: updateBundle");
    CoolSuppliesFeatureSet4Controller.updateBundle("Bundle1", "UpdatedBundle1", 25, "Grade 2");
    System.out.println(CoolSuppliesFeatureSet4Controller.getBundles());


    // Deleting a bundle
    System.out.println("\nTest 6: Deleting bundle");
    CoolSuppliesFeatureSet4Controller.deleteBundle("Bundle2");
    System.out.println(CoolSuppliesFeatureSet4Controller.getBundles());

    // The functions getBundle, getBundles, addBundle, updateBundle, deleteBundle all worked as expected!!!
  }

  public static CoolSupplies getCoolSupplies() {
    if (coolSupplies == null) {
      // these attributes are default, you should set them later with the setters
      coolSupplies = new CoolSupplies();
    }
    return coolSupplies;
  }
}
