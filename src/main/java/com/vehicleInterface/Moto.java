/*
 * Moto.java 2026-04-07
 *
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Represents a motorcycle in the simulation.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public class Moto extends Vehicle implements Refillable, Repairable {

    /**
     * Current petrol level in liters.
     */
    private int petrol;

    /**
     * Constructs a new Moto with specified attributes.
     *
     * @param petrol Initial petrol level.
     */
    public Moto(int posX, int posY, int money, boolean available, int petrol) {
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

    /**
     * Repairs the moto if it is disabled and sufficient funds are available.
     *
     * @return true if repaired; false if funds are low or not broken.
     */
    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.MOTO) {
            setMoney(getMoney() - Repairable.MOTO);
            setAvailable(true);
            return true;
        }

        return false;
    }

    /**
     * Moves the moto in the specified direction, consuming fuel.
     *
     * Movement is only possible if the moto is available.
     *
     * @param pos The axis to move along ('x' or 'y').
     * @return true if movement was successful; false otherwise.
     */
    @Override
    public boolean move(char pos) {
        if (isAvailable() && petrol >= Movable.MOTO_CONSUM) {
            switch (pos) {
                case 'x':
                    setPosX(getPosX() + Movable.MOTO);
                    break;
                case 'y':
                    setPosY(getPosY() + Movable.MOTO);
                    break;
                default:
                    throw new AssertionError();
            }

            petrol -= Movable.MOTO_CONSUM;

            return true;
        }

        return false;
    }

    /**
     * Refills the moto's tank to its maximum capacity.
     *
     * Only possible if the vehicle is operational and has enough money to cover
     * the cost.
     *
     * @return true if the tank was filled successfully.
     */
    @Override
    public boolean refill() {
        if (isAvailable()) {
            int liters = Refillable.MOTO - petrol;
            int cost = liters * Refillable.PRICE;

            if (petrol < Refillable.MOTO && getMoney() >= cost) {
                petrol += liters;
                setMoney(getMoney() - cost);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a string representation of this moto.
     *
     * @return a string representation of the moto
     */
    @Override
    public String toString() {
        return "Moto [petrol=" + petrol + ", " + super.toString();
    }
}
