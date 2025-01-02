package iterator;

import model.Applicant;

public interface ApplicantIterator<Applicant> {
	boolean hasNext();
	Applicant getNext();
	

}
