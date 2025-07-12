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
public class RegistroMascota {
    private ArrayList<Mascota> mascotas;

    public RegistroMascota() {
        mascotas = new ArrayList<>();
    }

       
    //LOS METODOS 
    public boolean guardarMascota(Mascota mascota){
        this.mascotas.add(mascota);
        return true;
    }
    
    public Mascota buscarMascota(String nombre){
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return mascotas.get(i);
            }
        }
        return null;
    }
      
    public boolean eliminarMascota(String nombre) {
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                mascotas.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarMascota(String nombre, Mascota nuevaMascota) {
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                mascotas.set(i, nuevaMascota);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Mascota> getListaMascotas() {
        return mascotas;
    }
}
