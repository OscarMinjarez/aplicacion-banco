
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Transaccion;
import excepciones.PersistenciaException;

/**
 *
 * @author naely
 */
public interface ITransaccionesDAO {

    public Transaccion consultar(Integer id) throws PersistenciaException;

<<<<<<< HEAD
    public Transaccion Insertar(Transaccion transaccion) throws PersistenciaException;
=======
    public Transaccion insertar (Transaccion transaccion)throws PersistenciaException;
>>>>>>> master

    public Transaccion eliminar(Integer id) throws PersistenciaException;

    public Cliente actualizar(Integer id) throws PersistenciaException;
}
