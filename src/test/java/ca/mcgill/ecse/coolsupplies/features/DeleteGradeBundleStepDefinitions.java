package ca.mcgill.ecse.coolsupplies.features;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse.coolsupplies.application.CoolSuppliesApplication;
import ca.mcgill.ecse.coolsupplies.model.CoolSupplies;
import ca.mcgill.ecse.coolsupplies.model.GradeBundle;
<<<<<<< HEAD
=======
import ca.mcgill.ecse.coolsupplies.model.Grade;
>>>>>>> eff3d16 (Fixed issue with TheFollowingGradeBundleEntitiesExistsInTheSystem)
import ca.mcgill.ecse.coolsupplies.controller.CoolSuppliesFeatureSet4Controller;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteGradeBundleStepDefinitions {
  private String error;

  @Given("the following grade entities exists in the system \\(p9)")
  public void the_following_grade_entities_exists_in_the_system_p9(
      io.cucumber.datatable.DataTable dataTable) {
	  List<Map<String, String>> rows = dataTable.asMaps();
	  for (var row : rows) {
		  String level = row.get("level");
		  CoolSuppliesApplication.getCoolSupplies().addGrade(level);
		  }
  }

  @Given("the following grade bundle entities exists in the system \\(p9)")
  public void the_following_grade_bundle_entities_exists_in_the_system_p9(
      io.cucumber.datatable.DataTable dataTable) {
	  List<Map<String, String>> rows = dataTable.asMaps();
	  for (var row : rows) {
        String level = row.get("gradeLevel");
        Grade grade = findGradeByLevel(level);
        int discount = Integer.parseInt(row.get("discount"));
	      CoolSuppliesApplication.getCoolSupplies().addBundle(level, discount, grade);
	      }
  }

  @When("the school admin attempts to delete from the system the gradeBundle with name {string} \\(p9)")
  public void the_school_admin_attempts_to_delete_from_the_system_the_grade_bundle_with_name_p9(
      String bundleName) {
      callController(CoolSuppliesFeatureSet4Controller.deleteBundle(bundleName));
  }

  @Then("the number of grade bundle entities in the system shall be {string} \\(p9)")
  public void the_number_of_grade_bundle_entities_in_the_system_shall_be_p9(String expectedNumber) {
    // Write code here that turns the phrase above into concrete actions
    int expectedNumberOfBundles = Integer.parseInt(expectedNumber);
    int actualNumberOfBundles = CoolSuppliesApplication.getCoolSupplies().getBundles().size();
    assertEquals(expectedNumberOfBundles, actualNumberOfBundles, "Expected " + expectedNumberOfBundles + " bundles, but found " + actualNumberOfBundles);
  }

	/**
  * @author Logan Ma
  */
	@Then("the following grade bundle entities shall exist in the system \\(p9)")
	public void the_following_grade_bundle_entities_shall_exist_in_the_system_p9(
			io.cucumber.datatable.DataTable dataTable) {
	
		List<Map<String, String>> expectedGradeBundles = dataTable.asMaps(String.class, String.class);
		List<GradeBundle> actualGradeBundles = CoolSuppliesApplication.getCoolSupplies().getBundles();
	
		for (Map<String, String> expectedBundle : expectedGradeBundles) {
			String name = expectedBundle.get("name");
			int discount = Integer.parseInt(expectedBundle.get("discount"));
			String gradeLevel = expectedBundle.get("gradeLevel");
	
			boolean exists = actualGradeBundles.stream().anyMatch(bundle -> bundle.getName().equals(name)
					&& bundle.getDiscount() == discount && bundle.getGrade().getLevel().equals(gradeLevel));
	
			assertTrue(exists, "Expected grade bundle entity with name '" + name + "', discount '" + discount
					+ "', and grade level '" + gradeLevel + "' does not exist in the system.");
		}
	}

  @Then("the error {string} shall be raised \\(p9)")
  public void the_error_shall_be_raised_p9(String string) {
    assertTrue(error.contains(string));
  }

  /** Calls controller and sets error and counter. */
  private void callController(String result) {
    if (!result.isEmpty()) {
      error += result;
    }
  }

  private static Grade findGradeByLevel(String gradeLevel) {
    CoolSupplies coolSupplies = CoolSuppliesApplication.getCoolSupplies();
    for (Grade grade : coolSupplies.getGrades()) {
        if (grade.getLevel().equals(gradeLevel)) {
            return grade;
        }
    }
    return null;
  }

}