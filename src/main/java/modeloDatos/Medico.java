package modeloDatos;

public class Medico {

    private int secuencia;  // 連番 1から生成
    private String nombre;
    private String esp;

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
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


    @Override
    public String toString(){
        return "\nNombre: "+this.nombre +
                "\nEspecialidad: "+this.esp;
    }
  
    
}
