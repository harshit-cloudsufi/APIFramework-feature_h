Feature: Bapi List and schema
  @Severity=Blocker @tmsLink=<TC-SAP1210-01> @RegressionTest
  Scenario: Verify that direct connection is established and user is able to fetch Bapi list.
    Given Base Url is known to connect with direct connection
    When user calls the bapi list by "bapiList" with GET http request
    Then API call got success with Bapi list with status code 200
    And Bapi list has the 8 types of elements


  @Severity=Blocker @tmsLink=<TC-SAP1210-02> @RegressionTest
  Scenario: Verify that connection via Load balancer is established and user is able to fetch Bapi list.
    Given Base Url is known to connect with connection via load balncer
    When user calls the bapi list by "bapiList" with GET http request
    Then API call got success with Bapi list with status code 200
    And Bapi list has the 8 types of elements

  @Severity=Blocker @tmsLink=<TC-SAP1210-03> @RegressionTest
  Scenario: Verify that SNC connection is established and user is able to fetch Bapi list.
    Given Base Url is known to connect with connection using snc
    When user calls the bapi list by "bapiListSNC" with GET http request
    Then API call got success with Bapi list with status code 200
    And Bapi list has the 8 types of elements

  @Severity=Blocker @tmsLink=<TC-SAP1210-04> @RegressionTest
  Scenario: Verify that S4 HANA connection is established and user is able to fetch Bapi list.
    Given Base Url is known to connect with S4 hana connection
    When user calls the bapi list by "bapiList" with GET http request
    Then API call got success with Bapi list with status code 200
    And Bapi list has the 8 types of elements

