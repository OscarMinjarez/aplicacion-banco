/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Direccion;

/**
 *
 * @author naely
 */
public interface IDireccionDAO {

    public Direccion consultar(Integer id);

    public Direccion insertar(Direccion direccion);

    public Direccion eliminar(Integer id);

}
