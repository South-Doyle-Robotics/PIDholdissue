package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class MidConeCmd extends CommandBase{
    private LauncherSubsystem launcherSubsystem;
    private ProfiledPIDController launcherController;

    public MidConeCmd(LauncherSubsystem launcherSubsystem) {
        // this.launcherSubsystem = launcherSubsystem;
        // final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.midConeMaxSpeed, LauncherConstants.midConeMaxAcceleration);
        // launcherController = new ProfiledPIDController(LauncherConstants.midConekP, LauncherConstants.midConekI, LauncherConstants.midConekD, m_constraints, LauncherConstants.kDt);
        // launcherController.setGoal(LauncherConstants.midConeGoal);
        // launcherController.setTolerance(LauncherConstants.midConeTolerance);
        // addRequirements(launcherSubsystem);
    }
    @Override
    public void initialize() {
        // final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.midConeMaxSpeed, LauncherConstants.midConeMaxAcceleration);
        // launcherController = new ProfiledPIDController(LauncherConstants.midConekP, LauncherConstants.midConekI, LauncherConstants.midConekD, m_constraints, LauncherConstants.kDt);
        // launcherController.setGoal(LauncherConstants.midConeGoal);
        // System.out.println("Started home cmd");
    }
    
    
    @Override
    public void execute() {
        launcherSubsystem.set(launcherController.calculate(launcherSubsystem.getEncoderPosition()));
    }

    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
        System.out.println("midConeCmd ended");
    }

    @Override
    public boolean isFinished() {
        return launcherController.atGoal();
    }
}
