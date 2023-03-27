package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class TopConeCmd extends CommandBase{
    private LauncherSubsystem launcherSubsystem;
    private ProfiledPIDController launcherController;

    public TopConeCmd(LauncherSubsystem launcherSubsystem) {
        this.launcherSubsystem = launcherSubsystem;
        final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.topConeMaxSpeed, LauncherConstants.topConeMaxAcceleration);
        launcherController = new ProfiledPIDController(LauncherConstants.topConekP, LauncherConstants.topConekI, LauncherConstants.topConekD, m_constraints, LauncherConstants.kDt);
        launcherController.setGoal(LauncherConstants.topConeGoal);
        // launcherController.setTolerance(LauncherConstants.topConeTolerance);
        addRequirements(launcherSubsystem);
    }
    @Override
    public void initialize() {
        final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.topConeMaxSpeed, LauncherConstants.topConeMaxAcceleration);
        launcherController = new ProfiledPIDController(LauncherConstants.topConekP, LauncherConstants.topConekI, LauncherConstants.topConekD, m_constraints, LauncherConstants.kDt);
        launcherController.setGoal(LauncherConstants.topConeGoal);
        System.out.println("Started home cmd");
    }
    
    
    @Override
    public void execute() {
        launcherSubsystem.set(launcherController.calculate(launcherSubsystem.getEncoderPosition()));
    }

    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
        System.out.println("topConeCmd ended");
    }

    @Override
    public boolean isFinished() {
        return launcherController.atGoal();
    }
}
