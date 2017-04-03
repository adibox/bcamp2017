package curs.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import curs.exceptions.ValidationException;
import curs.utils.ValidationUtils;

public class ValidationUtilsTest {

	@Test
	public void testValidatePasswordValid() throws ValidationException {
		ValidationUtils.validatePassword("01abcd02");
	}
	
	@Test(expected=ValidationException.class)
	public void testValidatePasswordInvalid() throws ValidationException {
		ValidationUtils.validatePassword("xx");
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testValidatePasswordInvalidSize() throws ValidationException {
		exception.expect(ValidationException.class);
		exception.expectMessage("minim 8 chars");
		ValidationUtils.validatePassword("xx");
	}

	@Test
	public void testValidatePasswordInvalidFormat() throws ValidationException {
		exception.expect(ValidationException.class);
		exception.expectMessage("letters AND digits");
		ValidationUtils.validatePassword("012");
	}
	
}
