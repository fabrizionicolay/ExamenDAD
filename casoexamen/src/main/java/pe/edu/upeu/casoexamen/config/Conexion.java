package pe.edu.upeu.casoexamen.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:postgresql://ec2-34-231-177-125.compute-1.amazonaws.com";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String PASS = "9d4aec3709161b92adea716cbc31e131bd8675c56009680029d4485751b40396";
    private static final String USER = "evsgzohyirrfko";
    private static Connection cx = null;
    
    public static Connection getConn() {
        try {
            Class.forName(DRIVER);
            if (cx == null) {
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return cx;
    }
}
