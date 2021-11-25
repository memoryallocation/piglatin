package com.skynet.translator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.skynet.translator.services.TranslatorService;
import com.skynet.translator.utils.WrapperResponse;
import com.skynet.translator.validators.TranslatorValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TranslatorController {
	@Autowired
	private TranslatorService translatorService;
	
	@GetMapping(value="/translator/{word}")
	public ResponseEntity<WrapperResponse<String>> translate(@PathVariable("word") String word) {
		TranslatorValidator.validate(word);
		String newWord = translatorService.translate(word);			
		return new WrapperResponse<String>(true, "success", newWord).createResponse(HttpStatus.OK);

	}

}
