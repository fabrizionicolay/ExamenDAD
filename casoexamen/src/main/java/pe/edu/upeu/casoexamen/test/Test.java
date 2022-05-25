package pe.edu.upeu.casoexamen.test;

import com.google.gson.Gson;
import pe.edu.upeu.casoexamen.config.Conexion;
import pe.edu.upeu.casoexamen.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.casoexamen.dao.UsuarioDao;

public class Test {
    static Gson gson = new Gson();
    static UsuarioDao u = new UsuarioDaoImpl(); 
    public static void main(String[] args) {
        if (Conexion.getConn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
        System.out.println(gson.toJson(u.readAll2()));
    }
}
