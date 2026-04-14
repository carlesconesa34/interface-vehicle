/*
 * Movable.java 2026-04-07
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the MIT License.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Defines movement behaviors and physical constraints for vehicles.
 *
 * Contains constants for movement distances and fuel consumption rates specific
 * to each vehicle type.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public interface Movable {

    public static final int CAR = 10;
    public static final int MOTO = 8;
    public static final int TRUCK = 7;
    public static final int BIKE = 3;
    public static final int CAR_CONSUM = 10;
    public static final int MOTO_CONSUM = 4;
    public static final int TRUCK_CONSUM = 6;

    public boolean move(char pos);

    public boolean collision();
}