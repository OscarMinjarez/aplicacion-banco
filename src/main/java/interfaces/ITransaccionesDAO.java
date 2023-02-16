/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Transaccion;

/**
 *
 * @author naely
 */
public interface ITransaccionesDAO {

    public Transaccion consultar(Integer id);

    public Transaccion Insertar (Transaccion transaccion);

    public Transaccion eliminar(Integer id);

}
