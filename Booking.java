/*
 * Program Design: An Object-oriented project that incorporates many different classes, methods and attributes
 * to produce a program which saves, edits, or removes events within the Booking object.
 * References: Code assistance from ChatGPT and lecture notes / pracs
 */
 /*
  * Booking class
  * Provides the initial template for the events to be manipulated within the Booking object
  *
  * Instance variables of the class:
  * @customerName - the name of the Customer associated with the Booking
  * @currentDate - the date of the booking
  * @EventToBook[] eventArray - stores all of the events (including its attributes) within the Booking object
  * @static final int CAPACITY = 4 - maximum capacity of the eventArray which is immutable and cannot be changed
  * @int eventCount - declaration of a variable that keeps track of the amount of events stored within eventArray
  */
public class Booking {
    private String customerName;
    private String currentDate;
    private EventToBook[] eventArray;
    private static final int CAPACITY = 4;
    private int eventCount;

    /*
     * Default Booking constructor
     * Initialises default values
     * Attributes of the constructor:
     * @customerName
     * @currentDate
     * @eventArray
     * @eventCount
     */

    public Booking() {
        customerName = "Unknown";
        currentDate = "1 May 2023";
        eventArray = new EventToBook[CAPACITY];
        eventCount = 0;
    }

    /* Booking Constructor with Parameters
     * Initialises user input as the instance variables of the object
     * Input parameters:
     * type: String, @name
     * type: String, @date
     * 
     * Attributes of the constructor:
     * @customerName
     * @currentDate
     * @eventArray
     * @eventCount
     */

    public Booking(String name, String date) {
        customerName = name;
        currentDate = date;

        eventArray = new EventToBook[CAPACITY];
        eventCount = 0;
    }

    /*
     * (Getter method): Method that returns a String type and returns the instance variable customerName
     * Enables other classes to access instance (private) variables of the Booking class
     * Attributes of the method:
     * @customerName
     */

    public String getCustomerName() {
        return customerName;
    }

    /*
     * (Setter method): Method that alters the state of the customerName instance variable and changes it to the parameter
     * Enables other classes to change the state of an instance variable of the Booking class
     * Input parameter:
     * @name
     * 
     * Attributes of the method:
     * @customerName
     * 
     * Note: the "this" keyword refers to the current instance of the object
     */

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    /*
     * (Getter method): Method that returns a String type and returns the instance variable customerName
     * Enables other classes to access instance (private) variables of the Booking class
     * Attributes of the method:
     * @currentDate 
     */

    public String getDate() {
        return currentDate;
    }

    /*
     * (Setter method): Method that alters the state of the currentDate instance variable and changes it to the parameter
     * Enables other classes to change the state of an instance variable of the Booking class
     * 
     * Input parameter:
     * @date
     * 
     * Attributes of the method:
     * @currentDate
     */

    public void setDate(String date) {
        this.currentDate = date;
    }

    /*
     * Method that returns a boolean (true or false) result that passes in the EventToBook class with the event parameter
     * Enables an event to be potentially added to the eventArray
     * Checks for equality with each event in the eventArray; if true return false; otherwise it adds the event object into the current index of the array
     * Checks whether the eventCount is equal to or higher than the capacity. If yes, return false. Otherwise it continues to the final block of code
     * 
     * Input parameter:
     * EventToBook class - event parameter (object associated with the class)
     * 
     * Attributes of the method:
     * @event - object of the EventToBook calss
     * @eventArray - array of objects within the Booking class that saves an event per indice
     * @CAPACITY - immutable integer variable defined at 4 that provides a hard limit on the amount of objects the @eventArray can hold
     * 
     * User-defined methods called:
     * @getTitle()
     * 
     * Loops of the method:
     * First loop iterates over the eventArray from the first indice (0) until it hits the last object stored in eventArray, which is tracked by the eventCount variable.
     * First If statement checks whether there is an object in the current index (!= null) and if the current title of the event is equal to the one in the index, the booking already exists.
     * Second if statement simply checks whether the eventArray has been completely filled up, tracked by eventCount
     * If none of the if statements are hit, the code hits the final code block and adds the @event object into the current indice of the eventArray, then increments the eventCount
     * 
     * NOTE: Refer to the methods called within this function for extra documentation
     */

