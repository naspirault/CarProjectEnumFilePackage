public class Car {
    private String brand;
    private String model;
    private Color color;
    private int nbDoors;
    private boolean isElectric;
    //Electric isElectric;
    static int nbCars = 0;  //Compteur de voiture

    public Car (){
        Car.nbCars += 1;
    }
    public Car (String aBrand, String aModel, Color aColor, int aNbDoors, boolean aIsElectric){
        brand = aBrand;
        model = aModel;
        color = aColor;
        nbDoors = aNbDoors;
        isElectric= aIsElectric;
        Car.nbCars += 1;}

    public void setBrand(String aBrand) { brand = aBrand; }
    public String getBrand() { return brand; }
    public void setModel(String aModel) { model = aModel;  }
    public String getModel() { return  model; }
    public void setColor(Color aColor){ color = aColor; }
    public String getColor() { return color.msg;  }
    public void setNbDoors(int aNbDoors) { nbDoors = aNbDoors;    }
    public int getNbDoors(){ return nbDoors; }
    public void setElectric(boolean aIsElectric) { isElectric = aIsElectric;    }
    public boolean getIsElectric() {return isElectric; }

    @Override
    public String toString(){
        String txt = "";
        txt = "Voiture { marque = '"+getBrand() +"', ";
        txt += "modèle = '"+getModel()+"', ";
        txt += "couleur = '"+getColor()+"', ";
        txt += "nombre de portes = " +getNbDoors()+", ";
        txt += "est électrique = ";
        if (getIsElectric()==true){
            txt+= " oui ";
        }else txt += " non ";

        return txt;
    }
}

