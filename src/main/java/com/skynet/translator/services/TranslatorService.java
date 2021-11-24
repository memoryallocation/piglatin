package com.skynet.translator.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TranslatorService {
	public String translate(String word) {
		word = word.toLowerCase();
		//if first character is a vowel
		if(word.substring(0, 1).matches("[aeiou]")) {
			word = word.substring(1, word.length())+word.charAt(0)+"way";
		} else if(word.substring(0, 1).matches("[^aeiou]")) {
			//if first character is a constant
			if(word.substring(1, 2).matches("[^aeiou]")) {
				//second character is a constant
				word = word.substring(2, word.length())+word.substring(0, 2)+"ay";
			} else {
				//second character is a vowel
				word = word.substring(1, word.length())+word.charAt(0)+"ay";
			}
		}
		return word;
	}

}
