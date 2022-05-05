package com.onebill.casestudy.employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class UpdateStatus {
	public static void name(EntityManager em, EntityTransaction et) {
		String query = "update EmployeeLeave set leaveStatus=:status where leaveId =:id";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter LeaveId:");
		int id = s.nextInt();
		System.out.println("Enter Status:");
		s.nextLine();
		String status = s.nextLine();
		Query q1 = em.createQuery(query);
		q1.setParameter("status", status);
		q1.setParameter("id", id);
		et.begin();

		int status1 = q1.executeUpdate();
		if (status1 < 1) {
			System.out.println("Enter Valid LeaveId..");
		} else {
			System.out.println("Status updated Succesfully");
		}

		et.commit();

	}

}
