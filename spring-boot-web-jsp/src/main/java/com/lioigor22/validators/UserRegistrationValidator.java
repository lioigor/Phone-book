package com.lioigor22.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lioigor22.model.User;
import com.lioigor22.services.UserService;

/**
 * Validator for {@link com.lioigor22.model.User} class, implements
 * {@link Validator} interface.
 *
 * @author Igor Likarenko
 * 
 */

@Component
public class UserRegistrationValidator implements Validator {

	@Autowired
	@Qualifier("userServiceJson")
	private UserService userService;

	private Pattern pattern;
	private Matcher matcher;

	private static final String FULLNAME_PATTERN = "^[A-Z][a-z]{2,}\040[A-Z][a-z]{2,}\040[A-Z][a-z]{2,}$";
	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,16}$";
	private static final String PASSWORD_PATTERN = "^[a-z0-9_-]{5,18}$";

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;

		// username validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
		if (user.getUsername().length() < 3 || user.getUsername().length() > 255) {
			errors.rejectValue("username", "Size.userForm.username");
		}

		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		if (!(user.getUsername() != null && user.getUsername().isEmpty())) {
			pattern = Pattern.compile(USERNAME_PATTERN);
			matcher = pattern.matcher(user.getUsername());
			if (!matcher.matches()) {
				errors.rejectValue("username", "Format.userForm.username");
			}
		}

		// password validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
		if (user.getPassword().length() < 5 || user.getPassword().length() > 255) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getConfirmPassword().equals(user.getPassword())) {
			errors.rejectValue("confirmPassword", "Different.userForm.password");
		}
		if (!(user.getPassword() != null && user.getPassword().isEmpty())) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(user.getPassword());
			if (!matcher.matches()) {
				errors.rejectValue("password", "Format.userForm.password");
			}
		}

		// fullname validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "Required");
		if (user.getFullName().length() < 5 || user.getFullName().length() > 255) {
			errors.rejectValue("fullName", "Size.userForm.fullname");
		}
		if (!(user.getFullName() != null && user.getFullName().isEmpty())) {
			pattern = Pattern.compile(FULLNAME_PATTERN);
			matcher = pattern.matcher(user.getFullName());
			if (!matcher.matches()) {
				errors.rejectValue("fullName", "Format.userForm.fullname");
			}
		}
	}
}