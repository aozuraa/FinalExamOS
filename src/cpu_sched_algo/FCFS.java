package cpu_sched_algo;

public class FCFS {

    static void findWaitingTime(int processes[], int n,
            int bt[], int wt[]) {
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    static void findTurnAroundTime(int processes[], int n,
            int bt[], int wt[], int tat[]) {

        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    static void findavgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findWaitingTime(processes, n, bt, wt);
        findTurnAroundTime(processes, n, bt, wt, tat);
        System.out.println("Waiting time:"
                + "\t\t\tTurn around time:");

        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println("P" + (i + 1) + ": " + wt[i]
                    + "\t\t\t\tP" + (i + 1) + ": " + tat[i]);
        }
        System.out.print("Average Waiting Time: "
                + (float) total_wt / (float) n);
        System.out.println("\tAverage Turnaround Time: "
                + (float) total_tat / (float) n);
    }

    public static void execute(int[] at, int[] bt, int n) {
        //int processes[] = new int[bt.length];
        //int n = processes.length;
        //findavgTime(processes, n, bt);
        ArrivalSorting(at, bt, n);
    }

    public static void ArrivalSorting(int[] at, int[] bt, int n) {
        int temp;
        int pid[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        float avgwt = 0, avgta = 0;
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (at[j] > at[j + 1]) {
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ct[i] = at[i] + bt[i];
            } else {
                if (at[i] > ct[i - 1]) {
                    ct[i] = at[i] + bt[i];
                } else {
                    ct[i] = ct[i - 1] + bt[i];
                }
            }
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - bt[i];
            avgwt += wt[i];
            avgta += ta[i];

        }
        System.out.println("Waiting Time:                 Turnaround Time:");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + ": " + wt[i] + "\t\t\t\t" + "P" + pid[i] + ": " + ta[i]);
        }
        System.out.println("Average Waiting Time: " + (avgwt / n) + "\tTurnaround time: " + (avgta / n));
        //System.out.println("\naverage waiting time: " + (avgwt / n));     // printing average waiting time.
        //System.out.println("average turnaround time:" + (avgta / n));  // total turnaround time
    }

}
