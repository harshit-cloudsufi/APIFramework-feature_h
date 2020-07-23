Feature: Connection Test via. Load Balancer

  @Severity=Blocker @tmsLink=<TC-SAP1200-02> @RegressionTest
  Scenario: Verify that connection  via load balancer is established with the valid credential and headers.
    Given Base Url is known and headers are valid via load balancer
    When user calls "connectionTest" with GET http request via load balancer
    Then Load balancer API call got success with status code 200

  @Severity=Normal @tmsLink=<TC-SAP1200-08>
  Scenario: Verify if Mshost parameter is not present then missing parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when mshost is not present connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection via load balancer
    Then Secondary mesaage is validated when "mshostMissing" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "configSecondarycode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-09>
  Scenario: Verify if Msserv parameter is not present then missing parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when msserv is not present connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection via load balancer
    Then Secondary mesaage is validated when "msservOrr3nameMissing" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "configSecondarycode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-10>
  Scenario: Verify if Group parameter is not present then missing parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when group is not present connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "groupMissingInvalid" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-11>
  Scenario: Verify if Client parameter is not present then missing parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when client is not present connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection via load balancer
    Then Secondary mesaage is validated when "clientMissing" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "configSecondarycode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-29,TC-SAP1200-30,TC-SAP1200-32>
  Scenario Outline: Verify if mshost parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when mshost is "<value>" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessageMsserv" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-31>
  Scenario: Verify if mshost parameter is wrong then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when wrong msshot is passed like "10.132.0.999" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessageMsserv" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-33,TC-SAP1200-34,TC-SAP1200-36>
  Scenario Outline: Verify if msserv parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when msserv is "<value>" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessageMsserv" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-35>
  Scenario: Verify if msserv parameter is wrong then wrong parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when wrong msserv is passed like "9999" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessageMsserv" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-37,TC-SAP1200-38>
  Scenario Outline: Verify if group parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when group is "<value>" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "groupMissingInvalid" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

    Examples:
      |value  |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-39,TC-SAP1200-40>
  Scenario Outline: Verify if r3name parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when r3name is "<value>" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessageMsserv" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "authClientCode" connection via load balancer

    Examples:
      |value  |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-41>
  Scenario: Verify if peak_limit parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when peak_limit is "1001" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessage" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "configSecondarycode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-42>
  Scenario: Verify if pool_capacity parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when pool_capacity is "1001" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessage" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "configSecondarycode" connection via load balancer

  @Severity=Normal @tmsLink=<TC-SAP1200-43,TC-SAP1200-45>
  Scenario Outline: Verify if lang parameter is invalid then invalid parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when lang is "<value>" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMessage" connection via load balancer
    Then Primary code is validated with "configurationPrimaryCode" connection via load balancer
    Then Secondary code is validated with "configSecondarycode" connection via load balancer

    Examples:
      |value  |
      |       |
      |e      |

  @Severity=Normal @tmsLink=<TC-SAP1200-44>
  Scenario: Verify if lang parameter is wrong then wrong parameter exception is thrown
    Given Base Url is known for load balancer
    When Following parameters are inserted in "connectionTest" with GET request as header when wrong lang is passed like "cn" and connection via load balancer
    Then Load balancer API call got success with status code 503
    Then Primary mesaage is validated with "invalidAuthorizationmessage" connection via load balancer
    Then Secondary mesaage is validated when "secondaryMassageInvalidLang" connection via load balancer
    Then Primary code is validated with "authPrimaryCode" connection via load balancer
    Then Secondary code is validated with "secondaryCodeDueToInvalid" connection via load balancer