// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class LauncherConstants {
    public static final int kMotorPort = 14;

    //public static final int limitSwitch1Channel = 0;
    //public static final int limitSwitch2Channel = 1;
    public static final double MotorRotationsToM = 0.03;
    
    public static final double topConekP = 3;
    public static final double topConekI = 0.09;
    public static final double topConekD = 0.00;

    // public static final double midConekP = 1.95;
    // public static final double midConekI = 0.0;
    // public static final double midConekD = 0.019;

    // public static final double topCubekP = 3.5;
    // public static final double topCubekI = 0.0;
    // public static final double topCubekD = 0.001;
    
    public static final double midCubekP = 3;
    public static final double midCubekI = 0.0;
    public static final double midCubekD = 0.09;

    public static final double homekP = 3;
    public static final double homekI = 0.09;
    public static final double homekD = 0.00;

    public static final double topConeGoal = -.25;//-0.4925;
    // public static final double midConeGoal = 0.555;
    // public static final double topCubeGoal = 0.4;
    public static final double midCubeGoal = -0.47;
    public static final double homeGoal = 0;

    public static final double midCubeTolerance = 0;
    public static final double homeTolerance = 0;
    public static final double topTolerance = 0;

    public static final double topConeMaxSpeed = 2;
    public static final double topConeMaxAcceleration =1.0;
    
    // public static final double midConeMaxSpeed = 3.6;
    // public static final double midConeMaxAcceleration = 10.0;

    // public static final double topCubeMaxSpeed = 3.6;
    // public static final double topCubeMaxAcceleration = 10.0;

    public static final double midCubeMaxSpeed = 4.5;
    public static final double midCubeMaxAcceleration = 9.0;
    
    public static final double homeMaxSpeed = 2;
    public static final double homeMaxAcceleration = 1;

    public static final double kDt = 0.05;
  }
  

  public static final class AutoConstants {
    public static final double kAutoTimeoutSeconds = 12;
    public static final double kAutoShootTimeSeconds = 7;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }
}
