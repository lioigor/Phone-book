package com.lioigor22.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomValidationUtils {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");
	private static final Pattern LOGIN_PATTERN = Pattern.compile("/^[a-z0-9_-]{3,16}$/");
	private static final Pattern FULLNAME_PATTERN = Pattern.compile("/^[A-Z][a-z]{2,}\040[A-Z][a-z]{2,}$/");

	public static boolean doMatchEmail(String word) {

		Matcher matcher = EMAIL_PATTERN.matcher(word);

		return matcher.matches();

	}

	public static boolean doMatchUsername(String word) {

		Matcher matcher = LOGIN_PATTERN.matcher(word);

		return matcher.matches();

	}

	public static boolean doMatchFullname(String word) {

		Matcher matcher = FULLNAME_PATTERN.matcher(word);

		return matcher.matches();

	}

	public static void main(String[] args) {

		String str = "hyg";

		System.out.println(doMatchUsername(str));

	}

}
