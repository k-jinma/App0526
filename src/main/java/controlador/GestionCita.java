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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import modeloDatos.*;

/**
 * コントローラクラス
 * @author mamiko
 */
public class GestionCita {
    
    private ArrayList<Paciente> pacientes;  //患者リスト
    private ArrayList<Medico> medicos;  //医者リスト
    private ArrayList<Cita> citas;  //予約リスト
    
    private GestorBD gb;    //DAO

    /**
     * コンストラクタ
     * @param gb DAO
     */
    public GestionCita( GestorBD gb ) {
        this.gb = gb;
    }  
    

    /**
     * DBから患者リストを抽出する
     */
    public void setPacientes() {
        this.pacientes = gb.obtenerPaciente();
        
    }

    /**
     * DBから医者リストを抽出する
     */
    public void setMedicos() {
        this.medicos = gb.obtenerMedico();
    }
    
    /**
     * 患者一覧表示
     */
    public void dispPacientes(){
        for( Paciente p : this.pacientes ){
            System.out.print( p.getDni() );
            System.out.print(" ");
            System.out.print( p.getNombre() );
            System.out.print(" ");
            System.out.print( p.getTel() );
            System.out.println();
        }
    }
    
    /**
     * 医者一覧表示
     */
    public void dispMedicos(){
        for( Medico m : this.medicos ){
            System.out.print( m.getSecuencia() );
            System.out.print(" ");
            System.out.print( m.getNombre() );
            System.out.print(" ");
            System.out.print( m.getEsp() );
            System.out.println();
        }        
    }
    
    /**
     * 予約一覧表示
     */
    public void dispCitas(){
        for( Cita c : this.citas ){
            System.out.print( c.getCodigo() );
            System.out.print(" ");
            System.out.print( c.getFechaS() );
            System.out.print(" ");
            System.out.print( c.getFechaCita() );
            System.out.print(" ");
            System.out.print( c.getMedico().getNombre() );
            System.out.print(" ");
            System.out.print( c.getPaciente().getNombre() );
            System.out.print(" ");
            System.out.println();
        }          
    }

    /**
     * 予約リスト作成
     */
    public void setCitas() {
        
        this.citas = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        //予約コードを入力
        System.out.print("Input YOYAKU-NO: "); 
        String yoyakuNo = sc.next();
        
        //患者コードを入力
        System.out.print("Input KANJA-NO: "); 
        String dni = sc.next();
        Paciente p = new Paciente();
        p = this.getPaciente(dni);
        
        //先生コードを入力（生成したシーケンスNO 1～）
        System.out.print("Input DOCTOR-SEQUENCE(1~): "); 
        int codigo = sc.nextInt();
        Medico m = new Medico();
        m = this.getMedico(codigo);
        
        //予約作成
        LocalDate dateNow = LocalDate.now(); //今日の日付
        System.out.print("Input YOYAKU-BI(yyyy-MM-dd): ");
        String str = sc.next(); //予約日
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate yoyakuDate = LocalDate.parse(str, formatter);
       
        Cita c = new Cita(yoyakuNo, dateNow, yoyakuDate, m, p);
        
        //予約リストに登録
        citas.add(c);
    }
    
    /**
     * 患者を検索
     * @param dni 患者DNI
     * @return 患者
     */
    private Paciente getPaciente(String dni ){
        for( Paciente p : this.pacientes ){
            if( p.getDni().equals(dni) ){
                return p;
            }
        }
        return null;
    }
    
    /**
     * 先生を検索
     * @param codigo シーケンシャルに生成されたNO
     * @return 先生
     */
    private Medico getMedico(int codigo){
        for( Medico m : this.medicos ){
            if( m.getSecuencia() == codigo ){
                return m;
            }
        }
        return null;
    }
    
    
}
