package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.List;

import org.photonvision.*;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Photonvision extends SubsystemBase {
    public PhotonCamera camera = new PhotonCamera("");
    private PhotonPipelineResult result=camera.getLatestResult();;

    PhotonTrackedTarget target = result.getBestTarget();
    double yaw = target.getYaw();
    double pitch = target.getPitch();
    double area = target.getArea();
    boolean hastarget = result.hasTargets();

    List<PhotonTrackedTarget> targets = result.getTargets();
    public double getBestTargetYaw() {

        result = camera.getLatestResult();

        var bestTarget = result.getBestTarget();
        return bestTarget.getYaw();
    }
    

    @Override
    public void periodic() {
    System.out.println(hastarget);
    yaw = target.getYaw();
    pitch = target.getPitch();
    area = target.getArea();
    hastarget = result.hasTargets();
    getBestTargetYaw();
    if (result.hasTargets()) { 
            int targetID = target.getFiducialId();
            double poseAmbiguity = target.getPoseAmbiguity();
            Transform3d bestCameraToTarget = target.getBestCameraToTarget();
            Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();

            SmartDashboard.putNumber("ID", targetID);
            SmartDashboard.putNumber("Ambiguity", poseAmbiguity);
            SmartDashboard.putData("3d", null);
    }
}
}