package com.personal.design.elevator;

/**
 * Created by prajeeva on 7/21/17.
 */
public class Building {
    Elevator elevator1 = new Elevator();
    Elevator elevator2 = new Elevator();
    Elevator elevator3 = new Elevator();
    Elevator elevator4 = new Elevator();

    public static void main(String[] args) {

        System.out.println("string the building elevators");
        Building building = new Building();
        new Thread(building.elevator1).start();
        sleep(1000);
        building.elevator1.door.openDoor();
        System.out.println("people boarding the elevator");
        building.elevator1.giveCommand(5);
        building.elevator1.giveCommand(7);
        building.elevator1.giveCommand(10);
        building.elevator1.giveCommand(6);
        building.elevator1.door.closeDoor();
        sleep(8000);
        System.out.println("jackass presses 28");
        building.elevator1.giveCommand(28);
        sleep(8000);
        System.out.println("jackass presses 2");
        building.elevator1.giveCommand(2);
        sleep(8000);
        sleep(8000);
        sleep(8000);
        sleep(8000);
        building.elevator1.giveCommand(28);

    }

    private static void sleep(int millls) {
        try {
            Thread.sleep(millls);
        }catch (Exception e) {

        }
    }
}
