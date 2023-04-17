import com.cp.utilitaires.MyUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.util.Comparator.comparing;
public class MainCarProject {
        public static void main(String[] args) {
            //Création d'objet selon les besoins
            Scanner sc = new Scanner(System.in);
            //Tableau dynamique de Car
            ArrayList< Car > arrayOfCar = new ArrayList<>();
            //Variables pour la lecture des infos au clavier
            String brand, model;
            int color;
            Color[] colors = Color.values();
            Color color1 = null;
            int isElec;
            //int doors;
            boolean electric;
            //Variable pour l'arrêt de la boucle
            String loop = "YES";
            int ok = 0;
            //Création de voitures
            Car car1 = new Car("Toyota", "Echo", Color.NOIRE, 3, true);
            Car car2 = new Car("Toyota", "Corolla", Color.ROUGE,4,true);
            Car car3 = new Car("Honda","Civic", Color.ROUGE,4,false);
            //Car carAjout = new Car();
            arrayOfCar.add(car1);
            arrayOfCar.add(car2);
            arrayOfCar.add(car3);

  /*      try(PrintWriter out = new PrintWriter("test.txt")) {
            for(Car line : arrayOfCar) {
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/
            //Affichage des objets créés
/*        System.out.println("Affichage des objets");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
*/
            //Création d'un tableau d'objets
 /*       Car listOfCar[]  = { new Car("Toyota", "Echo", "noire", 3, true),
                new Car("Toyota", "Corolla", "rouge",4,false),
                new Car("Honda","Civic", "rouge",4,true)
        };
        //Affichage du tableau d'objets
        System.out.println("\nAffichage du tableau d'objets");
        for (Car myCar : listOfCar ){
            System.out.println(myCar);
        }*/

            //Boucle pour l'ajout de voiture dans le arrayList
            while (loop.equalsIgnoreCase("YES")) {
                //Ajouter un Car avec des données capturées au clavier
                System.out.print("Entrez la marque de la voiture: ");
                brand = sc.next();
                System.out.print("Entrez le modèle de la voiture: ");
                model = sc.next();
                System.out.println("Entrez la couleur de la voiture: ");
                //Boucle pour afficher toutes les couleurs
                for (Color col : colors)
                {
                    // use getter method to get the value
                    System.out.println("Couleur : " + col.name() + "  -  Choix : " + col.ordinal() );
                }
                System.out.print("Entrez votre choix : ");
                color = sc.nextInt(); //Choix en int
                String couleur = colors[color].name();  //transfère du choix en mot à cause du constructeur
                //Utilisation d'une fonction pour vérifier si le texte entré est entre 1 et 8
                String msg = "Entrez un nombre de portes: ";
                int doors = MyUtils.readInteger(msg, 2,10);
                //isElectric est un boolean donc il faut le transformer
                String msgElectric = ("La voiture est électrique? 0-Oui/1-Non: ");
                //isElec = sc.nextInt();
                int elec = MyUtils.readInteger(msgElectric,0,1);
                /*if (isElec.equalsIgnoreCase("oui")) electric = true;
                else electric = false;*/
                electric = elec == 1;

                //Création de l'objet Car avec les propriétés de l'objet
                Car carAjout;
                carAjout = new Car(brand, model, Color.valueOf(couleur.toUpperCase()), doors, electric);
                arrayOfCar.add(carAjout);
                String msgLoop = ("Voulez-vous continuer (YES/NO)? ");
                loop = MyUtils.YesNo(msgLoop);
            }

     /*   System.out.println("\nAffichage du array avec un forEach");
        arrayOfCar.forEach((n) -> System.out.println(n));
        System.out.println("\nAffichage du array avec un forEach sans l'objet");
        arrayOfCar.forEach(System.out::println);

        System.out.println("\nAffichage du array avec un FOR");
        for (int i =0;i<arrayOfCar.size();i++)
            System.out.println(arrayOfCar.get(i));

        System.out.println("Objet indice 2 : " + arrayOfCar.get(2));
        arrayOfCar.remove(2);
        System.out.println("Après le remove()");
        */

            arrayOfCar.forEach(System.out::println);
            try {
                File myObj = new File("fileOfCars");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    // System.out.println(data);
                    // data = data.replaceAll("\"", "");
                    //System.out.println(data);
                    String[] split = data.split(",", 0);
                    int nb = Integer.parseInt(split[3]);
                    int nb2 = Integer.parseInt(split[4]);
                    boolean electBool = Boolean.parseBoolean(split[4]);
                    arrayOfCar.add(new Car(split[0],split[1],Color.valueOf(split[2].toUpperCase()),nb,electBool));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Une erreur est survenue: " + e);
                e.printStackTrace();
            }
            //arrayOfCar.forEach(System.out::println);
            // Collections.sort(arrayOfCar, new SortByBrand());

            //Trier le tableau
            // System.out.println("\nTrier par marque, modèle et est électrique");
            arrayOfCar.sort(
                    comparing(Car::getBrand)                   // comparer par marque
                            .thenComparing(Car::getModel)         // puis par modele
                            .thenComparing(Car::getIsElectric)      // et par electrique
            );

            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ListOfCars.txt",true)))) {
                for(Car element : arrayOfCar) {
                    out.println(element);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            arrayOfCar.forEach(System.out::println);
            System.out.println("Le nombre de voitures est  : " + Car.nbCars);

        }
 /*       public static int readInteger(String message, int min, int max) {
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
        }*/
    }