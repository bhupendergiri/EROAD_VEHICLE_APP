package com.eroad.bhupendergiri.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.eroad.bhupendergiri.Constants;
import com.eroad.bhupendergiri.Record;

/**
 * Read csv file whose header is UTC datetime,latitude,langitude
 * @author Bhupender Giri
 * 
 */
public class EroadCSVFileWriter {
	
	public static void writeCSVFile(String fileName, List<Record> records) {
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);
			//Write the record to the CSV file
			for (Record record : records) {
				fileWriter.append(String.valueOf(record.getUtcDate()));
				fileWriter.append(Constants.COMMA_DELIMITER);
				fileWriter.append(record.getLatitude());
				fileWriter.append(Constants.COMMA_DELIMITER);
				fileWriter.append(record.getLongitude());
				fileWriter.append(Constants.COMMA_DELIMITER);
				fileWriter.append(record.getLocalName());
				fileWriter.append(Constants.COMMA_DELIMITER);
				fileWriter.append(record.getLocalisedDatetime());
				fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			}
			System.out.println("\n\n*****************************  PLEASE SEE OUTPUT BELOW ***************************\n\n");
			System.out.println("   CSV file with name="+fileName+" was created successfully.\n\n\n");
			System.out.println("***************************** DEVELOPED BY BHUPENDER FOR EROAD *****************\n\n");
			
		} catch (Exception e) {
			System.err.println("Error in CsvFileWriter !!!"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter!=null) {
					fileWriter.flush();
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}
