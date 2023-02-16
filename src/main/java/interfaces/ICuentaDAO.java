/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cuenta;

/**
 *
 * @author naely
 */
public interface ICuentaDAO {

    public Cuenta consultar(Integer id);

    public Cuenta insertar(Cuenta cuenta);

    public Cuenta eliminar(Integer id);

}
