/*
 * Refillable.java 2026-04-07
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the MIT License.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Defines refilling behaviors for specific vehicles.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public interface Refillable {

    public static final int CAR = 100;
    public static final int MOTO = 50;
    public static final int TRUCK = 200;
    public static final int PRICE = 1;

    public boolean refill();
}
