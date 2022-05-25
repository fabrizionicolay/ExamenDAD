package pe.edu.upeu.casoexamen.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:postgresql://ec2-54-158-247-210.compute-1.amazonaws.com:5432/d2kn6f4htd8kem";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String PASS = "e7af3d2f59861fbd52be30ced8cc3340b2fe871f4742166deed2ab936047ddac";
    private static final String USER = "gfftgnqnjrbtdj";
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