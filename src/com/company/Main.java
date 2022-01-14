package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.minusDays(2);
        LocalDate date2 = date.minusDays(8);
        LocalDate date3 = date.minusDays(20);
        LocalDate date4 = date.minusDays(7);
        LocalDate date5 = date.minusDays(13);
        LocalDate date6 = date.minusDays(25);
        LocalDate monthsAgo = date.minusMonths(1);

        LocalDate searchDate = LocalDate.of(2022, 1, 13);
        LocalDate latestDate = LocalDate.of(2022, 1, 10);
        LocalDate oldestDate = LocalDate.of(2022, 1, 1);

        List<String> bookList = new ArrayList<>();
        bookList.add("Pinocchio");
        bookList.add("Three Musketeers");

        List<String> bookList1 = new ArrayList<>();
        bookList1.add("Hearts of three");
        bookList1.add("The Da Vinci Code");
        bookList1.add("Robinson Crusoe");

        List<String> bookList2 = new ArrayList<>();
        bookList2.add("Fifteen-year-old captain");
        bookList2.add("The triumph of the sun");
        bookList2.add("The Adventures of Sherlock Holmes");

        List<String> bookList3 = new ArrayList<>();
        bookList3.add("Divine comedy");
        bookList3.add("Faust");

        List<String> bookList4 = new ArrayList<>();
        bookList4.add("The Mahabharata");
        bookList4.add("Mowgli. The Jungle Book");
        bookList4.add("Journey to the center of the earth");

        List<String> bookList5 = new ArrayList<>();
        bookList5.add("The Iliad");
        bookList5.add("Odyssey");

        List<String> bookList6 = new ArrayList<>();
        bookList6.add("Moby Dick");
        bookList6.add("Don Quixote");
        bookList6.add("Tarzan");


        Map<LocalDate, List> alexMap = new HashMap<>();
        alexMap.put(date, bookList);
        alexMap.put(date1, bookList1);
        alexMap.put(date2, bookList2);
        alexMap.put(date3, bookList3);
        alexMap.put(date4, bookList4);
        alexMap.put(date5, bookList5);
        alexMap.put(date6, bookList6);

        System.out.println("\nMy Map: " + alexMap);

        int count = 0;
        for (Map.Entry<LocalDate, List> entry : alexMap.entrySet()) {
            if (entry.getKey().equals(searchDate)) {
                count++;
                System.out.println("\nIn day " + searchDate + " was taken book: " + entry.getValue());
            }
        }
        if (count == 0) {
            System.out.println("\nThere are no books have been taken this date: " + searchDate);
        }

        for (Map.Entry<LocalDate, List> entry : alexMap.entrySet()) {
            if (oldestDate.isAfter(entry.getKey())) {
                oldestDate = entry.getKey();
            } else if (latestDate.isBefore(entry.getKey())) {
                latestDate = entry.getKey();
            }
        }
        System.out.println("\nIn the date range " + "\"" + oldestDate + " - " + latestDate + "\"" +
                " the following list of books was taken: \n" + alexMap.values());


        System.out.println("\nDuring the last month such books were taken (list by days indicating on which day" +
                " how many were taken, and if so how many and which were taken)");
        for (int i = 0; i <= 30; i++) {
            for (Map.Entry<LocalDate, List> entry : alexMap.entrySet()) {
                if (monthsAgo.plusDays(i).isEqual(entry.getKey())) {
                    System.out.println(monthsAgo.plusDays(i) + " Were taken " + entry.getValue().size() +
                            " books with titles : " + entry.getValue());
                    i++;
                }
            }
            System.out.println(monthsAgo.plusDays(i) + " were taken 0 books");
        }
    }
}