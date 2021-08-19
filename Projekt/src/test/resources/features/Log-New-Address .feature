Feature: New address

  Scenario Outline: User can log to a page
    Given I'm on MyStore main page
    When I click sign in
    And I enter email address cinek_jedz@o2.pl on authentication page
    And I enter password Zadanie1 and click
    And I click Addresses and Create new address
    And I enter alias <Alias> address <Address> city <City> into form
    And I enter zip <Zip/Postal Code> country <Country> phone <Phone> into form
    And I click Save
    Then I can see success message with text Address successfully added!
#    And close qlo browser


    Examples:
      | Alias    | Address | Zip/Postal Code | City     | Country        | Phone     |
      | Cinek    | Glowna  | 54-610          | Wroclaw  | U              | 888777666 |