package mum.swe.mumsched.model;

import mum.swe.mumsched.enums.MonthEnum;

public class BlockSimple {
	private MonthEnum Month;
	private String CourseName;
	/**
	 * @return the month
	 */
	public MonthEnum getMonth() {
		return Month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(MonthEnum month) {
		Month = month;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return CourseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
}
