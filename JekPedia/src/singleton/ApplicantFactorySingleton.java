package singleton;

import factory.ApplicantFactory;

public class ApplicantFactorySingleton {
	private static ApplicantFactory instance;
	
	private ApplicantFactorySingleton() {
		
	}
	
	public static ApplicantFactory getInstance() {
		if(instance == null) {
			instance = new ApplicantFactory();
		}
		return instance;
	}
}
