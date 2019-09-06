package com.familymanager.menus.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class WeeklyMenu {

    private List<DailyMenu> dailyMenuList;

    public WeeklyMenu() throws IOException {
        List<String> DayList;
        DayList = getResourceFiles("classpath:menus/*");

        for (String day: DayList) {
            this.dailyMenuList.add(new DailyMenu(day));
        }
    }

    public List<DailyMenu> getDailyMenuList() {
        return dailyMenuList;
    }

    public void setDailyMenuList(List<DailyMenu> dailyMenuList) {
        this.dailyMenuList = dailyMenuList;
    }

    @Override
    public String toString() {
        return "WeeklyMenu{" +
                "dailyMenuList='" + dailyMenuList.toString() + '\'' +
                '}';
    }

    private List<String> getResourceFiles(String path) throws IOException {
        List<String> filenames = new ArrayList<>();

        try (
                InputStream in = getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String resource;

            while ((resource = br.readLine()) != null) {
                filenames.add(resource);
            }
        }

        return filenames;
    }

    private InputStream getResourceAsStream(String resource) {
        final InputStream in
                = getContextClassLoader().getResourceAsStream(resource);

        return in == null ? getClass().getResourceAsStream(resource) : in;
    }

    private ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
}
