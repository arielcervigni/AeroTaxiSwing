package com.AeroTaxi;

public class Usuario {

    private String nombre;
    private String apellido;
    private Integer DNI;
    private Integer edad;
    private String password;

    public Usuario(String nombre, String apellido, Integer DNI, Integer edad, String password){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.edad = edad;
        this.password = password;
    }

    //Este constructor lo podemos usar para hacer pruebas, asi no se pierde tiempo pasando argumentos
    public Usuario(){
        this("Usuario","User",01,1,"");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI=" + DNI +
                ", edad=" + edad +
                ", password="+ password +
                '}';
    }

}
