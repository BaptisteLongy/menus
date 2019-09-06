package com.familymanager.menus.web.controller;

import com.familymanager.menus.model.WeeklyMenu;
import com.familymanager.menus.web.exceptions.DailyMenuNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeeklyMenuController {
    @GetMapping("/Menus")
    public WeeklyMenu getWeeklyMenu() {
       WeeklyMenu foundWeeklyMenu;

       try {
           foundWeeklyMenu = new WeeklyMenu();
       } catch (IOException ie) {
           throw new DailyMenuNotFoundException("Weekly Menu for not found");
       }

       return foundWeeklyMenu;
    }
}
