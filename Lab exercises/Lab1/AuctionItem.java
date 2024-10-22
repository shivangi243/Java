import java.util.Scanner;

class AuctionItem {
    // Attributes
    private String itemName;
    private double startingPrice;
    private double currentBid;
    private String auctionEndTime;
    private boolean isSold;

    // Default constructor (displays initial values)
    public AuctionItem() {
        this.itemName = "Unknown";
        this.startingPrice = 0.0;
        this.currentBid = 0.0;
        this.auctionEndTime = "Not set";
        this.isSold = false;
        System.out.println("Default Constructor:");
        displayItemDetails();
    }

    // Parameterized constructor (takes only 3 attributes)
    public AuctionItem(String itemName, double startingPrice, String auctionEndTime) {
        this.itemName = itemName;
        this.startingPrice = startingPrice;
        this.currentBid = startingPrice;  // Initial bid is same as starting price
        this.auctionEndTime = auctionEndTime;
        this.isSold = false;
    }

    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Item Name: " + this.itemName);
        System.out.println("Starting Price: $" + this.startingPrice);
        System.out.println("Current Bid: $" + this.currentBid);
        System.out.println("Auction End Time: " + this.auctionEndTime);
        System.out.println("Is Sold: " + (this.isSold ? "Yes" : "No"));
        System.out.println("------------------------");
    }

    // Method to place a bid (Overloading Example 1)
    public void placeBid(double bidAmount) {
        if (bidAmount > this.currentBid) {
            this.currentBid = bidAmount;
            System.out.println("Bid placed successfully! New current bid is: $" + this.currentBid);
        } else {
            System.out.println("Bid amount must be higher than the current bid.");
        }
    }

    // Overloaded placeBid method to place bid by percentage increase (Overloading Example 2)
    public void placeBid(int percentageIncrease) {
        double newBid = this.currentBid + (this.currentBid * percentageIncrease / 100.0);
        this.currentBid = newBid;
        System.out.println("Bid placed successfully! New current bid is: $" + this.currentBid);
    }

    // Overloaded Constructor (Constructor Overloading Example)
    public AuctionItem(String itemName, double startingPrice, double currentBid, String auctionEndTime, boolean isSold) {
        this.itemName = itemName;
        this.startingPrice = startingPrice;
        this.currentBid = currentBid;
        this.auctionEndTime = auctionEndTime;
        this.isSold = isSold;
    }

    // Method to close auction and mark item as sold
    public void closeAuction() {
        this.isSold = true;
        System.out.println("Auction closed. " + this.itemName + " is sold for $" + this.currentBid);
    }

    // Main method to test the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompting user for item details (for parameterized constructor)
        System.out.println("Enter the item name:");
        String itemName = sc.nextLine();
        System.out.println("Enter the starting price:");
        double startingPrice = sc.nextDouble();
        sc.nextLine();  // Consume newline
        System.out.println("Enter the auction end time (e.g., 2024-10-20 15:00):");
        String auctionEndTime = sc.nextLine();

        // Creating an AuctionItem using user inputs
        AuctionItem item2 = new AuctionItem(itemName, startingPrice, auctionEndTime);
        item2.displayItemDetails();

        // Placing bids using user input
        System.out.println("Enter a bid amount (greater than current bid):");
        double bidAmount = sc.nextDouble();
        item2.placeBid(bidAmount);

        System.out.println("Enter a percentage increase to place a bid:");
        int percentageIncrease = sc.nextInt();
        item2.placeBid(percentageIncrease);

        // Closing auction
        item2.closeAuction();

        // Prompt for additional item details (for constructor overloading)
        sc.nextLine(); // Consume newline
        System.out.println("\nNow create another auction item with all details.");
        System.out.println("Enter the item name:");
        String itemName2 = sc.nextLine();
        System.out.println("Enter the starting price:");
        double startingPrice2 = sc.nextDouble();
        System.out.println("Enter the current bid:");
        double currentBid2 = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.println("Enter the auction end time (e.g., 2024-10-25 12:00):");
        String auctionEndTime2 = sc.nextLine();
        System.out.println("Is the item sold? (true/false):");
        boolean isSold = sc.nextBoolean();

        // Creating a second AuctionItem using user inputs
        AuctionItem item3 = new AuctionItem(itemName2, startingPrice2, currentBid2, auctionEndTime2, isSold);
        item3.displayItemDetails();

        sc.close(); // Close the scanner
    }
}
