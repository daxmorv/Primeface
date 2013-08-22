/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.xml.wss.util.DateUtils;
import dao.PersonaDAO;
import daoImpl.PersonaDAOImpl;
import entidades.Persona;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.primefaces.event.RowEditEvent;


/**
 *
 * @author root
 */

@Named(value = "controlador")
@ApplicationScoped
public class controlador {

    /**
     * Creates a new instance of controlador
     */
    
    private PersonaDAO personaDAO;
    private String nombre;    
    private String apellido;
    private String edad;
    private String telefono;
    private int id;
    private Date fecha;
    private Date fechamod   ;
    private boolean editar;
    private Persona personaSeleccionada;
    private Persona persona,p;
    private List<Persona> listaPersonas; 
    private String nombreprueba;
    private int mes; 
    private int dia;
    private int año;
  
  
    public controlador() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        System.out.println("iniciandoo....");
        personaDAO= new PersonaDAOImpl();
        listaPersonas = new ArrayList<Persona>();
        editar=true;
     limpiar();
        
    }


    public String getNombreprueba() {
        return nombreprueba;
    }

    public void setNombreprueba(String nombreprueba) {
        this.nombreprueba = nombreprueba;
    }
    
    
    public void consulta(){
       // log.info("****Consultando****");
        System.out.println("llegando al metodo consulta");
       listaPersonas=personaDAO.buscarTodos();
        for (Persona per : listaPersonas) {
            System.out.println("Nombre: "+per.getNombre()+" Apellido: "+per.getApellido());
        }
    }
   public void limpiar(){
       nombre=null;
       apellido=null;   
       edad=null;
       telefono=null;
       fecha=null;
       
   }
    
    public void guardar(){
     
        persona = new Persona();  
        
        if(nombre==null){
                  System.out.println("Ingrese un nombre.....");
              FacesContext context = FacesContext.getCurrentInstance();  
              context.addMessage(null, new FacesMessage("No Guardado"));
        }else{
                  persona.setNombre(nombre);
                  persona.setApellido(apellido);
                  persona.setTelefono(edad);
                  persona.setEdad(telefono);
                  persona.setFechaNacimiento(fecha);
                        
                System.out.println("Guardando......");
                System.out.println("NOmbre......"+nombre);
                System.out.println("Apellido......"+apellido);
                System.out.println("Edad......"+edad);
                System.out.println("Telefono......"+telefono);
                System.out.println("Fecha......"+fecha);
                
                personaDAO.guardar(persona);
              FacesContext context = FacesContext.getCurrentInstance();  
              context.addMessage(null, new FacesMessage("Guardado"));
             
                System.out.println("Guardado......");
        }
   }
    public void editar(Persona p){
        
                System.out.println("Editandooo....");
                System.out.println("NOmbre......"+p.getNombre());
                System.out.println("Apellido......"+p.getApellido());
                System.out.println("Edad......"+p.getEdad());
                System.out.println("Telefono......"+p.getTelefono());
                System.out.println("Fecha......"+p.getFechaNacimiento());
               
                p.setNombre(p.getNombre());
                p.setApellido(p.getApellido());
                p.setEdad(p.getEdad());
                p.setTelefono(p.getTelefono());
                p.setFechaNacimiento(p.getFechaNacimiento());
        
                personaDAO.editar(p);
                FacesContext context = FacesContext.getCurrentInstance();  
                context.addMessage(null, new FacesMessage("Persona Editada"));
    }
    
    public void eliminar(){
        System.out.println("ELIMINANDO......");
     
        System.out.println("ELIMINADO......");
    }
    
    public void actualizar(){
    System.out.println("Seleccionando......");
        if(personaSeleccionada==null){
        System.out.println("Seleccion nula......");    
        }else{
            System.out.println("Seleccion......"+personaSeleccionada);    
        }
    System.out.println("ACTUALIZADO......");    
    }
    public void onEdit(Persona p){
        System.out.println("Editandooo......"+p.getNombre());
         personaSeleccionada.setNombre(p.getNombre());
    //  persona.setNombre(nombre);
    System.out.println("Editado......"+nombre);
    }

    /*
    public void cambioFecha(Date event) {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    FacesContext.getCurrentInstance().addMessage(null,
    new FacesMessage("Fecha seleccionada: " + formatter.format(event.getDate())));
    }*/


    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Date getFechamod() {
        return fechamod;
    }

    public void setFechamod(Date fechamod) {
        this.fechamod = fechamod;
    }
	

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    
    
}
