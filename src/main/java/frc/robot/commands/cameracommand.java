package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import org.photonvision.targeting.PhotonTrackedTarget;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.Photonvision;
import frc.robot.subsystems.chassis;

public class cameracommand extends Command {
    private final chassis chassis;
    private final Photonvision newPhotonvision;

    public cameracommand(chassis chassis, Photonvision newPhotonvision) {
        this.chassis = chassis;
        this.newPhotonvision = newPhotonvision;
        addRequirements(this.chassis, this.newPhotonvision);
    }

    
}
 