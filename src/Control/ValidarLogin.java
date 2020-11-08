
package Control;

import DAO.UsuarioDAO;
//import Entidad.Sistema;
import Entidad.Usuario;
//import Frontera.FramePrincipal;

public class ValidarLogin {
    
    public ValidarLogin(){
        
    }
    
    //private Sistema sistema = FramePrincipal.sistema;
    private UsuarioDAO dao = new UsuarioDAO();
    
    public String verificarLogin (Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return("Longitud Nombre Incorrecta");
    }
        if(!verificarLongitudContraseña(usuario.getContraseña())){
            return("Longitud Contraseña Incorrecta");
        }
    /*    for(Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre()) &&
               u.getContraseña().equals(usuario.getContraseña())){
                return ("Bienvenido");
            }                 
        }    */
        if (dao.leer(usuario) != null){
        return ("Bienvenido");
    }
        return("Datos incorrectos");
    }
    
    
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length() > 1 && nombre.length() <=6);
    }
    public boolean verificarLongitudContraseña (String contraseña){
        return (contraseña.length() >= 3 && contraseña.length() < 6);
    }
    
}
