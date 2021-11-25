package com.skynet.translator.validators;

import com.skynet.translator.exceptions.ValidateServiceException;

public class TranslatorValidator {

	public static void validate(String word) {
		word = word.trim();
		word=word.toLowerCase();
		if(word == null || word.isEmpty()) {
			throw new ValidateServiceException(" Word empty");
		}

		if(word.matches(".*[0-9].*") && word.matches(".*[a-z].*")) {
			throw new ValidateServiceException("Word with digits");
		}
		
		
	}
	
}
