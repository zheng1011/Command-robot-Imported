package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.PhotonCamera;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Photonvision extends SubsystemBase {
    // Create an instance of the PhotonCamera
    PhotonCamera camera = new PhotonCamera("photonvision");
    PhotonTrackedTarget target;

    // Variables to store the target data
    double Yaw;
    double Area;
    double Pitch;

    @Override
    public void periodic() {
        // Get the latest result from the camera
        PhotonPipelineResult result = camera.getLatestResult();

        // Check if there are any targets detected
        if (result.hasTargets()) {
            // Retrieve the best target from the result
            target = result.getBestTarget();

            // Extract the data from the target
            Yaw = target.getYaw();
            Area = target.getArea();
            Pitch = target.getPitch();

            // Display the target data on the SmartDashboard
            SmartDashboard.putNumber("Yaw", Yaw);
            SmartDashboard.putNumber("Area", Area);
            SmartDashboard.putNumber("Pitch", Pitch);
            SmartDashboard.putNumber("Fiducial ID", target.getFiducialId());
        } else {
            // If no target is found, display a message on the SmartDashboard
            SmartDashboard.putString("Status", "No Target Found");
        }
    }
}


