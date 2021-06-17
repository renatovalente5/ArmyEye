Feature: test
  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"

#  Scenario: Aid actions
#    Given all the soldiers ECG are being represented
#    When there are values out of the recommended limits
#    Then it triggers an aid alert to a specific operational to move to a location
#
#    Given the ECG and localization of all the soldiers are being presented
#    When needed to know the exact localization and health state of an operational
#    Then it is possible to check soldiers GPS and ECG
#
#    Given the atmospheric conditions and geographic zones
#    When the values arent in the safety gap
#    Then it triggers a general alert of proibition to enter the danger zone
#
#    Given it is possible to know the localization and atmospheric conditions of the zones and roads
#    When it is needed to move operationals
#    Then it is conducted a marking of routes for the troops
#
#    Given restricted zone data
#    When there is unexpected presences in private zones
#    Then it triggers an alert to security