package strategy;

public class JobPreferencesValidation implements ValidationStrategy {

	@Override
	public boolean validate(String input) {
		// TODO Auto-generated method stub
		return (input.equals("Backend Dev") || input.equals("Frontend Dev"));
	}

}
