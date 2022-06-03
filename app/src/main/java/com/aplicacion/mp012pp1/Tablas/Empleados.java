package com.aplicacion.mp012pp1.Tablas;

public class Empleados {
    private Integer id;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String correo;

    public Empleados(){}


    public Empleados(Integer id, String nombre, String apellido, Integer edad, String correo){
        this.id =id;
        this.nombres=nombre;
        this.apellidos=apellido;
        this.edad=edad;
        this.correo=correo;

    }

    //Getter

    public Integer getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    //Setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
