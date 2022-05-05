package com.onebill.casestudy.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.onebill.casestudy.dto.EmployeeInfo;
import com.onebill.casestudy.dto.EmployeeLeave;

public class ManagerDisplay {
	public static void name(EntityManager em) {
		String query = "from EmployeeLeave ";
		Query createQuery = em.createQuery(query);

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
