package hibernate_4;
// Generated 24-mar-2021 22:28:59 by Hibernate Tools 4.3.1



/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private String codEmpleado;
     private Departamento departamento;
     private String nombreEmpleado;

    public Empleado() {
    }

    public Empleado(String codEmpleado, Departamento departamento, String nombreEmpleado) {
       this.codEmpleado = codEmpleado;
       this.departamento = departamento;
       this.nombreEmpleado = nombreEmpleado;
    }
   
    public String getCodEmpleado() {
        return this.codEmpleado;
    }
    
    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getNombreEmpleado() {
        return this.nombreEmpleado;
    }
    
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }




}


