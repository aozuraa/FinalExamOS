package cpu_sched_algo;

public class SJF {

    static int[][] mat = new int[10][6];

    static void arrangeArrival(int num, int[][] mat) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (mat[j][1] > mat[j + 1][1]) {
                    for (int k = 0; k < 5; k++) {
                        int temp = mat[j][k];
                        mat[j][k] = mat[j + 1][k];
                        mat[j + 1][k] = temp;
                    }
                }
            }
        }
    }

    static void completionTime(int num, int[][] mat) {
        int temp, val = -1;
        mat[0][3] = mat[0][1] + mat[0][2];
        mat[0][5] = mat[0][3] - mat[0][1];
        mat[0][4] = mat[0][5] - mat[0][2];
        for (int i = 1; i < num; i++) {
            temp = mat[i - 1][3];
            int low = mat[i][2];
            for (int j = i; j < num; j++) {
                if (temp >= mat[j][1] && low >= mat[j][2]) {
                    low = mat[j][2];
                    val = j;
                }
            }
            mat[val][3] = temp + mat[val][2];
            mat[val][5] = mat[val][3] - mat[val][1];
            mat[val][4] = mat[val][5] - mat[val][2];
            for (int k = 0; k < 6; k++) {
                int tem = mat[val][k];
                mat[val][k] = mat[i][k];
                mat[i][k] = tem;
            }
        }
    }

    public static void execute(int[] bt, int[] at) {
        int num = bt.length;
        int total_wt = 0, total_tat = 0;
        for (int i = 0; i < num; i++) {
            mat[i][0] = i + 1;
            mat[i][1] = at[i];
            mat[i][2] = bt[i];
        }
        arrangeArrival(num, mat);
        completionTime(num, mat);
        System.out.println("Waiting time:"
                + "\t\t\tTurn around time:");
        for (int i = 0; i < num; i++) {
            total_wt = total_wt + mat[i][4];
            total_tat = total_tat + mat[i][5];
            System.out.println("P" + (i + 1) + ": " + mat[i][4]
                    + "\t\t\t\tP" + (i + 1) + ": " + mat[i][5]);
        }
        System.out.print("Average Waiting Time: "
                + (float) total_wt / (float) num);
        System.out.println("\tAverage Turnaround Time: "
                + (float) total_tat / (float) num);
    }
}
