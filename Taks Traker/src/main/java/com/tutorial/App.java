package com.tutorial;

import com.google.gson.Gson;

import java.util.Scanner;

import static com.tutorial.Util.*;

public class App {
    public static void main(String[] args) {
        clearTerminal();
        Util.loadTasks();
        boolean isSelesai=false;
        while(!isSelesai) {
            System.out.println("\n");
            System.out.println("----------------TAKS TRAKER------------------");
            System.out.println("---------------------------------------------");
            System.out.println("1.\tAdd Task");
            System.out.println("2.\tUpdate Task");
            System.out.println("3.\tDelete Task");
            System.out.println("4.\tList Tasks");
            System.out.println("5.\tList Tasks Selesai");
            System.out.println("6.\tList Tasks Progres");
            System.out.println("7.\tExit");

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter your choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addtask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deletetask();
                    break;
                case 4:
                    listtasks();
                    break;
                case 5:
                    listTasksSelesai();
                    break;
                case 6:
                    listTasksProgres();
                    break;
                case 7:
                    System.out.println("---------BYE-BYE-----------");
                    isSelesai=true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            if (!isSelesai) {
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();

                clearTerminal();
        }

        }
    }
}
