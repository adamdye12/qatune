package com.qa.tunes.business;

public interface CDService {
	String getAllCDs();

	String createCD(String cd);

	String updateCD(Long id, String cd);

	String deleteCD(Long id);

	String getCD(Long id);
}
