package sapadapter.payload;

import gherkin.deps.com.google.gson.JsonObject;

public class BapiExecutionPayload {
    public static String Customer="{\n" +
            "\t\"POHEADER\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"1010\",\n" +
            "\t\t\"DOC_TYPE\": \"NB\",\n" +
            "\t\t\"ITEM_INTVL\": \"00000\",\n" +
            "\t\t\"VENDOR\": \"0010300001\",\n" +
            "\t\t\"PMNTTRMS\": \"0004\",\n" +
            "\t\t\"DSCNT1_TO\": \"0\",\n" +
            "\t\t\"DSCNT2_TO\": \"0\",\n" +
            "\t\t\"DSCNT3_TO\": \"0\",\n" +
            "\t\t\"DSCT_PCT1\": \"0.000\",\n" +
            "\t\t\"DSCT_PCT2\": \"0.000\",\n" +
            "\t\t\"PURCH_ORG\": \"1010\",\n" +
            "\t\t\"PUR_GROUP\": \"001\",\n" +
            "\t\t\"CURRENCY\": \"EUR\",\n" +
            "\t\t\"CURRENCY_ISO\": \"EUR\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"POHEADERX\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"X\",\n" +
            "\t\t\"ITEM_INTVL\": \"X\",\n" +
            "\t\t\"VENDOR\": \"X\",\n" +
            "\t\t\"PMNTTRMS\": \"X\",\n" +
            "\t\t\"PURCH_ORG\": \"X\",\n" +
            "\t\t\"PUR_GROUP\": \"X\",\n" +
            "\t\t\"CURRENCY\": \"X\",\n" +
            "\t\t\"CURRENCY_ISO\": \"X\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"POITEM\": \n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"SG21\",\n" +
            "\t\t\t\"PLANT\": \"1010\",\n" +
            "\t\t\t\"MATL_GROUP\": \"L003\",\n" +
            "\t\t\t\"QUANTITY\": \"10.000\",\n" +
            "\t\t\t\"NET_PRICE\": \"1.000000000\",\n" +
            "\t\t\t\"PERIOD_IND_EXPIRATION_DATE\": \"D\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"POITEMX\": \n" +
            "\t[\n" +
            "\t\t\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"X\",\n" +
            "\t\t\t\"PLANT\": \"X\",\n" +
            "\t\t\t\"MATL_GROUP\": \"X\",\n" +
            "\t\t\t\"QUANTITY\": \"X\",\n" +
            "\t\t\t\"NET_PRICE\": \"X\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
    public static String PurchaseOrderFRE="{\n" +
            "\t\"POHEADER\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"1010\",\n" +
            "\t\t\"DOC_TYPE\": \"NB\",\n" +
            "\t\t\"ITEM_INTVL\": \"00000\",\n" +
            "\t\t\"VENDOR\": \"0010300001\",\n" +
            "\t\t\"PMNTTRMS\": \"0004\",\n" +
            "\t\t\"DSCNT1_TO\": \"0\",\n" +
            "\t\t\"DSCNT2_TO\": \"0\",\n" +
            "\t\t\"DSCNT3_TO\": \"0\",\n" +
            "\t\t\"DSCT_PCT1\": \"0.000\",\n" +
            "\t\t\"DSCT_PCT2\": \"0.000\",\n" +
            "\t\t\"PURCH_ORG\": \"1010\",\n" +
            "\t\t\"PUR_GROUP\": \"001\",\n" +
            "\t\t\"CURRENCY\": \"EUR\",\n" +
            "\t\t\"CURRENCY_ISO\": \"EUR\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"POHEADERX\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"X\",\n" +
            "\t\t\"ITEM_INTVL\": \"X\",\n" +
            "\t\t\"VENDOR\": \"X\",\n" +
            "\t\t\"PMNTTRMS\": \"X\",\n" +
            "\t\t\"PURCH_ORG\": \"X\",\n" +
            "\t\t\"PUR_GROUP\": \"X\",\n" +
            "\t\t\"CURRENCY\": \"X\",\n" +
            "\t\t\"CURRENCY_ISO\": \"X\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"POITEM\": \n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"SG21\",\n" +
            "\t\t\t\"PLANT\": \"1010\",\n" +
            "\t\t\t\"MATL_GROUP\": \"L003\",\n" +
            "\t\t\t\"QUANTITY\": \"10.000\",\n" +
            "\t\t\t\"NET_PRICE\": \"1.000000000\",\n" +
            "\t\t\t\"PERIOD_IND_EXPIRATION_DATE\": \"D\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"POITEMX\": \n" +
            "\t[\n" +
            "\t\t\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"X\",\n" +
            "\t\t\t\"PLANT\": \"X\",\n" +
            "\t\t\t\"MATL_GROUP\": \"X\",\n" +
            "\t\t\t\"QUANTITY\": \"X\",\n" +
            "\t\t\t\"NET_PRICE\": \"X\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
    public String GetDetail1="{\n" +
            "\"PURCHASEORDER\": \"4500000691\"\n" +
            "}";
    public static String CreateFromData1InvalidComp_Code="{\n" +
            "\t\"POHEADER\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"qqq\",\n" +
            "\t\t\"DOC_TYPE\": \"NB\",\n" +
            "\t\t\"ITEM_INTVL\": \"00000\",\n" +
            "\t\t\"VENDOR\": \"0010300001\",\n" +
            "\t\t\"PMNTTRMS\": \"0004\",\n" +
            "\t\t\"DSCNT1_TO\": \"0\",\n" +
            "\t\t\"DSCNT2_TO\": \"0\",\n" +
            "\t\t\"DSCNT3_TO\": \"0\",\n" +
            "\t\t\"DSCT_PCT1\": \"0.000\",\n" +
            "\t\t\"DSCT_PCT2\": \"0.000\",\n" +
            "\t\t\"PURCH_ORG\": \"1010\",\n" +
            "\t\t\"PUR_GROUP\": \"001\",\n" +
            "\t\t\"CURRENCY\": \"EUR\",\n" +
            "\t\t\"CURRENCY_ISO\": \"EUR\"\n" +
            "\t\n" +
            "\n" +
            "\t},\n" +
            "\n" +
            "\t\"POHEADERX\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"X\",\n" +
            "\t\t\"ITEM_INTVL\": \"X\",\n" +
            "\t\t\"VENDOR\": \"X\",\n" +
            "\t\t\"PMNTTRMS\": \"X\",\n" +
            "\t\t\"PURCH_ORG\": \"X\",\n" +
            "\t\t\"PUR_GROUP\": \"X\",\n" +
            "\t\t\"CURRENCY\": \"X\",\n" +
            "\t\t\"CURRENCY_ISO\": \"X\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"POITEM\": \n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"SG21\",\n" +
            "\t\t\t\"PLANT\": \"1010\",\n" +
            "\t\t\t\"MATL_GROUP\": \"L003\",\n" +
            "\t\t\t\"QUANTITY\": \"10.000\",\n" +
            "\t\t\t\"NET_PRICE\": \"1.000000000\",\n" +
            "\t\t\t\"PERIOD_IND_EXPIRATION_DATE\": \"D\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"POITEMX\": \n" +
            "\t[\n" +
            "\t\t\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"X\",\n" +
            "\t\t\t\"PLANT\": \"X\",\n" +
            "\t\t\t\"MATL_GROUP\": \"X\",\n" +
            "\t\t\t\"QUANTITY\": \"X\",\n" +
            "\t\t\t\"NET_PRICE\": \"X\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";

