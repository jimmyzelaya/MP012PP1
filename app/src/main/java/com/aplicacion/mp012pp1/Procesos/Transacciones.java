package com.aplicacion.mp012pp1.Procesos;

public class Transacciones
{
    /*Nombre de la BD*/
    public static final String NameDataBase ="DBPM01";

    /*Conexion de tablas de la BD*/
    public static final String tablaEmpleados = "empleados";

    /*Crear campos de la Tabla*/
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    /*Sentencias SQL para crear la tabla*/
    public static final String CreateTablaEmpleados = "CREATE TABLE empleados " +
            "( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT)";

    /*Eliminar tabla*/
    public static final String DropTableEmpleados = "DROP TABLE IF EXISTS empleados";
}
