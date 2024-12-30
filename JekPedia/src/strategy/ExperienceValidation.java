package strategy;

public class ExperienceValidation implements ValidationStrategy {

	@Override
	public boolean validate(String input) {
		// TODO Auto-generated method stub
		try {
			int experience = Integer.parseInt(input);
			return experience > 1;
		} catch (NumberFormatException e) {
			return false;
		}	
	}

}
