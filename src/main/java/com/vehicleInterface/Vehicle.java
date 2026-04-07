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
 * Class description
 *
 * @author Carles Conesa Mañosa
 * @version 1.0
 * @since 2026-04-07
 */
public class Vehicle {

    // Attributes
    /**
     * Description of attribute1
     */
    private String attribute1;

    /**
     * Description of attribute2
     */
    private int attribute2;

    /**
     * Description of attribute3
     */
    private double attribute3;

    /**
     * Default constructor. Initializes all attributes with default values.
     */
    public Vehicle() {
        this.attribute1 = null;
        this.attribute2 = 0;
        this.attribute3 = 0.0;
    }

    /**
     * Parameterized constructor.
     *
     * @param attribute1 description of parameter
     * @param attribute2 description of parameter
     * @param attribute3 description of parameter
     */
    public Vehicle(String attribute1, int attribute2, double attribute3) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
    }

    // Getters and Setters
    /**
     * Gets the value of attribute1.
     *
     * @return the attribute1
     */
    public String getattribute1() {
        return attribute1;
    }

    /**
     * Sets the value of attribute1.
     *
     * @param attribute1 the attribute1 to set
     */
    public void setattribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    /**
     * Gets the value of attribute2.
     *
     * @return the attribute2
     */
    public int getattribute2() {
        return attribute2;
    }

    /**
     * Sets the value of attribute2.
     *
     * @param attribute2 the attribute2 to set
     */
    public void setattribute2(int attribute2) {
        this.attribute2 = attribute2;
    }

    /**
     * Gets the value of attribute3.
     *
     * @return the attribute3
     */
    public double getattribute3() {
        return attribute3;
    }

    /**
     * Sets the value of attribute3.
     *
     * @param attribute3 the attribute3 to set
     */
    public void setattribute3(double attribute3) {
        this.attribute3 = attribute3;
    }

    // Custom methods
    /**
     * Method description
     */
    public void methodName() {
        // TODO: Implement method
    }

    /**
     * Method description
     *
     * @param param parameter description
     * @return return value description
     */
    public ReturnType anotherMethod(ParamType param) {
        // TODO: Implement method
        return null;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Vehicle{"
                + "attribute1=" + attribute1
                + ", attribute2=" + attribute2
                + ", attribute3=" + attribute3
                + '}';
    }

    /**
     * Main method for testing purposes.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Vehicle obj = new Vehicle();
        // Test your class here
    }
}
