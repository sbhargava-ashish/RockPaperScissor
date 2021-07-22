package summary;

import logger.Logger;
import model.Result;
import participant.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SummaryService {

    private static Map<Player, Summary> summary = new HashMap<>();

    public static void addResults(Result result, Player... players) {
        Arrays.stream(players).forEach(player -> addResult(result, player));
    }

    public static void addResult(Result result, Player player) {
        Summary summary = SummaryService.summary.get(player);
        if (summary != null) {
            switch (result) {
                case WIN:
                    summary.incWinCount();
                    break;
                case LOSE:
                    summary.incLooseCount();
                    break;
                case TIE:
                    summary.incTieCount();
                    break;
            }
        } else {
            SummaryService.summary.put(player, new Summary());
            addResult(result, player);
        }
    }

    public static void getResultSummary() {
        Logger.spacer();
        Logger.debug("Game played " + summary.size() + " times");
        summary.forEach((player, result) -> {
            Logger.info("Player : " + player.getName() + " : " + result.toString());
        });
        Logger.spacer();
    }

    public static int getSummarySize() {
        return summary.size();
    }

    public static void resetSummary() {
        summary = new HashMap<>();
    }


}
