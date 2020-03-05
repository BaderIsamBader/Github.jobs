import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def getResponse = CustomKeywords.'sample.Github.search'('QA','USA', 'true')
def actual = CustomKeywords.'sample.Common.convertStringToJson'(getResponse.getResponseBodyContent())
WS.verifyResponseStatusCode(getResponse, 200)


WS.verifyElementPropertyValue(getResponse, '[0].company', 'HatchWorks Technologies')
WS.verifyElementPropertyValue(getResponse, '[0].location', 'Chamblee')
WS.verifyElementPropertyValue(getResponse, '[0].type', 'Full Time')

//if i need to check all the paramters in the json file

//def results = new groovy.json.JsonSlurper().parseText( getResponse.getResponseBodyContent() )
//for (i = 0; i <results.size().toInteger(); i++) {
//	WS.verifyElementPropertyValue(getResponse, '['+i+'].company', 'check if array containsValue (Expected result)') }
