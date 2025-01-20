/**
Calculate the avarage temperature, and give how many days are above the avarage temperature
  1. Take an input from the user (eg. 5)
  2. Prompt the user to enter all the 5 numbers (temperature values)
  3. Calculate the avarage temperature
  4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?
*/

import java.util.Scanner;

public class AvgTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1: Take input for the number of temperatures
        System.out.print("Enter the number of temperature readings: ");
        int numTemps = input.nextInt();

        if (numTemps <= 0) {
            System.out.println("Number of readings must be greater than zero.");
            return;
        }

        // 2: Prompt the user to enter all the temperature values
        double[] temperatures = new double[numTemps];
        double sum = 0;

        for (int i = 0; i < numTemps; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            temperatures[i] = input.nextDouble();
            sum += temperatures[i];
        }

        // 3: Calculate the average temperature
        double average = sum / numTemps;
        System.out.printf("The average temperature is: %.2f\n", average); // format to 2 decimal places

        // 4: Count how many temperatures are above the average
        int aboveAverageCount = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                aboveAverageCount++;
            }
        }

        
        System.out.println("Number of days with temperatures above the average: " + aboveAverageCount);

    }
}