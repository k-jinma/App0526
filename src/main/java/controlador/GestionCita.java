/*
 * Realizar la funcionalidad de crear citas solicitando los datos necesarios por teclado.
Para ello se comprobara que el medico y el paciente esten dados de alta en sus respectivos registros y 
que el paciente no teien ya una cita para la misma especialidad.
Gestiona con exceociones todas los casos que consideres nevesarios para esta funcionalidad.
Metodo que borre todas las citas ya pasadas(fecha de cita < fecha actual).
Elimina la informacion(local y bd) de aquellos pacientes cuyos dni nos pasan en una array estatico
 */
package controlador;

import accesobd.GestorBD;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import modeloDatos.*;


/**
 *
 * @author mamiko
 */
public class GestionCita {
    
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Cita> citas;
    private GestorBD gb;

    
    
    
}
