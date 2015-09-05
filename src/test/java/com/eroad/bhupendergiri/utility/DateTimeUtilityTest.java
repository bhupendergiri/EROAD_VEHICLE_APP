package com.eroad.bhupendergiri.utility;
import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.Test;

import com.eroad.bhupendergiri.utility.DateTimeUtility;

public class DateTimeUtilityTest {
	
	DateTimeUtility date;
	private static final String PACIFIC_AUCKLAND = "Pacific/Auckland";
	
	String latittude = "-44.490947";
	String longitude = "171.220966";
	String utcDateStr = "2013-07-10 02:52:49";
	String localizedDateStr = "2013-07-10T14:52:49";
	
	@Test
	public void testGetVehicleTimeZone(){
		TimeZone vehicleTimeZone = DateTimeUtility.getVehicleTimeZone(latittude, longitude);
		assertEquals(PACIFIC_AUCKLAND, vehicleTimeZone.getID());
	}
	
	@Test
	public void testGetVehicleTimeZone_Blank(){
		TimeZone vehicleTimeZone = DateTimeUtility.getVehicleTimeZone("", "");
		assertEquals(TimeZone.getDefault(), vehicleTimeZone);
	}
	
	@Test
	public void testGetVehicleTimeZone_NUll(){
		TimeZone vehicleTimeZone = DateTimeUtility.getVehicleTimeZone(null, null);
		assertEquals(TimeZone.getDefault(), vehicleTimeZone);
	}
	@Test
	public void testGetVehicleTimeZone_Invalid(){
		TimeZone vehicleTimeZone = DateTimeUtility.getVehicleTimeZone("0", "0");
		assertEquals(null, vehicleTimeZone);
	}
	@Test
	public void testGetVehicleTimeZone_NULL_LatLang(){
		TimeZone vehicleTimeZone = DateTimeUtility.getVehicleTimeZone(null, longitude);
		assertEquals(TimeZone.getDefault(), vehicleTimeZone);
	}
	
	@Test
	public void testConvertUTCDateToGivenTimeZone(){
		String output = DateTimeUtility.convertUTCDateToGivenTimeZone(utcDateStr, TimeZone.getTimeZone(PACIFIC_AUCKLAND));
		assertEquals(localizedDateStr, output);
	}
	
	@Test
	public void testConvertUTCDateToGivenTimeZone_BlankDate(){
		String output = DateTimeUtility.convertUTCDateToGivenTimeZone("", TimeZone.getTimeZone(PACIFIC_AUCKLAND));
		assertEquals("", output);
	}
	
	@Test
	public void testConvertUTCDateToGivenTimeZone_BlankTimeZone(){
		String output = DateTimeUtility.convertUTCDateToGivenTimeZone(utcDateStr, null);
		assertEquals(output, utcDateStr);
	}
}
