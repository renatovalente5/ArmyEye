Feature: test
  Scenario: localization actions
    Given the soldier localization are being represented
    When there are values out of the recommended limits
    Then it triggers an aid alert to a specific operational to move to a location "true"

  Scenario: health actions
    Given the ECG of the soldier are being presented
    When needed to know the exact health state of an operational
    Then it is possible to check soldier ECG "true"

  Scenario: atmospheric actions
    Given the atmospheric conditions and geographic zones
    When the values arent in the safety gap
    Then it triggers a general alert of prohibition to enter the danger zone "true"

  Scenario: restricted zone actions
    Given restricted zone data
    When there is unexpected presences in private zones
    Then it triggers an alert to security