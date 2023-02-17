/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;

/**
 *
 * @author naely
 */
public interface IClientesDAO {
    
    
    public Cliente consultar(Integer id) throws PersistenciaException;

    public Cliente insertar(Cliente cliente)throws PersistenciaException;

    public Cliente eliminar(Integer id)throws PersistenciaException;
       
}



