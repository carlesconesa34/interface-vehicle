/*
 * Car.java 2026-04-07
 *
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Represents a car in the simulation.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public class Car extends Vehicle implements Refillable, Repairable {

    /**
     * Description of attribute2
     */
    private int petrol;

    /**
     * Default constructor. Initializes all attributes with default values.
     */
    public Car(int posX, int posY, int money, boolean available, int petrol) {
        super(posX, posY, money, available);
        this.petrol = petrol;
    }

    // Getters and Setters
    /**
     * Gets the value of petrol.
     *
     * @return the petrol
     */
    public int getPetrol() {
        return petrol;
    }

    /**
     * Sets the value of petrol.
     *
     * @param petrol the petrol to set
     */
    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    // Custom methods
    /**
     * Method description
     */
    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.CAR) {
            setMoney(getMoney() - Repairable.CAR);
            setAvailable(true);
            return true;
        }

        return false;
    }

    /**
     * Moves the car in the specified direction.
     *
     * Movement is only possible if the bike is available. Unlike motorized
     * vehicles, this does not consume petrol.
     *
     *
     * @param pos The axis to move along ('x' or 'y').
     * @return true if movement was successful; false otherwise.
     */
    @Override
    public boolean move(char pos) {
        if (isAvailable() && petrol >= Movable.CAR_CONSUM) {
            switch (pos) {
                case 'x':
                    setPosX(getPosX() + Movable.CAR);
                    break;
                case 'y':
                    setPosY(getPosY() + Movable.CAR);
                    break;
                default:
                    throw new AssertionError();
            }

            petrol -= Movable.CAR_CONSUM;

            return true;
        }

        return false;
    }

    /**
     * Refills the car's tank to its maximum capacity.
     *
     * Only possible if the vehicle is operational and has enough money to cover
     * the cost.
     *
     * @return true if the tank was filled successfully.
     */
    @Override
    public boolean refill() {
        if (isAvailable()) {
            int liters = Refillable.CAR - petrol;
            int cost = liters * Refillable.PRICE;

            if (petrol < Refillable.CAR && getMoney() >= cost) {
                petrol += liters;
                setMoney(getMoney() - cost);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a string representation of this car.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return "Car [petrol=" + petrol + ", " + super.toString();
    }
}
