package state;

import model.Applicant;

public class InterviewState implements ApplicantState {

	@Override
	public void handle(Applicant applicant) {
		// TODO Auto-generated method stub
		if ("Backend Dev".equals(applicant.getJobPreferences())) {
			applicant.setState(new ProblemSolvingTestState());
		} else if ("Frontend Dev".equals(applicant.getJobPreferences())) {
			applicant.setState(new UIUXTestState());
		}
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Ongoing Interviews";
	}

}
