@CalendarScenario
  Feature: Calendar page scenario
    Background:
      Given I open "calendar" page

  @US0201
  Scenario: Validate default date is display as today date.
    Then Verify that the date is displayed as "today" date