package com.tutorial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Util {
    static  Scanner sc = new Scanner(System.in);
    static  ArrayList<Task> tasks = new ArrayList<>();

    public static void addtask(){
        System.out.println("\n----------------ADD TASK-------------------");
        System.out.println("---------------------------------------------");
        System.out.print("Add Task : ");
        String input = sc.nextLine();
        System.out.println(input);

        int i = generateId();

        tasks.add(new Task(i,input));

        saveTasks();

        System.out.println("added successfully (ID: "+i+")");

    }
    public static int generateId() {
        int maxId = 0;

        for (Task task : tasks) {
            if (task.getId() > maxId) {
                maxId = task.getId();
            }
        }

        return maxId + 1;
    }

    public static void saveTasks() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            FileWriter writer = new FileWriter("tasks.json");

            gson.toJson(tasks, writer);

            writer.close();

        } catch (IOException e) {
            System.out.println("Gagal menyimpan task.");
        }
    }

    public static void loadTasks() {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader("tasks.json");

            Task[] taskArray = gson.fromJson(reader, Task[].class);

            tasks = new ArrayList<>(Arrays.asList(taskArray));

            reader.close();

        } catch (IOException e) {
            System.out.println("File tasks.json belum ada.");
        }
    }


    public static void updateTask() {
        System.out.println("\n----- UPDATE TASK -----");

        System.out.print("Masukkan ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task task : tasks) {

            if (task.getId() == id) {

                // Tampilkan deskripsi lama
                System.out.println("Deskripsi lama : " + task.getDescription());
                System.out.print("Deskripsi baru (Enter = tidak berubah) : ");
                String description = sc.nextLine();

                // Kalau tidak kosong, ubah deskripsi
                if (!description.isEmpty()) {
                    task.setDescription(description);
                }

                // Update status
                System.out.print("Status (TODO/DONE) : ");
                String statusInput = sc.nextLine();

                if (!statusInput.isEmpty()) {
                    task.setStatus(
                            Status.valueOf(statusInput.toUpperCase())
                    );
                }

                saveTasks();

                System.out.println("Task berhasil diupdate.");
                return;
            }
        }

        System.out.println("Task dengan ID " + id + " tidak ditemukan.");
    }


    public static void deletetask(){
        System.out.println("\n-----DELETE TASK-----");
        System.out.print("Masukkan ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println(task.toString());
                System.out.print("Yakin Delede Task ini (Y/N) : ");
                String Yakin = sc.nextLine();

                if(Yakin.equalsIgnoreCase("Y")){
                    tasks.remove(task);
                    saveTasks();
                    System.out.println("Task berhasil diDelete.");
                    return;
                }else if(Yakin.equalsIgnoreCase("N")){
                    System.out.println("Task Batal di delete.");
                    return;
                }


            }
        }
        System.out.println("Task dengan ID " + id + " tidak ditemukan.");

    }
    public static void listtasks(){
        System.out.println("\n-----LIST TASK-----");

        for(Task t:tasks){
            System.out.println(t.toString());
        }

    }
    public static void listTasksSelesai(){
        System.out.println("\n-----LIST TASK SELESAI-----");

        for(Task t:tasks){
            if(t.getStatus() == Status.DONE){
                System.out.println(t.toString());
            }

        }

    }
    public static void listTasksProgres(){
        System.out.println("\n-----LIST TASK PROGRES-----");
        for(Task t:tasks){
            if(t.getStatus() == Status.TODO){
                System.out.println(t.toString());
            }
        }

    }

    public static void clearTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
