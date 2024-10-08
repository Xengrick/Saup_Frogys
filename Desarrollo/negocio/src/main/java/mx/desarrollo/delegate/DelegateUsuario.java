/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUsuario {
    
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param nombre
     * @param contrasena
     * @return un tipo usuario si no encuntra el usuario sera null
     */
    
    public Usuario login(String nombre, String contrasena){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        
        for(Usuario us:usuarios){
            if(us.getNombreUsuario().equalsIgnoreCase(nombre) && us.getClave().equalsIgnoreCase(contrasena)){
                usuario = us;
            }
        }
        return usuario;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Usuario usuario){
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }
    
}
