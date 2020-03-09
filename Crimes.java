/*
* File: Crime.java
* Author: Khoger Dosky 
* Date: 03/05/2020
* Purpose: Java program that tests the data located in Crime.csv file 
*/



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Crimes {

    private ArrayList<USCrime> data = new ArrayList<>();

    public Crimes(String fileName){
        InputStreamReader isr;
        try {
            isr = new InputStreamReader(new FileInputStream(fileName));
            try (BufferedReader in = new BufferedReader(isr)) {
                initiateData(in);
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void initiateData(BufferedReader in) throws IOException {
        String line;
        in.readLine();
        while((line=in.readLine())!=null){
            USCrime usCrime = parseUSCrime(line);
            data.add(usCrime);
        }
    }

    private USCrime parseUSCrime(String line) {

        String[] lineParts = line.split(",");
        int year = Integer.parseInt(lineParts[0]);
        int population = Integer.parseInt(lineParts[1]);
        int violentCrime = Integer.parseInt(lineParts[2]);
        float violentCrimerate = Float.parseFloat(lineParts[3]);
        int murderManslaughter = Integer.parseInt(lineParts[4]);
        float murderManslaughterRate = Float.parseFloat(lineParts[5]);
        int rape = Integer.parseInt(lineParts[6]);
        float rapeRate = Float.parseFloat(lineParts[7]);
        int robbery = Integer.parseInt(lineParts[8]);
        float robberyRate = Float.parseFloat(lineParts[9]);
        int aggravatedAssault = Integer.parseInt(lineParts[10]);
        float aggravatedAssaultRate = Float.parseFloat(lineParts[11]);
        int propertyCrime = Integer.parseInt(lineParts[12]);
        float propertyCrimeRate = Float.parseFloat(lineParts[13]);
        int burglary = Integer.parseInt(lineParts[14]);
        float burglaryRate = Float.parseFloat(lineParts[15]);
        int LarcenyTheft = Integer.parseInt(lineParts[16]);
        float LarcenyTheftRate = Float.parseFloat(lineParts[17]);
        int motorVehicleTheft = Integer.parseInt(lineParts[18]);
        float motorVehicleTheftRate = Float.parseFloat(lineParts[19]);
        return new USCrime(year, population, violentCrime, violentCrimerate, murderManslaughter, murderManslaughterRate, rape, rapeRate, robbery, robberyRate, aggravatedAssault, aggravatedAssaultRate, propertyCrime, propertyCrimeRate, burglary, burglaryRate, LarcenyTheft, LarcenyTheftRate, motorVehicleTheft, motorVehicleTheftRate);
    }

    public int getYearWithHighestMurder() {

        int highestYear = data.get(0).getYear();
        float max = data.get(0).getMurderRate();
        
        for(USCrime crime : data){
            float currentRate = crime.getMurderRate();
            if(currentRate>max){
                highestYear = crime.getYear();
                max = currentRate;
            }
        }
    return highestYear;
    }

    public int getYearWithLowestMurder() {

        int lowestYear = data.get(0).getYear();
        float min = data.get(0).getMurderRate();
        for(USCrime crime : data){
            float currentRate = crime.getMurderRate();
            if(currentRate<min){
                lowestYear = crime.getYear();
                min = currentRate;
            }
        }
    return lowestYear;
    }

    public int getYearWithHighestRobery() {

        int highestYear = data.get(0).getYear();
        float max = data.get(0).getRobberyRate();
        for(USCrime crime : data){
            float currentRate = crime.getRobberyRate();
            if(currentRate>max){
                highestYear = crime.getYear();
                max = currentRate;
            }
        }
    return highestYear;
    }

    public int getYearWithLowestRobery() {

        int lowestYear = data.get(0).getYear();
        float min = data.get(0).getRobberyRate();
        for(USCrime crime : data){
            float currentRate = crime.getRobberyRate();
            if(currentRate<min){
                lowestYear = crime.getYear();
                min = currentRate;
            }
        }
    return lowestYear;
    }

    public double[] getPopulationGrowth() {
        double growths[] = new double[data.size()];
        for(int i=0;i < data.size()-1;i++){
            int actualPopulation = data.get(i).getPopulation();
            int nextPopulation = data.get(i+1).getPopulation();
            double growth = (double)(nextPopulation-actualPopulation)/actualPopulation;
            growths[i] = 100*growth;
        }
        return growths;
    }

    public int getFirstYear() {

        return data.get(0).getYear();    
    }
}