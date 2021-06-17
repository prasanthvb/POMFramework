#2795 User time zone capability in Date Picker field
@2795
Feature: User time zone capability in Date Picker field
	Testing all the positive and negative Scenarios in ZIF UI User time zone capability in Date Picker field


Background: Launch the Browser with ZIF UI URL for User time zone capability in Date Picker field
Given Open chrome browser and enter the ZIF UI url for User time zone capability in Date Picker field


Scenario: Case Management - Validate the date picker with user's time zone

Given Login ZIF and hover the Operations menu present at the left margin.Select the Analytics sub-menu.Navigate to the Case Management tab
When Click the Filter icon, Select any Date/ Time Stamp and press Apply
Then Screen should reload and display the cases based on the Date/Time range selected by the user along with the count
When Select any Date/ Time Stamp and press Clear
Then Date selected should be cleared and the default date should be displayed
When Change the time zone and Apply the date filter, validate the search results
Then Screen should reload and display the cases based on the Date/Time range selected by the user along with the count


Scenario: Raw Alerts - Validate the date picker with user's time zone

Given Login ZIF and hover the Operations menu present at the left margin.Select the Raw Data sub-menu.Navigate to Alerts tab
When Click the Filter icon, Select any Date/ Time Stamp and press Apply
Then Screen should reload and display the alerts based on the Date/Time range selected by the user along with the count
And Alerts Dashboard should display the filter options selected by the user below the total count display
When Select any Date/ Time Stamp and press Clear
Then Date selected should be cleared and the default date should be displayed
When Change the time zone and Apply the date filter, validate the search results
Then Screen should reload and display the alerts based on the Date/Time range selected by the user along with the count
