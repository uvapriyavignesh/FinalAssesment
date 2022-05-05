package com.onebill.casestudy.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.onebill.casestudy.dto.EmployeeInfo;
import com.onebill.casestudy.dto.EmployeeLeave;

public class DispalyLeave {
	public static void name(EntityManager em, EmployeeInfo e1) {
		String query = "from EmployeeLeave where employeeInfo=(from EmployeeInfo where employeeId=:eid)";
		Query createQuery = em.createQuery(query);
		createQuery.setParameter("eid", e1.getEmployeeId());
		List resultList = createQuery.getResultList();
		System.out.println("--------------------------------------------------------------");
		for (Object object : resultList) {
			EmployeeLeave el = (EmployeeLeave) object;
			System.out.println(" EmployeeId= " + el.getEmployeeInfo().getEmployeeId() + " LeaveId= " + el.getLeaveId()
					+ " Date= " + el.getLeaveDate() + " Status= " + el.getLeaveStatus());
		}
		System.out.println("--------------------------------------------------------------");

	}

}
