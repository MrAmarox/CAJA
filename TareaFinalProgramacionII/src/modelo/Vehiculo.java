package modelo;

public class Vehiculo {
    private String matricula, marca, modelo, maletero;
    private int puertas, plazas, anio;

public Vehiculo(){
    matricula="";
    marca="";
    modelo="";
    maletero="";
    puertas= 0;
    plazas= 0;
    anio= 0;
}

public Vehiculo(String matricula, String marca, String modelo, String maletero, int puertas, int plazas, int anio) {
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
    this.maletero = maletero;
    this.puertas = puertas;
    this.plazas = plazas;
    this.anio = anio;
}

public String getMatricula() {
    return matricula;
}

public String getMarca() {
    return marca;
}

public String getModelo() {
    return modelo;
}

public String getMaletero() {
    return maletero;
}

public int getPuertas() {
    return puertas;
}

public int getPlazas() {
    return plazas;
}

public int getAnio() {
    return anio;
}

public void setMatricula(String matricula) {
    this.matricula = matricula;
}

public void setMarca(String marca) {
    this.marca = marca;
}

public void setModelo(String modelo) {
    this.modelo = modelo;
}

public void setMaletero(String maletero) {
    this.maletero = maletero;
}

public void setPuertas(int puertas) {
    this.puertas = puertas;
}

public void setPlazas(int plazas) {
    this.plazas = plazas;
}

public void setAnio(int anio) {
    this.anio = anio;
}
public void Mostrar(){
    System.out.println("Marca: "+marca+"\nModelo: "+modelo+"\nMaletero: "+maletero+"\nCantidad de puertas: "+puertas+"\nPlazas: "+plazas+"\nAño: "+anio);
}
}

