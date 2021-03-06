package org.openhealthtools.mdht.cts2.cache;

/**
 * TODO eclipse extension point for declaring Code System specific service handlers.
 * 
 * TODO this is a Code System handler, not a service handler
 * 
 * @author dcarlson
 * 
 */
public class MayoSctHandler extends CTS2Service {

	private static String SERVICE_NAME = "Mayo SCT";

	private static String SERVICE_URL = "http://informatics.mayo.edu/cts2/services/sct/cts2";

	public static String URI_BASE = "http://snomed.info/id/";

	public static String ROOT_ENTITY_ID = "138875005";

	public static String ROOT_ENTITY_URI = URI_BASE + ROOT_ENTITY_ID;

	public MayoSctHandler() {
		super(SERVICE_NAME, SERVICE_URL);
	}

	@Override
	public String getRootConceptURI() {
		return ROOT_ENTITY_URI;
	}

}
