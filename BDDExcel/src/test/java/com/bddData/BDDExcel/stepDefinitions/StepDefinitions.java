package com.bddData.BDDExcel.stepDefinitions;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

//    @Given("an example scenario")
//    public void anExampleScenario() {
//    }
//
//    @When("all step definitions are implemented")
//    public void allStepDefinitionsAreImplemented() {
//    }
//
//    @Then("the scenario passes")
//    public void theScenarioPasses() {
//    }
	@Given("Excel filename and Location is given as")
	public void excel_filename_and_location_is_given_as(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		System.out.println(dataTable);
	}

}