#  @Severity=Normal @tmsLink=<TC-SAP1210-05>
#  Scenario: Verify that direct connection is established using user with no authorisation, is not able to fetch Bapi list.
#    Given Base Url and "noAuthUserDirect" is known to connect with direct connection
#    When user calls the bapi list by "bapiList" with GET http request
#    Then API call got success with Bapi list with status code 503
#
#
#  @Severity=Normal @tmsLink=<TC-SAP1210-06>
#  Scenario: Verify that load balancer connection is established using user with no authorisation, is not able to fetch Bapi list.
#    Given Base Url and "noAuthUserDirect" is known to connect with load balancer connection
#    When user calls the bapi list by "bapiList" with GET http request
#    Then API call got success with Bapi list with status code 503
#
#
#  @Severity=Normal @tmsLink=<TC-SAP1210-07>
#  Scenario: Verify that snc connection is established using user with no authorisation, is not able to fetch Bapi list.
#    Given Base Url and "noAuthUserDirect" is known to connect with snc connection
#    When user calls the bapi list by "bapiListSNC" with GET http request
#    Then API call got success with Bapi list with status code 503
#
#  @Severity=Normal @tmsLink=<TC-SAP1210-08>
#  Scenario: Verify that s4 hana connection is established using user with no authorisation, is not able to fetch Bapi list.
#    Given Base Url and "noAuthUserDirect" is known to connect with S4 HANA connection
#    When user calls the bapi list by "bapiList" with GET http request
#    Then API call got success with Bapi list with status code 503

  @Severity=Normal @tmsLink=<TC-SAP1210-09> @RegressionTest
  Scenario Outline: Verify that direct connection is established using user with minimum authorisation,user is able to fetch Bapi Schema.
    Given Base Url is known to connect with direct connection for BAPI schema of "BusinessArea.GetDetail"
    When user calls the bapi list by "bapiSchema" with GET http request
    Then API call got success with Bapi list with status code 200
    And API response has <key> and <value>

    Examples:

    |key                      |value              |
    |RESPONSE_DETAIL.name[0]  |BUSINESSAREA_DETAIL|
    |RESPONSE_DETAIL[1].properties[1].name|CODE   |

  @Severity=Normal @tmsLink=<TC-SAP1210-10> @RegressionTest
  Scenario Outline: Verify that load balancer connection is established using user with minimum authorisation,user is able to fetch Bapi Schema.
    Given Base Url is known to connect with load balancer connection for BAPI schema of "BusinessArea.GetDetail"
    When user calls the bapi list by "bapiSchema" with GET http request
    Then API call got success with Bapi list with status code 200
    And API response has <key> and <value>

    Examples:

      |key                      |value              |
      |RESPONSE_DETAIL.name[0]  |BUSINESSAREA_DETAIL|
      |RESPONSE_DETAIL[1].properties[1].name|CODE   |

  @Severity=Normal @tmsLink=<TC-SAP1210-11> @RegressionTest
  Scenario Outline: Verify that SNC connection is established using user with minimum authorisation,user is able to fetch Bapi Schema.
    Given Base Url is known to connect with SNC connection for BAPI schema of "BusinessArea.GetDetail"
    When user calls the bapi list by "bapiSchemaSNC" with GET http request
    Then API call got success with Bapi list with status code 200
    And API response has <key> and <value>

    Examples:

      |key                      |value              |
      |RESPONSE_DETAIL.name[0]  |BUSINESSAREA_DETAIL|
      |RESPONSE_DETAIL[1].properties[1].name|CODE   |

  @Severity=Normal @tmsLink=<TC-SAP1210-12> @RegressionTest
  Scenario Outline: Verify that S4 HANA connection is established using user with minimum authorisation,user is able to fetch Bapi Schema.
    Given Base Url is known to connect with S4 HANA connection for BAPI schema of "BusinessArea.GetDetail"
    When user calls the bapi list by "bapiSchema" with GET http request
    Then API call got success with Bapi list with status code 200
    And API response has <key> and <value>

    Examples:

      |key                      |value              |
      |RESPONSE_DETAIL.name[0]  |BUSINESSAREA_DETAIL|
      |RESPONSE_DETAIL[1].properties[1].name|CODE   |


  @Severity=Normal @tmsLink=<TC-SAP1212-32> @RegressionTest
  Scenario: Bapi execution is successful for PO BAPI-BAPI_PO_CREATE1 using valid payload and auto commite true same can be verified on GUI using S4 HANA
    Given Base Url is known to connect with loadbalancer connection connection and has "PurchaseOrderFRE.CreateFromData1" payload and autocommit "true"
    When user calls the bapi execution by "bapiExecution" with GET http request
    Then API call got success with Bapi list with status code 200
    Then Verify "EXPHEADER.PO_NUMBER" has not null Value
    Then Get the "EXPHEADER.PO_NUMBER" value
    Given Base Url is known to connect with loadbalancer connection connection and has "BAPI_PO_GETDETAIL1" payload and autocommit "true" to verify auto commit
    When user calls the bapi execution by "rfcExecution" with GET http request
    Then API call got success with Bapi list with status code 200
    Then Verify "POHEADER.PO_NUMBER" has same value as above

  @Severity=Normal @tmsLink=<TC-SAP1212-33>
  Scenario: Bapi execution is successful for PO BAPI-BAPI_PO_CREATE1 using valid payload and no records created when autocommit is false
    Given Base Url is known to connect with loadbalancer connection connection and has "PurchaseOrderFRE.CreateFromData1" payload and autocommit "false"
    When user calls the bapi execution by "bapiExecution" with GET http request
    Then API call got success with Bapi list with status code 200
    Then Verify "EXPHEADER.PO_NUMBER" has not null Value
    Then Get the "EXPHEADER.PO_NUMBER" value
    Given Base Url is known to connect with loadbalancer connection connection and has "BAPI_PO_GETDETAIL1" payload and autocommit "true" to verify auto commit
    When user calls the bapi execution by "rfcExecution" with GET http request
    Then API call got success with Bapi list with status code 200
    Then Verify "POHEADER.PO_NUMBER" has null value

  @Severity=Normal @tmsLink=<TC-SAP1212-34>
  Scenario: Bapi execution is unsuccessful for PO BAPI-BAPI_PO_CREATE1 using invalid company code payload where company code is invalid
    Given Base Url is known to connect with loadbalancer connection connection and has invalid comp code "PurchaseOrderFRE.CreateFromData1" payload and autocommit "true"
    When user calls the bapi execution by "bapiExecution" with GET http request
    Then API call got success with Bapi list with status code 200
    Then Verify "EXPHEADER.PO_NUMBER" has null value
    And Verify "RETURN[1].MESSAGE" has message "Company code qqq is not defined"

  @Severity=Normal @tmsLink=<TC-SAP1212-34,TC-SAP1212-35,TC-SAP1212-36,TC-SAP1212-37,TC-SAP1212-38,TC-SAP1212-40>
  Scenario Outline: Bapi execution is unsuccessful for PO BAPI-BAPI_PO_CREATE1 using invalid Purchase organisation payload
    Given Base Url is known to connect with loadbalancer connection connection and has invalid Purchase organisation "PurchaseOrderFRE.CreateFromData1" payload and autocommit "true" replace <Key> with <Value>
    When user calls the bapi execution by "bapiExecution" with GET http request
    Then API call got success with Bapi list with status code 200
    Then Verify "EXPHEADER.PO_NUMBER" has null value
    And Verify <JsonPath> has error message <Message>

    Examples:
    |Key                        |Value                    |JsonPath                 |Message  |
    |"COMP_CODE": "1010"        |"COMP_CODE": "qqqq"      |RETURN[1].MESSAGE        |Company code qqqq is not defined  |
    |"PURCH_ORG": "1010"        |"PURCH_ORG": "goog"      |RETURN[2].MESSAGE        |Purchasing organization goog not defined      |
    |"PUR_GROUP": "001"         |"PUR_GROUP": "abc"       |RETURN[1].MESSAGE        |Purchasing group abc not defined      |
    |"VENDOR": "0010300001"     |"VENDOR": "ven0300001"   |RETURN[1].MESSAGE        |No master record exists for supplier ven0300001      |
    |"CURRENCY": "EUR"          |"CURRENCY": "xyz"        |RETURN[0].MESSAGE        |Currency key is unknown      |
    |"MATERIAL": "SG21"         |"MATERIAL": "inva"       |RETURN[2].MESSAGE        |Account assignment mandatory for material inva      |





