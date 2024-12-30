package observer;

import model.Applicant;

public interface ApplicantObserver {
	void onStateChange(Applicant applicant);
}
