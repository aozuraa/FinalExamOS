package DiskScheduling;
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

import DiskScheduling.Scan;
import DiskScheduling.CScan;

public class DiskScheduling {

    public static void main(String[] args) {
//        int currentPosition = 50;
//        int trackSize = 200 - 1;
//        int[] request = {82,170,43,140,24,16,190};
//                CScan cScan = new CScan(currentPosition, trackSize, request);
//                cScan.run();
        System.out.println("Welcome to the Disk Scheduling Algorithm Simulator");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the current position of the disk head: ");
        int currentPosition = sc.nextInt();
        System.out.println("Enter the track size of the disk: ");
        int trackSize = sc.nextInt() - 1;
        System.out.println("Enter the number of requests: ");
        int numberOfRequests = sc.nextInt();
        int[] requests = new int[numberOfRequests];
        System.out.println("Enter the requests: ");
        for (int i = 0; i < numberOfRequests; i++) {
            requests[i] = sc.nextInt();
        }
        System.out.println("Enter the disk scheduling algorithm: ");
//        System.out.println("[A] First Come First Serve (FCFS)");
//        System.out.println("[B] Shortest Seek Time First (SSTF)");
        System.out.println("[A] Scan");
//        System.out.println("[D] Look");
        System.out.println("[B]Circular Scan (CSCAN)");
//        System.out.println("[F] Circular Look (CLOOK)");
        System.out.println("[E] Exit");
        System.out.println("Enter choice: ");
        String choice = sc.next();
        switch (choice) {
            case "A":
                Scan scan = new Scan(currentPosition, trackSize, requests);
                scan.run();
                break;
            case "B": //TODO: implement aplha not sure what it does
                CScan cScan = new CScan(currentPosition, trackSize, requests);
                cScan.run();
                break;
            case "C":
                break;
            case "D":
                break;
            case "E":
                System.out.println("Exit to DOS/Windows (terminate the program)");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void inputCheck(){

    }
}
