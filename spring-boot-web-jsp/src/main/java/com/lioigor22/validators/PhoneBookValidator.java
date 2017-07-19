package com.lioigor22.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;

/**
 * Validator for {@link com.lioigor22.model.PhoneBook} class, implements
 * {@link Validator} interface.
 *
 * @author Igor Likarenko
 * 
 */

@Component
public class PhoneBookValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String UKRAINE_FORMAT_PHONE_PATTERN = "^[\\+]\\d{3}[\\(]\\d{2}[\\)]\\d{7}$";

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PhoneBook phonebook = (PhoneBook) obj;

		// name validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
		if (phonebook.getName().length() < 4 || phonebook.getName().length() > 255) {
			errors.rejectValue("name", "Size.phonebookForm.name");
		}

		// surName validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surName", "Required");
		if (phonebook.getSurName().length() < 4 || phonebook.getSurName().length() > 255) {
			errors.rejectValue("surName", "Size.phonebookForm.surName");
		}

		// patronymic validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patronymic", "Required");
		if (phonebook.getPatronymic().length() < 4 || phonebook.getPatronymic().length() > 255) {
			errors.rejectValue("patronymic", "Size.phonebookForm.patronymic");
		}

		// mobilePhone validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobilePhone", "Required");
		if (!(phonebook.getMobilePhone() != null && phonebook.getMobilePhone().isEmpty())) {
			pattern = Pattern.compile(UKRAINE_FORMAT_PHONE_PATTERN);
			matcher = pattern.matcher(phonebook.getMobilePhone());
			if (!matcher.matches()) {
				errors.rejectValue("mobilePhone", "Format.phonebookForm.mobilePhone");
			}
		}
		// homePhone validation
		if (!(phonebook.getHomePhone() != null && phonebook.getHomePhone().isEmpty())) {
			pattern = Pattern.compile(UKRAINE_FORMAT_PHONE_PATTERN);
			matcher = pattern.matcher(phonebook.getHomePhone());
			if (!matcher.matches()) {
				errors.rejectValue("homePhone", "Format.phonebookForm.homePhone");
			}
		}

		// email validation
		if (!(phonebook.getEmail() != null && phonebook.getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(phonebook.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "Format.phonebookForm.email");
			}
		}
	}
}
