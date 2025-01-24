package frc.robot.commands;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.Photonvision;
import frc.robot.subsystems.chassis;

public class SmartPhotonvision extends Command {
  private chassis newchassis;
  private Photonvision newPhotonvision;
  chassis myChassis = new chassis();            
    
  public SmartPhotonvision(chassis newchassis, Photonvision newPhotonvision) {
    this.newchassis = newchassis;
    this.newPhotonvision = newPhotonvision;

    addRequirements(this.newchassis, this.newPhotonvision);
  }

  public void getnumfromvision() {
    newPhotonvision.getvisionnum();

  }
  // public void autotarget() {
  // // double area = target.getArea();
  // // double Tag_X = LimelightHelpers.getTX("limelight"); // Use your actual
  // limelight name
  // PhotonTrackedTarget target = result.getBestTarget();
  // double yaw = target.getYaw();
  // double pitch = target.getPitch();
  // double area = target.getArea();
  // boolean hastarget = result.hasTargets();

  // if (Tag_X < 6 && Tag_X > -6 || Tag_X == 0) {
  // newchassis.stop();
  // if (Tag_Area < 6 && Tag_Area > 4 || Tag_Area == 0) {
  // newchassis.stop();
  // }
  // else if (Tag_Area >= 6) {
  // newchassis.backward();
  // }
  // else if (Tag_Area <= 4) {
  // newchassis.forward();
  // }
  // }
  // else if (Tag_X >= 6) {
  // newchassis.right();
  // }
  // else {
  // newchassis.left();
  // }
  // }
  public void letsgo() {
    newPhotonvision.getvisionnum();
    double yaw = newPhotonvision.getYaw();
    double pitch = newPhotonvision.getPitch();
    double area = newPhotonvision.getArea();
    boolean hasTarget = newPhotonvision.hasTarget();
    if (newPhotonvision.isornot()) {
      
      if(area<1){
        myChassis.forward();
      }
      else if(area>4){
        myChassis.backward();
      }
      else if(area==0){
        myChassis.stop();
      }
      else if(yaw<-14) {
        myChassis.left();
      }
      else if (yaw>13){
        myChassis.right();
      }
      else{
        myChassis.stop();
      }

  //     if (area < 6 && Tag_X > -6 || Tag_X == 0) {
  //       newchassis.stop();

  //       if (Tag_Area < 6 && Tag_Area > 4 || Tag_Area == 0) {
  //         stop();
  //       } else if (Tag_Area >= 6) {
  //         backward();
  //       } else if (Tag_Area <= 4) {
  //         forward();
  //       }
  //     } else if (Tag_X >= 6) {
  //       right();
  //     } else {
  //       left();
  //     }
  //   } else {
  //     visionstop();
  //   }
  // }

}
  }
}