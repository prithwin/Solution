package com.personal.design.elevator;


import java.util.TreeSet;


/**
 * Created by prajeeva on 7/21/17.
 */
public class Elevator implements Runnable{

    volatile TreeSet<Integer> upQueue = new TreeSet<>();
    volatile TreeSet<Integer> downQueue = new TreeSet<>();
    volatile ElevatorDoor door;
    volatile int direction = 0;
    volatile int curr = 0;

    public Elevator() {
        this.door = new ElevatorDoor();
    }

    @Override
    public void run() {
        while(true) {
            if(!door.isOpen() && (!upQueue.isEmpty() || !downQueue.isEmpty())) {
                if(direction == 0) {
                    if (!upQueue.isEmpty() && downQueue.isEmpty()) {
                        direction = 1;
                    } else if (upQueue.isEmpty() && !downQueue.isEmpty()) {
                        direction = -1;
                    }
                }

                try{Thread.sleep(1000);}catch (Exception e) {}
                curr += direction;
                if(direction > 0){
                    if(curr == upQueue.first()) {
                        door.openDoor();
                        System.out.println("passengers doing their thing");
                        door.closeDoor();
                        upQueue.pollFirst();
                        if(upQueue.isEmpty()) direction = 0;
                    }
                } else {
                    if(curr == downQueue.last()) {
                        door.openDoor();
                        System.out.println("passengers doing their thing");
                        door.closeDoor();
                        downQueue.pollLast();
                        if(downQueue.isEmpty()) direction = 0;
                    }
                }
                System.out.println("current floor is = "+ curr);

            } else {
            }
        }
    }

    public void giveCommand(int floor) {
        if(direction == 0) {
            if(floor > curr) direction = 1;
            else  direction = -1;
        }
        if(floor > curr) {
            upQueue.add(floor);
        } else {
            downQueue.add(floor);
        }
    }
}
