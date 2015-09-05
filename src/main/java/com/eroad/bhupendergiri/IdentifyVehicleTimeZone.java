package com.eroad.bhupendergiri;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.eroad.bhupendergiri.io.EroadCSVFileReader;
import com.eroad.bhupendergiri.io.EroadCSVFileWriter;

/**
 * This is the main class which will be taking a input file and producing output
 * file with required information
 * 
 * @author Bhupender Giri
 *
 */
public class IdentifyVehicleTimeZone {

	public static void main(String[] args) {
		IdentifyVehicleTimeZone obj = new IdentifyVehicleTimeZone();
		File inputFile = obj.getInputFile();
		if (inputFile != null) {
			List<Record> recordsRead = EroadCSVFileReader.readCSVFile(inputFile);
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.Output_CSV_CreatedTime);
			String format = dateFormat.format(date);
			String outputFileName = Constants.outputFileNamePrefix + format + ".csv";
			EroadCSVFileWriter.writeCSVFile(outputFileName, recordsRead);
		} else {
			System.err.println(
					"Could not locate the input file. Please verify if it is present in src/main/resources folder or not");
		}
	}
	/**
	 * This method will try to read the input.csv file and return the java.io.File object
	 * 
	 * @return java.io.File
	 */
	private File getInputFile() {
		File file = null;
		try {
			file = new File(this.getClass().getResource("/" + Constants.inputFileName).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return file;
	}

}
