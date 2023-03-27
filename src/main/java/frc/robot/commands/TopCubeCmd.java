package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class TopCubeCmd extends CommandBase{
    private LauncherSubsystem launcherSubsystem;
    private ProfiledPIDController launcherController;

    public TopCubeCmd(LauncherSubsystem launcherSubsystem) {
        // this.launcherSubsystem = launcherSubsystem;
        // final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.topCubeMaxSpeed, LauncherConstants.topCubeMaxAcceleration);
        // launcherController = new ProfiledPIDController(LauncherConstants.topCubekP, LauncherConstants.topCubekI, LauncherConstants.topCubekD, m_constraints, LauncherConstants.kDt);
        // launcherController.setGoal(LauncherConstants.topCubeGoal);
        // // launcherController.setTolerance(LauncherConstants.topCubeTolerance);
        // addRequirements(launcherSubsystem);
    }
    @Override
    public void initialize() {
        // final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.topCubeMaxSpeed, LauncherConstants.topCubeMaxAcceleration);
        // launcherController = new ProfiledPIDController(LauncherConstants.topCubekP, LauncherConstants.topCubekI, LauncherConstants.topCubekD, m_constraints, LauncherConstants.kDt);
        // launcherController.setGoal(LauncherConstants.topCubeGoal);
        // System.out.println("Started home cmd");
    }
    
    
    @Override
    public void execute() {
        launcherSubsystem.set(launcherController.calculate(launcherSubsystem.getEncoderPosition()));
    }

    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
        System.out.println("TopCubeCmd ended");
    }

    @Override
    public boolean isFinished() {
        return launcherController.atGoal();
    }
}
