package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.*;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class PhotonCamera {
    public PhotonCamera camera = new PhotonCamera("");
    private NetworkTable table;
    private PhotonPipelineResult result;

    PhotonTrackedTarget target = result.getBestTarget();
    double yaw = target.getYaw();
    double pitch = target.getPitch();
    double area = target.getArea();

    public PhotonCamera(NetworkTable table) {
        this.table = table;

    }

    public PhotonCamera(String tableName) {

        this.table = NetworkTableInstance.getDefault().getTable(tableName);
    }

    public double getBestTargetYaw() {

        result = camera.getLatestResult();

        var bestTarget = result.getBestTarget();
        return bestTarget.getYaw();
    }
    @Override
    




}
