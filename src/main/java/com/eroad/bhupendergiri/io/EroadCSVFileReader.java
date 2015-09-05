package com.eroad.bhupendergiri.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.eroad.bhupendergiri.Constants;
import com.eroad.bhupendergiri.Record;
import com.eroad.bhupendergiri.utility.DateTimeUtility;

/**
 * @author Bhupender Giri
 *
 */
public class EroadCSVFileReader {
	
	/**
	 * This method will read the inputFile and return the list of records containing 
	 * all the rows as a record. So one record is representing one row in input file.
	 * @param inputFile
	 * @return
	 */
	public static List<Record> readCSVFile(File inputFile){

		BufferedReader fileReader = null;
		//Create a new list of records  (each row in csv file means one record)
    	List<Record> records = new ArrayList<Record>();
        try {
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(inputFile));
            
            //Read the file line by line starting from the second line
            int count =0;
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] csvToken = line.split(Constants.COMMA_DELIMITER);
                if (csvToken!=null && csvToken.length > 0) {
                	//Create a new record object and fill his  data
                	Record record = new Record(csvToken[Constants.UTC_DATETIME_IDX], csvToken[Constants.lATITUDE_IDX], csvToken[Constants.LONGITUDE_IDX]);
                	if (count!=0) {
						TimeZone vehicleTimeZone = DateTimeUtility.getVehicleTimeZone(csvToken[Constants.lATITUDE_IDX], csvToken[Constants.LONGITUDE_IDX]);
						String localizedDate = DateTimeUtility.convertUTCDateToGivenTimeZone(csvToken[Constants.UTC_DATETIME_IDX],
								vehicleTimeZone);
						record.setLocalisedDatetime(localizedDate);
						record.setLocalName(vehicleTimeZone.getID());
					}else {
						record.setLocalisedDatetime(Constants.LOCALISED_DATETIME);
						record.setLocalName(Constants.VEHICLE_TIME_ZONE);
					}
					records.add(record);
					count++;
				}
            }
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return records;
	
	}

}
