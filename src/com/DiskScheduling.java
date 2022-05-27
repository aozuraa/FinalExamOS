package com;
//#region steps

// Input current position: 73

// Input track size: 200
// Input number of request: 5 <max of 10 request>
// Loc 1:
// Loc 2:
// Loc 3:
// Loc 4:
// Loc 5:
// Disk Scheduling Algorithm:	
// [A] First Come First Serve (FCFS)
// [B] Shortest Seek Time First (SSTF)
// [C] Scan
// [D] Look
// [E]Circular Scan (CSCAN)
// [F] Circular Look (CLOOK)
// [G] Exit
// Enter choice:
// If choice = A
// Total head movement:
// Seek time: 
// Input again [y/n]?
// If ‘y’= repeat process
// If ‘n’ = terminate program
// If choice = B
// <same output as A>
// If choice = C
// <same output as A>
// If choice = D
// <same output as A>
// If choice = E
// Input alpha:
// <same output as A>
// If choice = F
// Input alpha:
// <same output as A>
// If choice = G
// Exit to DOS/Windows (terminate the program)
// Note: Every after execution of choice from the menu, default is:
// Input again (y/n)?
// If  ‘y’ =repeat input
// If  ‘n’ = exit/terminate program

import java.util.Scanner;

import DiskScheduling.CScan;
import DiskScheduling.FCFS;
import DiskScheduling.Look;
import DiskScheduling.Scan;


public class DiskScheduling {
    private static Scanner sc = new Scanner(System.in);
    private static int currentPosition;
    private static int trackSize;
    private static int[] requests;
    private static int numberOfRequests;

    public static void run(){
        boolean endProgram = false;
        while (!endProgram) {
            System.out.println("Welcome to the Disk Scheduling Algorithm Simulator");
            System.out.println("Enter the current position of the disk head: ");
            currentPosition = inputCheck();
            System.out.println("Enter the track size of the disk: ");
            trackSize = inputCheck() - 1;
            System.out.println("Enter the number of requests [max of 10]: ");
            boolean check = false;
            do {
                numberOfRequests = inputCheck();
                check = numberOfRequests > 10 || numberOfRequests < 2;
                if (check)
                    System.out.println("Invalid size, please enter again");
            } while (check);
            requests = new int[numberOfRequests];
            System.out.println("Enter the requests: ");
            for (int i = 0; i < numberOfRequests; i++) {
                boolean check1;
                do {
                    System.out.print("Loc " + (i + 1) + ":");
                    requests[i] = inputCheck();
                    check1 = requests[i] > trackSize || requests[i] < 0;
                    if (check1)
                        System.out.println("Invalid request, please enter again");
                } while (check1);
            }
            System.out.println("Enter the disk scheduling algorithm: ");
            System.out.println("[A] First Come First Serve (FCFS)");
            System.out.println("[B] Look");
            System.out.println("[C] Scan");
            System.out.println("[D]Circular Scan (CSCAN)");
            System.out.println("[E] Exit");
            String isEnd = chooseAlgorithm();
            if (isEnd == "E") break;
            System.out.println("Input again? ");
            System.out.println("press ‘y’= repeat, press any other key to exit");
            String temp = sc.next();
            temp = temp.toUpperCase();
            if (temp.equals("Y"))
                endProgram = true;
        }
        sc.close();
    }

    public static int inputCheck() {
        boolean isValid = false;
        int input = -1;
        do {
            try {
                input = sc.nextInt();
                if (input < 0)
                    throw new Exception();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        } while (!isValid);
        return input;
    }

    public static String chooseAlgorithm() {
        System.out.println("Enter choice: ");
        String choice = sc.next();
        choice = choice.toUpperCase();
        switch (choice) {
            case "A":
                FCFS fcfs = new FCFS(currentPosition, requests);
                fcfs.run();
                break;
            case "B":
                Look look = new Look(currentPosition, requests);
                look.run();
                break;
            case "C":
                Scan scan = new Scan(currentPosition, trackSize, requests);
                scan.run();
                break;
            case "D": 
                System.out.println("Input alpha: ");
                int alpha = sc.nextInt();
                CScan cScan = new CScan(currentPosition, trackSize, requests, alpha);
                cScan.run();
                break;
            case "E":
                System.out.println("Exit to DOS/Windows (terminate the program)");
                break;
            default:
                System.out.println("Invalid choice");
                chooseAlgorithm();
        }
        return choice;
    }

}
