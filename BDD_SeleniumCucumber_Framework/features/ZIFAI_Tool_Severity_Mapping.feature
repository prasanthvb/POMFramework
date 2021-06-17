#2841 Tool Severity Mapping
@2841
Feature: Tool Severity Mapping
	Testing all the positive and negative Scenarios in ZIF UI Tool Severity Mapping


Background: Launch the Browser with ZIF UI URL for Tool Severity Mapping
Given Open chrome browser and enter the ZIF UI url for Tool Severity Mapping
Then Login with valid credentials and Navigate to Platform Management


Scenario: Validate the severity indication when severity is not mapped

Given Insert an alert with new tool severity which has no mapping in severity portal
When Navigate to Platform Management
Then Verify the severity indication in raw alerts screen
And Verify the severity indication of the case ID in Case Management screen


Scenario: Validate the severity reflection When severity is mapped

Given Insert an alert with new tool severity which has no mapping in severity portal
And Go to App settings and navigate to Platform Management tab and click the severity Mapping section
And Now Map the tool severity to GAVel Severity and Click Save button
Then Verify that the Severity Mapping updated Successfully is displayed
And Verify the severity indication in raw alerts screen should be reflected in Raw Alerts for the new comers
And Verify the severity indication of the case ID in Case Management screen should be reflected in the newly created case ID
When Now Map the tool severity to GAVel Severity and Click on Cancel button
Then The new changes should not be saved and the current mapping should remain the same


Scenario: Validate the severity reflection When the highest and lowest severity comes in 

Given Insert an alert with new tool severity
And Go to App settings and navigate to Platform Management tab and click the severity Mapping section
And Now map the new tool severity to the lowest severity respective severity must be low in alert correlation screen
And Insert an alert with the highest severity and Verify the severity indication in raw alerts screen
Then Highest severity should be reflected in Raw Alerts for the new comers
And Verify the severity indication of the case ID is showing the highest severity for newly created case ID
When Insert an alert with the lowest severity and Verify the severity indication in raw alerts screen
Then Highest severity should be reflected in Raw Alerts for the new comers
And Verify the severity indication of the case ID is showing the highest severity for newly created case ID


Scenario: Validate the severity reflection When the mapped severity is changed

Given Go to App settings screen and navigate to Platform Management screen
When Change any one of the mapped severity to new severity and Click Save button
Then The newly mapped GAVel severity should be saved successfully "Severity Mapping updated successfully"
And Verify that the Respective severity should be reflected in Raw Alerts for the new alerts
And Verify that the Respective severity should be reflected in the newly created case ID



Scenario: Validate the case ID generation is stopped when warning / information is mapped

Given Insert an alert with new tool severity
And Go to App settings and navigate to Platform Management screen and Select the Severity Mapping section
When Map the severity to Warning severity
Then Severity Mapping updated successfully should be displayed
And Verify the severity indication in raw alerts screen should display Warning tooltip and ZIF0 should be displayed in Case ID column
And Verify the severity indication of the case ID should not be generated in case management screen
When Insert an alert with new tool severity. Go to App settings and navigate to Platform Management screen. Select the Severity Mapping section
And Map the severity to Information severity
Then Severity Mapping updated successfully should be displayed
And Verify the severity indication in raw alerts screen should display Information  tooltip and ZIF0 should be displayed in Case ID column
And Verify the severity indication of the case ID should not be generated in case management screen