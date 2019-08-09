/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Estudiantes;

/**
 *
 * @author santi
 */
public interface EstudiantesDAO {
    public List<Estudiantes> mostrar();
    
    public void nuevoestudiante (Estudiantes estudiantes);
}
