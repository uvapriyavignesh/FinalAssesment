package com.onebill.casestudy.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee_info")
public class EmployeeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employe_id")
	private int employeeId;
	@Column(name = "employe_name")
	private String employeeName;
	@Column(name = "employe_type")
	private boolean employeeType;
	@Column(name = "employe_email")
	private String employeeEmail;
	@Column(name = "employe_password")
	private String password;
	@OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL)
	private List<EmployeeLeave> employeLeave;

	@Override
	public String toString() {
		return "EmployeeInfo [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeType="
				+ employeeType + ", employeeEmail=" + employeeEmail + ", password=" + password + "]";
	}

}
