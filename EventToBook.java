 /*
  * EventToBook class
  * Provides a number of versatile methods that manipulate the properties of an event object
  *
  * Instance variables of the class:
  * @eventTitle - the name of the event of an object
  * @pricePerPerson - the price that each person pays
  * @numOfPeople - total number of people in an event
  */
public class EventToBook {
    private String eventTitle;
    private int pricePerPerson;
    private int numOfPeople;

    /*
     * Default EventToBook constructor
     * Initialises default values
     * Attributes of the constructor:
     * @eventTitle
     * @pricePerPerson
     * @pricePerPerson
     */

    public EventToBook() {
        eventTitle = "none";
        pricePerPerson = 0;
        numOfPeople = 0;
    }

    /* EventToBook Constructor with Parameters
     * Initialises user input as the instance variables of the object
     * Input parameters:
     * type: String, @title
     * type: int, @price
     * type: int, @quantity
     * 
     * Attributes of the constructor:
     * @eventTitle
     * @pricePerPerson
     * @numOfPeople
     */

    public EventToBook(String title, int price, int quantity) {
        eventTitle = title;
        pricePerPerson = price;
        numOfPeople = quantity;
    }

    /*
     * Void method (no return statement) that alters the state of the event's title and sets it as the parameter
     * Attributes of the method:
     * @title
     * @eventTitle
     * 
     * Conditional checks:
     * If the amount of characters of the title exceeds 15 characters, use a substring to force it to conform to 15 characters
     * Otherwise simply set the eventTitle as the title
     */

    public void setTitle(String title) {
        if (title.length() > 15) {
            eventTitle = title.substring(0, 15);
        } else {
            eventTitle = title;
        }
    }

    /*
     * (Getter method): String method that simply returns the eventTitle of the event from the object
     * Attribute of the method:
     * @eventTitle
     */

    public String getTitle() {
        return eventTitle;
    }

    /* (Setter method): void method that sets the pricePerPerson attribute of the current object to the instance variable of price
     * Input parameter:
     * @price
     */

    public void setPrice(int price) {
        this.pricePerPerson = price;
    }

    /* (Getter method): Method that returns the instance variable of pricePerPerson of that object
     * Attributes of the method:
     * @pricePerPerson
     */

    public int getPrice() {
        return pricePerPerson;
    }

    /* (Setter method): Method that alters the state of an event object's numOfPeople attribute to set it as the quantity
     * Input parameter:
     * @quantity
     * Attribute of the method:
     * @quantity
     */

    public void setQuantity(int quantity) {
        this.numOfPeople = quantity;
    }

    /* (Getter method): Method that returns the numOfPeople instance variable associated with an event object
     * Attribute of the method:
     * @numOfPeople
     */

    public int getQuantity() {
        return numOfPeople;
    }

    /* (Getter method): Method that returns the product of pricePerPerson and numOfPeople which equals the total cost of an event
     * Attributes of the method:
     * @pricePerPerson
     * @numOfPeople
     */

    public int getCost() {
        return (pricePerPerson) * (numOfPeople);
    }

    /* String method that returns the attributes of the event (eventTitle, numOfPeople, pricePerPerson) and the total cost of the event
     * Attributes of the method:
     * @eventTitle
     * @numOfPeople
     * @pricePerPerson
     * 
     * User-defined method call:
     * @getCost()
     */

    public String toString() {
        return eventTitle + ": " + numOfPeople + " @" + " $" + pricePerPerson + " = " + "$" + getCost();
    }
}