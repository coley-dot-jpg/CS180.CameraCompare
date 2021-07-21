import java.util.Scanner;

/**
 * Project 1 - CameraCompare.java
 *
 * This programmed is designed to compare 2 cameras and tell the user which one is better.
 *  It receives information about features of both the cameras like wifi capabilities, water resistance,
 *  GPS capabilities, the ability to zoom, the condition of the camera, price, and user rating.
 *  The program uses the existence of WiFi, water resistance, GPS, zoom, and condition to determine a number
 *  to represent the camera's value. Based on the camera's value, user rating, and price the program will
 *  determine which camera is better and display the result.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version February 4, 2019
 */

public class CameraCompare {

    public static void main(String[] args) {
        /**
         * DO NOT REMOVE ANY OF THESE VARIABLES!
         *
         * These should be used by your program to complete the outlined task.
         *
         * You may add variables as you see fit.
         */
        boolean hasWiFi1;
        boolean hasWiFi2;
        boolean isWaterResistant1;
        boolean isWaterResistant2;
        boolean hasGPS1;
        boolean hasGPS2;
        boolean hasZoom1;
        boolean hasZoom2;
        String condition1;
        String condition2;
        double price1;
        double price2;
        int userRating1;
        int userRating2;
        int cameraValue1 = 0;
        int cameraValue2 = 0;
        String bestCamera = "";
        double pVRatio1;
        double pVRatio2;

        Scanner s = new Scanner(System.in);


        /**
         * Part 1 -- Obtaining Camera Details
         */

        // Camera 1 details
        System.out.println("Enter attributes of Camera 1:");  // DO NOT REMOVE THIS LINE

        System.out.println("Is it WiFi enabled? (true/false)");
        hasWiFi1 = s.nextBoolean();

        System.out.println("Is it water resistant? (true/false)");
        isWaterResistant1 = s.nextBoolean();

        System.out.println("Is it GPS enabled? (true/false)");
        hasGPS1 = s.nextBoolean();

        System.out.println("Is the lens able to zoom? (true/false)");
        hasZoom1 = s.nextBoolean();

        System.out.println("What is the condition? (New/Refurbished/Used)");
        s.nextLine();
        condition1 = s.nextLine();

        System.out.println("Enter price from $0.00 to $1000.00");
        price1 = s.nextDouble();

        System.out.println("Enter user rating from 0 to 5");
        userRating1 = s.nextInt();

        /**
         * DO NOT REMOVE THESE LINES
         */
        // Camera 2 details
        System.out.println("======================");
        System.out.println("Enter attributes of Camera 2:");

        System.out.println("Is it WiFi enabled? (true/false)");
        hasWiFi2 = s.nextBoolean();

        System.out.println("Is it water resistant? (true/false)");
        isWaterResistant2 = s.nextBoolean();

        System.out.println("Is it GPS enabled? (true/false)");
        hasGPS2 = s.nextBoolean();

        System.out.println("Is the lens able to zoom? (true/false)");
        hasZoom2 = s.nextBoolean();

        System.out.println("What is the condition? (New/Refurbished/Used)");
        s.nextLine();
        condition2 = s.nextLine();

        System.out.println("Enter price from $0.00 to $1000.00");
        price2 = s.nextDouble();

        System.out.println("Enter user rating from 0 to 5");
        userRating2 = s.nextInt();

        s.close();

        /**
         * Part 2 -- Computing Camera Values
         */

        // Camera 1 value
        if (hasWiFi1) {
            cameraValue1 += 1;
        }

        if (isWaterResistant1) {
            cameraValue1 += 1;
        }

        if (hasGPS1) {
            cameraValue1 += 1;
        }

        if (hasZoom1) {
            cameraValue1 += 1;
        }

        switch(condition1) {
            case "New":
                cameraValue1 += 2;
                break;
            case "Refurbished":
                cameraValue1 += 1;
                break;
        }

        // Camera 2 value
        if (hasWiFi2) {
            cameraValue2 += 1;
        }

        if (isWaterResistant2) {
            cameraValue2 += 1;
        }

        if (hasGPS2) {
            cameraValue2 += 1;
        }

        if (hasZoom2) {
            cameraValue2 += 1;
        }

        switch(condition2) {
            case "New":
                cameraValue2 += 2;
                break;
            case "Refurbished":
                cameraValue2 += 1;
                break;
        }

        /**
         * Part 3 -- Camera Comparison
         */
        price1 = (double) Math.round(price1 * 100) / 100;
        price2 = (double) Math.round(price2 * 100) / 100;
        pVRatio1 = price1 / cameraValue1;
        pVRatio2 = price2 / cameraValue2;

        if (cameraValue1 == cameraValue2 && userRating1 == userRating2 && price1 == price2) {
            bestCamera = "equal";

        } else if (userRating1 == userRating2 && price1 == price2 && cameraValue1 != cameraValue2) {
            if (cameraValue1 > cameraValue2) {
                bestCamera = "cam1";

            } else {
                bestCamera = "cam2";
            }

        } else if (cameraValue1 == cameraValue2 && price1 == price2 && userRating1 != userRating2) {
            if (userRating1 > userRating2) {
                bestCamera = "cam1";

            } else {
                bestCamera = "cam2";
            }

        } else if (userRating1 == userRating2 && cameraValue1 == cameraValue2 && price1 != price2) {
            if (price1 < price2) {
                bestCamera = "cam1";

            } else if (price1 > price2) {
                bestCamera = "cam2";
            }

        } else {
            if (pVRatio1 > pVRatio2) {
                bestCamera = "cam2";

            } else if (pVRatio1 < pVRatio2) {
                bestCamera = "cam1";

            } else if (pVRatio1 == pVRatio2) {
                bestCamera = "equal";
            }
        }

        /**
         * Part 4 -- Comparison Results
         *
         * DO NOT REMOVE THESE LINES
         */
        System.out.println("======================");
        System.out.println("Result of Comparison:");

        switch (bestCamera) {
            case "cam1":
                System.out.println("Camera 1 is better than Camera 2!");
                break;
            case "cam2":
                System.out.println("Camera 2 is better than Camera 1!");
                break;
            case "equal":
                System.out.println("Camera 1 and Camera 2 are equal.");
                break;
        }

    }

}