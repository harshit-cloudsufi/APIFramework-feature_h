Feature: iDoc List and schema
  @Severity=Blocker @tmsLink=<TC-SAP1221-01> @RegressionTest
  Scenario: Verify that direct connection is established and user is able to fetch iDoc list.
    Given Base Url is known to for iDoc connect with direct connection
    When user calls the iDoc list by "iDocList" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc list has the 16 types of obj


  @Severity=Blocker @tmsLink=<TC-SAP1221-02> @RegressionTest
  Scenario: Verify that connection via Load balancer is established and user is able to fetch iDoc list.
    Given Base Url is known to for iDoc connect with connection via load balncer
    When user calls the iDoc list by "iDocList" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc list has the 16 types of obj

  @Severity=Blocker @tmsLink=<TC-SAP1221-03> @RegressionTest
  Scenario: Verify that SNC connection is established and user is able to fetch iDoc list.
    Given Base Url is known to for iDoc connect with connection using snc
    When user calls the iDoc list by "iDocListSNC" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc list has the 16 types of obj

  @Severity=Blocker @tmsLink=<TC-SAP1221-04> @RegressionTest
  Scenario: Verify that S4 HANA connection is established and user is able to fetch iDoc list.
    Given Base Url is known to for iDoc connect with S4 hana connection
    When user calls the iDoc list by "iDocList" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc list has the 16 types of obj


#  @Severity=Normal @tmsLink=<TC-SAP1221-05>
#  Scenario: Verify that direct connection is established using user with no authorisation, is not able to fetch iDoc list.
#    Given Base Url and "noAuthUserDirect" is known to connect with direct connection
#    When user calls the iDoc list by "iDocList" with http request
#    Then API call got success with iDoc list with status code 503
#
#
#  @Severity=Normal @tmsLink=<TC-SAP1221-06>
#  Scenario: Verify that load balancer connection is established using user with no authorisation, is not able to fetch iDoc list.
#    Given Base Url and "noAuthUserDirect" is known to connect with load balancer connection
#    When user calls the iDoc list by "iDocList" with http request
#    Then API call got success with iDoc list with status code 503
#
#
#  @Severity=Normal @tmsLink=<TC-SAP1221-07>
#  Scenario: Verify that snc connection is established using user with no authorisation, is not able to fetch iDoc list.
#    Given Base Url and "noAuthUserDirect" is known to connect with snc connection
#    When user calls the iDoc list by "iDocListSNC" with http request
#    Then API call got success with iDoc list with status code 503
#
#  @Severity=Normal @tmsLink=<TC-SAP1221-08>
#  Scenario: Verify that s4 hana connection is established using user with no authorisation, is not able to fetch iDoc list.
#    Given Base Url and "noAuthUserDirect" is known to connect with S4 HANA connection
#    When user calls the iDoc list by "iDocList" with http request
#    Then API call got success with iDoc list with status code 503

  @Severity=Normal @tmsLink=<TC-SAP1221-09> @RegressionTest
  Scenario Outline: Verify that direct connection is established using user with minimum authorisation,user is able to fetch iDoc Schema.
    Given Base Url is known to for iDoc connect with direct connection for iDoc schema of "MATMAS05"
    When user calls the iDoc list by "iDocSchema" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc API response has <key> and <value>

    Examples:

      |key       |value             |
      |[1].name  |E1MARAM           |
      |[3].name  |E1IDOCENHANCEMENT   |

  @Severity=Normal @tmsLink=<TC-SAP1221-10> @RegressionTest
  Scenario Outline: Verify that load balancer connection is established using user with minimum authorisation,user is able to fetch iDoc Schema.
    Given Base Url is known to for iDoc connect with load balancer connection for iDoc schema of "MATMAS05"
    When user calls the iDoc list by "iDocSchema" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc API response has <key> and <value>

    Examples:

      |key       |value             |
      |[1].name  |E1MARAM           |
      |[3].name|E1IDOCENHANCEMENT   |

  @Severity=Normal @tmsLink=<TC-SAP1221-11> @RegressionTest
  Scenario Outline: Verify that SNC connection is established using user with minimum authorisation,user is able to fetch iDoc Schema.
    Given Base Url is known to for iDoc connect with SNC connection for iDoc schema of "MATMAS05"
    When user calls the iDoc list by "iDocSchemaSNC" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc API response has <key> and <value>

    Examples:

      |key       |value             |
      |[1].name  |E1MARAM           |
      |[3].name|E1IDOCENHANCEMENT   |

  @Severity=Normal @tmsLink=<TC-SAP1221-12> @RegressionTest
  Scenario Outline: Verify that S4 HANA connection is established using user with minimum authorisation,user is able to fetch iDoc Schema.
    Given Base Url is known to for iDoc connect with S4 HANA connection for iDoc schema of "MATMAS05"
    When user calls the iDoc list by "iDocSchema" with http request
    Then API call got success with iDoc list with status code 200
    And iDoc API response has <key> and <value>

    Examples:

      |key       |value             |
      |[1].name  |E1MARAM           |
      |[3].name|E1IDOCENHANCEMENT   |



#  @Severity=Normal @tmsLink=<TC-SAP1221-14> @RegressionTest
#  Scenario: Verify that S4 HANA connection is established using user is able to execute idoc inbound
#    Given Base Url is known to for idoc-activateListener connect with S4 HANA connection
#    When user calls the iDoc list by "idocactivateListener" with post http request
#    Then API call got success with iDoc list with status code 200
#    Given Base Url is known to connect with s4 connection connection and has "ZFM_SEND_IDOC_BD10" payload and autocommit "true" for inbound file creation
#    When user calls the iDoc list by "rfcExecution" with post http request
#    Then API call got success with iDoc list with status code 200
#    And iDoc inbound file has "IDOC_DATA_REC_40[0].SEGNAM" and "E2MARAM008"




