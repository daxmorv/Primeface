/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Persona;
import java.util.List;

/**
 *
 * @author root
 */
public interface PersonaDAO {
    
    public List<Persona> buscarTodos();
    public  void guardar(Persona p);
    public  void editar(Persona p);
    
}
