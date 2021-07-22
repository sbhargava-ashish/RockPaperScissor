package summary;

import model.Result;
import org.junit.Assert;
import org.junit.Test;
import participant.Computer;
import participant.Person;
import participant.Player;

public class SummaryServiceTest {

    @Test
    public void addResults() {
        Player person = new Person("Ashish");
        Player computer = new Computer();
        SummaryService.addResults(Result.TIE, person, computer);
        Assert.assertEquals(2,SummaryService.getSummarySize());
    }

    @Test
    public void addResult() {
        Player person = new Person("Ashish");
        SummaryService.resetSummary();
        SummaryService.addResult(Result.TIE, person);
        Assert.assertEquals(1,SummaryService.getSummarySize());
    }

    @Test
    public void getResultSummary() {
        Player person = new Person("Ashish");
        SummaryService.resetSummary();
        SummaryService.addResult(Result.TIE, person);
        SummaryService.getResultSummary();
        Assert.assertEquals(1,SummaryService.getSummarySize());

    }
}