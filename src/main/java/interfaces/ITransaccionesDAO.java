
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import dominio.Transaccion;
import excepciones.PersistenciaException;

/**
 *
 * @author naely
 */
public interface ITransaccionesDAO {

    public Transaccion consultar(Integer id) throws PersistenciaException;

    public Transaccion Insertar(Transaccion transaccion) throws PersistenciaException;

    public Transaccion eliminar(Integer id) throws PersistenciaException;

    public Transaccion actualizar(Integer id) throws PersistenciaException;
}
