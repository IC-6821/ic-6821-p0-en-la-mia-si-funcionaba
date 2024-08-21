package gamelogic;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        final Game game = new Game(args[1]);
        game.play();
    }
}
