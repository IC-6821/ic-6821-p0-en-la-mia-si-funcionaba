package Players;

import java.util.Scanner;

public class DifficultyMenu {
    public Player selectDifficulty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new TypeOfDifficulties.EasyDifficulty('O');
            case 2:
                return new TypeOfDifficulties.MediumDifficulty('O');
            case 3:
                return new TypeOfDifficulties.HardDifficulty('O');
            default:
                System.out.println("Opción no válida, seleccionando dificultad fácil por defecto.");
                return new TypeOfDifficulties.EasyDifficulty('O');
        }
    }
}



