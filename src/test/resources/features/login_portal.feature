Feature: Test login functionality

  Scenario: User Successfully logged in LinkedIn Webbrowser
    Given open browser 
    When navigated to LinkedIn login page
    Then locate on SignIn on home page
    When provide login credentials with user_email and user_password
    Then click on SignInbutton
    When locate search_box and search user_profile
    Then click on user_profile
    And provide custom message in the text_box
    When click on send button and message send
    Then logout and close browser

