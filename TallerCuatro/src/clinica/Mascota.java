/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

import java.util.ArrayList;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class Mascota {
    //Atributos de la Mascota
    private String nombre;
    private String especie;
    private int edad;
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private Historial historial;
    
    //Cosntructor de la mascota
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.historial = new  Historial();
        mascotas = new ArrayList<>();
        
    }

    //LOS GET Y SET 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    
    
    
    public void agregarConsulta(Consulta consulta) {
        consultas.add(consulta);
    } 
    
    public void mostrarInfo() {
        System.out.println(" 📋 Mascota: " + nombre + "|  Especie: " + especie + "| Edad: " + edad );
    } 
    
    public void mostrarHistorial() {
        System.out.println("📋 Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial de consultas:");
        /*if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }*/
        historial.mostrarConsultas(); 
    }  
    
      
}
