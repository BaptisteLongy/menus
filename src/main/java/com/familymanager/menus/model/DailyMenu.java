package com.familymanager.menus.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;


public class DailyMenu {
    private String dayName;
    private String menuDetails;

    @Autowired
    ResourceLoader resourceLoader;

    public DailyMenu() {
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(String menuDetails) {
        this.menuDetails = menuDetails;
    }

    public DailyMenu(String dayName) throws IOException {

        resourceLoader = new DefaultResourceLoader();

        this.dayName = dayName;

        Resource menuDetailsResource = resourceLoader.getResource("classpath:menus/" + dayName);
        StringBuilder textBuilder = new StringBuilder();
        try (
                InputStream menuDetailsInputStream = menuDetailsResource.getInputStream();

                BufferedReader menuDetailsReader = new BufferedReader(new InputStreamReader(menuDetailsInputStream))
                ) {
            int c = 0;
            while ((c = menuDetailsReader.read()) != -1) {
                textBuilder.append((char) c);
            }
            this.menuDetails = textBuilder.toString();
        }
    }

    @Override
    public String toString() {
        return "DailyMenu{" +
                "dayName=" + dayName +
                ", menuDetails='" + menuDetails + '\'' +
                '}';
    }
}
