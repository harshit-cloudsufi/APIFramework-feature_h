Feature: RFC List and schema
  @Severity=Blocker @tmsLink=<TC-SAP1210-01> @RegressionTest
  Scenario: Verify that direct connection is established and user is able to fetch RFC list.
    Given Base Url is known to connect with direct connection for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements


  @Severity=Blocker @tmsLink=<TC-SAP1210-02> @RegressionTest
  Scenario: Verify that connection via Load balancer is established and user is able to fetch RFC list.
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Blocker @tmsLink=<TC-SAP1210-03> @RegressionTest
  Scenario: Verify that SNC connection is established and user is able to fetch RFC list.
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Blocker @tmsLink=<TC-SAP1210-04> @RegressionTest
  Scenario: Verify that S4 HANA connection is established and user is able to fetch RFC list.
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

#  @Severity=Normal @tmsLink=<TC-SAP1210-05>
#  Scenario: Verify that direct connection is established using user with no authorisation, is not able to fetch RFC list.
#    Given Base Url and "noAuthUserDirect" is known to connect with direct connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
#    When user calls the list by "rfcList" with GET http request
#    Then API call got success with Bapi list with status code 503
#
#
#  @Severity=Normal @tmsLink=<TC-SAP1210-06>
#  Scenario: Verify that load balancer connection is established using user with no authorisation, is not able to fetch RFC list.
#    Given Base Url and "noAuthUserDirect" is known to connect with load balancer connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
#    When user calls the list by "rfcList" with GET http request
#    Then API call got success with Bapi list with status code 503


#  @Severity=Normal @tmsLink=<TC-SAP1210-07>
#  Scenario: Verify that snc connection is established using user with no authorisation, is not able to fetch RFC list.
#    Given Base Url and "noAuthUserDirect" is known to connect with snc connection for RFC for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
#    When user calls the list by "rfcList" with GET http request
#    Then API call got success with Bapi list with status code 503

