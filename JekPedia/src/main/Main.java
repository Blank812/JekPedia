package main;

import java.util.ArrayList;
import java.util.Scanner;

import factory.ApplicantFactory;
import model.Applicant;
import singleton.ApplicantFactorySingleton;
import singleton.ScannerSingleton;
import strategy.ExperienceValidation;
import strategy.JobPreferencesValidation;
import strategy.NameValidation;
import strategy.ValidationStrategy;

public class Main {
	private ArrayList<Applicant> database = new ArrayList<>();
	private ApplicantFactory applicantFactory = ApplicantFactorySingleton.getInstance();
	private Scanner scan = ScannerSingleton.getInstance();
	
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
				registerApplicant();
				break;

			case "2":
				viewApplicants();
				break;
			}
			
		} while (!option.equals("3"));
		
		System.out.println("Thank you for your cooperation!");
		
		
		
}
	private void registerApplicant() {
		String name = validateInput("Input name [cannot be empty]: ", new NameValidation());
		String jobExperienceInput = validateInput("Input job experience [> 1]: ", new ExperienceValidation());
		int jobExperience = Integer.parseInt(jobExperienceInput);
		String jobPreferences = validateInput("Input job preferences [Backend Dev | Frontend Dev][case sensitive]: ", new JobPreferencesValidation());
		
		
		
		database.add(applicantFactory.createApplicant(name, jobExperience, jobPreferences));
		System.out.println("Data submitted!");
	}
	
	private void viewApplicants() {
		if (database.isEmpty()) {
			System.out.println("No data submitted yet");
		} else {
			for (Applicant applicant : database) {
				applicant.displayInformation();
				String choice = "";
				do {
					System.out.println("Preview next applicant form ? [N for next | U to update applicant status | Q to quit][case sensitive]: ");
					choice = scan.nextLine();
				} while (!choice.equals("N") && !choice.equals("U") && !choice.equals("Q"));
				
				switch (choice) {
				case "N":
					break;
					
				case "U":
					applicant.changeState();
					System.out.println("Applicant status updated");
					return;
					
				case "Q":
					return;
				}
			}
		}
	}
	
	private String validateInput(String prompt, ValidationStrategy strategy) {
		String input;
		do {
			System.out.print(prompt);
			input = scan.nextLine();
		} while (!strategy.validate(input));
		return input;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}
