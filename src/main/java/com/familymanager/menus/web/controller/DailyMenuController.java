package com.familymanager.menus.web.controller;

import com.familymanager.menus.model.DailyMenu;
import com.familymanager.menus.web.exceptions.DailyMenuNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DailyMenuController {

    @GetMapping("/Menus/{dayName}")
    public DailyMenu getDailyMenu(@PathVariable String dayName) {
        DailyMenu foundDailyMenu;
        try {
            foundDailyMenu = new DailyMenu(dayName);
        }
        catch (IOException ie) {
            throw new DailyMenuNotFoundException("Menu for " + dayName + " not found");
        }
        return foundDailyMenu;
    }
}
