package participant;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void getName() {
        Player person = new Person("Ashish");
        Assert.assertNotNull(person.getName());
        Assert.assertEquals("Ashish", person.getName());
    }
}