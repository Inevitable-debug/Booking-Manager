import java.util.Scanner;
 /*
  * SpecialCustomer that extends the Booking class
  * Inherits the methods from the Booking class and provides extra methods to handle the additional functionality of the SpecialCustomer class
  *
  * Instance variables of the class:
  * @totalCost - sum total costs from the eventArray
  * @availablePoints - total amount of points that can be redeemed
  */
public class SpecialCustomer extends Booking {
    private int totalCost;
    private int availablePoints;
    
    /* SpecialCustomer Constructor with a Parameter
     * Initialises the totalCost from the Booking object into the instance variable within the SpecialCustomer object
     * Input parameters:
     * type: int, @totalCost
     * 
     * Attributes of the constructor:
     * @totalCost - derived from the totalCost value of the booking object
     * @availablePoints - setting a storeable availablePoints value in the class
     */

    public SpecialCustomer(int totalCost) {
        this.totalCost = totalCost;
        availablePoints = getAvailablePoints();
    }

    /* Method that returns an integer variable which overrides the Booking class' corresponding method by the same name and method signature
     * Attribute of the method:
     * @totalCost
     * 
     * I overrode the method, as this class already has access to the value of the getTotalCost method. Not overriding it means the method would assume
     * the specialCustomer object has the eventArray, which it does not.
     */
    
    @Override
    public int getTotalCost() {
        return this.totalCost;
    }

    /* (Setter method): Void method that alters the value of the instance variable within the SpecialCustomer class and sets it as the parameter
     * Input parameter:
     * @totalCost 
     */

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    /* Void method that sets the availablePoints as the discountPoints, which is entered by the user in the main program.
     * Input parameter:
     * @discountPoints - entered in the main program by the user
     * Attribute of the method:
     * @availablePoints
     */

    public void setAvailablePoints(int discountPoints) {
        this.availablePoints = discountPoints;
    }

    /* (Getter method): Method that returns the availablePoints of the current object
     * Attribute of the method:
     * @availablePoints
     * NOTE: 'this' keyword refers to the current object
     */

    public int getAvailablePoints() {
        return this.availablePoints;
    }

    /* Void method that adds new points to the availablePoints instance variable
     * Attribute of the method:
     * @availablePoints
     * @totalCost - every $1 is equal to 1 point, so once this is calculated, the program adds it to the total available points
     * 
     * Method called:
     * setAvailablePoints()
     */

    public void collectPoints() {
        setAvailablePoints(availablePoints + totalCost);
    }

    /* Method that returns an integer of the amount of points that can be redeemed.
     * If redeemPoints is below 50 or redeemPoints is higher than availablePoints, return 0
     * Attributes of the method:
     * @redeemPoints
     * @totalCost
     * @pointsRedeemed
     * @availablePoints
     * 
     * User-defined methods called:
     * @getAvailablePoints()
     * @setAvailablePoints()
     * @setTotalCost()
     */

    /* Method that returns an integer of getTotalCost();
     * Attributes of the method:
     * @redeemPointsScanner
     * @redeemPoints
     * @pointsRedeemed
     * 
     * User-defined methods called:
     * @getTotalCost()
     * @setTotalCost()
     * @getAvailablePoints()
     * @setAvailablePoints()
     * @getTotalCost()
     * @collectPoints()
     * 
     * Logic in the loop:
     * The while loop tracks the userinput of redeemPoints
     * The loop terminates if the user enters -1
     * 
     * In the first if statement, this checks whether the redeemPoints value
     * matches the conditions in the assignment spec.
     * If redeemPoints is at least 50 and it does not exceed availablePoints,
     * it performs a number of methods and calculations to successfully redeem
     * the points at a 50:1 ratio of points to discount in dollars.
     * 
     * The rest of the else if statements should be fairly self-explanatory
     */

     public int redeemPoints() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Redeem points? (Y/N)");
        String redeemPointsScanner = scanner.nextLine();
    
        if (redeemPointsScanner.equalsIgnoreCase("y")) {
            int redeemPoints = 0;
            while (redeemPoints != -1) {
                System.out.println("Enter points to be redeemed: -1 to quit:");
                redeemPoints = scanner.nextInt();
    
                if (redeemPoints >= 50 && redeemPoints <= getAvailablePoints()) {
                    int pointsRedeemed = redeemPoints / 50;
                    setTotalCost(getTotalCost() - pointsRedeemed);
                    setAvailablePoints(getAvailablePoints() - redeemPoints);
                    System.out.println("Redeeming " + redeemPoints + " points.");
                    System.out.println("Total to pay: $" + getTotalCost());
                    collectPoints();
                    System.out.println(getTotalCost() + " points added!");
                    System.out.println("Current points: " + getAvailablePoints());
                    System.out.println("Thank you & bye...");
                    redeemPoints = -1;
                } else if (redeemPoints < 50) {
                    System.out.println("Current available points: " + getAvailablePoints());
                    System.out.println("Less than 50! Please retry. Enter -1 to quit.");
                } else if (redeemPoints > getAvailablePoints()) {
                    System.out.println("Current available points: " + getAvailablePoints());
                    System.out.println("Not enough points. Please try. Enter -1 to quit.");
                }
            }
        }
        scanner.close();
        return getTotalCost();
    }
    
    public int applyDiscount() {
        if (totalCost >= 100) {
            int discountAmount = (int) (totalCost * 0.05); 
            setTotalCost(totalCost - discountAmount);
            return totalCost; 
        }
        return getTotalCost();
    }    
}