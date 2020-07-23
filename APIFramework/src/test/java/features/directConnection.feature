Feature: Connection Test
  @Severity=Blocker @tmsLink=<TC-SAP1200-01> @RegressionTest
  Scenario: Verify that connection is established with the valid credential and headers.
    Given Base Url is known and headers are valid
    When user calls "connectionTest" with GET http request
    Then API call got success with status code 200

  @Severity=Blocker @tmsLink=<TC-SAP1200-04> @RegressionTest
  Scenario: Verify that connection is not established with invalid credentials and valid headers.
    Given Base Url is known and password is invalid
    When user calls "connectionTest" with GET http request and capture response
    Then API call got the response with status code 503
    And Primary mesaage is validated
    And Secondary mesaage is validated
    And Primary code is validated
    And Secondary code is validated

  @Severity=Normal @tmsLink=<TC-SAP1200-05>
  Scenario: Verify if client parameter is not present then missing parameter exception is thrown
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header when client is not present
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "clientMissing"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"

  @Severity=Normal @tmsLink=<TC-SAP1200-06>
  Scenario: Verify if ashostMissing parameter is not present then missing parameter exception is thrown
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header when ashost is not present
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "ashostMissing"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"

  @Severity=Normal @tmsLink=<TC-SAP1200-07>
  Scenario: Verify if sysnrMissing parameter is not present then missing parameter exception is thrown
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header when sysnr is not present
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "sysnrMissing"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"

  @Severity=Normal @tmsLink=<TC-SAP1200-12,C-SAP1200-13,C-SAP1200-15>
  Scenario Outline: Verify if Client parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header and client is "<value>"
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "secondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"


    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |


  @Severity=Normal @tmsLink=<TC-SAP1200-16,C-SAP1200-17,C-SAP1200-19>
  Scenario Outline: Verify if Sysnr parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header and sysnr is "<value>"
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "sysnrInvalid"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"

    Examples:
      |value  |
      |s      |
      |n1r    |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-20,C-SAP1200-21,C-SAP1200-23>
  Scenario Outline: Verify if Ashost parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header and ashost is "<value>"
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "secondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"


    Examples:
      |value  |
      |C      |
      |xxx.x.x.x    |
      |       |


  @Severity=Normal @tmsLink=<TC-SAP1200-26>
  Scenario Outline: Verify if Lang parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header and lang is "<value>"
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "secondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"


    Examples:
      |value  |
      |C      |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-24>
  Scenario: Verify if peak_limit parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header and peak_limit is 1187
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "secondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"

  @Severity=Normal @tmsLink=<TC-SAP1200-25>
  Scenario: Verify if pool_capacity parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as header and pool_capacity is 123515
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage"
    Then Secondary mesaage is validated when "secondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "configSecondarycode"

  @Severity=Normal @tmsLink=<TC-SAP1200-14>
  Scenario: Verify if Client parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as a header and client is 101
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "invalidAuthorizationmessage"
    Then Secondary mesaage is validated when "secondaryMassageInvalidClient"
    Then Primary code is validated with "invalidAuthorizationCode"
    Then Secondary code is validated with "secondaryCodeDueToInvalid"


  @Severity=Normal @tmsLink=<TC-SAP1200-18>
  Scenario: Verify if sysnr parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as a header and sysnr is 99
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "authClientMessage"
    Then Secondary mesaage is validated when "authClientSecondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "authClientCode"


  @Severity=Normal @tmsLink=<TC-SAP1200-28>
  Scenario: Verify if lang parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as a header and lang is "cn"
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "invalidAuthorizationmessage"
    Then Secondary mesaage is validated when "secondaryMassageInvalidLang"
    Then Primary code is validated with "invalidAuthorizationCode"
    Then Secondary code is validated with "secondaryCodeDueToInvalid"

  @Severity=Normal @tmsLink=<TC-SAP1200-22>
  Scenario: Verify if ashost parameter has invalid value then connection is not established
    Given Base Url is known
    When Following parameters are inserted in "connectionTest" with GET request as a header and ashost is "10.132.0.0"
    Then API call got the response with status code 503
    Then Primary mesaage is validated with "authClientMessage"
    Then Secondary mesaage is validated when "authClientSecondaryMessage"
    Then Primary code is validated with "configurationPrimaryCode"
    Then Secondary code is validated with "authClientCode"

