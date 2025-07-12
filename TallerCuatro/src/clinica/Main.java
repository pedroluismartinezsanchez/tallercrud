/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinica;

import clinica.Consulta;
import clinica.Mascota;
import clinica.Propietario;
import clinica.Veterinario;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
// === Registrar propietario ===
        System.out.println("===== REGISTRO DE PROPIETARIO =====");
        
        //Variable con su tipo de dato 
        String nombreProp;                             
        // validamos si en el campo se ingresa correctamente el nombre
        while (true) {   
        //Mensaje para el ususario     
        System.out.print("Nombre del propietario: ");
        //leer linea de texto y elimina los espacios
        nombreProp = sc.nextLine().trim();
        
        //que la variable tenga solo letras mayúsculas/minúsculas y espacios
        if (nombreProp.isBlank()){
            System.out.println("No a ingresado ningun Nombre");
        } else if (nombreProp.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$")) {
        //salgo del if    
            break;  
        //si la condicion no se cumple   
        } else {
            System.out.println("Nombre invalido. Ingrese el Nombre Correcto.");
            }
        }

    
        
        int documento;
        while (true) {
             System.out.print("Documento del propietario: ");
             String input = sc.nextLine().trim(); // leer como texto primero

             // Validar que no esté vacío
             if (input.isEmpty()) {
                 System.out.println("El documento no puede estar vacio.");
                 continue;
             }

             // Validar que solo contenga dígitos numéricos
             if (!input.matches("\\d+")) {
                 System.out.println("El documento solo debe contener numeros.");
                 continue;
             }

             // Validar que tenga mínimo 7 dígitos
             if (input.length() < 7) {
                 System.out.println(" El documento debe tener al menos 7 digitos.");
                 continue;
             }

             // (Opcional) Validar que no tenga más de 10 dígitos
             if (input.length() > 10) {
                 System.out.println("El documento no debe tener mas de 10 digitos.");
                 continue;
             }

             // Si pasa todas las validaciones, lo convertimos a int
             documento = Integer.parseInt(input);
             break;
         }


        
        
        
// === VALIDAR TELÉFONO ===
        int telefono;
        while (true) {
            System.out.print("Telefono del propietario: ");
            String input = sc.nextLine().trim(); // leer como texto primero

             // Validar que no esté vacío
             if (input.isEmpty()) {
                 System.out.println("El numero de telefono no puede estar vacio.");
                 continue;
             }

             // Validar que solo contenga dígitos numéricos
             if (!input.matches("\\d+")) {
                 System.out.println("El telefono solo debe contener numeros.");
                 continue;
             }

             // Validar que el numero no sea diferente a 10 dígitos
             if (input.length() != 10) {
                 System.out.println(" El Telefono debe tener al menos 10 digitos.");
                 continue;
             }

             // Si pasa todas las validaciones, lo convertimos a int
             telefono = Integer.parseInt(input);
             break;
        }
        

        Propietario propietario = new Propietario(nombreProp, documento, telefono);

// === Registrar mascotas ===
        String respuestaMascota;
        do {
            System.out.println("\n--- REGISTRO DE MASCOTA ---");
       
            System.out.print("Nombre de la mascota: ");
            
            String nombreMascota;
            nombreMascota = sc.nextLine().trim();
            while (true) {
                if (nombreMascota.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                    break;
                } else {
                  System.out.println("❌ Nombre de Mascota invalido. Ingrese nombre correcto.");

                }
            }
            System.out.print("Especie: ");
            String especie = sc.nextLine();
            
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            Mascota mascota = new Mascota(nombreMascota, especie, edad);

// === Registrar consultas para esta mascota ===
            




            String respuestaConsulta;
            do {
//tomamos los datos de la consulta                
                System.out.println("\n   > REGISTRO DE CONSULTA");
                
                String codigo = IDGenerator.generarCodigoConsulta();
               LocalDate fecha = null;

while (true) {
    System.out.print("Fecha de la consulta (YYYY-MM-DD): ");
    String input = sc.nextLine().trim();

    if (input.isEmpty()) {
        System.out.println("❌ La fecha no puede estar vacía.");
        continue;
    }

    try {
        fecha = LocalDate.parse(input); // intenta convertir la fecha
        break; // si no lanza error, es válida
    } catch (DateTimeParseException e) {
        System.out.println("❌ Formato de fecha incorrecto. Usa el formato YYYY-MM-DD.");
    }
    
}


                // Registrar veterinario
                System.out.print("Nombre del veterinario: ");
                String nombreVet = sc.nextLine();
                System.out.print("Especialidad del veterinario: ");
                String especialidad = sc.nextLine();

                Veterinario vet = new Veterinario(nombreVet, especialidad);
                Consulta consulta = new Consulta(codigo, fecha, vet);

                mascota.agregarConsulta(consulta);

                System.out.print("¿Desea agregar otra consulta a esta mascota? (s/n): ");
                respuestaConsulta = sc.nextLine().trim().toLowerCase();
            } while (respuestaConsulta.equals("s"));

            propietario.agregarMascota(mascota);

            System.out.print("¿Desea agregar otra mascota? (s/n): ");
            respuestaMascota = sc.nextLine().trim().toLowerCase();
        } while (respuestaMascota.equals("s"));

// === Mostrar ficha clínica ===
        System.out.println("\n===== FICHA CLÍNICA =====");
        System.out.println("👤 Propietario: " + propietario.getNombre());
        System.out.println("🆔 Documento: " + propietario.getDocumento());
        System.out.println("📞 Teléfono: " + propietario.getTelefono());

        for (Mascota m : propietario.getMascotas()) {
            System.out.println("\n📋 Mascota: " + m.getNombre() + " | Especie: " + m.getEspecie() + " | Edad: " + m.getEdad() + " años");
            System.out.println("Historial de consultas:");
            for (Consulta c : m.getConsultas()) {
                System.out.println("Consulta Codigo: " + c.getCodigo());
                System.out.println("Fecha: " + c.getFecha());
                System.out.println("Veterinario: " + c.getVeterinario().getNombre() + " | Especialidad: " + c.getVeterinario().getEspecialidad());
                System.out.println("--------------------------");
            }
        }
    }
    
}
