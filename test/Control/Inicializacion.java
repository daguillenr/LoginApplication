
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author baham
 */
public class Inicializacion {
    
    public Inicializacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void initData() {
    
        UsuarioDAO dao = new UsuarioDAO();
        
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    Usuario a = new Usuario();
    Usuario b = new Usuario();
    Usuario c = new Usuario();
    
    a.setNombre("juan");
    a.setContraseña("1234");
    b.setNombre("pedro");
    b.setContraseña("123");
    c.setNombre("maria");
    c.setContraseña("12345");
    
    usuarios.add(a);
    usuarios.add(b);
    usuarios.add(c);

    //sistema.setUsuarios(usuarios);
       
    for (Usuario u: usuarios){
        System.out.println(u.getNombre());
        System.out.println(u.getContraseña());
        System.out.println("-----------");
        dao.crear(u);
    }
    
    }

      
}
