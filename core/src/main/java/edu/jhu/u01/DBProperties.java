package edu.jhu.u01;

import org.mskcc.cbio.portal.util.GlobalProperties;

public class DBProperties {

	private static DBProperties instance;
	private DBVendor vendor;
	
	public static DBProperties getInstance(){
		if(instance == null)
			init();
		return instance;
	}
	private static void init(){
		instance = new DBProperties();
		instance.vendor = DBVendor.mysql;
		String readVendor = GlobalProperties.getProperty("db.vendor");
		if (readVendor != null && readVendor.trim().length() > 0)
			instance.vendor = DBVendor.valueOf(readVendor.trim());
	}
	public static DBVendor getDBVendor(){
		return getInstance().vendor;
	}
}
