/*
 * Bike.java 2026-04-07
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the MIT License.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Represents a bike in the simulation.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public class Bike extends Vehicle implements Movable, Repairable {

    /**
     * Constructs a new Bike with specified position, funds, and status.
     *
     * @param posX Initial X coordinate.
     * @param posY Initial Y coordinate.
     * @param money Initial amount of money available for repairs.
     * @param available Initial operational status.
     */
    public Bike(int posX, int posY, int money, boolean available) {
        super(posX, posY, money, available);
    }

    /**
     * Moves the bike in the specified direction.
     *
     * Movement is only possible if the bike is available. Unlike motorized
     * vehicles, this does not consume petrol.
     *
     * @param pos The axis to move along ('x' or 'y').
     * @return true if movement was successful; false otherwise.
     */
    @Override
    public boolean move(char pos) {
        if (isAvailable()) {
            switch (pos) {
                case 'x':
                    setPosX(getPosX() + Movable.BIKE);
                    break;
                case 'y':
                    setPosY(getPosY() + Movable.BIKE);
                    break;
                default:
                    throw new AssertionError();
            }

            return true;
        }

        return false;
    }

    /**
     * Repairs the bike if it is disabled and sufficient funds are available.
     *
     * @return true if repaired; false if funds are low or not broken.
     */
    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.BIKE) {
            setMoney(getMoney() - Repairable.BIKE);
            setAvailable(true);
            return true;
        }

        return false;
    }

    /**
     * Returns a string representation of this bike.
     *
     * @return a string representation of the bike
     */
    @Override
    public String toString() {
        return "Bike [" + super.toString() + "]";
    }
}
