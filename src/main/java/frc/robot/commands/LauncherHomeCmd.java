package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class LauncherHomeCmd extends CommandBase{
    
    private final LauncherSubsystem launcherSubsystem;
    private ProfiledPIDController launcherController;

    public LauncherHomeCmd(LauncherSubsystem launcherSubsystem) {
        final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.homeMaxSpeed, LauncherConstants.homeMaxAcceleration);
        launcherController = new ProfiledPIDController(LauncherConstants.homekP, LauncherConstants.homekI, LauncherConstants.homekD, m_constraints, LauncherConstants.kDt);

        this.launcherSubsystem = launcherSubsystem;
        launcherController.setGoal(LauncherConstants.homeGoal);
        addRequirements(launcherSubsystem);
    }
    @Override
    public void initialize() {
        final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(LauncherConstants.homeMaxSpeed, LauncherConstants.homeMaxAcceleration);
        launcherController = new ProfiledPIDController(LauncherConstants.homekP, LauncherConstants.homekI, LauncherConstants.homekD, m_constraints, LauncherConstants.kDt);
        launcherController.reset(launcherSubsystem.getEncoderPosition());
        launcherController.setGoal(LauncherConstants.homeGoal);
        System.out.println("Started home cmd");
    }
    
    @Override
    public void execute() {
        launcherSubsystem.set(launcherController.calculate(launcherSubsystem.getEncoderPosition()));
    }

    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
        System.out.println("home cmd ended");
    }

    @Override
    public boolean isFinished() {
        if(launcherController.atGoal())
            System.out.println("is finished");
        return launcherController.atGoal();
    }
}
