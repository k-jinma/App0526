package modeloDatos;

public class Medico implements Comparable<Medico>{
    
    
    
    private String codigo;
    private String nombre;
    private String esp;
    public static int secuencia = 1; 

    public Medico(String nombre, String esp) {
        this.codigo = generarCodigo();
        this.nombre = nombre;
        this.esp = esp;
    }

    public Medico(String nombre) {
        this.nombre = nombre;
    }
    
    public Medico() {
    }
    
    public String generarCodigo(){
        String cadena;
        Medico aux = new Medico();
        cadena = aux.getEsp() + Medico.secuencia;
        Medico.secuencia++;
        return cadena;
    }

    @Override
    public String toString(){
        return "\nCodigo: "+this.codigo+
                "\nNombre: "+this.nombre+
                "\nEspecialidad: "+this.esp;
    }
    
    @Override
    public boolean equals(Object o){
        Medico m = (Medico)o;
        return this.nombre.equalsIgnoreCase(m.getNombre());
    }
    
    @Override
    public int hashCode(){
        return this.nombre.toUpperCase().hashCode();
    }
    
    @Override
    public int compareTo(Medico t) {
        return this.nombre.compareToIgnoreCase(t.getNombre());
    }
    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = generarCodigo();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    
    
}
