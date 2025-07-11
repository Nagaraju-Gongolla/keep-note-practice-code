package com.stackroute.keepnote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
 * The class "Reminder" will be acting as the data model for the Reminder Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

@Entity
public class Reminder {
	/*
	 * This class should have seven fields
	 * (reminderId,reminderName,reminderDescription,reminderType,
	 * reminderCreatedBy,reminderCreationDate,notes). Out of these seven fields, the
	 * field reminderId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. The value of
	 * reminderCreationDate should not be accepted from the user but should be
	 * always initialized with the system date. annotate notes field with @OneToMany
	 * and @JsonIgnore
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reminderId;
	private String reminderName;
	private String reminderDescription;
	private String reminderType;
	private String reminderCreatedBy;
	private Date reminderCreationDate;

	@OneToMany(mappedBy = "reminder")
	@JsonIgnore
	private List<Note> notes;

	public Reminder() {

	}

	public Reminder(int Int, String string, String string1, String string2, String string3, List<Note> list,
			Date date) {
	}

	public Integer getReminderId() {
		return reminderId;
	}

	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}

	public String getReminderName() {
		return reminderName;
	}

	public void setReminderName(String reminderName) {
		this.reminderName = reminderName;
	}

	public String getReminderDescription() {
		return reminderDescription;
	}

	public void setReminderDescription(String reminderDescription) {
		this.reminderDescription = reminderDescription;
	}

	public String getReminderType() {
		return reminderType;
	}

	public void setReminderType(String reminderType) {
		this.reminderType = reminderType;
	}

	public String getReminderCreatedBy() {
		return reminderCreatedBy;
	}

	public void setReminderCreatedBy(String reminderCreatedBy) {
		this.reminderCreatedBy = reminderCreatedBy;
	}


	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Date getReminderCreationDate() {
		return reminderCreationDate;
	}

	public void setReminderCreationDate(Date reminderCreationDate) {
		this.reminderCreationDate = reminderCreationDate;
	}

	@Override
	public String toString() {
		return "Reminder{" +
				"reminderId=" + reminderId +
				", reminderName='" + reminderName + '\'' +
				", reminderDescription='" + reminderDescription + '\'' +
				", reminderType='" + reminderType + '\'' +
				", reminderCreatedBy='" + reminderCreatedBy + '\'' +
				", reminderCreationDate=" + reminderCreationDate +
				", notes=" + notes +
				'}';
	}
}
