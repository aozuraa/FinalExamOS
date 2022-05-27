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

    public static void execute(int[] bt) {
        int processes[] = new int[bt.length];
        int n = processes.length;
        findavgTime(processes, n, bt);
    }
}
