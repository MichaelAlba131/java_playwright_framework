@severity=blocker
@login @loginFeature @All
Feature: Dafiti login tests
  Responsible for filling out the login screen

  Background:
    * I open the url

  @InvalidAuthenticationSceneryOutlineExample
  Scenario Outline:  "<scenery>" - Login with invalid authentication scenery outline
    When I fill the "<user>" and "<password>"
    Then I validate the error message "Dados incorretos"
    Then I validate the error message "Revise as informações fornecidas"

    Examples:
      | scenery | user              | password    |
      | Dafiti  | teste01@gmail.com | teste123    |
      | Dafiti2 | teste02@gmail.com | teste1234   |
      | Dafiti3 | teste03@gmail.com | teste12345  |
      | Dafiti4 | teste04@gmail.com | teste123456 |