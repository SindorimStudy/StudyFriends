package com.study.friends.utils;

import java.util.List;
import org.springframework.http.HttpStatus;

public class Utils {
	
	private Utils() {}
	
	public static HttpStatus getStatusCode(final List response) {
		return response.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK;
	}
}
