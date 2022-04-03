package Models;

public interface IRemoteControlable {
    default void Start(){};
    default void Stop(){};
    default void VolumeUp(){};
    default void VolumeDown(){};

}
