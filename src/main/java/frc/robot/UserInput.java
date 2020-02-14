
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */

public class UserInput
{
    private static final int LEFTPORT=0;
    private static final int RIGHTPORT=1;
    private static final int OPERATORPORT=2;
    private static final double Deadband=.2;
    private static final int Y_AXIS=1;


    public static  Joystick leftStick;
    private static  Joystick rightStick;
    private static  Joystick operatorStick;  //driver two
  


  
    //buttons on driver stick
    private static final int JSB_GEARSHIFT=1;
  


    //bottons on the operator stick

    private static final int JSB_INTAKERUN=1;
    private static final int JSB_INTAKEUP=2;
    private static final int JSB_INTAKEDOWN=4;


  
    private static final int JSB_LIFTERUP=5;
    private static final int JSB_LIFTERDOWN=6;
    private static final int JSB_LIFTERHOIST=7;

public static void Init()
    {
        leftStick=new Joystick(LEFTPORT);
        rightStick=new Joystick(RIGHTPORT);
        operatorStick=new Joystick(OPERATORPORT);
    }

    public static double  getLeftStick()    
    {
        return getDeadband(leftStick.getRawAxis(Y_AXIS));
    }

    public static double  getRightStick(){
        return getDeadband(rightStick.getRawAxis(Y_AXIS));
    }

    public static double  getDeadband(double Joystick_val){ 
                if (Math.abs(Joystick_val)<Deadband) return 0;

                return Math.signum(Joystick_val)*(Math.abs(Joystick_val)-Deadband)/(1-Deadband);
}  



public static boolean getGearButton()
    {
         
		return rightStick.getRawButton(JSB_GEARSHIFT);
    }


//Intake functions

    public static boolean intakeUp()
    {
        return operatorStick.getRawButton(JSB_INTAKEUP);
    }
    public static boolean intakeDown()
    {
        return operatorStick.getRawButton(JSB_INTAKEDOWN);
    }
    public static boolean intakeRun()
    {
        return operatorStick.getRawButton(JSB_INTAKERUN);
    }


    //Lifter functions
    public static boolean climb()
    {
        return operatorStick.getRawButton(JSB_LIFTERHOIST);
    }
    public static boolean getLifterUp()
    {
        return operatorStick.getRawButton(JSB_LIFTERUP);
    }

    public static boolean getLifterDown()
    {
        return operatorStick.getRawButton(JSB_LIFTERDOWN);
    }
    
}

  

