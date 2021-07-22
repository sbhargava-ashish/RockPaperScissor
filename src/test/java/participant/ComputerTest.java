package participant;

import model.Choice;
import org.junit.Assert;
import org.junit.Test;

import java.security.SecureRandom;

public class ComputerTest {

    private Computer computer;

    @Test
    public void selectChoice() {
        Player computer = new Computer();
        Choice choice = computer.selectChoice();
        Assert.assertNotNull(choice);
        Assert.assertNotNull(computer.getChoice());
        Assert.assertNotNull(computer.getName());
        Assert.assertEquals("Computer", computer.getName());
    }

    @Test
    public void getName() {
        Player computer = new Computer(new SecureRandom());
        Choice choice = computer.selectChoice();
        Assert.assertNotNull(choice);
        Assert.assertNotNull(computer.getName());

    }

    @Test
    public void getChoice() {
        Player computer = new Computer();
        Choice choice = computer.selectChoice();
        Assert.assertNotNull(choice);
        Assert.assertNotNull(computer.getChoice());
    }
}