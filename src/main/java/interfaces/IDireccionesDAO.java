
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Direccion;
import excepciones.PersistenciaException;

/**
 *
 * @author naely
 */
public interface IDireccionesDAO {

    public Direccion consultar(Integer id) throws PersistenciaException;

    public Direccion insertar(Direccion direccion) throws PersistenciaException;

    public Direccion eliminar(Integer id) throws PersistenciaException;

    public Direccion actualizar(Direccion direccion, Direccion actualizacionDireccion) throws PersistenciaException;

}
