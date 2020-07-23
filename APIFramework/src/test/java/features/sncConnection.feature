Feature: SNC connection test

  @Severity=Blocker @tmsLink=<TC-SAP1200-03> @RegressionTest
  Scenario: Verify that connection using SNC is established with the valid headers
    Given Base Url is known and headers are valid for connection using SNC
    When user calls "connectionTestSNC" with GET http request for connection using  SNC
    Then SNC connection API call got success with status code 200

  @Severity=Normal @tmsLink=<TC-SAP1200-46>
    Scenario: Verify if Client parameter is not present then missing parameter exception is thrown
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when client is not present connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "clientMissing" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-47>
  Scenario: Verify if Sysnr parameter is not present then missing parameter exception is thrown
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when Sysnr is not present connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "sysnrMissing" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-48>
  Scenario: Verify if ashost parameter is not present then missing parameter exception is thrown
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when ashost is not present connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "ashostMissing" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-49>
  Scenario: Verify if snc_partnername parameter is not present then missing parameter exception is thrown
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_partnername is not present connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-50>
  Scenario: Verify if snc_lib parameter is not present then missing parameter exception is thrown
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_lib is not present connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "libMissing" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-51,C-SAP1200-52,C-SAP1200-54>
  Scenario Outline: Verify if Client parameter has invalid value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when client is "<value>" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection


    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<C-SAP1200-53>
  Scenario: Verify if Client parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when client is int 111 for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-55,TC-SAP1200-57>
  Scenario Outline: Verify if Lang parameter has invalid value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when lang is "<value>" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection


    Examples:
      |value  |
      |E      |
      |       |

  @Severity=Normal @tmsLink=<TC-SAP1200-56>
  Scenario: Verify if Lang parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when lang is "Cn" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "invalidAuthorizationmessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMassageInvalidLang" connection for SNC connection
    Then Primary code is validated with "invalidAuthorizationCode" connection for SNC connection
    Then Secondary code is validated with "secondaryCodeDueToInvalid" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-59,TC-SAP1200-61>
  Scenario Outline: Verify if Sysnr parameter has invalid value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when Sysnr is "<value>" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "sysnrInvalid" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection


    Examples:
      |value  |
      |c      |
      |a1c    |

  @Severity=Normal @tmsLink=<TC-SAP1200-58>
  Scenario: Verify if Sysnr parameter has blank value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when Sysnr is "" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-60>
  Scenario: Verify if Sysnr parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when Sysnr is "24" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection for SNC connection
    Then Secondary mesaage is validated when "authClientSecondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "authClientCode" connection for SNC connection

  @Severity=Normal @tmsLink=<TC-SAP1200-62,C-SAP1200-63,C-SAP1200-65>
  Scenario Outline: Verify if Asost parameter has invalid value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when Ashost is "<value>" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection


    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<C-SAP1200-64>
  Scenario: Verify if ashost parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when Ashost is "10.132.0.40" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection for SNC connection
    Then Secondary mesaage is validated when "authClientSecondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "authClientCode" connection for SNC connection


#TODO
  @Severity=Normal @tmsLink=<TC-SAP1200-66,C-SAP1200-67,C-SAP1200-69>
  Scenario Outline: Verify if SNC_Mode parameter has invalid value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when SNC_Mode is "<value>" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection


    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |

    #TODO
  @Severity=Normal @tmsLink=<C-SAP1200-68>
  Scenario: Verify if SNC_Mode parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when SNC_Mode is "9" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection



  @Severity=Normal @tmsLink=<C-SAP1200-70>
  Scenario: Verify if snc_partnername parameter has blank value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_partnername is "" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<C-SAP1200-71>
  Scenario: Verify if snc_partnername parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_partnername is "p:CN=S4H, OU=INITIAL, O=SAP Trust Community, C=DEkk" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection for SNC connection
    Then Secondary mesaage is validated when "authClientSecondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "authClientCode" connection for SNC connection


  @Severity=Normal @tmsLink=<TC-SAP1200-72,C-SAP1200-73,C-SAP1200-75>
  Scenario Outline: Verify if snc_qop parameter has invalid value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_qop is "<value>" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection


    Examples:
      |value  |
      |c      |
      |a1c    |
      |       |

  @Severity=Normal @tmsLink=<C-SAP1200-74>
  Scenario: Verify if snc_qop parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_qop is "4" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection




  @Severity=Normal @tmsLink=<C-SAP1200-76>
  Scenario: Verify if snc_myname parameter has blank value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_myname is "" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<C-SAP1200-77>
  Scenario: Verify if snc_myname parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_myname is "p:CN=ZAS, OU=IT, O=CSW, C=US" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection for SNC connection
    Then Secondary mesaage is validated when "mynameInvalidSecMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "authClientCode" connection for SNC connection


  @Severity=Normal @tmsLink=<C-SAP1200-78>
  Scenario: Verify if snc_lib parameter has blank value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_lib is "" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "missingInvalidParameterPrimaryMessage" connection for SNC connection
    Then Secondary mesaage is validated when "secondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "configSecondarycode" connection for SNC connection

  @Severity=Normal @tmsLink=<C-SAP1200-79>
  Scenario: Verify if snc_lib parameter has wrong value then connection is not established
    Given Base Url "connectionTestSNC" is known for SNC connection
    When Following parameters are inserted with GET request as header when snc_lib is "C:\snc1zzz\sapcrypto.dll" for SNC connection
    Then SNC connection API call got success with status code 503
    Then Primary mesaage is validated with "authClientMessage" connection for SNC connection
    Then Secondary mesaage is validated when "authClientSecondaryMessage" connection for SNC connection
    Then Primary code is validated with "configurationPrimaryCode" connection for SNC connection
    Then Secondary code is validated with "authClientCode" connection for SNC connection