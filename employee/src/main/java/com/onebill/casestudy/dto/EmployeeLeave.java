package com.onebill.casestudy.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_leave")
public class EmployeeLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leave_id")
	private int leaveId;
	@Column(name = "leave_date")
	private String leaveDate;
	@Column(name = "leave_status")
	private String leaveStatus;
	@ManyToOne
	private EmployeeInfo employeeInfo;

	@Override
	public String toString() {
		return "EmployeeLeave [leaveId=" + leaveId + ", leaveDate=" + leaveDate + ", leaveStatus=" + leaveStatus + "]";
	}

}
