
package az.devolopia.SpringJava20_Mubariz_Bayramov.util;

public class Constants {
	public static final String VALIDATION_MESSAGE = "Məlumatların tamlığı pozuldu!";
	public static final String VALIDATION_TYPE = "Validation";

	public static final String STRING_MIN_MESSAGE = "Minimum ";
	public static final String USER_EXISTS_MESSAGE = "Bu username artıq istifadə olunub!";

	public static final String validationMinMessage(int value) {
		return "Minimum " + value + " simvol olmalıdır!";
	}

}