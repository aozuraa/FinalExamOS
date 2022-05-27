package cpu_sched_algo;

public class RR {

    static void findWaitingTime(int processes[], int n,
            int bt[], int wt[], int quantum) {
        int rem_bt[] = new int[n];
        System.arraycopy(bt, 0, rem_bt, 0, n);

        int t = 0;
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    if (rem_bt[i] > quantum) {

                        t += quantum;
                        rem_bt[i] -= quantum;
                    } else {
                        t = t + rem_bt[i];
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done == true) {
                break;
            }
        }
    }

    static void findTurnAroundTime(int processes[], int n,
            int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    static void findavgTime(int processes[], int n, int bt[], int quantum) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findWaitingTime(processes, n, bt, wt, quantum);
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

    public static void execute(int[] bt, int ts) {
        int processes[] = new int[bt.length];
        for (int i = 0; i < bt.length; i++) {
            processes[i] = i + 1;
        }
        int n = processes.length;
        findavgTime(processes, n, bt, ts);
    }
}
