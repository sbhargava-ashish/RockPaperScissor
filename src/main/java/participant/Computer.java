package participant;

import model.Choice;

import java.util.Objects;
import java.util.Random;

public class Computer implements Player {

    private Random random;

    private Choice choice;

    private final String name = "Computer";

    public Computer(final Random random) {
        if (random != null) {
            this.random = random;
        } else {
            new Computer();
        }
    }

    public Computer() {
        this.random = new Random();
    }


    @Override
    public Choice selectChoice() {

        int choiceNum = this.random.nextInt(3) + 1;
        Choice choice = findChoice(choiceNum);
        if (choice != null) {
            this.setChoice(choice);
            return choice;
        } else {
            this.setChoice(Choice.QUIT);
            return Choice.QUIT;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Choice getChoice() {
        return this.choice;
    }

    private void setChoice(Choice choice) {
        this.choice = choice;
    }

    private Choice findChoice(int choice) {
        switch (choice) {
            case 1:
                return Choice.ROCK;
            case 2:
                return Choice.PAPER;
            case 3:
                return Choice.SCISSOR;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return name.equals(computer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
