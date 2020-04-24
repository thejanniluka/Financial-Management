package com.ITP.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ITP.service.IFinancialService;

public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IFinancialService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Employee ID
	 */
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.FINANCIAL_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.FINANCIAL_ID_PREFIX + next;
		}
		return id;
	}
}
