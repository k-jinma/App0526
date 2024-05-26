package modeloDatos;

import java.time.LocalDate;

public class Cita implements Comparable<Cita>{
    private String codigo;          //予約番号（手入力）
    private LocalDate fechaS;       //登録日
    private LocalDate fechaCita;    //予約日
    private Medico medico;          //患者
    private Paciente paciente;      //医者

    public Cita(String codigo, LocalDate fechaS, LocalDate fechaCita, Medico medico, Paciente paciente) {
        this.codigo = codigo;
        this.fechaS = fechaS;
        this.fechaCita = fechaCita;
        this.medico = medico;
        this.paciente = paciente;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaS() {
        return fechaS;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
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
    

}
