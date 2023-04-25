import java.util.Scanner;

public class Menu {
    public static int menu(){
    int choice;
    Scanner scMenu = new Scanner(System.in);
    System.out.println("1 - Afficher une liste. \n2 - Ajouter \n3 - Supprimer \n4 - Modifier \n5 - Rechercher" +
            "\n9 - Quitter");
    choice = scMenu.nextInt();
    return choice;
}
}
