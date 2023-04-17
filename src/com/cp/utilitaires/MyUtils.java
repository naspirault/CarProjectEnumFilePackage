package com.cp.utilitaires;
import java.awt.*;
import java.util.Scanner;
public abstract class MyUtils {
    public static int readInteger(String message, int min, int max) {
    Scanner sc = new Scanner(System.in);
    System.out.print(message);
    while (true) {
        try {
            int result = Integer.parseInt(sc.nextLine());
            if (result >= min && result <= max) {
                return result;
            } else {
                throw new IllegalStateException("La valeur doit être comprise entre "
                        + min + " et " + max + ": " + result);
            }
        }catch (NumberFormatException e ){
            System.out.println("Erreur de format. "  +e );
            System.out.print(message);
        }
        catch (RuntimeException e) {
            System.err.println("Une erreur est survenue: " );
            System.out.print(message);
        }
    }
}

    public static String YesNo (String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while (true){
            try {
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("YES") || (answer.equalsIgnoreCase("NO")))
                    return answer.toUpperCase();
                else {
                    throw new IllegalStateException("La valeur entrée n'est pas YES ou NO");
                }
            } catch (RuntimeException e) {
                System.err.println("Une erreur est survenue : " +e);
                System.out.print(message);
            }
        }
    }

}
