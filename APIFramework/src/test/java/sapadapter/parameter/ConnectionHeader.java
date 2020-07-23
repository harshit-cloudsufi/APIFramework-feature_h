package sapadapter.parameter;

import java.util.HashMap;
import java.util.Map;

public class ConnectionHeader {

    public static Map<String, String> trueConnectionHeader(){
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap.put("jco.client.client", "001");
        headerMap.put("jco.client.lang", "En");
        headerMap.put("jco.client.sysnr","00");
        headerMap.put("jco.client.ashost","10.132.0.8");
        headerMap.put("jco.destination.peak_limit","10");
        headerMap.put("jco.destination.pool_capacity","3");
        return  headerMap;
    }
    public static Map<String, String> trueConnectionHeaderLoad(){
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap.put("jco.client.client", "001");
        headerMap.put("jco.client.mshost","10.132.0.8");
        headerMap.put("jco.client.msserv","3601");
        headerMap.put("jco.client.r3name","ABA");
        headerMap.put("jco.client.lang","en");
        headerMap.put("jco.client.group","LB_ABA_01");
        headerMap.put("jco.destination.peak_limit","10");
        headerMap.put("jco.destination.pool_capacity","3");
        return  headerMap;
    }
    public static Map<String, String> trueConnectionSNC(){
        Map<String, String> headerMap =new HashMap<>();
        headerMap.put("jco.client.client","100");
        headerMap.put("jco.client.lang","EN");
        headerMap.put("jco.client.sysnr","00");
        headerMap.put("jco.client.ashost","10.132.0.4");
        headerMap.put("jco.client.snc_mode","1");
        headerMap.put("jco.client.snc_partnername","p:CN=S4H, OU=INITIAL, O=SAP Trust Community, C=DE");
        headerMap.put("jco.client.snc_qop","1");
        headerMap.put("jco.client.snc_myname","p:CN=QAS, OU=IT, O=CSW, C=US");
        headerMap.put("jco.client.snc_lib","C:\\snc1\\sapcrypto.dll");
        return headerMap;
    }
    public static Map<String, String> trueConnectionHeaderHana(){
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap.put("jco.client.client", "100");
        headerMap.put("jco.client.lang", "En");
        headerMap.put("jco.client.sysnr","00");
        headerMap.put("jco.client.ashost","10.132.0.4");
        headerMap.put("jco.destination.peak_limit","10");
        headerMap.put("jco.destination.pool_capacity","3");
        return  headerMap;
    }

}
