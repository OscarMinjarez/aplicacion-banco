/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;

/**
 *
 * @author naely
 */
public interface IClientesDAO {
    
    
    public Cliente consultar(Integer id);

    public Cliente insertar(Cliente cliente);

    public Cliente eliminar(Integer id);
       
}



