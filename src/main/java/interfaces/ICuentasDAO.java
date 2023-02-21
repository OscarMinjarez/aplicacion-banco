
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author naely
 */
public interface ICuentasDAO {

    public Cuenta consultar(Integer id) throws PersistenciaException;

    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException;

    public Cuenta eliminar(Integer id) throws PersistenciaException;

    public Cuenta actualizar(Integer id,Cuenta actualizacionCuenta) throws PersistenciaException;

}
