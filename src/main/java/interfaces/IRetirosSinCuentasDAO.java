/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.RetiroSinCuenta;

/**
 *
 * @author naely
 */
public interface IRetirosSinCuentasDAO {

    public RetiroSinCuenta consultar(Integer id);

    public RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta);

    public RetiroSinCuenta eliminar(Integer id);

}
