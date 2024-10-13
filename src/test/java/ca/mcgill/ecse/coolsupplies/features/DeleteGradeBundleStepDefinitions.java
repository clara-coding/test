package ca.mcgill.ecse.coolsupplies.features;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse.coolsupplies.application.CoolSuppliesApplication;
import ca.mcgill.ecse.coolsupplies.model.CoolSupplies;
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
		  CoolSuppliesApplication.getCoolSupplies().addGrade(level); //check if already present?
		  }
  }

  @Given("the following grade bundle entities exists in the system \\(p9)")
  public void the_following_grade_bundle_entities_exists_in_the_system_p9(
      io.cucumber.datatable.DataTable dataTable) {
	  List<Map<String, String>> rows = dataTable.asMaps();
	    for (var row : rows) {
	      String bundles = row.get("bundles");  
	      CoolSuppliesApplication.getCoolSupplies().addBundle(bundles);
	      }
  }

  @When("the school admin attempts to delete from the system the gradeBundle with name {string} \\(p9)")
  public void the_school_admin_attempts_to_delete_from_the_system_the_grade_bundle_with_name_p9(
      String string) {
      CoolSuppliesApplication.getCoolSupplies().deleteBundle(bundleName);
  }

  @Then("the number of grade bundle entities in the system shall be {string} \\(p9)")
  public void the_number_of_grade_bundle_entities_in_the_system_shall_be_p9(String expectedNumber) {
    // Write code here that turns the phrase above into concrete actions
    int expectedNumberOfBundles = Integer.parseInt(expectedNumber);
    int actualNumberOfBundles = CoolSuppliesApplication.getCoolSupplies().getBundles().size();
    assertEquals(expectedNumberOfBundles, actualNumberOfBundles, "Expected " + expectedNumberOfBundles + " bundles, but found " + actualNumberOfBundles);
  }

  @Then("the following grade bundle entities shall exist in the system \\(p9)")
  public void the_following_grade_bundle_entities_shall_exist_in_the_system_p9(
      io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    throw new io.cucumber.java.PendingException();
  }

  @Then("the error {string} shall be raised \\(p9)")
  public void the_error_shall_be_raised_p9(String string) {
    assertTrue(error.contains(string));
  }

}
