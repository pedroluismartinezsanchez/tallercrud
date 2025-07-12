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
public class Propietario {
     private String nombre;
     private int documento;
     private int telefono;
     private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Propietario(String nombre, int documento, int telefono) {
        //this.nombre = nombre;
        setNombre(nombre);
        this.documento = documento;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        } 
        this.nombre = nombre;
    }
    
    public int getDocumento() {
        return documento;
    }
 
   

    public int getTelefono() {
        return telefono;
    }
    

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
     
    
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }     
   
    public void mostrarInformacionCompleta(){
        System.out.println("--FICHA CLINICA--");
        System.out.println("? Propietario: " + nombre);
        System.out.println("? Documento: " + documento);
        System.out.println("? Telefono: " + telefono);
        
    }
    
    public void informacionMascota(){
         // Mostrar información de cada mascota       
          if (mascotas.isEmpty()) {
                System.out.println("Este propietario no tiene mascotas registradas.");
          } else {
                for (Mascota m : mascotas) {
                     System.out.println("----------------------");
                     m.mostrarInfo();
                }
            }   
    }
}
