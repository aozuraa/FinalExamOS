package DiskScheduling;

import java.util.ArrayList;


public class Scan {
    private final int currentPosition;
    private final int trackSize;
    private final ArrayList<Integer> requests = new ArrayList<>();
    private final int requestRealSize;

    public Scan(int currentPosition, int trackSize, int[] requests) {
        this.currentPosition = currentPosition;
        this.trackSize = trackSize;
        for (int request : requests) {
            this.requests.add(request);
        }
        requestRealSize = requests.length;
    }

    public void run(){
        ArrayList<Integer> timeList = new ArrayList<>();
        requests.add(currentPosition);
        if (!requests.contains(trackSize)) requests.add(trackSize);
        requests.sort(Integer::compareTo);
       int startHeadIndex = requests.indexOf(currentPosition);
       int currentHeadIndex = 0;
       //Go right
       for (int i = startHeadIndex; i < requests.size() - 1; i++) {
           currentHeadIndex = i;
           timeList.add(requests.get(currentHeadIndex) - requests.get(++currentHeadIndex));
       }
       //Go left
       timeList.add(requests.get(currentHeadIndex) - requests.get(--startHeadIndex));
       for (int i = startHeadIndex; i > 0; i--) {
          currentHeadIndex = i;
           timeList.add(requests.get(currentHeadIndex) - requests.get(--currentHeadIndex));
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
