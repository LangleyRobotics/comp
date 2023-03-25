package frc.robot.commands.lightingCommands;

import edu.wpi.first.util.datalog.DataLog;
import edu.wpi.first.util.datalog.DoubleLogEntry;
import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.lightingSubsystem;


public class CargoSignalCmd extends CommandBase{
    private final lightingSubsystem lightingSubsystem;
    private final PneumaticsSubsystem pneumaticsSubsystem;
    //DoubleLogEntry voltageLog;



    public CargoSignalCmd(lightingSubsystem lightingSubsystem, PneumaticsSubsystem pneumaticsSubsystem) {
        this.lightingSubsystem = lightingSubsystem;
        this.pneumaticsSubsystem = pneumaticsSubsystem;
        addRequirements(lightingSubsystem);
        addRequirements(pneumaticsSubsystem);
    }

    @Override
    public void initialize() {
        /* 
        DataLogManager.start();
        DataLog log = DataLogManager.getLog();;

        voltageLog = new DoubleLogEntry(log, "voltage: ");
        */

    }

    @Override
    public void execute() {
        //int toggleCount = 0;
        //double elapsed;
        //boolean awakePrev = false;

        /* 
        if (Timer.getMatchTime() <= 15) {
            elapsed = 15-Timer.getMatchTime();
        } else {
            elapsed = 165-Timer.getMatchTime(); 
        }
        */
        if (!pneumaticsSubsystem.isSallyAwake()) {
            //set purple
            lightingSubsystem.setAllColorUniform(255, 0, 255);
           /* 
            if (awakePrev) {
                toggleCount++;
            }
            awakePrev = false;
            */
            //95, 52, 206
        }
        if (pneumaticsSubsystem.isSallyAwake()) {
            //set yellow
           
            lightingSubsystem.setAllColorUniform(250, 145, 0);
            /* 
            if (!awakePrev) {
                toggleCount++;
            }
            awakePrev = true;
            */
        }
        /* 
        if ((elapsed%3) <= 0.05) {
            toggleCount  = 0;
        }

        if (toggleCount > 4){
            pneumaticsSubsystem.toggleSally();
            toggleCount = 0;
            voltageLog.append(RobotController.getBatteryVoltage());
        }
        */
    }
     
    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }


}
