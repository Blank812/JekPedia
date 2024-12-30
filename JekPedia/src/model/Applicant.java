package model;

import state.ApplicantState;
import state.SubmissionState;

public class Applicant {
	private String code;
	private String name;
	private int jobExperience;
	private String jobPreferences;
	private ApplicantState state;
	
	public Applicant(String code, String name, int jobExperience, String jobPreferences) {
		super();
		this.code = code;
		this.name = name;
		this.jobExperience = jobExperience;
		this.jobPreferences = jobPreferences;
		this.state = new SubmissionState();
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
	public ApplicantState getState() {
		return state;
	}
	public void setState(ApplicantState state) {
		this.state = state;
	}
	public String getStateName() {
		return state.getStateName();
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
		System.out.println("Current Phase  : " + this.state.getStateName());
	}
	public void changeState() {
		state.handle(this);
	}
	
	
}
