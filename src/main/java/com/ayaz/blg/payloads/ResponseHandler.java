package com.ayaz.blg.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHandler {
   private String message;
   private boolean succsess;
	
}
