import java.util.Scanner;

public class DifficultyMenu {
    public GameDifficulty selectDifficulty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la dificultad: 1. Fácil, 2. Medio, 3. Difícil");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new TypeOfDifficulties.EasyDifficulty();
            case 2:
                return new TypeOfDifficulties.MediumDifficulty();
            case 3:
                return new TypeOfDifficulties.HardDifficulty();
            default:
                System.out.println("Opción no válida, seleccionando dificultad fácil por defecto.");
                return new TypeOfDifficulties.EasyDifficulty();
        }
    }
}


