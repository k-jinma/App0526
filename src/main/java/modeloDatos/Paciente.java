package modeloDatos;

public class Paciente implements Comparable<Paciente> {
    
    private String dni;
    private String nombre;
    private String tel;
    
    @Override
    public String toString(){
        return "\nDNI de paciente: "+this.dni+
                "\nNombre: "+this.nombre+
                "\nTelefono: "+this.tel;
    }
    
    @Override
    public boolean equals(Object o){
        Paciente p = (Paciente)o;
        return this.dni.equalsIgnoreCase(p.getDni());
    }
    
    @Override
    public int hashCode(){
        return this.dni.toUpperCase().hashCode();
    }
    
    @Override
    public int compareTo(Paciente t) {
        return this.nombre.compareToIgnoreCase(t.getNombre());
    }
    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    
}
