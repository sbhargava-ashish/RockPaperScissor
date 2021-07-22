package participant;

import model.Choice;

public interface Player {

    Choice selectChoice();

    String getName();

    Choice getChoice();
}
