Feature: Smoke
  As a user
  I want to test Asos site functionality
  So that I can be sure that site works correctly

  Scenario: Check My Account popup window
    Given User is on the 'Home Page' page
    When User puts the mouse cursor on the 'My Account' button
    Then 'My Account' popup window appears
    And 'Sign In' button is displayed
    And 'Join' button is displayed
    And 'My Account' button is displayed
    And 'My Orders' button is displayed
    And 'Returns Information' button is displayed
    And 'Contact Preferences' button is displayed
    And User is able to close 'My Account' pop up window by clicking on 'Close' button

  Scenario: Check error messages for all mandatory field appear on Registration form
    Given User is on the 'Home Page' page
    And User navigates to 'Registration Page' page
    And Registration form is available
    When User clicks on 'Join Asos' button
    Then the following error messages appear
      | Oops! You need to type your email here        |
      | We need your first name – it’s nicer that way |
      | Last name, too, please!                       |
      | Hey, we need a password here                  |
      | Enter your full date of birth                 |


  Scenario Outline: Check error messages on Registration form
    Given User is on the 'Home Page' page
    And User navigates to 'Registration Page' page
    And Registration form is available
    When User fills the 'Email Address' field on Registration form with '<emailAddress>' value
    And User fills the 'First Name' field on Registration form with '<firstName>' value
    And User fills the 'Last Name' field on Registration form with '<lastName>' value
    And User fills the 'Password' field on Registration form with '<password>' value
    And User fills the 'Day Of Birth' field on Registration form with '<dayOfBirth>' value
    And User fills the 'Month Of Birth' field on Registration form with '<monthOfBirth>' value
    And User fills the 'Year Of Birth' field on Registration form with '<yearOfBirth>' value
    And User clicks on 'Join Asos' button
    Then the appropriate error messages appear '<errorMessage>'

    Examples:
      | emailAddress  | firstName     | lastName     | password   | dayOfBirth | monthOfBirth | yearOfBirth | errorMessage                                          |
      | test email    | testfirstname | testlastname | 1111111111 | 1          | 1            | 1982        | Email fail! Please type in your correct email address |
      | test@test.com | testfirstname | testlastname | 123456789  | 1          | 11           | 1986        | Erm, you need 10 or more characters                   |

  Scenario Outline: User is redirected to Home Page after clicking on Asos logo on the Registration Page
    Given User is on the 'Home Page' page
    And User navigates to 'Registration Page' page
    And Registration form is available
    When User clicks 'Asos Logo' button
    Then User is redirected to the '<redirectedPage>' page

    Examples:
      | redirectedPage        |
      | https://www.asos.com/ |

  Scenario Outline: Check filtering by Brand through the search field in Brand filter
    Given User is on the 'Home Page' page
    And User navigates to 'Women Page' page
    And User moves to 'Sale' menu item
    And User moves 'Best Of Sale' submenu item
    And User clicks 'Brand' button
    When User fills the brand search field with '<brandName>' value
    And User clicks on search result
    Then the '<brandName>' brand is displayed in search popup title
    And found products respond to search brand '<expectedBrand>'

    Examples:
      | brandName  | expectedBrand |
      | ASOS Curve | Curve         |

  Scenario Outline: Check add product to SaveForLater list
    Given User is on the 'Home Page' page
    And User navigates to 'Women Page' page
    And User moves to 'Sale' menu item
    And User moves 'Best Of Sale' submenu item
    When User clicks 'Save for later' button on the first product
    Then the <amountOfProducts> product is added to 'Save for later' list

    Examples:
      | amountOfProducts |
      | 1                |

  Scenario Outline: Check add product to Shopping Bag
    Given User is on the 'Home Page' page
    And User navigates to 'Women Page' page
    And User moves to 'Accessories' menu item
    And User moves 'Hair Accessories' submenu item
    And User clicks on the <productNumber> product
    When User clicks 'Add to bag' button
    Then the amount of products in 'Shopping Bag' are '<amountOfProducts>'

    Examples:
      | productNumber | amountOfProducts |
      | 1             | 1                |


  Scenario Outline: Check that error message appears when User tries to add product to Shopping Bag without size selection
    Given User is on the 'Home Page' page
    And User fills the search field with '<productCode>' value
    And User clicks search button
    When User clicks 'Add to bag' button
    Then the following error messages appear '<errorMessage>'

    Examples:
      | productCode | errorMessage                                             |
      | 113447918   | Please select from the available colour and size options |

  Scenario Outline: Check that search history is saved
    Given User is on the 'Home Page' page
    And User fills the search field with '<firstKeyword>' value
    And User clicks search button
    And User fills the search field with '<secondKeyword>' value
    And User clicks search button
    And User fills the search field with '<thirdKeyword>' value
    And User clicks search button
    When User clicks on search field
    Then the following search words is displayed in the search field
      | Shirt |
      | Skirt |
      | Coat  |

    Examples:
      | firstKeyword | secondKeyword | thirdKeyword |
      | coat         | skirt         | shirt        |

  Scenario Outline: Check that searching is performed based on enter keyword
    Given User is on the 'Home Page' page
    And User fills the search field with '<keyword>' value
    When User clicks search button
    Then User checks that current url contains '<keyword>' parameter

    Examples:
      | keyword |
      | coat    |

  Scenario Outline: Check deleting product from Shopping Bag
    Given User is on the 'Home Page' page
    And User navigates to 'Women Page' page
    And User moves to 'Accessories' menu item
    And User moves 'Hair Accessories' submenu item
    And User clicks on the <productNumber> product
    And User clicks 'Add to bag' button
    And User moves to the 'Shopping Bag'
    When User clicks on 'Remove' button
    Then the product is deleted from 'Shopping Bag'

    Examples:
      | productNumber |
      | 1             |

  Scenario Outline: Check that user can change quantity of selected products in shopping bag
    Given User is on the 'Home Page' page
    And User fills the search field with '<productCode>' value
    And User clicks search button
    And User clicks 'Add to bag' button
    And User moves to the 'Shopping Bag'
    When User selects <quantity> items in 'Quantity' dropdown menu
    Then the amount of products in 'Shopping Bag' is updated to '<amountOfProducts>'
    Examples:
      | productCode | amountOfProducts | quantity |
      | 2021756     | 3                | 3        |












