#2878 Device Criticality Mapping
@2878
Feature: Device Criticality Mapping
	Testing all the positive and negative Scenarios in ZIF UI Device Criticality Mapping


Background: Launch the Browser with ZIF UI URL for Device Criticality Mapping
Given Open chrome browser and enter the ZIF UI url for Device Criticality Mapping


Scenario: Case Management - Correlation - Verification of Case Details

Given Login ZIF and hover the Operations menu present at the left margin
When Select the Analytics sub-menu. Navigate to Case Management screen click the Correlation icon present in the header section
Then Ensure the Case Severity indication is displayed on the left corner of the row
And No Severity Mapped tooltip should be displayed for the alerts not mapped to Gavel Severity
And Ensure the Case Status icon is displayed below the severity icon
And Verify whether the unique icons are displayed each status
And Ensure case IDs are sorted by default
And Ensure the Created Date is displayed below the case ID
And Ensure the timestamp is showing the UTC timezone
And Ensure the Updated Date is displayed below the case ID
And Ensure the timestamp is showing the UTC timezone
And Ensure the correlated count of the case id's are displayed in the bell icon column
And Ensure the Device count is displayed in Devices field represented with icon
And Ensure the Tool count is displayed in Tools field represented with icon
And Ensure the screen is aligned properly and matching the visual design
And Ensure the required tooltip is displayed across the case management screen


Scenario: Case total count verification

Given Login ZIF and hover the Operations menu present at the left margin.Select the Analytics sub-menu and Navigate to Case Management Correlation tab
Then Ensure the case total count is displayed next to All label present in the header row
And Ensure the Case (N) total count is getting updated on every new case ID
And Ensure the count is displayed in tooltip without decimal value

Scenario: Case Management - Correlation screen - Live Feed
Given Login ZIF and hover the Operations menu present at the left margin.Select the Analytics sub-menu and Navigate to Case Management Correlation tab
When Click the Live Feed icon 
Then New Alerts flow should be stopped and the user should not be seeing the new alerts flowing in
When Mouse hover the icon when line feed is off
Then Feed paused tooltip should be displayed
When Click the Feed paused icon
Then New Alerts flow should be resumed back in the screen and user should be able to see new alerts

Scenario: Correlation screen- Case Acknowledgement verification
Given Login ZIF and hover the Operations menu present at the left margin.Select the Analytics sub menu and Navigate to Case Management - Correlation tab
Then Ensure the presence of Acknowledgement icon in each case ID row
When Mouse hover the icon and verify the tooltip before clicking it.
Then Acknowledgement tooltip should be displayed
When Click the Acknowledgement icon
Then The respective case ID should be acknowledged and the icon should be changed along with the acknowledgment status
And On mouse hover, the user Email ID should be displayed along with the acknowledged date and timestamp
And Ensure the acknowledgement icon is disabled for the user's action once it is acknowledged

Scenario: Case Management -Correlation - Ensure the live feed is present in the screen
Given Login ZIF and hover the Operations menu present at the left margin.Select the Analytics sub menu and Navigate to Case Management - Correlation tab
Then Live feed icon should be enabled by default
When Mouse hover the icon when line feed is on
Then Live Feed tooltip should be displayed

