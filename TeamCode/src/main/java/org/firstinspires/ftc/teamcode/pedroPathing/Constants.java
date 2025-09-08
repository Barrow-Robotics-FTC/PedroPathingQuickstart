package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.pedropathing.control.PIDFCoefficients;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(15) // Weight of the robot in kg (this is estimated since we dont have a scale)
            .forwardZeroPowerAcceleration(0) // TUNE THIS
            .lateralZeroPowerAcceleration(0) // TUNE THIS
            //.setBrakingStrength(0.5) // This should be fine for normal driving, you may change this after testing
            // Use dual PIDs for accuracy (you should use this)
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true)
            // TUNE THESE
            .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0))
            .secondaryTranslationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0))
            .headingPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0))
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0))
            .centripetalScaling(0); // TUNE THIS

    // You shouldn't mess with this for now
    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1) // This should pretty much always stay at 1 (100%)
            // Names of the motors in the hardware map (these are the defaults from the FTC SDK examples)
            .rightFrontMotorName("front_right_drive")
            .rightRearMotorName("back_right_drive")
            .leftRearMotorName("back_left_drive")
            .leftFrontMotorName("front_left_drive")
            // Adjust the motor directions according to your robot
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .xVelocity(0) // TUNE THIS
            .yVelocity(0); // TUNE THIS

    public static PinpointConstants localizerConstants = new PinpointConstants()
            // Adjust the pod distances according to this diagram:
            // https://pedropathing.com/_next/static/media/odometry.528df183.png
            .forwardPodY(0)
            .strafePodX(0)
            .distanceUnit(DistanceUnit.INCH) // Measure everything in this unit (INCH or MM)
            .hardwareMapName("pinpoint") // Hardware map name of the pinpoint
            // Change this to goBILDA_4_BAR_POD or goBILDA_SWINGARM_POD
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            // Change this to FORWARD or REVERSE according to the pod direction
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);

    // Don't touch this
    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .pinpointLocalizer(localizerConstants)
                .build();
    }
}
