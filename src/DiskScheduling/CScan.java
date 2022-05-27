package DiskScheduling;


import java.util.ArrayList;

public class CScan {
    private final int currentPosition;
    private final int trackSize;
    private final ArrayList<Integer> requests = new ArrayList<>();
    private boolean checkEnd;
    private final int requestRealSize;

    public CScan(int currentPosition, int trackSize, int[] requests) {
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
        if (!requests.contains(0)) requests.add(0);
        requests.sort(Integer::compareTo);
        System.out.println(requests.toString());;
        int startHeadIndex = requests.indexOf(currentPosition);
        int currentHeadIndex = 0;
        //Go right
        for (int i = startHeadIndex; i < requests.size() - 1; i++) {
            currentHeadIndex = i;
            timeList.add(requests.get(currentHeadIndex) - requests.get(++currentHeadIndex));
        }
        timeList.add(requests.get(currentHeadIndex));
        for (int i = 0; i < startHeadIndex - 1; i++) {
            currentHeadIndex = i;
            timeList.add(requests.get(currentHeadIndex) - requests.get(++currentHeadIndex));
        }


        int headMovement = 0;
        for (Integer integer : timeList) {
            headMovement += Math.abs(integer);
        }
        float seekTime = (float) headMovement / requestRealSize;
        System.out.println("head movement:" + headMovement);
        System.out.printf("seek time: %f" + "\n", seekTime);
        System.out.println(timeList.toString());
    }
}
