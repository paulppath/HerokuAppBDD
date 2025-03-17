@HomeScenario
  ## Feature: -> is a High-level description of a software feature of behavior of application under test. ***
Feature: HomePage Scenario
## Scenario: ->   Feature file can contain more than one scenario which acts as a test case derived from
##                test scenarios/behavior. It also symbolizes and acts as one or more user perspectives involved.

  @US001
  Scenario: Test Title
    #Given User navigate to homepage
    Then User should see title as "TLA Automation"
@US002
  Scenario: Header Test
    Then User should see Header as "Automation with Selenium"
@US003
  Scenario Outline: Verify footerLink direct to the correct new window
    And User click the "<footerLink>" to open new window
    Then User should see title as "<title>"
    Examples:
    |footerLink         |title                                                  |
    |PHP Travels        |Book Your Free Demo Now - Phptravels                  |
    |Mercury tours      |demoaut.com - demoaut Resources and Information. |
    |Internet           |The Internet                                           |
    |E-commerce         |InMotion Hosting                                       |
    |Passion Tea Company|practiceselenium.com - practiceselenium Resources and Information.|
    |Saucedemo          |Swag Labs                                              |
    |Shopping Cart      |Typescript React Shopping cart                         |