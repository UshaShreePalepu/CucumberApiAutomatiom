Feature: Employment Details

  Scenario Outline: should post new employment details successfully
    Given the employment details with the "<Name>"
    When the employment details are posted to create endpoint
    Then the response status should be <SUCCESS>

    Examples:
    | Name |
    |FullTestName|