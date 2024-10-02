package ca.mcgill.ecse.coolsupplies.controller;

import java.util.List;

public class CoolSuppliesFeatureSet4Controller {

  public static String addBundle(String name, int discount, String gradeLevel) {
    // throw new UnsupportedOperationException("Not implemented yet.");
    if (name == null) {
      throw IllegalArgumentException("A bundle needs a name on order to be created")
    }
    if (discount < 0) {
      throw IllegalArgumentException("A discount has to be positive")
    }





  }

  public static String updateBundle(String name, String newName, int newDiscount,
      String newGradeLevel) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  public static String deleteBundle(String name) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  public static TOGradeBundle getBundle(String name) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  // returns all bundles
  public static List<TOGradeBundle> getBundles() {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

}
