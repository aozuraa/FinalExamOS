package com;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean check = true;
        System.out.println("--Group 3: OS Final--");
        System.out.println("CPU/Disk Scheduling");
        System.out.println("=======================");
        System.out.println("[A] CPU Scheduling");
        System.out.println("[B] Disk Scheduling");
        System.out.println("[C] Exit");
        String input;
        while (check) {
            System.out.print("Enter choice: ");
            input = scan.nextLine();
            input = input.toUpperCase();
            switch (input) {
                case "A":
                    CPUScheduling.CpuSchedMethod();
                    check = false;
                    break;
                case "B":
                    DiskScheduling.run();
                    check = false;
                    break;
                case "C":
                    check = false;
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }

}
