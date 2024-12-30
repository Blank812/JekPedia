package state;

import model.Applicant;

public interface ApplicantState {
	void handle(Applicant applicant);
	String getStateName();
}
