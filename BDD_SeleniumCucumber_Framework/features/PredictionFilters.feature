@ZIFUIPredictionFilter
Feature: ZIF UI Prediction Filter
	Testing all the positive and negative Scenarios in ZIF UI Prediction Filter


Background: Launch the Browser with URL
Given Open chrome browser and enter the url
And Login with valid Email ID and Password
And Navigate to Predictions Page


Scenario: Validate All Filter Fields and Enabling Functionalities

Given Click the Filter icon
Then Verify all the fields in the Filter side panel
When Click on Resource Group drop down
Then Verify all Resource Group drop down values
When User Selects Resource Group as CPU
Then Counters drop down should be enabled and Drive / Mount Name should be disabled
When User Selects Resource Group as Memory
Then Counters drop down should be enabled and Drive / Mount Name should be disabled
When User Selects Resource Group as Disk
Then Counters drop down should be enabled and Drive / Mount Name should be disabled
When User enters the Device name
Then Counters and Drive / Mount Name drop downs should be enabled



Scenario: Validate Apply Clear and close function of Filter

Given Click the Filter icon
And Clicks on Apply button
Then Verify the Filter panel is closed and Filter Icon is displayed with three dots
When Click the Filter icon
And Click on Clear button
Then Verify the user is in Filter Panel
When Click on Filter close
Then Verify the Filter panel is closed and Filter Icon is displayed without three dots
When Click the Filter icon
And Enter values in all fields
And Click on Clear button
Then Verify the user is in Filter Panel

Scenario: Validate Opportunity ID Filter

Given Click the Filter icon
And Enter Valid Opportunity ID in Opportunity ID Filter
And Clicks on Apply button
Then Verify the Opportunity ID Filter on Opportunity cards
When Click the Filter icon
And Enter Invalid Opportunity ID in Opportunity ID Filter
And Clicks on Apply button
Then Verify the No Data Available on Opportunity cards
When Click the Filter icon
And Enter alphabets or special characters in Opportunity ID Filter
And Clicks on Apply button
Then Verify the No Data Available on Opportunity cards


Scenario: Validate Device Name Filter

Given Click the Filter icon
And Enter Valid Device Name in Device Name Filter
And Clicks on Apply button
Then Verify the Device Name Filter on Opportunity cards
When Click the Filter icon
And Enter Invalid Device Name in Device Name Filter
And Clicks on Apply button
Then Verify the No Data Available on Opportunity cards

Scenario: Validate the Resource Type - Single selection mode

Given Click the Filter icon
And User Selects Resource Group as CPU
And Clicks on Apply button
Then Verify the Filter is applied on Opportunity cards
When Click the Filter icon
When User Selects Resource Group as Memory
And Clicks on Apply button
Then Verify the Filter is applied on Opportunity cards
When Click the Filter icon
When User Selects Resource Group as Disk
And Clicks on Apply button
Then Verify the Filter is applied on Opportunity cards
When Click the Filter icon


Scenario: Validate the Resource Type and Counters / Drive-Mount names - Single selection mode

Given Click the Filter icon
And User Selects Resource Group as CPU
And Click on Counters drop down
Then Verify the CPU counters
When Click on any CPU counter from drop down
Then Verify the CPU Counter Filter is applied on Opportunity cards
When Click the Filter icon
And User Selects Resource Group as Memory
And Click on Counters drop down
Then Verify the Memory counters
When Click on any Memory counter from drop down
Then Verify the Memory Counter Filter is applied on Opportunity cards
When Click the Filter icon
And User Selects Resource Group as Disk
And Click on Counters drop down
Then Verify the Disk counters
When Click on any Disk counter from drop down
Then Verify the Disk Counter Filter is applied on Opportunity cards

Scenario: Validate the Resource Type / Counters / Drive-Mount names - Single selection mode

Given Click the Filter icon
And Enter Valid Device Name in Device Name Filter
And User Selects Resource Group as Disk
And Click on Counters drop down
And Click on any Disk counter from drop down
When Click on Drive-Mount names drop down
Then Verify the Drive-Mount names values
When Click on any Drive-Mount names from drop down
And Clicks on Apply button
Then Verify the Drive-Mount Filter is applied on Opportunity cards

