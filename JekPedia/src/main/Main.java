package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public class Applicant {
		private String code;
		private String name;
		private int jobExperience;
		private String jobPreferences;
		private String state;
		
		public Applicant(String code, String name, int jobExperience, String jobPreferences) {
			super();
			this.code = code;
			this.name = name;
			this.jobExperience = jobExperience;
			this.jobPreferences = jobPreferences;
			this.state = "Going Through Paperwork";
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getJobExperience() {
			return jobExperience;
		}
		public void setJobExperience(int jobExperience) {
			this.jobExperience = jobExperience;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getJobPreferences() {
			return jobPreferences;
		}
		public void setJobPreferences(String jobPreferences) {
			this.jobPreferences = jobPreferences;
		}
		
		public void displayInformation() {
			System.out.println("Applicant Code : " + this.code);
			System.out.println("Applicant Name : " + this.name);
			System.out.println("Job Experience : " + this.jobExperience);
			System.out.println("Job Preference : " + this.jobPreferences);
			System.out.println("Current Phase  : " + this.state);
		}
		public void changeState() {
			switch (this.state) {
			case "Going Through Paperwork":
				this.setState("Ongoing Interviews");
				break;
			case "Ongoing Interviews":
				switch (this.jobPreferences) {
				case "Backend Dev":
					this.setState("Solving Algorithm Problems");
					break;

				case "Frontend Dev":
					this.setState("Designing Application UI UX");
					break;
				}
				break;
			case "Solving Algorithm Problems":
				this.setState("Applicant Successfully Saved");
				break;
			case "Designing Application UI UX":
				this.setState("Applicant Successfully Saved");
				break;
			}
		}
		
		
	}
	
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
