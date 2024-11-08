import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class
class Item {
    private String name;
    private double startingPrice;
    private double highestBid;
    private String highestBidder;

    public Item(String name, double startingPrice) {
        this.name = name;
        this.startingPrice = startingPrice;
        this.highestBid = startingPrice;
        this.highestBidder = "No bids yet";
    }

    public String getName() {
        return name;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }

    // Overridable method for placing a bid
    public void placeBid(String bidderName, double bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidderName;
            System.out.println("Bid placed successfully!");
        } else {
            System.out.println("Bid amount must be higher than the current highest bid.");
        }
    }

    public void displayInfo() {
        System.out.println("Item: " + name + ", Starting Price: $" + startingPrice + ", Current Highest Bid: $" + highestBid + " by " + highestBidder);
    }
}

// Subclass for luxury items with a minimum bid increase rule
class LuxuryItem extends Item {
    public LuxuryItem(String name, double startingPrice) {
        super(name, startingPrice);
    }

    @Override
    public void placeBid(String bidderName, double bidAmount) {
        // Luxury items require bids to be at least 10% higher than the current highest bid
        if (bidAmount >= getHighestBid() * 1.1) {
            super.placeBid(bidderName, bidAmount);
        } else {
            System.out.println("Luxury items require a bid at least 10% higher than the current highest bid.");
        }
    }
}

// Subclass for regular items with default bidding behavior
class RegularItem extends Item {
    public RegularItem(String name, double startingPrice) {
        super(name, startingPrice);
    }
    // Inherits default placeBid behavior from Item
}

// Auction system managing the items
class AuctionSystem {
    private List<Item> items;
    private boolean auctionOpen;

    public AuctionSystem() {
        items = new ArrayList<>();
        auctionOpen = true;
    }

    public void addItem(String name, double startingPrice, String itemType) {
        Item item;
        if (itemType.equalsIgnoreCase("Luxury")) {
            item = new LuxuryItem(name, startingPrice);
        } else {
            item = new RegularItem(name, startingPrice);
        }
        items.add(item);
        System.out.println("Item added successfully! Current items:");
        for (Item i : items) {
            System.out.println("- " + i.getName());
        }
    }

    public void placeBid(String itemName, String bidderName, double bidAmount) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.placeBid(bidderName, bidAmount);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void viewItems() {
        for (Item item : items) {
            item.displayInfo();
        }
    }

    public void closeAuction() {
        auctionOpen = false;
        System.out.println("Auction closed!");
    }

    public void showWinners() {
        if (auctionOpen) {
            System.out.println("Please close the auction to see the winners.");
            return;
        }
        for (Item item : items) {
            System.out.println("Winner for item " + item.getName() + ": " + item.getHighestBidder() + " with a bid of $" + item.getHighestBid());
        }
    }

    public boolean isAuctionOpen() {
        return auctionOpen;
    }
}

// Main class to drive the auction management system
public class AuctionManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuctionSystem auctionSystem = new AuctionSystem();
        
        while (true) {
            System.out.println("\nAuction Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Place Bid");
            System.out.println("3. View Items");
            System.out.println("4. Close Auction");
            System.out.println("5. Show Winners");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter starting price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter item type (Luxury/Regular): ");
                    String itemType = scanner.nextLine();
                    auctionSystem.addItem(name, price, itemType);
                    break;
                    
                case 2:
                    if (!auctionSystem.isAuctionOpen()) {
                        System.out.println("The auction is closed. No more bids can be placed.");
                        break;
                    }
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String bidderName = scanner.nextLine();
                    System.out.print("Enter your bid amount: ");
                    double bidAmount = scanner.nextDouble();
                    auctionSystem.placeBid(itemName, bidderName, bidAmount);
                    break;
                    
                case 3:
                    auctionSystem.viewItems();
                    break;
                    
                case 4:
                    auctionSystem.closeAuction();
                    break;
                    
                case 5:
                    auctionSystem.showWinners();
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
