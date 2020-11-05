package com.awign.utilities;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;


import com.awign.dataprovider.TestDataFactory;

public class EventProcessorFactory {
	
	
	public void processEvents(String event) {
		if (StringUtils.containsIgnoreCase(event, "testdata")) {
			JSONObject testdata = new JSONObject();
			
		}
		
	}

}
