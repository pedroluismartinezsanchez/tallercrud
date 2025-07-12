/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class Consulta {
    private String codigo;
    private LocalDate fecha;
    private Veterinario veterinario;

    public Consulta(String codigo, LocalDate fecha, Veterinario veterinario) {
        this.codigo = codigo;
        this.fecha = LocalDate.now();
        this.veterinario = veterinario;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    
    
    public void mostrarConsulta() {
        System.out.println("Consulta Código: " + codigo);
        System.out.println("Fecha: " + fecha);
        if (veterinario != null) {
            veterinario.mostrarPerfil();
        } else {
            System.out.println("Sin veterinario asignado.");
        }
    }
    
    
    
}
