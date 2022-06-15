package com.app.nsoft.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMesage {

	
	private String dateTime;
	private String message;
	private int status;
	private String code;
}
