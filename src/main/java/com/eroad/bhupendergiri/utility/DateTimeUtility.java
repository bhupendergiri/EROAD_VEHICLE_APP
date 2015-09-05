package com.eroad.bhupendergiri.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.eroad.bhupendergiri.Constants;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;

/**
 * 
 * @author Bhupender Giri
 *
 */
public class DateTimeUtility {

	/**
	 * This method will conver the given ucd date format (in input file) to
	 * given timezone
	 * 
	 * @param UTCDateStr
	 * @param localizedTimeZone
	 * @return
	 */
	public static String convertUTCDateToGivenTimeZone(String UTCDateStr, TimeZone localizedTimeZone) {
		System.out.println("Input UTC Date was = " + UTCDateStr);
		if (UTCDateStr != null && !"".equals(UTCDateStr) && localizedTimeZone != null) {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.UCD_DATEFORMAT_PATTERN_YYYYMMddHHmmss);
			dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date parsedDate = null;
			try {
				parsedDate = dateFormatter.parse(UTCDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dateFormatter = new SimpleDateFormat(Constants.LOCALIZED_DATEFORMAT_PATTERN_YYYYMMddTHHmmss);
			dateFormatter.setTimeZone(localizedTimeZone);

			String formattedDate = dateFormatter.format(parsedDate);
			return formattedDate;
		} else {
			System.err.println("localized date will be = " + UTCDateStr);
			return UTCDateStr;
		}
	}

	/**
	 * This method will return the vehicles current Timezone based on given
	 * <code>latittude</code> and <code>lon</code> arguments
	 * 
	 * @param latittude
	 * @param lon
	 * @return java.util.TimeZone
	 */
	public static TimeZone getVehicleTimeZone(String latittude, String lon) {

		if (latittude == null || lon == null || "".equals(latittude.trim()) || "".equals(lon.trim())) {
			return TimeZone.getDefault();
		} else {
			TimeZone targetTimeZone = null;
			double lat = Double.parseDouble(latittude);
			double longitude = Double.parseDouble(lon);
			LatLng latLongLocation = new LatLng(lat, longitude);
			GeoApiContext context = new GeoApiContext().setApiKey(Constants.API_KEY);
			PendingResult<TimeZone> req = TimeZoneApi.getTimeZone(context, latLongLocation);
			try {
				targetTimeZone = req.await();
			} catch (NumberFormatException ne) {
				System.out.println(
						" Error occured with given latitude="+latittude+" and longitude="+latittude+" and err message is =" + ne.getMessage());
			} catch (Exception e) {
				System.out.println(
						" Error occured for latitude="+latittude+" and longitude="+latittude+" and err message is =" + e.getMessage());
			}
			req.awaitIgnoreError(); // No checked exception
			return targetTimeZone;
		}
	}

	public static void main(String[] arr) {
		String a = "-44.490947";
		String b = "171.220966";

		System.out.println(getVehicleTimeZone(a, b));
	}

}
