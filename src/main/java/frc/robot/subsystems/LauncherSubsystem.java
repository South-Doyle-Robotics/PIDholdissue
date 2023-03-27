package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;
import com.revrobotics.RelativeEncoder;


/** A robot arm subsystem that moves with a motion profile. */
public class LauncherSubsystem extends SubsystemBase {
  private final CANSparkMax LauncherMotor = new CANSparkMax(LauncherConstants.kMotorPort, MotorType.kBrushless);
  private final RelativeEncoder LauncherEncoder = LauncherMotor.getEncoder();

  //private DigitalInput LimitSwitch1 = new DigitalInput(LauncherConstants.limitSwitch1Channel);
  //private DigitalInput LimitSwitch2 = new DigitalInput(LauncherConstants.limitSwitch1Channel);
  /** Create a new ArmSubsystem. */
  public LauncherSubsystem() {
    LauncherEncoder.setPositionConversionFactor(LauncherConstants.MotorRotationsToM);
    LauncherMotor.enableVoltageCompensation(12);
  }
  @Override
  public void periodic() {}
  public double getEncoderPosition() {
    return LauncherEncoder.getPosition();
  }
  public void stop() {
    LauncherMotor.set(0.0);
  }
  public void set(double speed) {
    LauncherMotor.set(speed);
  }
}
