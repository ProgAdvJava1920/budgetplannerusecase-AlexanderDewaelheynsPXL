import be.pxl.alexander.BudgetPlanner;
import be.pxl.alexander.entity.Account;
import be.pxl.alexander.util.BudgetPlannerImporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
//import sun.jvm.hotspot.utilities.Assert;

public class BudgetPlannerImporterTest {

    @Test
    public void readFileCreateAccountTest() {
        //BudgetPlanner planner = new BudgetPlanner();
        BudgetPlannerImporter budgetPlannerImporter = new BudgetPlannerImporter();
        Account account= budgetPlannerImporter.readFile("src\\main\\resources\\account_payments.csv");

        Assertions.assertNotEquals(null, account);
    }

    @Test
    public void readFileThrowErrorTest() {
        BudgetPlannerImporter budgetPlannerImporter = new BudgetPlannerImporter();
        Account account = budgetPlannerImporter.readFile("src\\main\\resources\\account_payment.csv");

        // Assertions.assertThrows(IOException.class, () -> {  });
    }
}
