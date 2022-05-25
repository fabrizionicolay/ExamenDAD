package pe.edu.upeu.casoexamen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.casoexamen.config.Conexion;
import pe.edu.upeu.casoexamen.dao.UsuarioDao;
import pe.edu.upeu.casoexamen.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cn;

    @Override
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<>();
        try {
            String SQL = "select * from usuarios";
            int estado = 0;
            cn = Conexion.getConn();
            ps = cn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIdpersona(rs.getInt("idpersona"));
                user.setIdrol(rs.getInt("idrol"));
                user.setFecha(rs.getString("fechacreacion"));
                if (rs.getBoolean("estado") == true) {
                    estado = 1;
                } else {
                    estado = 0;
                }
                user.setEstado(estado);
                lista.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return lista;
    }

    @Override
    public int create(Usuario user) {
        int x = 0;
        boolean estado = false;
        String SQL = "insert into usuarios(username, password, idpersona, idrol, fechacreacion, estado) values(?, ?, ?, ?, ?, ?)";
        try {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdpersona());
            ps.setInt(4, user.getIdrol());
            ps.setString(5, user.getFecha());
            if (user.getEstado() == 1) {
                estado = true;
            } else {
                estado = false;
            }
            ps.setBoolean(6, estado);
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int update(Usuario user) {
        int x = 0;
        boolean estado = false;
        String SQL = "update usuarios set username=?, password=?, idpersona=?, idrol=?, fechacreacion=?, estado=?) where idusuario=?";
        try {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdpersona());
            ps.setInt(4, user.getIdrol());
            ps.setString(5, user.getFecha());
            if (user.getEstado() == 1) {
                estado = true;
            } else {
                estado = false;
            }
            ps.setBoolean(6, estado);
            ps.setInt(7, user.getIdusuario());
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public Usuario read(int id) {
        Usuario user = new Usuario();
        String SQL = "select * from usuarios where idusuario=?";
        try {
            cn = Conexion.getConn();
            ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIdpersona(rs.getInt("idpersona"));
                user.setIdrol(rs.getInt("idrol"));
                user.setFecha(rs.getString("fechacreacion"));
                user.setEstado(rs.getInt("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "delete from usuarios where idusuario=?";
        try {
            cn = Conexion.getConn();
            ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "select u.idusuario, u.username, p.apellidos, p.nombres, r.nombre  from usuarios as u "
                + "inner join roles as r on u.idrol = r.idrol "
                + "inner join personas as p on u.idpersona = p.idpersona ";
        try {
            cn = Conexion.getConn();
            ps = cn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idusuario", rs.getInt("idusuario"));
                map.put("username", rs.getString("username"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("nombres", rs.getString("nombres"));
                map.put("rol", rs.getString("nombre"));
                lista.add(map);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return lista;
    }
}
