Feature: Organization Feature

  #author: Nithesh
  Background: 
    Given As a user I will launch "chrome" browser and enter the url "http://localhost:8888/"
    When login page is displayed as a user I will enter username "admin" and password "manager"
    And click on login

  @RegressionTest
  Scenario Outline: As a user I want to create multiple organization
    When In home page click on Organization link
    And click on create oragnization
    And In organization name enter "<OrganizationName>" and "<industryType>"
    Then click on save and verify the data

    Examples: 
      | OrganizationName | industryType |
      | TY               | Technology   |
      | Photon           | Energy       |
      | Visa             | Technology   |
      | Lenscart         | Technology   |

  @End2End
  Scenario: As a user I want to create a organization
    When In home page click on Organization link
    And click on create oragnization
    And I will enter oraganization name and industry dropdown
      | comapny | dropdown   |
      | Iqvia   | Technology |
    Then click on save and verify the data
