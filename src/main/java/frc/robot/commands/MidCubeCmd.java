package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class MidCubeCmd extends CommandBase{
    
    private LauncherSubsystem launcherSubsystem;
    private ProfiledPIDController launcherController;

    public MidCubeCmd(LauncherSubsystem launcherSubsystem) {
        this.launcherSubsystem = launcherSubsystem;
        final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.midCubeMaxSpeed, LauncherConstants.midCubeMaxAcceleration);
        launcherController = new ProfiledPIDController(LauncherConstants.midCubekP, LauncherConstants.midCubekI, LauncherConstants.midCubekD, m_constraints, LauncherConstants.kDt);
        launcherController.setGoal(LauncherConstants.midCubeGoal);
        //launcherController.setTolerance(LauncherConstants.midCubeTolerance);
        addRequirements(launcherSubsystem);
    }
    @Override
    public void initialize() {
        final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.midCubeMaxSpeed, LauncherConstants.midCubeMaxAcceleration);
        launcherController = new ProfiledPIDController(LauncherConstants.midCubekP, LauncherConstants.midCubekI, LauncherConstants.midCubekD, m_constraints, LauncherConstants.kDt);
        launcherController.setGoal(LauncherConstants.midCubeGoal);
        System.out.println("Started home cmd");
    }
    
    @Override
    public void execute() {
        launcherSubsystem.set(launcherController.calculate(launcherSubsystem.getEncoderPosition()));
    }

    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
        System.out.println("MidCubeCmd ended");
    }

    @Override
    public boolean isFinished() {
        return launcherController.atGoal();
    }
}
