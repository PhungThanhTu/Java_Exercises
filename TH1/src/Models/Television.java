package Models;

public class Television implements IControllable {
    String model;
    int volume;
    int channel;

    public Television() {
        this.model = "undefined";
        this.volume = 0;
        this.channel = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void turnOn() {
        System.out.println("Television On");
    }

    @Override
    public void turnOff() {
        System.out.println("Television Off");
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
