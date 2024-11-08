import java.util.Scanner;

// Abstract base class
abstract class Device {
    protected String name;
    protected boolean status;

    // Constructor
    public Device(String name) {
        this.name = name;
        this.status = false; // Default status is off
    }

    // Abstract method to toggle device status
    public abstract void toggleStatus();

    // Method to get device status
    public String getStatus() {
        return status ? "ON" : "OFF";
    }
}

// Child class for Lights
class Light extends Device {
    private String brightness;

    public Light(String name) {
        super(name);
        this.brightness = "Medium";
    }

    // Override toggle method and include chaining for setting brightness
    @Override
    public void toggleStatus() {
        status = !status;
        setBrightness("High").setBrightness("Low"); // Method chaining example
        System.out.println(name + " is " + getStatus());
    }

    // Method to set brightness with chaining
    public Light setBrightness(String level) {
        this.brightness = level;
        return this;
    }

    public void displayBrightness() {
        System.out.println("Brightness of " + name + ": " + brightness);
    }
}

// Child class for Security System
class SecuritySystem extends Device {
    private String securityMode;

    public SecuritySystem(String name) {
        super(name);
        this.securityMode = "Disarmed";
    }

    @Override
    public void toggleStatus() {
        status = !status;
        System.out.println(name + " is " + getStatus());
    }

    public void setMode(String mode) {
        this.securityMode = mode;
    }

    public void displayMode() {
        System.out.println("Security mode for " + name + ": " + securityMode);
    }
}

public class SmartHomeAutomation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light livingRoomLight = new Light("Living Room Light");
        SecuritySystem mainSecurity = new SecuritySystem("Main Security");

        // Using StringBuffer to build a description
        StringBuffer description = new StringBuffer();
        description.append("Smart Home Automation System\n")
                   .append("1. Toggle Light\n")
                   .append("2. Toggle Security System\n")
                   .append("3. Set Light Brightness\n")
                   .append("4. Set Security Mode\n")
                   .append("5. Display Device Status\n")
                   .append("6. Exit\n");
        System.out.println(description.toString());

        int choice;
        do {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    livingRoomLight.toggleStatus();
                    break;
                case 2:
                    mainSecurity.toggleStatus();
                    break;
                case 3:
                    System.out.print("Enter brightness (Low, Medium, High): ");
                    String brightness = scanner.nextLine();
                    livingRoomLight.setBrightness(brightness);
                    livingRoomLight.displayBrightness();
                    break;
                case 4:
                    System.out.print("Enter security mode (Armed, Disarmed): ");
                    String mode = scanner.nextLine();
                    mainSecurity.setMode(mode);
                    mainSecurity.displayMode();
                    break;
                case 5:
                    System.out.println(livingRoomLight.name + " is " + livingRoomLight.getStatus());
                    livingRoomLight.displayBrightness();
                    System.out.println(mainSecurity.name + " is " + mainSecurity.getStatus());
                    mainSecurity.displayMode();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
