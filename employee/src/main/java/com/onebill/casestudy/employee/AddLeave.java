package com.onebill.casestudy.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collection;

import com.onebill.casestudy.dto.EmployeeInfo;
import com.onebill.casestudy.dto.EmployeeLeave;

public class AddLeave {
	public static void addLeave(EntityManager em, EntityTransaction et, EmployeeInfo e1) {
		String date;
		// String queryupdate = "update EmployeeInfo set employeLeave=:listleave where
		// employeeId =1";
		Scanner s = new Scanner(System.in);
		List<EmployeeLeave> employeLeave = new ArrayList<EmployeeLeave>() {
		};
		String employee = "from EmployeeLeave";

		Query query = em.createQuery(employee);
		List details = query.getResultList();
		for (Object object : details) {
			EmployeeLeave el = (EmployeeLeave) object;
			employeLeave.add(el);
		}

		System.out.println(" Enter leave date:");
		date = s.nextLine();

		EmployeeLeave newEl = new EmployeeLeave();
		newEl.setLeaveDate(date);
		newEl.setLeaveStatus("Pending");
		newEl.setEmployeeInfo(e1);

		employeLeave.add(newEl);

		e1.setEmployeLeave(employeLeave);

		et.begin();
		em.persist(newEl);
//        Query q1 = em.createQuery(queryupdate);
//		//q1.setParameter("employeeId", e1.getEmployeeId());
//		q1.setParameter("listleave", employeLeave);
//		int status = q1.executeUpdate();
//		System.out.println(status + " Row Affected");

		et.commit();

	}

}
