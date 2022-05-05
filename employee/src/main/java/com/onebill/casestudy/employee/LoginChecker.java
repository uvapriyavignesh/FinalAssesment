package com.onebill.casestudy.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.soap.Detail;

import com.onebill.casestudy.dto.EmployeeInfo;

public class LoginChecker {

	public static EmployeeInfo login(int employeeid, String password, EntityManager em) {
		String employee = "from EmployeeInfo";

		Query query = em.createQuery(employee);
		List details = query.getResultList();

		for (Object object : details) {
			EmployeeInfo e1 = (EmployeeInfo) object;
			if (employeeid == (e1.getEmployeeId()) && password.equals(e1.getPassword())) {
				System.out.println("Login successfull ....:)");
				return e1;

			}

		}

		return null;
	}

}
