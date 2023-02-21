/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import dominio.Direccion;
import interfaces.IClientesDAO;
import java.util.logging.Logger;
import dominio.NombreCompleto;
import excepciones.PersistenciaException;
import interfaces.IDireccionesDAO;
import interfaces.INombresCompletosDAO;
import javax.swing.JOptionPane;
import utils.ValidacionDatos;

/**
 *
 * @author Oscar
 */
public class RegistrarCliente extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(RegistrarCliente.class.getName());
    private final IClientesDAO clientesDAO;
    private final INombresCompletosDAO nombresCompletosDAO;
    private final IDireccionesDAO direccionesDAO;
    
    private Cliente cliente;
    private NombreCompleto nombreCompleto;
    private Direccion direccion;
    
    /**
     * Creates new form RegistrarCliente
     */
    public RegistrarCliente(IClientesDAO clientesDAO, INombresCompletosDAO nombresCompletosDAO, IDireccionesDAO direccionesDAO) {
        this.clientesDAO = clientesDAO;
        this.nombresCompletosDAO = nombresCompletosDAO;
        this.direccionesDAO = direccionesDAO;
        this.cliente = null;
        this.nombreCompleto = null;
        this.direccion = null;
        initComponents();
    }
    
    private NombreCompleto extraerDatosNombreCompleto() throws PersistenciaException {
        String nombres = this.txtNombre.getText();
        String apellidoPaterno = this.txtApellidoPaterno.getText();
        String apellidoMaterno = this.txtApellidoMaterno.getText();
        
        if (nombres.isBlank() || apellidoPaterno.isBlank()) {
            throw new PersistenciaException("Campos necesarios vacíos.");
        }
        
        if (
            !ValidacionDatos.validarSoloLetrasYLongitud(nombres, 50) ||
            !ValidacionDatos.validarSoloLetrasYLongitud(apellidoPaterno, 50) ||
            !ValidacionDatos.validarSoloLetrasYLongitud(apellidoMaterno, 50)
        ) {
            throw new PersistenciaException("Datos inválidos o longitud máxima de caracteres.");
        }
        
        this.nombreCompleto = new NombreCompleto(nombres, apellidoPaterno, apellidoMaterno);
        
        return this.nombreCompleto;
    }
    
    private Direccion extraerDatosDireccion() throws PersistenciaException {
        String calle = this.txtCalle.getText();
        String numeroExterior = this.txtNumeroExterior.getText();
        String numeroInterior = this.txtNumeroInterior.getText();
        String codigoPostal = this.txtCodigoPostal.getText();
        String colonia = this.txtColonia.getText();
        
        if (
            calle.isBlank() ||
            numeroExterior.isBlank() ||
            codigoPostal.isBlank() ||
            colonia.isBlank()
        ) {
            throw new PersistenciaException("Campos necesarios vacíos.");
        }
        
        if (
            !ValidacionDatos.validarSoloLetrasYNumerosYLongitud(calle, 100) ||
            !ValidacionDatos.validarSoloLetrasYNumerosYLongitud(numeroExterior, 10) ||
            !ValidacionDatos.validarSoloLetrasYNumerosYLongitud(numeroInterior, 10) ||
            !ValidacionDatos.validarSoloNumerosYLongitud(codigoPostal, 5) ||
            !ValidacionDatos.validarSoloLetrasYNumerosYLongitud(colonia, 100)
        ) {
            throw new PersistenciaException("Datos inválidos o longitud máxima de caracteres.");
        }
        
        this.direccion = new Direccion(calle, numeroExterior, numeroInterior, codigoPostal, colonia);
        
        return this.direccion;
    }
    
    private Cliente extraerDatosCliente() throws PersistenciaException {
        String fechaDeNacimiento = this.txtAnio.getText() + "/" + this.txtMes.getText() + "/" + this.txtDia.getText();
        String telefono = this.txtNumeroTelefonico.getText();
        String nombreUsuario = this.txtNombreUsuario.getText();
        String contrasenia = this.txtContrasenia.getText();
        
        if (
            this.txtAnio.getText().isBlank() ||
            this.txtMes.getText().isBlank() ||
            this.txtMes.getText().isBlank() ||
            telefono.isBlank() ||
            nombreUsuario.isBlank() ||
            contrasenia.isBlank()
        ) {
            throw new PersistenciaException("Campos necesarios vacíos.");
        }
        
        if (
            !ValidacionDatos.validarSoloNumerosYLongitud(this.txtAnio.getText(), 4) ||
            !ValidacionDatos.validarSoloNumerosYLongitud(this.txtMes.getText(), 2) ||
            !ValidacionDatos.validarSoloNumerosYLongitud(this.txtDia.getText(), 2) ||
            !ValidacionDatos.validarSoloNumerosYLongitud(telefono, 10)
        ) {
            throw new PersistenciaException("Datos inválidos, longitud máxima de caracteres y/o caracteres inválidos");
        }
        
        if (
            ValidacionDatos.validarCadenaConEspacios(nombreUsuario) ||
            nombreUsuario.length() > 20 ||
            ValidacionDatos.validarCadenaConEspacios(contrasenia) ||
            contrasenia.length () > 50
        ) {
            throw new PersistenciaException("Credenciales invalidas.");
        }
        
        this.cliente = new Cliente(null, null, fechaDeNacimiento, telefono, nombreUsuario, contrasenia);
        
        return this.cliente;
    }
    
    private void guardarClienteEnBaseDeDatos() {
        try {
            NombreCompleto nombreCompleto = this.extraerDatosNombreCompleto();
            Direccion direccion = this.extraerDatosDireccion();
            Cliente cliente = this.extraerDatosCliente();
            
            NombreCompleto nombreCompletoGuardado = this.nombresCompletosDAO.insertar(new NombreCompleto(
                    nombreCompleto.getNombres(),
                    nombreCompleto.getApellidoPaterno(),
                    nombreCompleto.getApellidoMaterno()
            ));
            
            Direccion direccionGuardada = this.direccionesDAO.insertar(new Direccion(
                    direccion.getCalle(),
                    direccion.getNumeroExterior(),
                    direccion.getNumeroInterior(),
                    direccion.getCodigoPostal(),
                    direccion.getColonia()
            ));
            
            Cliente clienteGuardado = this.clientesDAO.insertar(new Cliente(
                    nombreCompletoGuardado.getIdNombre(),
                    direccionGuardada.getIdDireccion(),
                    cliente.getFechaNacimiento(),
                    cliente.getTelefono(),
                    cliente.getUsuario(),
                    cliente.getContrasenia()
            ));
            
            this.mostrarMensajeClienteGuardado(nombreCompleto);
        } catch (PersistenciaException e) {
            this.mostrarErrorAlGuardarCliente(e.getMessage());
        }
    }
    
    private void mostrarMensajeClienteGuardado(NombreCompleto nombreCompleto){
        JOptionPane.showConfirmDialog(this, "!Bienvenido " + nombreCompleto.getNombres() + "!", "Éxito", JOptionPane.DEFAULT_OPTION);
    }
    
    private void mostrarErrorAlGuardarCliente(String msg){
        JOptionPane.showMessageDialog(this, "No pudimos crear tu cuenta, intenta otra vez.\n" + msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloRegistrar = new javax.swing.JLabel();
        tituloDatosPersonales = new javax.swing.JLabel();
        tituloFechaDeNacimiento = new javax.swing.JLabel();
        tituloUsuario = new javax.swing.JLabel();
        panelDatosPersonales = new javax.swing.JPanel();
        tituloNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        tituloApellidoPaterno = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        tituloApellidoMaterno = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        panelUsuario = new javax.swing.JPanel();
        tituloNumeroTelefonico = new javax.swing.JLabel();
        txtNumeroTelefonico = new javax.swing.JTextField();
        tituloNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        tituloContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        panelFechaDeNacimiento = new javax.swing.JPanel();
        txtMes = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        mes = new javax.swing.JLabel();
        dia = new javax.swing.JLabel();
        anio = new javax.swing.JLabel();
        panelDireccion = new javax.swing.JPanel();
        tituloCalle = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        tituloNumeroExterior = new javax.swing.JLabel();
        txtNumeroExterior = new javax.swing.JTextField();
        tituloNumeroInterior = new javax.swing.JLabel();
        txtNumeroInterior = new javax.swing.JTextField();
        tituloCodigoPostal = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        tituloColonia = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        tituloRegistrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tituloRegistrar.setText("Registrar");

        tituloDatosPersonales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloDatosPersonales.setText("Datos personales");

        tituloFechaDeNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloFechaDeNacimiento.setText("Fecha de nacimiento");

        tituloUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloUsuario.setText("Usuario:");

        tituloNombre.setText("Nombre(s):");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        tituloApellidoPaterno.setText("Apellido paterno:");

        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });

        tituloApellidoMaterno.setText("Apellido materno (Opcional):");

        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosPersonalesLayout = new javax.swing.GroupLayout(panelDatosPersonales);
        panelDatosPersonales.setLayout(panelDatosPersonalesLayout);
        panelDatosPersonalesLayout.setHorizontalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tituloApellidoPaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloApellidoMaterno)
                    .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(tituloNombre)))))
        );
        panelDatosPersonalesLayout.setVerticalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloApellidoPaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloApellidoMaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tituloNumeroTelefonico.setText("Número telefónico:");

        txtNumeroTelefonico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroTelefonicoActionPerformed(evt);
            }
        });

        tituloNombreUsuario.setText("Nombre de usuario:");

        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        tituloContrasenia.setText("Contraseña:");

        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tituloNumeroTelefonico)
                    .addComponent(txtNumeroTelefonico)
                    .addComponent(tituloNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreUsuario)
                    .addComponent(tituloContrasenia)
                    .addComponent(txtContrasenia))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloNumeroTelefonico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        txtMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesActionPerformed(evt);
            }
        });

        txtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaActionPerformed(evt);
            }
        });

        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        mes.setText("Mes:");

        dia.setText("Día:");

        anio.setText("Año:");

        javax.swing.GroupLayout panelFechaDeNacimientoLayout = new javax.swing.GroupLayout(panelFechaDeNacimiento);
        panelFechaDeNacimiento.setLayout(panelFechaDeNacimientoLayout);
        panelFechaDeNacimientoLayout.setHorizontalGroup(
            panelFechaDeNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaDeNacimientoLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelFechaDeNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(panelFechaDeNacimientoLayout.createSequentialGroup()
                        .addComponent(dia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFechaDeNacimientoLayout.createSequentialGroup()
                        .addComponent(mes)
                        .addGap(6, 6, 6)
                        .addComponent(txtMes))
                    .addGroup(panelFechaDeNacimientoLayout.createSequentialGroup()
                        .addComponent(anio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        panelFechaDeNacimientoLayout.setVerticalGroup(
            panelFechaDeNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaDeNacimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaDeNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dia)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaDeNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mes)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaDeNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anio)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tituloCalle.setText("Calle:");

        txtCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleActionPerformed(evt);
            }
        });

        tituloNumeroExterior.setText("Número exterior:");

        txtNumeroExterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroExteriorActionPerformed(evt);
            }
        });

        tituloNumeroInterior.setText("Número interior: (opcional)");

        txtNumeroInterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroInteriorActionPerformed(evt);
            }
        });

        tituloCodigoPostal.setText("CódigoPostal:");

        txtCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPostalActionPerformed(evt);
            }
        });

        tituloColonia.setText("Colonia:");

        txtColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColoniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDireccionLayout = new javax.swing.GroupLayout(panelDireccion);
        panelDireccion.setLayout(panelDireccionLayout);
        panelDireccionLayout.setHorizontalGroup(
            panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDireccionLayout.createSequentialGroup()
                        .addComponent(tituloCodigoPostal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tituloColonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtColonia))
                    .addGroup(panelDireccionLayout.createSequentialGroup()
                        .addComponent(tituloNumeroExterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tituloNumeroInterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroInterior))
                    .addGroup(panelDireccionLayout.createSequentialGroup()
                        .addComponent(tituloCalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelDireccionLayout.setVerticalGroup(
            panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCalle)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloNumeroExterior)
                    .addComponent(txtNumeroExterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloNumeroInterior)
                    .addComponent(txtNumeroInterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCodigoPostal)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloColonia)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Dirección");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tituloDatosPersonales)
                            .addComponent(panelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tituloFechaDeNacimiento)
                            .addComponent(panelFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(tituloUsuario))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrarse))
                            .addComponent(panelDireccion, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloRegistrar, javax.swing.GroupLayout.Alignment.CENTER))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tituloRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tituloFechaDeNacimiento)
                    .addComponent(tituloDatosPersonales)
                    .addComponent(tituloUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFechaDeNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarse)
                    .addComponent(btnCancelar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        this.guardarClienteEnBaseDeDatos();
        PantallaPrincipal principal = new PantallaPrincipal(this.cliente, this.nombreCompleto);
        principal.setVisible(true);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNumeroTelefonicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroTelefonicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroTelefonicoActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void txtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaActionPerformed

    private void txtMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesActionPerformed

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleActionPerformed

    private void txtNumeroExteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroExteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroExteriorActionPerformed

    private void txtNumeroInteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroInteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroInteriorActionPerformed

    private void txtCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPostalActionPerformed

    private void txtColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColoniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColoniaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel dia;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel mes;
    private javax.swing.JPanel panelDatosPersonales;
    private javax.swing.JPanel panelDireccion;
    private javax.swing.JPanel panelFechaDeNacimiento;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JLabel tituloApellidoMaterno;
    private javax.swing.JLabel tituloApellidoPaterno;
    private javax.swing.JLabel tituloCalle;
    private javax.swing.JLabel tituloCodigoPostal;
    private javax.swing.JLabel tituloColonia;
    private javax.swing.JLabel tituloContrasenia;
    private javax.swing.JLabel tituloDatosPersonales;
    private javax.swing.JLabel tituloFechaDeNacimiento;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloNombreUsuario;
    private javax.swing.JLabel tituloNumeroExterior;
    private javax.swing.JLabel tituloNumeroInterior;
    private javax.swing.JLabel tituloNumeroTelefonico;
    private javax.swing.JLabel tituloRegistrar;
    private javax.swing.JLabel tituloUsuario;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNumeroExterior;
    private javax.swing.JTextField txtNumeroInterior;
    private javax.swing.JTextField txtNumeroTelefonico;
    // End of variables declaration//GEN-END:variables
}
