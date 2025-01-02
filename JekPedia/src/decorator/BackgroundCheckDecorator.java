package decorator;

import model.Applicant;

public class BackgroundCheckDecorator extends ApplicantDecorator {

    public BackgroundCheckDecorator(Applicant decoratedApplicant) {
        super(decoratedApplicant);
    }

    @Override
    public void performAction() {
        super.performAction();
        performBackgroundCheck();
    }

    private void performBackgroundCheck() {
        System.out.println("Performing background check...");
    }
}

