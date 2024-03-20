package com.bddData.CucumberOpt;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/com/bddData/BDDExcel/dataTable.feature"
//,glue="com.featurescom.stepDefinitions"
,glue="classpath:com.bddData.BDDExcel.stepDefinitions"
,monochrome=true
,dryRun=false
//,tags="@PlaceOrder or @OffersPage"
,plugin= {
	"pretty"
	//,"html:target/cucumber.html"
	//,"json:target/cucumber.json"
	//,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	//,"rerun:result/failed_scenarios.txt"
}
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
