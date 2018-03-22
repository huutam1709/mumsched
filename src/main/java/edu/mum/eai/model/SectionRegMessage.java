package edu.mum.eai.model;

import java.io.Serializable;

import edu.mum.eai.enums.ActionTypeEnum;

public class SectionRegMessage implements Serializable {

	private static final long serialVersionUID = 5010227670206248151L;
	private Long studentId;
	private Long courseId;
	private String courseName;
	private ActionTypeEnum actionType;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public ActionTypeEnum getActionType() {
		return actionType;
	}

	public void setActionType(ActionTypeEnum actionType) {
		this.actionType = actionType;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
