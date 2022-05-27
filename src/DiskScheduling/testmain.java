package DiskScheduling;

public class testmain {
    public static void main(String[] args) {
        int currentPosition = 50;
        int trackSize = 200 - 1;
        int[] request = {82, 170, 43, 140, 24, 16, 190};
         int alpha = 0;
        Scan Scan = new Scan(currentPosition, trackSize, request);
        Scan.run();
        CScan CScan = new CScan(currentPosition, trackSize, request,alpha);
        CScan.run();
        Look look = new Look(currentPosition, request);
        look.run();
        FCFS fcfs = new FCFS(currentPosition, request);
        fcfs.run();
    }
}
