package factory;

import java.util.Random;

import model.Applicant;
import observer.ApplicantLogger;

public class ApplicantFactory {
	private Random rand = new Random();
	
	public Applicant createApplicant(String name, int jobExperience, String jobPreferences) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder randomCode = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			int index = rand.nextInt(characters.length());
			randomCode.append(characters.charAt(index));
		}
		
		Applicant applicant = new Applicant(randomCode.toString(), name, jobExperience, jobPreferences);
		applicant.addObserver(new ApplicantLogger());
		return applicant;
	}
}
