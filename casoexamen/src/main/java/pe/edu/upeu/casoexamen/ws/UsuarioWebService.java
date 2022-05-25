package pe.edu.upeu.casoexamen.ws;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.casoexamen.dao.UsuarioDao;
import pe.edu.upeu.casoexamen.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.casoexamen.model.Usuario;


@WebService(serviceName = "UsuarioWebService")
public class UsuarioWebService {

    private UsuarioDao dao = new UsuarioDaoImpl();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "readAllUsuario")
    public List<Usuario> readAllUsuario() {
        return dao.readAll();
    }

    @WebMethod(operationName = "readAll2")
    public List<Map<String, Object>> readAll2() {
        return dao.readAll2();
    }
}