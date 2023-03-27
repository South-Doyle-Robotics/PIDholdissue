// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.Button;

import frc.robot.commands.MidCubeCmd;
// import frc.robot.commands.TopCubeCmd;
// import frc.robot.commands.MidConeCmd;
import frc.robot.commands.TopConeCmd;
import frc.robot.commands.LauncherHomeCmd;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
  private final DigitalOutput launchEM = new DigitalOutput(5);

  // The driver's controller
  XboxController m_driverController =
      new XboxController(OIConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    launchEM.set(false);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * JoystickButton}.
   */
  private void configureButtonBindings() {
    // Move the arm to 2 radians above horizontal when the 'A' button is pressed.

    new JoystickButton(m_driverController, Button.kX.value).onTrue(new MidCubeCmd(launcherSubsystem));
    // new JoystickButton(m_driverController, Button.kY.value).onTrue(new TopCubeCmd(launcherSubsystem));
    // new JoystickButton(m_driverController, Button.kA.value).onTrue(new MidConeCmd(launcherSubsystem));
    new JoystickButton(m_driverController, Button.kB.value).onTrue(new TopConeCmd(launcherSubsystem));
    new JoystickButton(m_driverController, Button.kRightBumper.value).onTrue(new LauncherHomeCmd(launcherSubsystem));
    // Disable the arm controller when Y is pressed.

    // Drive at half speed when the bumper is held
  }

  /**
   * Disables all ProfiledPIDSubsystem and PIDSubsystem instances. This should be called on robot
   * disable to prevent integral windup.
   */

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return Commands.none();
  }
}
