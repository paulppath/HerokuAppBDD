@InputScenarios
  Feature: Input page scenarios
    Background:
      Given I open "input" page

  @US0101
  Scenario: Verify correct message is displayed
    When User enter text as "aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuuvvvvvwwwwwxxxxxyyyyyzzzzz"
    And click "Show message" button
    Then Verify text is displayed as "aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuuvvvvvwwwwwxxxxxyyyyyzzzzz"

  @US0102
  Scenario: Verify sum of 2 numeric number
    When User enter text as "3"
    And User enter text as "4"
    And click "Get Total" button
    Then Verify text is displayed as "7"

  @US0103
  Scenario Outline: Verify alert after invalid input
    When User enter text as "<numberA>"
    And User enter text as "<numberB>"
    And click "Get Total" button
    Then Verify alert displayed with text "a and b must be numeric!"
    Examples:
    |numberA    |numberB  |
    |F          |4        |
    |5          |K        |
    |5F         |8K       |