package com.familymanager.menus.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DailyMenuNotFoundException extends RuntimeException {
        public DailyMenuNotFoundException(String s) {
            super(s);
        }
}
