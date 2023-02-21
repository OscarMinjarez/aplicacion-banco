
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author naely
 */
public interface IRetirosSinCuentasDAO {

    public RetiroSinCuenta consultar(Integer id) throws PersistenciaException;

    public RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException;

    public RetiroSinCuenta eliminar(Integer id) throws PersistenciaException;

    public Cliente actualizar(Integer id) throws PersistenciaException;

}
