import java.util.Scanner;


/* BookingManager class
* This is where the program is run and all of the classes interact with each other to create the program.
* User-defined methods:
* stage1()
* stage2()
* stage3()
* stage4()
*/

public class BookingManager {
    /* Void method that passes in an 'event' parameter that is an object of the EventToBook class
     * Input parameter:
     * type: Class, @event
     * 
     * Attributes of the method: 
     * @scanner
     * 
     * User-defined methods called:
     * @setTitle()
     * @setPrice()
     * @setQuantity()
     */

    public static void stage1(EventToBook event){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the event: ");
        event.setTitle(scanner.nextLine());
        System.out.println("Enter the price per person: ");
        event.setPrice(scanner.nextInt());
        System.out.println("Enter the number of participants: ");
        event.setQuantity(scanner.nextInt());
        System.out.println(event.toString());
        //scanner.close();
    }

    /* Void method that passes in a 'booking' parameter that is an object of the Booking class
     * Input parameter:
     * type: Class, @booking
     * 
     * Attributes of the method: 
     * @scanner
     * @title
     * @price
     * @quantity
     * 
     * User-defined methods called:
     * @setCustomerName()
     * @setDate()
     * @addEvent()
     * 
     * Loop in the method:
     * Tries a block of code at least once (do-while) to add at least 1 potential event
     * An event is initialised with a title and some 0 values.
     * addEvent is improvised to test whether the event exists or not. if it doesn't, reset it back to a default value
     * Otherwise, the loop will continue normally assuming the booking doesn't exist
     * New event object is initialised each time to insert an object into each indice of the eventArray in the booking object
     */
    
    public static void stage2(Booking booking){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the customer: ");
        booking.setCustomerName(scanner.nextLine());
        System.out.println("Enter the current date: ");
        booking.setDate(scanner.nextLine());
        System.out.println(booking.printTotal());

        String userInput = "y";
        do {
            System.out.println("Enter the title of the event: ");
            String title = scanner.nextLine();
            EventToBook newEvent = new EventToBook(title, 0, 0);
            if (!booking.addEvent(newEvent)) {
                newEvent.setTitle("none");
                System.out.println("Add more events? (Y/N)");
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("n")) {
                    break;
                }
                else if (userInput.equalsIgnoreCase("y")) {
                    continue;
                } else {
                    System.out.println("Add more events? (Y/N)");
                    userInput = scanner.nextLine();
                }
            }
            newEvent.setTitle(title);
            System.out.println("Enter the price per person: ");
            int price = scanner.nextInt();
            newEvent.setPrice(price);

            System.out.println("Enter the number of participants: ");
            int quantity = scanner.nextInt();
            newEvent.setQuantity(quantity);
            scanner.nextLine(); //consume the \n

            do {
                System.out.println("Add more events? (Y/N)");
                userInput = scanner.nextLine();
            } while (!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("N"));

        } while (userInput.equalsIgnoreCase("Y"));

