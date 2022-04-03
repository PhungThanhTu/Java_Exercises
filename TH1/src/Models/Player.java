package Models;

public class Player implements IControllable{
    String model;
    int volume;
    String memory;

    public Player() {
        this.model = "undefined";
        this.volume = 0;
        this.memory = "Hello";
    }

    @Override
    public void turnOn() {
        System.out.println("Player On");
    }

    @Override
    public void turnOff() {
        System.out.println("Player Off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Volume up : " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Volume down : " + volume);
    }
}
