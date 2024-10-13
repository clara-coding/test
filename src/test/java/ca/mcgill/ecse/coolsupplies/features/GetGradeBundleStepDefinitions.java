package ca.mcgill.ecse.coolsupplies.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.mcgill.ecse.coolsupplies.model.GradeBundle;
import ca.mcgill.ecse.coolsupplies.controller.CoolSuppliesFeatureSet4Controller;

public class GetGradeBundleStepDefinitions {
  private GradeBundle gradeBundleFound;
  
  @When("the school admin attempts to get from the system all the bundles \\(p9)")
  public void the_school_admin_attempts_to_get_from_the_system_all_the_bundles_p9() {
    CoolSuppliesFeatureSet4Controller.getBundles();
  }

  @When("the school admin attempts to get from the system the grade bundle with name {string} \\(p9)")
  public void the_school_admin_attempts_to_get_from_the_system_the_grade_bundle_with_name_p9(
      String string) {
	  gradeBundleFound = CoolSuppliesFeatureSet4Controller.getBundle(string);
  }

  @Then("the following grade bundle entities shall be presented \\(p9)")
  public void the_following_grade_bundle_entities_shall_be_presented_p9(
      io.cucumber.datatable.DataTable dataTable) {
    Map<String,String> expectedGradeBundle = dataTable.asMap(String.class, String.class);
    
    // Compare names
    assertEquals(gradeBundleFound.getName(), expectedGradeBundle.get("name"));
    // Compare discounts
    assertEquals(gradeBundleFound.getDiscount(), expectedGradeBundle.get("discount"));
    // Compare levels
    assertEquals(gradeBundleFound.getGrade().getLevel(), 
      expectedGradeBundle.get("level"));
  }

  @Then("no grade bundle entities shall be presented \\(p9)")
  public void no_grade_bundle_entities_shall_be_presented_p9() {
    // Write code here that turns the phrase above into concrete actions
    assertTrue(CoolSuppliesFeatureSet4Controller.getBundles().isEmpty());
  
  }
}
