/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.dao.EstudiantesDAO;
import sys.dao.EstudiantesDAOimp;
import sys.model.Estudiantes;

@Named(value = "estudiantesBean")
@ViewScoped
public class EstudiantesBean {

    private List<Estudiantes> listar;
    private Estudiantes estudiante;
    
    public EstudiantesBean() {
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public List<Estudiantes> getListar() {
        EstudiantesDAO edao = new EstudiantesDAOimp();
        listar = edao.mostrar();
        return listar;
    }
    
    public void nuevoestudiante(){
        EstudiantesDAO edao = new EstudiantesDAOimp();
        edao.nuevoestudiante(estudiante);
        estudiante = new Estudiantes();
    }
}