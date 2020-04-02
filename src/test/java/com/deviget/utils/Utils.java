package com.deviget.utils;

import com.deviget.sites.AliExpressSite;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class Utils {
	
	public static String getUser(String credentials) {
		try {
			return getCredentials(credentials)[0];
		} catch(ArrayIndexOutOfBoundsException ex) {}
		finally {
			return "";
		}
	}
	
	public static String getPassword(String credentials) {
		try {
			return getCredentials(credentials)[1];
		} catch(ArrayIndexOutOfBoundsException ex) {}
		finally {
			return "";
		}
	}

	public static String[] getCredentials(String creds) {
		return creds.split(":");
	}

    public static void fetchParameters(AliExpressSite site, DataTable table) {
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
		site.addParameters(rows.get(0));
    }
}
