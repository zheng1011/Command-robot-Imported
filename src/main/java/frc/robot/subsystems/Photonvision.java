package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.List;

import org.photonvision.*;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class Photonvision extends SubsystemBase {
    public PhotonCamera camera = new PhotonCamera("");
    private PhotonPipelineResult result = camera.getLatestResult();

    PhotonTrackedTarget target;
    private double yaw;
    private double pitch;
    private double area;
    private boolean hastarget;
    private int targetID;
    private double poseAmbiguity;

    List<PhotonTrackedTarget> targets = result.getTargets();

    public void getvisionnum() {
        PhotonPipelineResult result = camera.getLatestResult();
        PhotonTrackedTarget target = result.getBestTarget();

        if (target == null) {
            hastarget = false;
            // 可以選擇設定 yaw, pitch, area 的預設值，例如 0
            yaw = 0;
            pitch = 0;
            area = 0;
        } else if (result.hasTargets()) {
            yaw = target.getYaw();
            pitch = target.getPitch();
            area = target.getArea();
            hastarget = true;
            // ... 其他程式碼 (例如 SmartDashboard) ...
        } else {
            hastarget = false;
            // 可以選擇設定 yaw, pitch, area 的預設值，例如 0
            yaw = 0;
            pitch = 0;
            area = 0;
        }
    }

    // 提供 getter 方法
    public double getYaw() {
        return yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public double getArea() {
        return area;
    }

    public boolean hasTarget() {
        return result.hasTargets();
        // return hastarget;
    }

    public double getBestTargetYaw() {

        if (result.hasTargets()) {
            target = result.getBestTarget();
            yaw = target.getYaw();
            pitch = target.getPitch();
            area = target.getArea();
            hastarget = true;
            return target.getYaw(); // 直接回傳 yaw
        } else {
            hastarget = false;
            yaw = 0;
            pitch = 0;
            area = 0;
            return 0; // 沒有目標時回傳 0 或其他預設值
        }
    }
    // PhotonTrackedTarget target = null;
    // double isfalse=0;

    // if (result.hasTargets()) {
    // target = result.getBestTarget(); // 僅在有目標時賦值
    // yaw = target.getYaw();
    // pitch = target.getPitch();
    // area = target.getArea();
    // hastarget = true;
    // // ... 其他程式碼 (例如 SmartDashboard) ...
    // }
    // else if (target == null){
    // isfalse=1;
    // }
    // else {
    // hastarget = false;
    // // 可以選擇設定 yaw, pitch, area 的預設值，例如 0
    // yaw = 0;
    // pitch = 0;
    // area = 0;
    // // 或保持 target 為 null
    // }

    // ... 後續程式碼中，在使用 target 之前賦值
    // if (result.hasTargets()) {
    // target = result.getBestTarget();
    // result = camera.getLatestResult();
    // var bestTarget = result.getBestTarget();
    // return bestTarget.getYaw();
    // }
    // else{
    // return isfalse;
    // }

    // public void getvisionnum(){
    // PhotonTrackedTarget target = result.getBestTarget();
    // double yaw = target.getYaw();
    // double pitch = target.getPitch();
    // double area = target.getArea();
    // boolean hastarget = result.hasTargets();

    // List<PhotonTrackedTarget> targets = result.getTargets();
    // if (result.hasTargets()) {

    // int targetID = target.getFiducialId();
    // double poseAmbiguity = target.getPoseAmbiguity();
    // Transform3d bestCameraToTarget = target.getBestCameraToTarget();
    // Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();
    // double Yaw = target.getYaw();
    // SmartDashboard.putNumber("ID", targetID);
    // SmartDashboard.putNumber("Ambiguity", poseAmbiguity);
    // SmartDashboard.putNumber("Yaw", yaw);
    // SmartDashboard.putNumber("Pitch", pitch);
    // SmartDashboard.putNumber("Area", area);

    // }

    // }

    // public void letsgo() {

    // if (result.hasTargets()) {

    // if (Tag_X < 6 && Tag_X > -6 || Tag_X == 0) {
    // stop();
    // if (Tag_Area < 6 && Tag_Area > 4 || Tag_Area == 0) {
    // stop();
    // } else if (Tag_Area >= 6) {
    // backward();
    // } else if (Tag_Area <= 4) {
    // forward();
    // }
    // } else if (Tag_X >= 6) {
    // right();
    // } else {
    // left();
    // }
    // }
    // else{
    // visionstop();
    // }
    // }
    public boolean isornot() {
        if (result.hasTargets()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void periodic() {
        System.out.println(hastarget);
        PhotonTrackedTarget target;
        // Update Apriltag results


        if (result.hasTargets()) {
            target = result.getBestTarget();
            yaw = target.getYaw();
            pitch = target.getPitch();
            area = target.getArea();
            hastarget = result.hasTargets();

            targetID = target.getFiducialId();
            poseAmbiguity = target.getPoseAmbiguity();
            Transform3d bestCameraToTarget = target.getBestCameraToTarget();
            Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();
            double Yaw = target.getYaw();
            // SmartDashboard.putNumber("ID", targetID);
            // SmartDashboard.putNumber("Ambiguity", poseAmbiguity);
            // SmartDashboard.putNumber("Yaw", yaw);
            // SmartDashboard.putNumber("Pitch", pitch);
            // SmartDashboard.putNumber("Area", area);

            // SmartDashboard.put

            getvisionnum();
        }
        SmartDashboard.putNumber("ID", targetID);
        SmartDashboard.putNumber("Ambiguity", poseAmbiguity);
        SmartDashboard.putNumber("Yaw", yaw);
        SmartDashboard.putNumber("Pitch", pitch);
        SmartDashboard.putNumber("Area", area);

        // double getID = SmartDashboard.getNumber("ID", 0);
        // double getYaw = SmartDashboard.getNumber("yaw", 0);
        // double getArea = SmartDashboard.getNumber("Area", 0);
        // double getPitch = SmartDashboard.getNumber("Area", 0);


    }
}