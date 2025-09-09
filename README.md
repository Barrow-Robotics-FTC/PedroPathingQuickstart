# Pedro Pathing Quickstart Setup

## 1. Install Android Studio
- Download and install the latest [Android Studio](https://developer.android.com/studio) (current version: **Narwhal**).
- If Android Studio is already installed on your laptop, make sure it's the latest version (Narwhal 3).

## 2. Clone the Project
1. In Android Studio, click "Clone Repository" in the top right of teh "Welcome to Android Studio" screen. NOTE: If you are already in the editor, press `File -> Close Project`
3. Enter the repository URL:
   
   ```
   https://github.com/DylDevs/PedroPathingTest
   ```
   This will clone the **Pedro Pathing Quickstart** workspace.

## 3. Configure Constants
In `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/pedroPathing/Constants.java`, configure values to match your robot.  

Pedro Pathing uses **4 sets of constants**:
- **Follower Constants**: PID values, factors, etc. (must be tuned).  
- **Drivetrain Constants**: Robot specs (mass, motor names, directions, etc.).  
- **Localizer Constants**: Odometry solution setup (e.g., GoBilda Pinpoint Computer).  
- **Path Constraints**: Defines when a target is considered “achieved” (rarely needs changes).  

⚠️ If the comment says `// TUNE THIS`, `// Don’t touch this`, or similar, don't touch it as we either don't need to mess with it, or it will be tuned in a later step.

## 4. Connect Robot to Android Studio
1. In Android Studio, go to **File → Settings → Plugins**.  
2. Search for **ADB Wi-Fi** and install the one by *Yury Polek*.  
3. Connect to the **Control Hub Wi-Fi** (note: make sure you are connected to the control hub internet).  
4. Use a **USB → USB-C cable** to connect the laptop to the Control Hub temporarily.  
5. Open the **ADB Wi-Fi tab** (bottom right in Android Studio) and connect to the Control Hub.  
6. Disconnect the USB cable. If successful, you should remain connected via Wi-Fi.  
7. Test the connection:
   - Restart the Control Hub.  
   - Reconnect to its Wi-Fi.  
   - Look under **ADB Wi-Fi → Previously connected devices** and reconnect.  

## 5. Run Localization Test
1. Run this OpMode:
   
   ```
   TeamCode/src/main/java/org/firstinspires/ftc/teamcode/pedroPathing/Tuning.java
   ```
3. Navigate to **Localization Test**.  
4. Open your browser (while connected to the Control Hub) and go to:
   
   ```
   http://192.168.43.1:8001
   ```
   This UI will be referred to as **Panels** in the documentation.  

You should see the robot’s position on the field.  
- Moving **forward** should increase **X**.  
- Moving **left** should increase **Y**.  

## 6. Tuning
Pedro Pathing provides simple **automatic tuners**.  

- **Automatic Tuning Guide**: [Docs](https://pedropathing.com/docs/pathing/tuning/automatic)  
- **PID Basics**: [Docs](https://pedropathing.com/docs/pathing/tuning/pids)  

### Controllers to Tune
1. **Primary & Secondary Translation PIDF**
   [Guide](https://pedropathing.com/docs/pathing/tuning/pids/translational)  
2. **Primary and Secondary Heading PIDF**
   [Guide](https://pedropathing.com/docs/pathing/tuning/pids/heading)  
3. **Primary and Secondary Drive PIDF**
   [Guide](https://pedropathing.com/docs/pathing/tuning/pids/drive)  
   - You can adjust `BrakingStrength` to change braking behavior.
4. **Centripetal Force Factor**
   [Guide](https://pedropathing.com/docs/pathing/tuning/pids/centripetal)  

### Final Checks
- Run validation tests: [Docs](https://pedropathing.com/docs/pathing/tuning/tests)  

At this point, tuning is complete 🎉

## 7. Start Coding!
You’re now ready to build **Autonomous** and **TeleOp** programs with Pedro.

In `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/examples`, you’ll find:
- `PedroAutonomous.java`
- `PedroTeleOp.java`
(These files do not currently exist)

Copy the one you need into:
```
TeamCode/src/main/java/org/firstinspires/ftc/teamcode/TeamCode
```

Use the comments to understand how the code works. From there, modify and expand to create your own **TeleOp** or **Autonomous** programs.
