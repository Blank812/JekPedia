package state;

import model.Applicant;

public class FinishState implements ApplicantState {

	@Override
	public void handle(Applicant applicant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Applicant Successfully Saved";
	}
	
}
