public enum Electric {
    ELECTRIC ("La voiture est électrique"),
    GAZ("La voiture est à essence"),
    HYBRID("La voiture est hybride");
    String msg;
    Electric (String elec){
        this.msg=elec;
    }

    public String getMsg() {
        return msg;
    }
}
