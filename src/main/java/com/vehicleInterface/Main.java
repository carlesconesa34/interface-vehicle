/*
 * Main.java 2026-04-07
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the MIT License.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

import java.util.Scanner;

/**
 * Main menu for the simulation.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car myCar = new Car(0, 0, 1000, true, 100);
        int option;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. MOVE CAR X");
            System.out.println("2. MOVE CAR Y");
            System.out.println("3. SHOW DETAILS CAR");
            System.out.println("4. SIMULATE COLLISION CAR");
            System.out.println("5. REPAIR CAR");
            System.out.println("6. REFILL CAR");
            System.out.println("7. GET MONEY CAR");
            System.out.println("0. LEAVE.");
            System.out.print("OPTION (0..7) ? ");

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    if (myCar.move('x')) {
                        System.out.println("Successfully moved in X.");
                    } else {
                        System.out.println("Action failed: Check petrol or availability.");
                    }
                    break;

                case 2:
                    if (myCar.move('y')) {
                        System.out.println("Successfully moved in Y.");
                    } else {
                        System.out.println("Action failed: Check petrol or availability.");
                    }
                    break;

                case 3:
                    System.out.println(myCar.toString());
                    break;

                case 4:
                    if (myCar.collision()) {
                        System.out.println("Collision occurred! Vehicle is now unavailable.");
                    } else {
                        System.out.println("Vehicle was already in an accident.");
                    }
                    break;

                case 5:
                    if (myCar.repair()) {
                        System.out.println("Vehicle repaired successfully.");
                    } else {
                        System.out.println("Repair failed: Ensure you have $500 and the car is broken.");
                    }
                    break;

                case 6:
                    if (myCar.refill()) {
                        System.out.println("Tank refilled successfully.");
                    } else {
                        System.out.println("Refill failed: Check availability, money, or if tank is already full.");
                    }
                    break;

                case 7:
                    int extra = 100;
                    myCar.setMoney(myCar.getMoney() + extra);
                    System.out.println("Obtained $" + extra + ". Total balance: $" + myCar.getMoney());
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}