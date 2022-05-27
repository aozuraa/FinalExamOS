package DiskScheduling;

import java.util.ArrayList;

public class Look {
    private final int currentPosition;
    private final ArrayList<Integer> requests = new ArrayList<>();
    private final int requestRealSize;

    public Look(int currentPosition, int[] requests) {
        this.currentPosition = currentPosition;
        for (int request : requests) {
            this.requests.add(request);
        }
        requestRealSize = requests.length;
    }

    public void run() {
        ArrayList<Integer> timeList = new ArrayList<>();
        requests.add(currentPosition);
        requests.sort(Integer::compareTo);
        int startHeadIndex = requests.indexOf(currentPosition);
        int currentHeadIndex = 0;
        // Go right
        for (int i = startHeadIndex; i < requests.size() - 1; i++) {
            currentHeadIndex = i;
            timeList.add(requests.get(currentHeadIndex) - requests.get(++currentHeadIndex));
        }
        // Go left
        if(startHeadIndex == requests.size()-1) //check if all request are to the left
        {
            for (int i = startHeadIndex; i > 0; i--) {
                currentHeadIndex = i;
                timeList.add(requests.get(currentHeadIndex) - requests.get(--currentHeadIndex));
            }
        }
        else if (startHeadIndex != 0) { // check if the request are all on the right of starting headpostion
            timeList.add(requests.get(currentHeadIndex) - requests.get(--startHeadIndex));
            for (int i = startHeadIndex; i > 0; i--) {
                currentHeadIndex = i;
                timeList.add(requests.get(currentHeadIndex) - requests.get(--currentHeadIndex));
            }
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
