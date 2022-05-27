package DiskScheduling;

import java.util.ArrayList;

public class FCFS {

    private final ArrayList<Integer> requests = new ArrayList<>();
    private final int requestRealSize;

    public FCFS(int currentPosition, int[] requests) {
        this.requests.add(currentPosition);
        for (int request : requests) {
            this.requests.add(request);
        }
        requestRealSize = requests.length;
    }

    public void run(){
        ArrayList<Integer> timeList = new ArrayList<>();
        for(int i = 0; i < requests.size() - 1; i++){
            timeList.add(requests.get(i) - requests.get(i+1));
        }

        int headMovement = 0;
        for (Integer integer : timeList) {
            headMovement += Math.abs(integer);
        }
        float seekTime = (float) headMovement / requestRealSize;
        System.out.println("head movement:" + headMovement);
        System.out.printf("seek time: %f" + "\n", seekTime);
    }
}
