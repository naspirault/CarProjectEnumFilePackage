public enum Color {
    ROUGE("La voiture est rouge"),
    NOIRE("La voiture est noire"),
    BLEUE("La voiture est bleue"),
    BLANCHE("La voiture est blanche"),
    GRISE("La voiture est grise");

    String msg;
    Color (String color){
        this.msg=color;
    }

    public String getMsg() {
        return msg;
    }
}
