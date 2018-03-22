package edu.mum.eai.model;

import java.io.Serializable;

import edu.mum.eai.enums.ActionTypeEnum;

public class TransactionMessage implements Serializable {

	private static final long serialVersionUID = 643955232943885368L;

	private Long id;

	private String direction;

	private ActionTypeEnum type;

	private String description;

	private Long courseId;

	private Long studentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public ActionTypeEnum getType() {
		return type;
	}

	public void setType(ActionTypeEnum type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	
}
