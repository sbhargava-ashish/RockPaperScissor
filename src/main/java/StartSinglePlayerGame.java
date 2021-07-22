import logger.Logger;
import participant.Person;
import summary.SummaryService;
import game.Game;
import game.SinglePlayerGame;

import java.util.Scanner;

public class StartSinglePlayerGame {

    public static void main(String[] args) {
        showRules();
        boolean exit = false;

        String playerName = enterYourName();
        Person player = new Person(playerName);

        while (!exit) {
            Game game = new SinglePlayerGame(player);
            boolean continuePlay = game.play();
            if(!continuePlay) {
                exit = true;
                SummaryService.getResultSummary();
            } else {
                game.result();
            }
        }
    }

    private static String enterYourName() {
        Logger.info("Please enter your name");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static void showRules() {
        Logger.spacer();
        Logger.info("Welcome to Rock Paper Scissor");
        Logger.spacer();
        Logger.debug("How to play this game :");
        Logger.debug("Rock, Paper, Scissors is a game for two players. Each player simultaneously");
        Logger.debug("choose either Rock , Paper or Scissors and one of them wins or result end up in TIE");
        Logger.debug("Game Continues until one player decide to Quit");
        Logger.debug("Result summary will be provided at the end.");
        Logger.spacer();
    }
}
