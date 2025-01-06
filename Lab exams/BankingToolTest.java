abstract class BankingTool {
    private String toolName;

    protected void setToolName(String name) {
        this.toolName = name;
    }

    public String getToolName() {
        return toolName;
    }
}

interface Audit {
    void performAudit();
}

interface ProductManagement {
    void manageProduct(String productType);
}

class SoftwareTool extends BankingTool implements Audit {
    private String softwareType;

    public SoftwareTool(String toolName, String softwareType) {
        setToolName(toolName);
        this.softwareType = softwareType;
    }

    @Override
    public void performAudit() {
        System.out.println("Auditing the software tool: " + getToolName());
    }
}

class LoanProcessingTool extends SoftwareTool implements ProductManagement {
    private String securityProtocol;

    public LoanProcessingTool(String toolName, String softwareType, String securityProtocol) {
        super(toolName, softwareType);
        this.securityProtocol = securityProtocol;
    }

    @Override
    public void manageProduct(String productType) {
        System.out.println("Managing product: " + productType + " using Loan Processing Tool.");
    }
}

public class BankingToolTest {
    public static void main(String[] args) {
        LoanProcessingTool loanTool = new LoanProcessingTool("Loan Master", "Financial Software", "SSL");
        loanTool.setToolName("Loan Pro");
        System.out.println("Tool Name: " + loanTool.getToolName());
        loanTool.manageProduct("Home Loan");
        loanTool.performAudit();
    }
}