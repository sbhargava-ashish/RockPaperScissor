package participant;

import logger.Logger;
import model.Choice;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Person implements Player {

    private final String name;

    private final String id = UUID.randomUUID().toString();

    private Scanner scanner;

    private Choice choice;

    public Person(String name) {
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    @Override
    public Choice selectChoice() {
        Choice choice = findChoice();
        if (choice != null) {
            this.setChoice(choice);
            return choice;
        } else {
            return this.selectChoice();
        }
    }

    private void setChoice(Choice choice) {
        this.choice = choice;
    }

    private Choice findChoice() {
        System.out.println("Please select [R] - Rock , [P] - Paper, [S] - Scissor , [Any Other Key] - Quit");
        try {
            char choice = this.scanner.nextLine().toUpperCase().charAt(0);
            switch (choice) {
                case 'R' :
                    return Choice.ROCK;
                case 'P' :
                    return Choice.PAPER;
                case 'S' :
                    return Choice.SCISSOR;
                default:
                    return Choice.QUIT;
            }
        } catch (Exception ex) {
            Logger.error("Invalid Choice");
        }
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Choice getChoice() {
        return this.choice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
