
package com.qualcomm.ftcrobotcontroller.opmodes;

//------------------------------------------------------------------------------
//
// SarthakTest
//
/**
 * Provide a basic manual operational mode that uses the left and right
 * drive motors, left arm motor, servo motors and gamepad input from only one
 * gamepad for the Push Bot.
 *
 * @author SSI Robotics
 * @version 2015-09-05-20-12
 */
public class SarthakTest extends PushBotTelemetry

{
    //--------------------------------------------------------------------------
    //
    // SarthakTest
    //

    /**
     * Construct the class.
     * <p/>
     * The system calls this member when the class is instantiated.
     */
    public SarthakTest()

    {
        //
        // Initialize base classes.
        //
        // All via self-construction.

        //
        // Initialize class members.
        //
        // All via self-construction.

    } // SarthakTest

    //--------------------------------------------------------------------------
    //
    // loop
    //

    /**
     * Implement a state machine that controls the robot during
     * manual-operation.  The state machine uses gamepad input to transition
     * between states.
     * <p/>
     * The system calls this member repeatedly many times while the OpMode is running.
     */
    @Override
    public void loop()

    {

        //Below code is for the mumbo jumbo motor.
        float x = gamepad1.left_stick_x;
        set_drive_power(x, x);

        //Below code is for servos.
        boolean y = gamepad1.y;
        if (y) {
            m_hand_position(a_hand_position() + 0.05);
        }
        boolean xinput = gamepad1.x;
        if (xinput) {
            m_hand_position(a_hand_position() - 0.05);
        }

        update_gamepad_telemetry ();
        telemetry.addData
                ( "12"
                        , "Servo Position: " + a_hand_position()
                );

    } // loop

} // SarthakTest
