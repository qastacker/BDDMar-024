package com.bddData.BDDExcel.stepDefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;

import java.util.Map;
import java.util.List;


import org.junit.jupiter.api.Assertions.*;

import com.bddData.CucumberOpt.ExcelConfigr;
import com.bddData.CucumberOpt.ExcelDataReader;
import com.bddData.CucumberOpt.ExcelDataReader3;
import com.bddData.CucumberOpt.IDataReader;

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
	@Given("Excel filename and Location is given for second as")
	public void excel_filename_and_location_is_given_for_second_as(IDataReader dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		System.out.println(dataTable.getAllRows());
		List<Map<String, String>> data = dataTable.getAllRows();
		System.out.println(data.get(3).get("email"));
		System.out.println(dataTable.getASingleRow());
	}
	
	@Given("Excel filename and Location is given as")
	public void excel_filename_and_location_is_given_as(IDataReader dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		System.out.println(dataTable.getAllRows());
		List<Map<String, String>> data = dataTable.getAllRows();
		System.out.println(data.get(5).get("email"));
	}
	
	@Given("Excel filename and Location is given for fourth as")
	public void excel_filename_and_location_is_given_for_fourth_as(IDataReader dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		System.out.println(dataTable.getAllRows());
		List<Map<String, String>> data = dataTable.getAllRows();
		System.out.println(data.get(10).get("email"));
		System.out.println(dataTable.getASingleRow());
	}
	
	@Given("Excel filename and Location is given for third as")
	public void excel_filename_and_location_is_given_for_third_as(IDataReader dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
		System.out.println(dataTable.getAllRows());
		List<Map<String, String>> data = dataTable.getAllRows();
		System.out.println(data.get(20).get("email"));
	}

	@DataTableType
	public IDataReader excelToDataTable(Map<String,String> entry) {
		ExcelConfigr config = new ExcelConfigr.ExcelConfigBuilder()
				.setFileName(entry.get("Excel"))
				.setfileLoc(entry.get("Location"))
				.setSheetName(entry.get("Sheet"))
				.setIndex(Integer.valueOf(entry.getOrDefault("Index", "0")))
				.build();
		//return new ExcelDataReader(config);
		return new ExcelDataReader3(config);
	}
}
