package state;

import model.Applicant;

public class SubmissionState implements ApplicantState {

	@Override
	public void handle(Applicant applicant) {
		// TODO Auto-generated method stub
		applicant.setState(new InterviewState());
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Going Through Paperwork";
	}

}
