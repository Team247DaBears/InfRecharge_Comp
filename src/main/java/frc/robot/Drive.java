

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class  Drive
{

  public GearStates currentGearState=GearStates.LowGearOff;
  

    
    public void drive()
      {
          

          double leftSideMotorSpeed= UserInput.getLeftStick();
          double rightSideMotorSpeed=UserInput.getRightStick();
//System.out.println("Ls"+leftSideMotorSpeed);
         Devices.backLeft.set(leftSideMotorSpeed);
         Devices.frontLeft.set(leftSideMotorSpeed);
         Devices.frontRight.set(rightSideMotorSpeed);
          Devices.backRight.set(rightSideMotorSpeed);
             shiftGears();// This could go in robot.java
      
      }
   
    
    public void shiftGears(){

   // if (UserInput.getGearButton()) System.out.println("true");
  //  else System.out.println("False");
    //System.out.println("Gear button is "+UserCom.getGearButton());
//System.out.println("Gear state before is "+currentGearState.toString());
    switch(currentGearState)
    {
        case HighGearOff:
            if(UserInput.getGearButton())
            {
                currentGearState=GearStates.LowGearPressed;
            }
            break;
       case HighGearPressed:
            if (!UserInput.getGearButton())
            {
                currentGearState=GearStates.HighGearOff;
            }
            break;
      case LowGearOff:
           if (UserInput.getGearButton())
           {
               currentGearState=GearStates.HighGearPressed;
           }
           break;
      case LowGearPressed:
           if (!UserInput.getGearButton())
           {
               currentGearState=GearStates.HighGearOff;
           }
           break;
          
      }
      switch(currentGearState)
      {
          case HighGearOff:
          case HighGearPressed:
          Devices.gearShift.set(DoubleSolenoid.Value.kForward);
              break;
          case LowGearOff:
          case LowGearPressed:
              Devices.gearShift.set(DoubleSolenoid.Value.kReverse);
              break;
      }
  }
//  System.out.println("Gear state after is "+currentGearState.toString());

}       