        System.out.println(booking.printTotal());
        //scanner.close();
    }

    /* Void method that passes in an 'event' parameter that is an object of the EventToBook class
     * Input parameter:
     * type: Class, @booking
     * 
     * Attributes of the method: 
     * @scanner
     * @removeBookingString
     * @eventTitle
     * @removedEvent
     * @modifyBookingString
     * @newQuantity
     * @modifiedEvent
     * @checkoutString
     * 
     * User-defined methods called:
     * @removeEvent() 
     * @printTotal()
     * @modifyEvent()
     * @checkOut()
     * 
     * NOTE: Consult documentation for how the above methods work
     */

    public static void stage3(Booking booking){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to remove an event in the booking? Y/N");
        String removeBookingString = scanner.nextLine();
        if (removeBookingString.equalsIgnoreCase("Y")) {
            System.out.println("What's the title of the event?");
            String eventTitle = scanner.nextLine();
            booking.removeEvent(eventTitle);
        }
        System.out.println(booking.printTotal());
        System.out.println("Do you want to modify an event in the booking? Y/N");
        String modifyBookingString = scanner.nextLine();
        if (modifyBookingString.equalsIgnoreCase("Y")) {
            System.out.println("Enter the title");
            String eventTitle = scanner.nextLine();
            System.out.println("Please enter the new number of people:");
            int newQuantity = Integer.parseInt(scanner.nextLine().trim()); //Using the trim method consumes the newline character, so any subsequent scanners aren't skipped
            booking.modifyEvent(eventTitle, newQuantity);
        }
        
        System.out.println(booking.printTotal());

        System.out.println("Do you want to checkout? Y/N");
        String checkoutString = scanner.nextLine();

        if (checkoutString.trim().equalsIgnoreCase("Y")) {
            booking.checkOut();
        }
        //scanner.close();
    }

    /* Void method that passes in an 'event' parameter that is an object of the EventToBook class
     * Input parameter:
     * type: Class, @booking
     * 
     * Attributes of the method: 
     * @scanner
     * @removeBookingString
     * @eventTitle
     * @removedEvent
     * @modifyBookingString
     * @newQuantity
     * @modifiedEvent
     * @checkoutString
     * 
     * User-defined methods called:
     * @setCustomerName()
     * @setDate()
     * @addEvent()
     * @setTitle()
     * @setPrice()
     * @setQuantity()
     * @setAvailablePoints()
     * @applyDiscount()
     * @getTotalCost()
     * @setTotalCost()
     * @checkOut()
     * @redeemPoints()
     * 
     * Loop in the method:
     * Between lines 216 and 235 is the same sort of logic in the do-while loop in stage 2. Refer to documentation there.
     * 
     * Last if statement has a substring. The idea behind this was to integrate whether there was a discount or not.
     * This defeated the need to pass in the object contents into my specialCustomer class if I wanted to create an overriding
     * subclass method to override the printTotal method in Booking
     * 
     * NOTE: Consult documentation for how the above methods work
     */

    public static void stage4(Booking booking){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the customer: ");
        booking.setCustomerName(scanner.nextLine());
        System.out.println("Enter the current date: ");
        booking.setDate(scanner.nextLine());
        System.out.println("Enter the available points");
        int availablePoints = Integer.parseInt(scanner.nextLine().trim());
        String userInput = "y";
        do {
            System.out.println("Enter the title of the event: ");
            String title = scanner.nextLine();
            EventToBook newEvent = new EventToBook(title, 0, 0);
            if (!booking.addEvent(newEvent)) {
                newEvent.setTitle("none");
                System.out.println("Add more events? (Y/N)");
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("n")) {
                    break;
                }
                else if (userInput.equalsIgnoreCase("y")) {
                    continue;
                } else {
                    System.out.println("Add more events? (Y/N)");
                    userInput = scanner.nextLine();
                }
            }
            newEvent.setTitle(title);
            System.out.println("Enter the price per person: ");
            int price = scanner.nextInt();
            newEvent.setPrice(price);

            System.out.println("Enter the number of participants: ");
            int quantity = scanner.nextInt();
            newEvent.setQuantity(quantity);
            scanner.nextLine(); //consume the \n

            do {
                System.out.println("Add more events? (Y/N)");
                userInput = scanner.nextLine();
            } while (!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("N"));

        } while (userInput.equalsIgnoreCase("Y"));

        SpecialCustomer specialCustomer = new SpecialCustomer(booking.getTotalCost());
        specialCustomer.setAvailablePoints(availablePoints);
        System.out.println("These are the available points: " + specialCustomer.getAvailablePoints());
        int newTotalCostValue = specialCustomer.applyDiscount();

        if (newTotalCostValue != booking.getTotalCost()) {
            String modifiedTotal = booking.printTotal().replace("Total: $" + booking.getTotalCost(), "Total: $" + newTotalCostValue + " (after 5% discount)");
            specialCustomer.setTotalCost(newTotalCostValue);
            System.out.println(modifiedTotal);
        } else {
            System.out.println(booking.printTotal());
            System.out.println("No discount for a total less than 100.");
            specialCustomer.setTotalCost(newTotalCostValue);
        }
        specialCustomer.redeemPoints();
        //scanner.close();
    }

    public static void main(String[] args) {
        EventToBook event = new EventToBook();
        Booking booking = new Booking();
        Booking special = new Booking();
        System.out.println("************** Stage 1 **************");
        stage1(event);
        System.out.println("************** Stage 2 **************");
        stage2(booking);
        System.out.println("************** Stage 3 **************");
        stage3(booking);
        System.out.println("************** Stage 4 **************");
        stage4(special);
    }
}