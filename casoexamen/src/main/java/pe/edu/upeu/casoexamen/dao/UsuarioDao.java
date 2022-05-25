package pe.edu.upeu.casoexamen.dao;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.casoexamen.model.Usuario;

public interface UsuarioDao {
    List<Usuario> readAll();
    int create(Usuario user);
    int update(Usuario user);
    Usuario read(int id);
    int delete(int id);
    List<Map<String, Object>> readAll2();
}
