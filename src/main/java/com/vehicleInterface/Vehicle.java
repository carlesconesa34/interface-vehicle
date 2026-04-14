/*
 * Vehicle.java 2026-04-07
 *
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the MIT license.
 * See https://opensource.org/licenses/MIT for more information.
 */
package com.vehicleInterface;

/**
 * Represents a generic vehicle within the simulation.
 *
 * This abstract class provides the core attributes and behaviors shared by all
 * vehicles, including positioning, financial management, and operational
 * status.
 *
 * It cannot be instantiated directly.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public abstract class Vehicle implements Movable {

    /**
     * Current horizontal position of the vehicle.
     */
    private int posX;

    /**
     * Current vertical position of the vehicle.
     */
    private int posY;

    /**
     * Available funds for the vehicle to pay for repairs or fuel.
     */
    private int money;

    /**
     * Operational status of the vehicle.
     */
    private boolean available;

    /**
     * Constructs a Vehicle with specified position, money, and status.
     *
     * @param posX Initial X coordinate.
     * @param posY Initial Y coordinate.
     * @param money Initial funds.
     * @param available Initial operational status.
     */
    public Vehicle(int posX, int posY, int money, boolean available) {
        this.posX = posX;
        this.posY = posY;
        this.money = money;
        this.available = available;
    }

    /**
     * Gets the value of posX.
     *
     * @return the poxX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Sets the value of posX.
     *
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Gets the value of posY.
     *
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets the value of posY.
     *
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Gets the value of money.
     *
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the value of money.
     *
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Gets the value of available.
     *
     * @return available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of available.
     *
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Simulates a vehicle collision.
     *
     * If the vehicle is currently available, its status is changed to false.
     *
     * @return true if the collision was successfully processed; false if it was
     * already disabled.
     */
    @Override
    public boolean collision() {
        if (available) {
            setAvailable(false);
            return true;
        }

        return false;
    }

    /**
     * Returns a string representation of this vehicle.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return "Vehicle ["
                + "posX=" + posX
                + ", posY=" + posY
                + ", money=" + money
                + ", available=" + available
                + ']';
    }
}
