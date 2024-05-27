@web
Feature: Test Automation Web UI

  @valid-login
  Scenario: Log in using valid username and password
    Given user is on home page
    When user click "Log in" menu
    Then user see "Log in" modal
    And user input username with "tes"
    And user input password with "tes"
    When user click "Log in" button
    Then user is logged in

  @invalid-login
  Scenario: Log in using username and invalid password
    Given user is on home page
    When user click "Log in" menu
    Then user see "Log in" modal
    And user input username with "tes"
    And user input password with "pass"
    When user click "Log in" button
    Then user get alert "Wrong password."

  @invalid-login
  Scenario: Log in using empty username and password
    Given user is on home page
    When user click "Log in" menu
    Then user see "Log in" modal
    And user input username with ""
    And user input password with "tes"
    When user click "Log in" button
    Then user get alert "Please fill out Username and Password."

  @valid-signup
  Scenario: Sign up using valid username and password
    Given user is on home page
    When user click "Sign up" menu
    Then user see "Sign up" modal
    And user input username with new username
    And user input password with "pass"
    When user click "Sign up" button
    Then user is signed up

  @invalid-signup
  Scenario: Sign up using registered username and password
    Given user is on home page
    When user click "Sign up" menu
    Then user see "Sign up" modal
    And user input username with "tes"
    And user input password with "tes"
    When user click "Sign up" button
    Then user get alert "This user already exist."

  @valid-home-menu
  Scenario: Open home menu
    Given user is on home page
    When user click "Home" menu
    Then user is on "index" page

  @valid-contact-menu
  Scenario: Open contact menu
    Given user is on home page
    When user click "Contact" menu
    Then user see "Contact" modal
    And user input contact email with "tes"
    And user input contact name with "tes"
    And user input contact message with "tes"
    When user click "Send message" button
    Then user get alert "Thanks for the message!!"


  @valid-about-us-menu
  Scenario: Open about us menu
    Given user is on home page
    When user click "About us" menu
    Then user see "About us" modal
    And user play the video

  @valid-cart-menu
  Scenario: Open cart menu
    Given user is on home page
    When user click "Cart" menu
    Then user is on "cart" page

  @valid-add-phones-items-to-cart
  Scenario: Add phones item to cart
    Given user is on home page
    When user click "Phones" category
    And user click item
    Then user is on product content page
    When user click Add to cart button
    Then user get alert "Product added"
    When user click "Cart" menu
    Then user is on "cart" page
    And validation item is on the cart list

  @valid-add-laptops-items-to-cart
  Scenario: Add laptops item to cart
    Given user is on home page
    When user click "Laptops" category
    And user click item
    Then user is on product content page
    When user click Add to cart button
    Then user get alert "Product added"
    When user click "Cart" menu
    Then user is on "cart" page
    And validation item is on the cart list

  @valid-add-monitors-items-to-cart
  Scenario: Add monitors item to cart
    Given user is on home page
    When user click "Monitors" category
    And user click item
    Then user is on product content page
    When user click Add to cart button
    Then user get alert "Product added"
    When user click "Cart" menu
    Then user is on "cart" page
    And validation item is on the cart list

  @valid-logout
  Scenario: Log out
    Given user is on home page
    When user click "Log in" menu
    Then user see "Log in" modal
    And user input username with "tes"
    And user input password with "tes"
    When user click "Log in" button
    Then user is logged in
    And user click "Log out" menu
    Then user is logged out