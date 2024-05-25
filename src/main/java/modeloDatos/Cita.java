package modeloDatos;

import java.time.LocalDate;
import java.util.List;

public class Cita implements Comparable<Cita>{

    private List<Cita> citas;   //医者は複数の予約をもつ
        
    private String codigo;
    private LocalDate fechaS;
    private LocalDate fechaCita;
    private Medico medico;
    private Paciente paciente;

    public Cita(String codigo, LocalDate fechaS, LocalDate fechaCita, Medico medico, Paciente paciente) {
        this.codigo = codigo;
        this.fechaS = fechaS;
        this.fechaCita = fechaCita;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Cita(String codigo) {
        this.codigo = codigo;
    }

    public Cita(Medico medico) {
        this.medico = medico;
    }

    

    
    
    public Cita() {
    }

    
    @Override
    public String toString(){
        String cadena,cadena2;
        if(this.medico==null)
            cadena = "No hay médico";
        else
            cadena = this.medico.getNombre()+" ";
        if(this.paciente==null)
            cadena2 = "No hay paciente";
        else
            cadena2 = this.paciente.getNombre()+" ";
        return "\nCodigo de cita: "+this.codigo+
                "\nFecha de solicitud: "+this.fechaS+
                "\nFecha de cita: "+this.fechaCita+
                "\nNombre de medico: "+cadena+
                "\nNombre de paciente: "+cadena2;
    }
    
    @Override
    public boolean equals(Object o){
        Cita c = (Cita)o;
        return this.codigo.equalsIgnoreCase(c.getCodigo());
    }
    
    @Override
    public int hashCode(){
        return this.codigo.toUpperCase().hashCode();
    }
    
    @Override
    public int compareTo(Cita t) {
        return this.fechaCita.compareTo(t.getFechaCita());
    }
    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaS() {
        return fechaS;
    }

    public void setFechaS(LocalDate fechaS) {
        this.fechaS = fechaS;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
}
