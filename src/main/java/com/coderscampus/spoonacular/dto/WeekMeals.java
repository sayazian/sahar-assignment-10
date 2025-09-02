package com.coderscampus.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekMeals {

    @JsonProperty("monday")
    private DayMeals monday;

    @JsonProperty("tuesday")
    private DayMeals tuesday;

    @JsonProperty("wednesday")
    private DayMeals wednesday;

    @JsonProperty("thursday")
    private DayMeals thursday;

    @JsonProperty("friday")
    private DayMeals friday;

    @JsonProperty("saturday")
    private DayMeals saturday;

    @JsonProperty("sunday")
    private DayMeals sunday;

    public DayMeals getMonday() {
        return monday;
    }

    public void setMonday(DayMeals monday) {
        this.monday = monday;
    }

    public DayMeals getTuesday() {
        return tuesday;
    }

    public void setTuesday(DayMeals tuesday) {
        this.tuesday = tuesday;
    }

    public DayMeals getWednesday() {
        return wednesday;
    }

    public void setWednesday(DayMeals wednesday) {
        this.wednesday = wednesday;
    }

    public DayMeals getThursday() {
        return thursday;
    }

    public void setThursday(DayMeals thursday) {
        this.thursday = thursday;
    }

    public DayMeals getFriday() {
        return friday;
    }

    public void setFriday(DayMeals friday) {
        this.friday = friday;
    }

    public DayMeals getSaturday() {
        return saturday;
    }

    public void setSaturday(DayMeals saturday) {
        this.saturday = saturday;
    }

    public DayMeals getSunday() {
        return sunday;
    }

    public void setSunday(DayMeals sunday) {
        this.sunday = sunday;
    }

}
