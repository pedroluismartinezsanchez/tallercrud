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
public class Historial {
    private ArrayList<Consulta> consultas;

    public Historial() {
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta);
        }
    }

    public void mostrarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }
    }

    public ArrayList<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}
