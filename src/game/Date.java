/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author 342619939
 */
public class Date {
    private int day;
    private int month;
    private int year;
    /**
     * This is a constructor for user's date of birth if there are variables
     * @param day
     * @param month
     * @param year 
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    /**
     * This is a constructor preset for user's date of birth
     */
    public Date() {
        this.day = 00;
        this.month = 00;
        this.year = 0000;
    }
    /**
     * This method sets the day of user's birth
     * @param day 
     */
    public void setDay(int day) {
        this.day = day;
    }
    /**
     * This method sets the month of user's birth
     * @param month 
     */
    public void setMonth(int month) {
        this.month = month;
    }
    /**
     * This method sets the year of user's birth
     * @param year 
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * This method gets the day of user's birth
     * @return Returns user's day of birth
     */
    public int getDay() {
        return day;
    }
    /**
     * This method gets the month of user's birth
     * @return Returns user's month of birth
     */
    public int getMonth() {
        return month;
    }
    /**
     * This method gets the year of user's birth
     * @return Returns user's year of birth
     */
    public int getYear() {
        return year;
    }
    /**
     * This method returns user's date of birth in a string format
     * @return Returns formatting of user's date of birth
     */
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
