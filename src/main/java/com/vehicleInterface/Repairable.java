/*
 * Repairable.java 2026-04-07
 *
 *
 * ©Copyright 2026 Carles Conesa Mañosa <a251158cc@correu.escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package com.vehicleInterface;

/**
 * Defines repairing behaviors for vehicles.
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public interface Repairable {

    public static final int CAR = 500;
    public static final int MOTO = 300;
    public static final int TRUCK = 400;
    public static final int BIKE = 50;

    public boolean repair();
}
