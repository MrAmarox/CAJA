package modelo;

public class Vehiculo {
    private String mat, marca, mod, malet;
    private int puer, plaz, year; //tengo un TOC con anio :)

public Vehiculo(){
    mat="";
    marca="";
    mod="";
    malet="";
    puer= 0;
    plaz= 0;
    year= 0;
}



public Vehiculo(String mat, String marca, String mod, String malet, int puer, int plaz, int year) {
    this.mat = mat;
    this.marca = marca;
    this.mod = mod;
    this.malet = malet;
    this.puer = puer;
    this.plaz = plaz;
    this.year = year;
}

public String getMat() {
    return mat;
}

public String getMar() {
    return marca;
}

public String getMod() {
    return mod;
}

public String getMalet() {
    return malet;
}

public int getPuer() {
    return puer;
}

public int getPlaz() {
    return plaz;
}

public int getYear() {
    return year;
}

public void setMat(String mat) {
    this.mat = mat;
}

public void setMar(String marca) {
    this.marca = marca;
}

public void setMod(String mod) {
    this.mod = mod;
}

public void setMaletero(String malet) {
    this.malet = malet;
}

public void setPuer(int puer) {
    this.puer = puer;
}

public void setPlaz(int plaz) {
    this.plaz = plaz;
}

public void setYear(int year) {
    this.year = year;
}
public void Mostrar(){
    System.out.println("Marca: "+marca+"\nModelo: "+mod+"\nMaletero: "+malet+"\nCantidad de puertas: "+puer+"\nPlazas: "+plaz+"\nAño: "+year+"\nMatricula: "+mat);
}
}

