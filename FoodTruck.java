package FoodTruckProject;

public class FoodTruck {

    private static int uniqueNumber = 0;
    private int counter = 0;
    private String foodTruckName;
    private String foodType;
    private int rating;

    public FoodTruck(String foodTruckName, String foodType, int rating) {
        counter = uniqueNumber;
        this.counter = counter;
        uniqueNumber++;
        this.foodTruckName = foodTruckName;
        this.foodType = foodType;
        this.rating = rating;
    }

    public String displayFoodTruckInformation(){
        return ("ID Number: " + getCounter() +", Food Truck: " + getFoodTruckName() + ", Food Type: " + getFoodType() + ", Rating: " + getRating());
    }

    @Override
    public String toString() {
        return "FoodTruck{" +
                "foodTruckName='" + foodTruckName + '\'' +
                ", foodType='" + foodType + '\'' +
                ", rating=" + rating +
                '}';
    }

    public int getCounter() {
        return this.counter;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getRating() {
        return rating;
    }
}
