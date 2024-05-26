package controlador;

import accesobd.GestorBD;

public class NewMain {

    public static void main(String[] args) {
        //DB接続
        GestorBD gbd = new GestorBD("mysql","bdalameda","root","root");

        //患者リスト作成（DBから抽出）
        GestionCita gc = new GestionCita( gbd );
        gc.setPacientes();
        
        //医者リスト作成（DBから抽出）
        gc.setMedicos();
        
        //予約リスト作成
        gc.setCitas();
        
        
        //患者リスト一覧表示
        gc.dispPacientes();
        
        //医者リスト一覧表示
        gc.dispMedicos();
       
        //予約リスト一覧表示
        gc.dispCitas();
    }
    
}