    public boolean addEvent(EventToBook event) {
        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i] != null && event.getTitle().equalsIgnoreCase(eventArray[i].getTitle())) { 
                System.out.println("BOOKING ALREADY EXISTS!");
                return false;
            }
        }
        if (eventCount >= CAPACITY) {
            System.out.println("Booking limit is reached.");
            return false;
        }
        eventArray[eventCount] = event;
        eventCount++;
        return true;
    }

    /*
     * (Getter method): Method that returns an integer value of the sum total of people in the eventArray
     * Attributes of the method:
     * @totalPeople - keeps track of the total amount of people in the eventArray
     * 
     * User-defined methods called:
     * @getQuantity()
     * 
     * Loop of the method:
     * Iterates through the eventArray from indice 0 until the value of eventCount. 
     * If the eventArray has an object stored in the indice, then start to tally up the quantity of people from taht object
     * Calls the getQuantity method on the current object within the eventArray provided the if statement is hit and adds it to totalPeople
     * Once the loop finishes, return the totalPeople attribute
     */

    public int getTotalNumPeople() {
        int totalPeople = 0;

        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i] != null) {
                totalPeople += eventArray[i].getQuantity();
            }
        }
        return totalPeople;
    }

    /*
     * (Getter method): Method that returns an integer value of adding together each of the costs per event in the eventArray
     * Attributes of the method:
     * @totalCost - tracks the total amount of money that the Booking is worth
     * 
     * User-defined methods:
     * @getCost()
     * 
     * Loop of the method:
     * Refer to getTotalNumPeople for an explanation of the method - more or less the same one
     */

    public int getTotalCost() {
        int totalCost = 0;

        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i] != null) {
                totalCost += eventArray[i].getCost();
            }
        }
        return totalCost;
    }

    /*
     * Method that returns a String value which prints out all of the data regarding the information of a booking
     * Attributes of the method:
     * @data - stores the data from the eventArray and the Booking object
     * @eventCount
     * 
     * Loop of the method:
     * Iterates through the eventArray from indice 0 until eventCount
     * If the event has an initialised object, add the data inside to the string and call the toString() method
     * 
     * Data string is returned at the end and whatever data is stored within it will be printed if printTotal() is called
     * 
     * NOTE: Refer to documentation of the methods that are called within this method
     */

    public String printTotal() {
        String data = "";
        if (eventCount == 0) {
            return getCustomerName() + " - " + getDate() + "\nNO BOOKING!"; 
        }
        
        data += getCustomerName() + " - " + getDate() + "\n" + "Total number of people: " + getTotalNumPeople() + "\n";
        
        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i] != null) {
                data += eventArray[i].toString() + ("\n");
            }
        }
        data += "Total: $" + getTotalCost();
        return data;
    }

    /*
     * Method that returns a boolean result (true or false) which modifies an existing event in the eventArray
     * 
     * Input parameters:
     * @eventTitle - used to compare the eventTitle against any entries in the eventArray to see if there's a match
     * @quantity - pass in the new quantity to replace the old quantity of the current object
     * 
     * Loop of the method:
     * Iterates through eventArray
     * First if statement checks if the parameter of quantity is above or equal to 0. you cannot set a quantity as below 0.
     * Second if statement checks each eventTitle of each object in eventArray and compares for equality with the eventTitle parameter
     * If the second if statement is true, then set the new quantity to the corresponding object that has the right eventTitle
     * Print the updated event and then return true
     * 
     * If no event matches, print it was not found and return false
     * 
     */

    public boolean modifyEvent(String eventTitle, int quantity) {
        for (int i = 0; i < eventCount; i++) {
            if (quantity >= 0) {
                if (eventArray[i].getTitle().equalsIgnoreCase(eventTitle)) {
                    String modifyEventTitle = eventArray[i].getTitle();
                    eventArray[i].setQuantity(quantity);
                    System.out.println("[" + modifyEventTitle + "]" + " has been updated!");
                    return true;
                }
            }
        }
        System.out.println("[" + eventTitle + "]" + " not found in the booking.");
        return false;
    }

    /*
     * Boolean method that returns a true or false in terms of whether an event was successfuly removed from the eventArray
     * Input parameter:
     * @eventTitle
     * 
     * Attributes of the method:
     * @eventCount
     * @eventArray
     * @removedEventTitle
     * 
     * Loop of the method:
     * Iterate through eventArray and see whether the parameter of eventTitle matches with any objects in the eventArray
     * If it matches, set a variable that captures the value of eventTitle in the current object. This is so we can reference the value later if it is removed from the booking
     * Shift elements one cell to the left in the nested loop
     * Set the last element to null to avoid duplicate elements in the array after the nested loop finishes
     * Deincrement eventCount
     * Print result
     * return true
     * Otherwise the other code will be hit outside of the if statement and will return false
     * 
     * NOTE: removedEventTitle saves the title name, because if I were to try and access it on line 297, it would have been set to null. So I wouldn't be able to access it
     */

     public boolean removeEvent(String eventTitle) {
        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i].getTitle().equalsIgnoreCase(eventTitle)) {
                String removedEventTitle = eventArray[i].getTitle();
    
                // Shift elements to fill the gap (somewhat complex code here)
                for (int j = i; j < eventCount - 1; j++) {
                    eventArray[j] = eventArray[j + 1];
                }
    
                // Set the last element to null
                eventArray[eventCount - 1] = null;
    
                eventCount--;
    
                System.out.println("[" + removedEventTitle + "]" + " is removed from the booking.");
                return true;
            }
        }
        System.out.println("[" + eventTitle + "]" + " not found in the booking.");
        return false;
    }
    /*
     * Void (no return statement needed) method that resets the eventArray if it has at least 1 event
     * Attributes of the method:
     * @eventCount
     * @eventArray
     * 
     * Loop and conditionals:
     * Checks whether there is at least 1 event
     * Print the contents of eventArray
     * Reset each indice to null if an object has been initialised in it
     * Resets eventCount to 0
     * Otherwise, simply call printTotal() if eventCount == 0
     */

    public void checkOut() {
        if (eventCount > 0) {
            System.out.println(printTotal());
            for (int i = 0; i < eventCount; i++) { 
                eventArray[i] = null;
            } 
            eventCount = 0;
            System.out.println("Thank you & bye...");
        } else {
            System.out.println(printTotal());
        }  
    }
}