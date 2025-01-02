package factory;

import java.util.ArrayList;
import java.util.List;

import iterator.ApplicantIterator;
import model.Applicant;
import iterator.ApplicantListIterator;

public class ApplicantCollection {
    private List<Applicant> applicants = new ArrayList<>();

    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public void removeApplicant(Applicant applicant) {
        applicants.remove(applicant);
    }

    public ApplicantIterator iterator() {
        return new ApplicantListIterator(applicants);
    }

    
}
