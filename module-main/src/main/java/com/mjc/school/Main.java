package com.mjc.school;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int operationNumber = 1;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("""
                    Enter the number of operation:
                    1 - Get all news.
                    2 - Get news by id.
                    3 - Create news.
                    4 - Update news.
                    5 - Remove news by id.
                    0 - Exit.""");
            if(scanner.hasNextInt()){
                operationNumber = scanner.nextInt();
            }
            else{
                scanner.nextLine();
                System.out.println("Command not found.");
                continue;
            }
            switch (operationNumber) {
                case 1 -> {
                    System.out.println("All news");
                }
                case 2 -> {
                    System.out.println("getting news by id");
                }
                case 3 -> {
                    System.out.println("creating news");
                }
                case 4 -> {
                    System.out.println("updating news");
                }
                case 5 -> {
                    System.out.println("removing news");
                }
                case 0 -> {
                    System.out.println("exiting");
                }
                default -> {
                    System.out.println("Unknown command");
                }
            }
        }while(operationNumber != 0);

    }
}