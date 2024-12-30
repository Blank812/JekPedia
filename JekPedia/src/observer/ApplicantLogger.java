package observer;

import model.Applicant;

public class ApplicantLogger implements ApplicantObserver {

	@Override
	public void onStateChange(Applicant applicant) {
		// TODO Auto-generated method stub
		System.out.println("Log: Applicant " + applicant.getName() + " is now in state: " + applicant.getStateName());
	}

}
