package gameuserinterface;

public interface UI {
    void showGame(String boardStatus);
    void displayWinMessage();
    void displayLoseMessage();
    void displayTieMessage();
    String[] readHumanPlayerInput();
    void humanPlayerErrorMessage(int execption);
    void computerPlayerErrorMessage();
    void gameConfigErrorMessage();
}
