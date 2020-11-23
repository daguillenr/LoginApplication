/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TestLogin {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    private String LONG_NOMBRE_INCORRECTO = "Longitud Nombre Incorrecta";
    private String LONG_CONTRASEÑA_INCORRECTA = "Longitud Contraseña Incorrecta";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
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
    public void testLongitudNombre(){
        
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setContraseña("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTO);
        
        u.setNombre("Roberto");
        u.setContraseña("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTO);
    }
    
    @Test
    public void testLongitudContraseña(){
        
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setContraseña("12");
        assertEquals(validarLogin.verificarLogin(u), LONG_CONTRASEÑA_INCORRECTA);
        u.setNombre("Pepe");
        u.setContraseña("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_CONTRASEÑA_INCORRECTA);
    }
    
    @Test
    public void testNombre(){
        
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setContraseña("12345");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
        
    }
    @Test
    public void testContraseña(){
        
        Usuario u = new Usuario();
        u.setNombre("maria");
        u.setContraseña("1234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
        
    }
    @Test
    public void testDatos(){
        
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setContraseña("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
        
    }
    
    @Test
    public void testTodoCorrecto(){
        
        Usuario u = new Usuario();
        
        u.setNombre("juan");
        u.setContraseña("1234");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("pedro");
        u.setContraseña("123");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("maria");
        u.setContraseña("12345");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
}
