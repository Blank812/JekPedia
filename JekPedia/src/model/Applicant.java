package model;

import java.util.ArrayList;

import observer.ApplicantObserver;
import state.ApplicantState;
import state.SubmissionState;

public class Applicant {
	private String code;
	private String name;
	private int jobExperience;
	private String jobPreferences;
	private ApplicantState state;
	private ArrayList<ApplicantObserver> observers = new ArrayList<>();
	
	public Applicant(String code, String name, int jobExperience, String jobPreferences) {
		super();
		this.code = code;
		this.name = name;
		this.jobExperience = jobExperience;
		this.jobPreferences = jobPreferences;
		this.state = new SubmissionState();
	}
	
	public void addObserver(ApplicantObserver observer) {
		observers.add(observer);
	}
	public void notifyObservers() {
		for (ApplicantObserver observer : observers) {
			observer.onStateChange(this);
		}
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getJobExperience() {
		return jobExperience;
	}
	public String getJobPreferences() {
		return jobPreferences;
	}
	public String getStateName() {
		return state.getStateName();
	}
	public void setState(ApplicantState state) {
		this.state = state;
		notifyObservers();
	}
	public ApplicantState getState() {
		return state;
	}
	public void changeState() {
		state.handle(this);
	}
	public void displayInformation() {
		System.out.println("Applicant Code : " + this.code);
		System.out.println("Applicant Name : " + this.name);
		System.out.println("Job Experience : " + this.jobExperience);
		System.out.println("Job Preference : " + this.jobPreferences);
		System.out.println("Current Phase  : " + this.state.getStateName());
	}
}
