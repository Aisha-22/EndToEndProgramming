package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Print links count in the page
        Scope scope = new Scope();
//        Scope.getScopeLinksCount();

        //Handling Calendar UI Travel website
        CalendarUI calendarui = new CalendarUI();
        calendarui.handleCalendarUi();

    }
}
