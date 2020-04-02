package FoodTruckProject;

import java.util.Scanner;

public class FoodTruckApplication {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        FoodTruck[] allFoodTrucks = new FoodTruck[5];
        String foodTruckName, foodType, menuOption, numChoice;
        int rating, counter = 0, sumNum = 0, maxNumber = -1;
        boolean choice = true, menuChoice = true;
        String maxFoodTruck = null;

        System.out.println("You can enter up to 5 food trucks in this app.");

        while (choice) {

            while (counter < 5) {
                System.out.println("Please enter the food truck name\n(Enter \"quit\" to exit) ");
                foodTruckName = keyboard.nextLine();

                if (foodTruckName.equalsIgnoreCase("quit")) {
                    break;
                }

                System.out.println("Please enter the food type the truck sells: ");
                foodType = keyboard.nextLine();

                while (true) {
                    System.out.println("Please enter a rating from 1 - 5: ");
                    numChoice = keyboard.nextLine();
                    if(numChoice.equals("1") || numChoice.equals("2") || numChoice.equals("3") || numChoice.equals("4") || numChoice.equals("5")){
                        rating = Integer.parseInt(numChoice);
                        break;
                    } else {
                        System.out.println("You have entered an invalid entry.");
                    }
                }

                allFoodTrucks[counter] = new FoodTruck(foodTruckName, foodType, rating);
                int numRating = allFoodTrucks[counter].getRating();
                sumNum += numRating;

                if (maxNumber == -1) {
                    maxNumber = numRating;
                    maxFoodTruck = allFoodTrucks[counter].displayFoodTruckInformation() + "\nHighest Rating: " + maxNumber;
                } else if (maxNumber < numRating) {
                    maxNumber = numRating;
                    maxFoodTruck = allFoodTrucks[counter].displayFoodTruckInformation() + "\nHighest Rating: " + maxNumber;
                }

                counter++;

            }

            if (counter == 0){
                System.out.println("You did not enter any food trucks. Exiting app.");
                System.exit(0);
                keyboard.close();
            }

            while (menuChoice) {
                System.out.println("MENU:");
                System.out.println("Press #1: List All Trucks");
                System.out.println("Press #2: See Average Rating of Food Trucks");
                System.out.println("Press #3: See Highest-Rated Food Truck");
                System.out.println("Press #4: Quit Program");
                menuOption = keyboard.nextLine();

                switch (menuOption) {
                    case "1":
                        for (FoodTruck eachTruck : allFoodTrucks) {
                            try {
                                System.out.println(eachTruck.displayFoodTruckInformation());
                            } catch (Exception e) {
                                continue;
                            }
                        }
                        break;
                    case "2":
                        System.out.println("Average: " + (sumNum / counter * 1.0));
                        break;
                    case "3":
                        System.out.println(maxFoodTruck);
                        break;
                    case "4":
                        menuChoice = false;
                        break;
                    default:
                        System.out.println("You have entered an invalid entry.");
                }
            }
            keyboard.close();
            choice = false;
        }
    }
}
