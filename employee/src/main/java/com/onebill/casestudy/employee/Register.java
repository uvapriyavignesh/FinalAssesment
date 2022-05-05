package com.onebill.casestudy.employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.onebill.casestudy.dto.EmployeeInfo;

public class Register {
	private static String employeeName;
	private static String employeeEmail;
	private static boolean employeType;
	private static String password;

	public static void name(EntityManager em, EntityTransaction et) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome To registeration ");
		System.out.println("Enter your name:");
		employeeName = s.nextLine();
		System.out.println("Enter your Email:");
		employeeEmail = s.nextLine();
		System.out.println("Enter your type:");
		String sample = s.nextLine();
		employeType = (sample.equals("Manager") || sample.equals("manager")) ? true : false;

		System.out.println("Enter your Password:");
		password = s.nextLine();

		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setEmployeeName(employeeName);
		employeeInfo.setEmployeeEmail(employeeEmail);
		employeeInfo.setPassword(password);
		employeeInfo.setEmployeeType(employeType);

		et.begin();
		em.persist(employeeInfo);
		et.commit();
		System.out.println(" Register Succesfully \n Your Employee Id is " + employeeInfo.getEmployeeId());

	}

}
