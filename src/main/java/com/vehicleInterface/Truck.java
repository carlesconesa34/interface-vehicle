/*
 * Truck.java 2026-04-07
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the MIT License.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Represents a truck in the simulation, including load capacity.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public class Truck extends Vehicle implements Refillable, Repairable {

    /**
     * Current petrol level in liters.
     */
    private int petrol;

    /**
     * Current cargo weight carried by the truck.
     */
    private int load;

    /**
     * Constructs a Truck with specified attributes and load.
     *
     * @param petrol Initial fuel level.
     * @param load Current cargo load.
     */
    public Truck(int posX, int posY, int money, boolean available, int petrol, int load) {
        super(posX, posY, money, available);
        this.petrol = petrol;
        this.load = load;
    }

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
     * Repairs the truck if it is disabled and sufficient funds are available.
     *
     * @return true if repaired; false if funds are low or not broken.
     */
    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.TRUCK) {
            setMoney(getMoney() - Repairable.TRUCK);
            setAvailable(true);
            return true;
        }

        return false;
    }

    /**
     * Moves the truck in the specified direction, consuming fuel.
     *
     * Movement is only possible if the moto is available.
     *
     * @param pos The axis to move along ('x' or 'y').
     * @return true if movement was successful; false otherwise.
     */
    @Override
    public boolean move(char pos) {
        if (isAvailable() && petrol >= Movable.TRUCK_CONSUM) {
            switch (pos) {
                case 'x':
                    setPosX(getPosX() + Movable.TRUCK);
                    break;
                case 'y':
                    setPosY(getPosY() + Movable.TRUCK);
                    break;
                default:
                    throw new AssertionError();
            }

            petrol -= Movable.TRUCK_CONSUM;

            return true;
        }

        return false;
    }

    /**
     * Refills the truck's tank to its maximum capacity.
     *
     * Only possible if the vehicle is operational and has enough money to cover
     * the cost.
     *
     * @return true} if the tank was filled successfully.
     */
    @Override
    public boolean refill() {
        if (isAvailable()) {
            int liters = Refillable.TRUCK - petrol;
            int cost = liters * Refillable.PRICE;

            if (petrol < Refillable.TRUCK && getMoney() >= cost) {
                petrol += liters;
                setMoney(getMoney() - cost);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a string representation of this truck.
     *
     * @return a string representation of the truck
     */
    @Override
    public String toString() {
        return "Truck [petrol=" + petrol + ", load=" + load + super.toString();
    }
}