    public static String CreateFromData1InvalidPurchase_organisation="{\n" +
            "\t\"POHEADER\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"1010\",\n" +
            "\t\t\"DOC_TYPE\": \"NB\",\n" +
            "\t\t\"ITEM_INTVL\": \"00000\",\n" +
            "\t\t\"VENDOR\": \"0010300001\",\n" +
            "\t\t\"PMNTTRMS\": \"0004\",\n" +
            "\t\t\"DSCNT1_TO\": \"0\",\n" +
            "\t\t\"DSCNT2_TO\": \"0\",\n" +
            "\t\t\"DSCNT3_TO\": \"0\",\n" +
            "\t\t\"DSCT_PCT1\": \"0.000\",\n" +
            "\t\t\"DSCT_PCT2\": \"0.000\",\n" +
            "\t\t\"PURCH_ORG\": \"goog\",\n" +
            "\t\t\"PUR_GROUP\": \"001\",\n" +
            "\t\t\"CURRENCY\": \"EUR\",\n" +
            "\t\t\"CURRENCY_ISO\": \"EUR\"\n" +
            "\t\n" +
            "\n" +
            "\t},\n" +
            "\n" +
            "\t\"POHEADERX\": \n" +
            "\t{\n" +
            "\t\t\"COMP_CODE\": \"X\",\n" +
            "\t\t\"ITEM_INTVL\": \"X\",\n" +
            "\t\t\"VENDOR\": \"X\",\n" +
            "\t\t\"PMNTTRMS\": \"X\",\n" +
            "\t\t\"PURCH_ORG\": \"X\",\n" +
            "\t\t\"PUR_GROUP\": \"X\",\n" +
            "\t\t\"CURRENCY\": \"X\",\n" +
            "\t\t\"CURRENCY_ISO\": \"X\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"POITEM\": \n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"SG21\",\n" +
            "\t\t\t\"PLANT\": \"1010\",\n" +
            "\t\t\t\"MATL_GROUP\": \"L003\",\n" +
            "\t\t\t\"QUANTITY\": \"10.000\",\n" +
            "\t\t\t\"NET_PRICE\": \"1.000000000\",\n" +
            "\t\t\t\"PERIOD_IND_EXPIRATION_DATE\": \"D\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"POITEMX\": \n" +
            "\t[\n" +
            "\t\t\n" +
            "\t\t{\n" +
            "\t\t\t\"PO_ITEM\": \"00010\",\n" +
            "\t\t\t\"MATERIAL\": \"X\",\n" +
            "\t\t\t\"PLANT\": \"X\",\n" +
            "\t\t\t\"MATL_GROUP\": \"X\",\n" +
            "\t\t\t\"QUANTITY\": \"X\",\n" +
            "\t\t\t\"NET_PRICE\": \"X\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
}
