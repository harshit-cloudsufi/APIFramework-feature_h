package resources;

public enum APIResources {

	connectionTest("/connectionTest"),
	rfcList("/rfcList"),
	bapiList("/bapiList"),
	bapiListSNC("/bapiListSNC"),
	bapiSchema("/bapiSchema"),
	bapiSchemaSNC("/bapiSchemaSNC"),
	connectionTestSNC("/connectionTestSNC"),
	bapiExecution("/bapiExecution"),
	rfcSchema("/rfcSchema"),
	rfcListSNC("/rfcListSNC"),
	rfcSchemaSNC("/rfcSchemaSNC"),
	rfcExecution("/rfcExecution"),
	rfcExecutionSNC("/rfcExecutionSNC"),
	iDocList("/iDocList"),
	iDocListSNC("/iDocListSNC"),
	iDocSchema("/iDocSchema"),
	iDocSchemaSNC("/iDocSchemaSNC"),
	idocactivateListener("/idoc-activateListener");
	private String resource;

	APIResources(String resource)
	{
		this.resource=resource;
	}
	public String getResource()
	{
		return resource;
	}

}
