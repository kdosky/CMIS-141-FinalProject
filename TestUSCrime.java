/*
* File: TestUSCrime.java
* Author: Khoger Dosky 
* Date: 03/05/2020
* Purpose: Java program that tests the data located in Crime.csv file 
*/



import java.util.Scanner;


public class TestUSCrime {

    private static long elapsedTime;
    

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long endTime;
        try (Scanner input = new Scanner(System.in)) {
            Crimes crimes = new Crimes("C:\\Users\\Owner\\Desktop\\UMGC\\CMIS 141\\Week 8\\Project\\FinalProject\\src\\Crime.csv");
            printWelcomeMessage();
            char req;
            
            do{
                printRequestMessage();
                req = input.next().charAt(0);
                int result ;
                switch(req){
                    case '1' :
                        double[] percentages = crimes.getPopulationGrowth();
                        for(int i=0;i< percentages.length-1;i++){
                            int year = crimes.getFirstYear()+i;
                            System.out.printf("Population growth percentage from " + year + " to " + (year+1) +" is : %.4f" , percentages[i]);
                            System.out.println("%");
                        }
                        break;
                    case '2' :
                        result = crimes.getYearWithHighestMurder();
                        System.out.println("\nThe Murder rate was highest in " + result);
                        break;
                    case '3':
                        result = crimes.getYearWithLowestMurder();
                        System.out.println("\nThe Murder rate was lowest in " + result);
                        break;
                    case '4' :
                        result = crimes.getYearWithHighestRobery();
                        System.out.println("\nThe Robbery rate was highest in " + result);
                        break;
                    case '5' :
                        result = crimes.getYearWithLowestRobery();
                        System.out.println("\nThe Robbery rate was lowest in " + result);
                        break;
                    case 'Q' :
                        break;
                }
            }while(req!='Q');
        }
        endTime = System.currentTimeMillis();
        elapsedTime = (endTime - startTime)/1000;
        printExitMessage();
    }

    private static void printWelcomeMessage() {

        System.out.println("********** Welcome to the US Crime Statistical Application **************************");
    }

    private static void printRequestMessage() {

        System.out.println("\nEnter the number of the question you want answered. Enter ‘Q’ to quit the program :\n");
        System.out.println("1.  What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2.  What year was the Murder rate the highest?");
        System.out.println("3.  What year was the Murder rate the lowest?");
        System.out.println("4.  What year was the Robbery rate the highest?");
        System.out.println("5.  What year was the Robbery rate the lowest?");
        System.out.println("Q.  Quit the program");
        System.out.print("\nEnter your selection: " );
    }

    private static void printExitMessage() {

        System.out.println("\nThank you for trying the US Crimes Statistics Program.\n");
        System.out.println("Elapsed time in seconds was:" + elapsedTime);
    }
}

