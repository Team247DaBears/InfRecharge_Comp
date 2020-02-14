/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * Add your docs here.
 */
public class Devices {
    static final boolean UseSparkMax = false;
    static final boolean UseEncoder = true;
      
    private static final int CANFRONTLEFTPWM = 12;
    private static final int CANFRONTRIGHTPWM=3;
    private static final int CANBACKLEFTPWM=4;
    private static final int CANBACKRIGHTPWM=5;    

    private static final int FRONTLEFTPWM = 12; // victor
    private static final int FRONTRIGHTPWM=8; // victor
    private static final int BACKLEFTPWM=13;
    private static final int BACKRIGHTPWM=9; 

    
    private static final int PWM_INTAKE_MOTOR=0;
    
    private static final int PWM_LIFTER_LEFT = 3;
    private static final int PWM_LIFTER_RIGHT= 4;



    public static final int  PCM_INTAKE_FORWARD=0;
    public static final int  PCM_INTAKE_BACK=1;
    public static final int  PCM_LIFTER_FORWARD=5;
    public static final int  PCM_LIFTER_BACK=6;

   

    private static final int GEARFORWARD = 6; // solonoid3 pin0
    private static final int GEARREVERSE = 7; // solonoid3 pin1

    public static DaBearsSpeedController frontLeft = null;
    public static DaBearsSpeedController frontRight = null;
    public static DaBearsSpeedController backLeft = null;
    public static DaBearsSpeedController backRight = null;

    public static DoubleSolenoid gearShift;

    //So, I'll add another set of controls, and you can comment out whichever is unused.    
      public static DoubleSolenoid lifter_solenoid;
      public static SpeedController lifter_left_motor;
      public static SpeedController lifter_right_motor;

      public static DoubleSolenoid intake_solenoid;
      public static SpeedController intake_motor;


    // Insert constants

    // Insert fields (variables, objects)

    // Insert member functions

    // Create all objects in the Init function, unless there is some reason it has
    // to wait until the beginning of autonomous.
    // This will be called from robot.init, which executes as soon as the power is
    // applied and the roborio boots up.
    public static void Init() {
      if (frontLeft==null) {
        System.out.println("Init Devics:");
        if (UseSparkMax) {
          frontLeft=new DaBearsSpeedController(CANFRONTLEFTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax,20,21);
          frontRight=new DaBearsSpeedController(CANBACKLEFTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax,22,23);

          backLeft=new DaBearsSpeedController(CANFRONTRIGHTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax,16,17);
          backRight=new DaBearsSpeedController(CANBACKRIGHTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax,18,19);
        }
        else {
          frontLeft=new DaBearsSpeedController(FRONTLEFTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax);
          frontRight=new DaBearsSpeedController(BACKLEFTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax);

          backLeft=new DaBearsSpeedController(FRONTRIGHTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax);
          backRight=new DaBearsSpeedController(BACKRIGHTPWM, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless,UseSparkMax);
        }
        frontRight.setInverted(true);
        backRight.setInverted(false);

        lifter_solenoid=new DoubleSolenoid(PCM_LIFTER_FORWARD, PCM_LIFTER_BACK);
        lifter_solenoid.set(DoubleSolenoid.Value.kReverse);  //Set default as down

        lifter_left_motor=new Spark(PWM_LIFTER_LEFT);
        lifter_right_motor=new Spark(PWM_LIFTER_RIGHT);
        lifter_right_motor.setInverted(true);


        intake_solenoid=new DoubleSolenoid(PCM_INTAKE_FORWARD, PCM_INTAKE_BACK);
        intake_motor=new Spark(PWM_INTAKE_MOTOR);


        gearShift = new DoubleSolenoid(GEARFORWARD, GEARREVERSE);
        Devices.gearShift.set(DoubleSolenoid.Value.kReverse); // set default as low
      }
    else {
      System.out.println("Init entered twice:");
    }
    }
  }

