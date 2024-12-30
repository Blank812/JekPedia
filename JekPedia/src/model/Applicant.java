package model;

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
