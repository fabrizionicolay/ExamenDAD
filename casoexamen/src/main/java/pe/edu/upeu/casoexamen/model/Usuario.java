package pe.edu.upeu.casoexamen.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    private int estado;
    private int idusuario;
    private String username;
    private String password;
    private int idpersona;
    private int idrol;
    private String fecha;
}
