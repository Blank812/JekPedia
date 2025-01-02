package iterator;

import java.util.List;
import model.Applicant;

public class ApplicantListIterator implements ApplicantIterator {
    private List<Applicant> applicants;
    private int index = 0;

    public ApplicantListIterator(List<Applicant> applicants) {
        this.applicants = applicants;
    }

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index < applicants.size();
	}

	@Override
	public Object getNext() {
		if(hasNext()) {
			return applicants.get(index++);
		}
		return null;
	}

	

	

    
}
