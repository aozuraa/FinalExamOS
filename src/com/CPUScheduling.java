package com;

import static com.misc.*;
import java.util.Scanner;
import cpu_sched_algo.*;

public class CPUScheduling {

    public static void CpuSchedMethod() {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        int num = InputProcess();
        int[] at = InputAT(num);
        int[] bt = InputBT(num);

        System.out.println("CPU Scheduling Algorithm:");
        System.out.println("[A] Shortest Remaining Time First (SRTF) - Preemptive");
        System.out.println("[B] Round Robin (RR) - Preemptive");
        System.out.println("[C] Shortest Job First (SJF) - Non Preemptive");
        System.out.println("[D] First Come First Serve (FCFS) - Non Preemptive");
        System.out.println("[F] Exit");

        while (!check) {
            System.out.print("Enter choice: ");
            String input = scan.nextLine();

            switch (input) {
                case "A":
                case "a":
                    SRTF(at, bt);
                    if (YesOrNo()) {
                        check = true;
                        System.out.println("==============================");
                        CpuSchedMethod();
                    } else {

                        return;
                    }
                    break;
                case "B":
                case "b":
                    RR(at, bt);
                    if (YesOrNo()) {
                        check = true;
                        System.out.println("==============================");
                        CpuSchedMethod();
                    } else {

                        return;
                    }
                    break;
                case "C":
                case "c":
                    SJF(at, bt);
                    if (YesOrNo()) {
                        check = true;
                        System.out.println("==============================");
                        CpuSchedMethod();
                    } else {

                        return;
                    }
                    break;
                case "D":
                case "d":
                    FCFS(at, bt);
                    if (YesOrNo()) {
                        check = true;
                        System.out.println("==============================");
                        CpuSchedMethod();
                    } else {

                        return;
                    }
                    break;
                case "F":
                case "f":
                    check = true;
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }

    public static void SRTF(int[] at, int[] bt) {
        System.out.println("You have chosen SRTF!");
        SRTF.execute(bt, at);
    }

    public static void RR(int[] at, int[] bt) {
        System.out.println("You have chosen RR");
        int timeslice = InputInt("Input time  slice: ");
        RR.execute(at, bt, timeslice);
    }

    public static void FCFS(int[] at, int[] bt) {
        System.out.println("You have chosen FCFS!");
        FCFS.execute(bt);
    }

    public static void SJF(int[] at, int[] bt) {
        System.out.println("You have chosen SJF");
        SJF.execute(bt, at);
    }
}
