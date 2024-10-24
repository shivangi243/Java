class AuctionSystem {
    
    public static void main(String[] args) {

        OnlineAuctionItem onlineAuctionItem = new OnlineAuctionItem();
        onlineAuctionItem.itemID = 101;
        onlineAuctionItem.itemName = "Antique Vase";
        onlineAuctionItem.startingPrice = 5000.0;
        onlineAuctionItem.category = "Antiques";
        onlineAuctionItem.description = "A rare 18th-century vase.";
        onlineAuctionItem.bidLink = "www.onlineauction.com/antiquevase";
        onlineAuctionItem.bidValidityDays = 7;

        OfflineAuctionItem offlineAuctionItem = new OfflineAuctionItem();
        offlineAuctionItem.itemID = 102;
        offlineAuctionItem.itemName = "Classic Car";
        offlineAuctionItem.startingPrice = 20000.0;
        offlineAuctionItem.category = "Vehicles";
        offlineAuctionItem.description = "A vintage car from the 1960s.";
        offlineAuctionItem.auctionLocation = "New York Auction House";
        offlineAuctionItem.availableSlots = 10;

        onlineAuctionItem.display();
        offlineAuctionItem.display();

    }

}

class AuctionItem {
    
    int itemID;
    String itemName;
    double startingPrice;   
    String category;
    String description;

}

class OnlineAuctionItem extends AuctionItem {

    String bidLink;
    int bidValidityDays;

    void display() {
        System.out.println("------------------------------");
        System.out.println("Item ID: " + itemID);
        System.out.println("Item Name: " + itemName);
        System.out.println("Starting Price: $" + startingPrice);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Bid Link: " + bidLink);
        System.out.println("Bid Validity (days): " + bidValidityDays);
        System.out.println("------------------------------");
    }

}

class OfflineAuctionItem extends AuctionItem {

    String auctionLocation;
    int availableSlots;

    void display() {
        System.out.println("------------------------------");
        System.out.println("Item ID: " + itemID);
        System.out.println("Item Name: " + itemName);
        System.out.println("Starting Price: $" + startingPrice);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Auction Location: " + auctionLocation);
        System.out.println("Available Slots: " + availableSlots);
        System.out.println("------------------------------");
    }

}