#  @Severity=Normal @tmsLink=<TC-SAP1210-08>
#  Scenario: Verify that s4 hana connection is established using user with no authorisation, is not able to fetch RFC list.
#    Given Base Url and "noAuthUserDirect" is known to connect with S4 HANA connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
#    When user calls the list by "rfcList" with GET http request
#    Then API call got success with RFC list with status code 503

  @Severity=Normal @tmsLink=<TC-SAP1210-09> @RegressionTest
  Scenario Outline: Verify that direct connection is established using user with minimum authorisation,user is able to fetch RFC Schema.
    Given Base Url is known to connect with direct connection for RFC schema of "CSAI_BOM_DELETE"
    When user calls the list by "rfcSchema" with GET http request
    Then API call got success with RFC list with status code 200
    And RFC API response has <key> and <value>

    Examples:
      |key                      |value        |
      |REQUEST_DETAIL[0].name   |ECSIN        |
      |RESPONSE_DETAIL[0].name  |FL_WARNING   |

  @Severity=Normal @tmsLink=<TC-SAP1210-10> @RegressionTest
  Scenario Outline: Verify that load balancer connection is established using user with minimum authorisation,user is able to fetch RFC Schema.
    Given Base Url is known to connect with load balancer connection for RFC schema of "CSAI_BOM_DELETE"
    When user calls the list by "rfcSchema" with GET http request
    Then API call got success with RFC list with status code 200
    And RFC API response has <key> and <value>

    Examples:
      |key                      |value        |
      |REQUEST_DETAIL[0].name   |ECSIN        |
      |RESPONSE_DETAIL[0].name  |FL_WARNING   |

  @Severity=Normal @tmsLink=<TC-SAP1210-11> @RegressionTest
  Scenario Outline: Verify that SNC connection is established using user with minimum authorisation,user is able to fetch RFC Schema.
    Given Base Url is known to connect with SNC connection for RFC schema of "CSAI_BOM_DELETE"
    When user calls the list by "rfcSchemaSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And RFC API response has <key> and <value>

    Examples:
      |key                      |value        |
      |REQUEST_DETAIL[0].name   |ECSIN        |
      |RESPONSE_DETAIL[0].name  |FL_WARNING   |

  @Severity=Normal @tmsLink=<TC-SAP1210-12> @RegressionTest
  Scenario Outline: Verify that S4 HANA connection is established using user with minimum authorisation,user is able to fetch RFC Schema.
    Given Base Url is known to connect with S4 HANA connection for RFC schema of "CSAI_BOM_DELETE"
    When user calls the list by "rfcSchema" with GET http request
    Then API call got success with RFC list with status code 200
    And RFC API response has <key> and <value>

    Examples:
      |key                      |value        |
      |REQUEST_DETAIL[0].name   |ECSIN        |
      |RESPONSE_DETAIL[0].name  |FL_WARNING   |

  @Severity=Normal @tmsLink=<TC-SAP1210-29> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with direct connection and "Refresh = False"
    Given Base Url is known to connect with direct connection for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with direct connection for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-30> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for direct connection  and "Refresh = False"
    Given Base Url is known to connect with direct connection for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements
    Given Base Url is known to connect with direct connection for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-31> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with direct connection and "Refresh = true"
    Given Base Url is known to connect with direct connection for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with direct connection for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-32> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for direct connection  and "Refresh = true"
    Given Base Url is known to connect with direct connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with direct connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements


  @Severity=Normal @tmsLink=<TC-SAP1210-33> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with load balncer connection and "Refresh = False"
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-34> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for load balncer connection  and "Refresh = False"
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-35> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with load balncer connection and "Refresh = true"
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-36> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for load balncer connection  and "Refresh = true"
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with connection via load balncer for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements


  @Severity=Normal @tmsLink=<TC-SAP1210-37> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with snc connection and "Refresh = False"
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-38> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for snc connection  and "Refresh = False"
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-39> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with snc connection and "Refresh = False"
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-40> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for snc connection  and "Refresh = true"
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with connection using snc for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcListSNC" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-41> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with S4 hana connection and "Refresh = False"
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-42> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for S4 hana connection  and "Refresh = False"
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "false" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 1 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-43> @RegressionTest
  Scenario: Validate that the cached RFC list is returned as a response when a previously fetched RFC list is fetched again with S4 hana connection and "Refresh = true"
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "true" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "false" and filter= ""
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-44> @RegressionTest
  Scenario: Validate that the filtered RFC list is returned as a response when filter parameters are passed in the header for S4 hana connection  and "Refresh = true" with filter
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements
    Given Base Url is known to connect with S4 hana connection for RFC with query refresh= "true" and filter= "CDESK_CREATE_DOCUMENT_RFC"
    When user calls the list by "rfcList" with GET http request
    Then API call got success with RFC list with status code 200
    And list has the 24 types of elements

  @Severity=Normal @tmsLink=<TC-SAP1210-46> @RegressionTest
  Scenario: rfc execution is successful for PO rfc-rfc_PO_CREATE1 using valid payload and no records created when autocommit is false
    Given Base Url is known to connect with loadbalancer connection connection and has "BAPI_CUSTOMER_CREATEFROMDATA1" payload and autocommit "true" for RFC
    When user calls the RFC execution by "rfcExecution" with GET http request
    Then API call got success with RFC list with status code 200
    Then Validate "CUSTOMERNO" has not null Value
    Then Get the value of "CUSTOMERNO"
    Given Base Url is known to connect with loadbalancer connection connection and has "BAPI_CUSTOMER_GETDETAIL2" payload and autocommit "true" to verify auto commit for RFC
    When user calls the RFC execution by "rfcExecution" with GET http request
    Then API call got success with RFC list with status code 200
    Then Verify "CUSTOMERADDRESS.CUSTOMER" has same value
