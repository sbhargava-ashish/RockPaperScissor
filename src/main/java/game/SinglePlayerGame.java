package game;

import logger.Logger;
import model.Choice;
import model.Result;
import participant.Computer;
import participant.Player;
import summary.SummaryService;

public class SinglePlayerGame implements Game {

    private Player person;

    private Player computer;

    public SinglePlayerGame(final Player person) {
        this.person = person;
        this.computer = new Computer();
    }

    @Override
    public boolean play() {
        Logger.spacer();
        Choice personChoice = person.selectChoice();
        Choice computerChoice = computer.selectChoice();
        if (checkForQuit(personChoice)) {
            return false;
        } else {
            Result result = this.result();
            showResult(result);
            addToResults(result);
            return true;
        }
    }

    private void addToResults(Result result) {
        if(result.equals(Result.TIE)) {
            SummaryService.addResults(Result.TIE, person, computer);
        } else if (result.equals(Result.WIN)) {
            SummaryService.addResult(Result.WIN, person);
            SummaryService.addResult(Result.LOSE, computer);
        } else {
            SummaryService.addResult(Result.LOSE, person);
            SummaryService.addResult(Result.WIN, computer);
        }
    }

    private void showResult(Result result) {
        Logger.debug(person.getName() + " choose : " + person.getChoice() + " and computer chooses : " +
                computer.getChoice() + " and result is that you : " + result.getValue());
    }

    private boolean checkForQuit(Choice personChoice) {
        return personChoice.equals(Choice.QUIT) ? true : false;
    }

    @Override
    public Result result() {

        if(person.getChoice().equals(computer.getChoice())) {
            return Result.TIE;
        }

        switch (person.getChoice()) {
            case ROCK:
                return computer.getChoice().equals(Choice.SCISSOR) ? Result.WIN : Result.LOSE;
            case PAPER:
                return computer.getChoice().equals(Choice.ROCK) ? Result.WIN : Result.LOSE;
            case SCISSOR:
                return computer.getChoice().equals(Choice.PAPER) ? Result.WIN : Result.LOSE;
        }

        return Result.UNSURE;
    }
}
