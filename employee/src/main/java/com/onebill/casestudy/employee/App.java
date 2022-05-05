package com.onebill.casestudy.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.onebill.casestudy.dto.EmployeeInfo;
import com.onebill.casestudy.dto.EmployeeLeave;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Scanner s = new Scanner(System.in);

//   EmployeeInfo e1 = (LoginChecker.login("uva", "1234" , entityManager));
//   EmployeeLeave el=new EmployeeLeave();
//   //AddLeave.addLeave(entityManager, entityTransaction, e1, el);
//        
//        //DispalyLeave.name(entityManager, entityTransaction, e1);
////        ManagerDisplay.name(entityManager);
//   UpdateStatus.name(entityManager, entityTransaction);
		EmployeeInfo e1 = null;
		System.out.println(" Welcome to Employee Port\n 1.press Register\n 2. press Login");
		int key = s.nextInt();
		switch (key) {
		case 1:
			Register.name(entityManager, entityTransaction);

			break;
		case 2:
			System.out.println("Welcome to Login..");
			s.nextLine();
			System.out.println("Enter Employeeid:");
			int Employeeid = s.nextInt();
			System.out.println("Enter Employee Password:");
			s.nextLine();
			String password = s.nextLine();
			e1 = LoginChecker.login(Employeeid, password, entityManager);
			if (e1 != null) {
				System.out.println(" Welcome Back Cheef..." + e1.getEmployeeName());
				if (e1.isEmployeeType()) {
					boolean main1 = true;
					while (main1) {
						System.out.println(" 1.press Show All leave Request\n 2.press update Status\n 3.Exit");
						int key1 = s.nextInt();
						switch (key1) {

						case 1:
							ManagerDisplay.name(entityManager);
							break;
						case 2:
							UpdateStatus.name(entityManager, entityTransaction);
							break;
						case 3:
							System.out.println("exit Succesfully");
							main1 = false;
							break;

						default:
							break;
						}

					}

				} else {
					System.out.println("Welcome " + e1.getEmployeeName());
					boolean main1 = true;
					while (main1) {
						System.out.println(" 1.press to Apply Leave\n 2.press Show Leave Status\n 3.Exit");
						int key2 = s.nextInt();
						switch (key2) {
						case 1:

							AddLeave.addLeave(entityManager, entityTransaction, e1);
							break;
						case 2:
							DispalyLeave.name(entityManager, e1);
							break;
						case 3:
							System.out.println("exit Succesfully");
							main1 = false;

							break;

						default:
							break;
						}

					}

				}
			} else {
				System.out.println("Login Failed :(");
			}
			break;

		default:
			break;
		}
	}
}
