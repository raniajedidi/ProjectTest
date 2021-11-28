Feature: Automate Key Presses

  Scenario: Write "A" and press Enter and assert the text "You entered: ENTER"
    Given User is on the key presses page
    When He enters a key "A" and he clicks ENTER
    Then a msg text is shown "You entered: ENTER"