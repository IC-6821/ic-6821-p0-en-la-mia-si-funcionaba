package gameLogic;

public class App{
    public static void main(String[] args) {
        Game game = new Game(args[1]);
        game.Play();
    }
}
