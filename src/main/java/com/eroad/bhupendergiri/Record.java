package com.eroad.bhupendergiri;
/**
 * POJO class representing the row/record of CSV File
 * @author sinbhu
 *
 */
public class Record {
	
	private String utcDate;
	private String latitude;
	private String longitude;
	private String localisedDatetime;
	private String localName;

	public Record(String utcDateStr, String lat, String longitude) {
		this.utcDate = utcDateStr;
		this.latitude= lat;
		this.longitude = longitude;
	}
	
	public String getUtcDate() {
		return utcDate;
	}

	public void setUtcDate(String utcDate) {
		this.utcDate = utcDate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLocalisedDatetime() {
		return localisedDatetime;
	}

	public void setLocalisedDatetime(String localisedDatetime) {
		this.localisedDatetime = localisedDatetime;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}
}
