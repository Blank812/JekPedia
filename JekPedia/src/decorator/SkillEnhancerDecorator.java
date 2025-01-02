package decorator;

import model.Applicant;

public class SkillEnhancerDecorator extends ApplicantDecorator {

    public SkillEnhancerDecorator(Applicant decoratedApplicant) {
        super(decoratedApplicant);
    }

    @Override
    public void performAction() {
        super.performAction();
        enhanceSkill();
    }

    private void enhanceSkill() {
        System.out.println("Enhancing applicant's skills...");
    }
}
