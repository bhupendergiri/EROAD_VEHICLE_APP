package com.eroad.bhupendergiri;
/**
 * This file contains all the constants used 
 * throughout the application.
 *  
 * @author Bhupender Giri 
 *
 */
public interface Constants {
	
	static final String inputFileName = "input.csv";
	static final String outputFileNamePrefix = "output_";
	final String Output_CSV_CreatedTime = "yyyy-MM-dd_HH_mm_ss";

	static final String UCD_DATEFORMAT_PATTERN_YYYYMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	static final String LOCALIZED_DATEFORMAT_PATTERN_YYYYMMddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";
	
	//Delimiter used in CSV file
	static final String COMMA_DELIMITER = ",";
	static final String NEW_LINE_SEPARATOR = "\n";
	//Records index used in CSV
	static final int UTC_DATETIME_IDX = 0;
	static final int lATITUDE_IDX = 1;
	static final int LONGITUDE_IDX = 2;
	static final int LOCALIZED_DATE_IDX = 3;
	
	//Below are two extra coloumn header name to be appended in first row of  output csv file
	final String LOCALISED_DATETIME = "localised datetime";
	final String VEHICLE_TIME_ZONE = "Vehicle TimeZone";
	
	//following api-key is used to interact with google timezone api
	static String API_KEY ="AIzaSyARHFOPWj8S0RGd1V0F39cJZUCcuQDYrto";
}
