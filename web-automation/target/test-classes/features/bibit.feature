Feature: Bibit Search Product and Logout

Scenario: Search EMAS product and logout

  Given User opens Bibit login page

  When User clicks Explore tab
  Then Explore page should be displayed

  When User searches investment product "EMAS"
  And User selects EMAS product
  Then Buy button should be displayed

  And User waits for 3 seconds
  And User navigates back to Explore page
  And User navigates back to Home page

  When User clicks Profile tab
  And User scrolls down
  And User clicks Logout button
  Then User should be redirected to landing page