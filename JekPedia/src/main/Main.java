package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Applicant;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Applicant> database = new ArrayList<>();
	
	public Main() {
		String option = "";
		
		do {
			System.out.println("JekPedia");
			System.out.println("========");
			System.out.println("1. Register New Applicant Form");
			System.out.println("2. View Form");
			System.out.println("3. Exit");
			System.out.print(">> ");
			option = scan.nextLine();
			
			switch (option) {
			case "1":
				String name = "";
				do {
					System.out.print("Input name [cannot be empty]: ");
					name = scan.nextLine();
				} while(name.isEmpty());
				
				int jobExperience = 0;
				do {
					System.out.print("Input job experience [> 1]: ");
					try {
						jobExperience = scan.nextInt();
					} catch (Exception e) {	
					} finally {
						scan.nextLine();
					}
				} while(jobExperience <= 1);
				
				String jobPreferences;
				do {
					System.out.print("Input job preferences [Backend Dev | Frontend Dev][case sensitive]: ");
					jobPreferences = scan.nextLine();
				} while(!jobPreferences.equals("Backend Dev") && !jobPreferences.equals("Frontend Dev"));
				
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
				String randomCode = "";
				
				for(int i = 0; i < 5; i++) {
					int index = rand.nextInt(characters.length());
					randomCode += characters.charAt(index);
				}
				
				System.out.println("Data submitted!");
				
				database.add(new Applicant(randomCode, name, jobExperience, jobPreferences));
				break;

			case "2":
				if (database.isEmpty()) {
					System.out.println("No data submitted yet");
				} else {
					for (Applicant applicant : database) {
						applicant.displayInformation();
						String choice = "";
						do {
							System.out.println("Preview next applicant form ? [N for next | U to update applicant status | Q to quit][case sensitive]: ");
							choice = scan.nextLine();
						} while (!choice.equals("N") && !choice.equals("Q"));
						
						switch (choice) {
						case "N":
							break;
							
						case "U":
							applicant.changeState();
							System.out.println("Applicant status updated");
							break;
							
						case "Q":
							return;
						}
					}
				}
				break;
			}
		} while (!option.equals("3"));
		
		System.out.println("Thank you for your cooperation!");
		
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}
