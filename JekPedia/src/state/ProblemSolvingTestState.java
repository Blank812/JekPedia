package state;

import model.Applicant;

public class ProblemSolvingTestState implements ApplicantState {

	@Override
	public void handle(Applicant applicant) {
		// TODO Auto-generated method stub
		applicant.setState(new FinishState());
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Solving Algorithm Problems";
	}

}
