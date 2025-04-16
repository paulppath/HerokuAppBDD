@CalendarScenario
  Feature: Calendar page scenario
    Background:
      Given I open "calendar" page

  @US0201
  Scenario: Validate default date is display as today date.
    Then Verify that the date is displayed as "today" date

  @US0202
  Scenario: Validation of displayed date after clicking a date on the calendar
    When user click date "19" in the calendar
    Then Verify that the date is displayed as "4/19/2025" date
