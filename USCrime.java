/*
* File: USCrime.java
* Author: Khoger Dosky 
* Date: 03/05/2020
* Purpose: Java program that tests the data located in Crime.csv file 
*/


public class USCrime {

    private int year;
    private int population;
    private float murderManslaughterRate;
    private float robberyRate;       
            
    public USCrime(int year, int population, int violentCrime, float violentCrimerate, int murderManslaughter, 
            float murderManslaughterRate, int rape, float rapeRate, int robbery, float robberyRate, 
            int aggravatedAssault, float aggravatedAssaultRate, int propertyCrime, float propertyCrimeRate, 
            int burglary, float burglaryRate, int LarcenyTheft, float LarcenyTheftRate, 
            int motorVehicleTheft, float motorVehicleTheftRate) {

        this.year = year;
        this.population = population;
        this.robberyRate = robberyRate;
        this.murderManslaughterRate=murderManslaughterRate;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public int getPopulation() {

        return population;
    }

    public void setPopulation(int population) {

        this.population = population;
    }

    public float getMurderRate() {

        return murderManslaughterRate;
    }

    public void setMurderRate(float murderRate) {

        this.murderManslaughterRate = murderRate;
    }

    public float getRobberyRate() {

        return robberyRate;
    }

    public void setRobberyRate(float robberyRate) {

        this.robberyRate = robberyRate;
    }
}
