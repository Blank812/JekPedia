package decorator;

import model.Applicant;

public abstract class ApplicantDecorator extends Applicant {
	 protected Applicant decoratedApplicant;

	  public ApplicantDecorator(Applicant decoratedApplicant) {
		  super(decoratedApplicant.getCode(), decoratedApplicant.getName(), 
	              decoratedApplicant.getJobExperience(), decoratedApplicant.getJobPreferences());
	        this.decoratedApplicant = decoratedApplicant;
	  }

	    @Override
	    public void performAction() {
	        decoratedApplicant.performAction();
	    }

}
