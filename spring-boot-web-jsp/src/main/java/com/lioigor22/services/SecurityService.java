package com.lioigor22.services;

/**
 * Service for Security.
 *
 * @author Igor Likarenko
 */

public interface SecurityService {

	String findLoggedInUsername();

	void autoUsername(String username, String password);
}
