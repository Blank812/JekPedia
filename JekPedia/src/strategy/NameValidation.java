package strategy;

public class NameValidation implements ValidationStrategy{

	@Override
	public boolean validate(String input) {
		// TODO Auto-generated method stub
		return input != null && !input.trim().isEmpty();
	}
	
}
