DROP DATABASE IF EXISTS banco;

CREATE DATABASE banco;

USE banco;

#Tabla1
CREATE TABLE NombresCompletos (
    idNombreCompleto INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(50) NOT NULL,
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50) NOT NULL
);

#Table2
CREATE TABLE Direcciones (
    idDireccion INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(100) NOT NULL,
    numeroExterior VARCHAR(10) NOT NULL,
    numeroInterior VARCHAR(10),
    codigoPostal VARCHAR(5) NOT NULL,
    colonia VARCHAR(100) NOT NULL
);

#Table3
CREATE TABLE Clientes (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    fechaNacimiento DATE NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    usuario VARCHAR(20) NOT NULL,
    contrasenia VARCHAR(50) NOT NULL,
    
    idNombreCompleto INT NOT NULL,
    FOREIGN KEY (idNombreCompleto) REFERENCES NombresCompletos (idNombreCompleto),
    
    idDireccion INT NOT NULL,
    FOREIGN KEY (idDireccion) REFERENCES Direcciones (idDireccion)
);

#Tabla4
CREATE TABLE Cuentas (
    idCuenta INT PRIMARY KEY AUTO_INCREMENT,
    numeroCuenta VARCHAR(16) NOT NULL,
    fechaApertura DATE NOT NULL,
    saldo DECIMAL(8 , 2 ) NOT NULL,
    
    idCliente INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Clientes (idCliente)
);

#Tabla5
CREATE TABLE Transferencias (
    folio INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(8 , 2 ) NOT NULL,
    fechaHora DATETIME NOT NULL,
    idCuentaOrigen INT NOT NULL,
    FOREIGN KEY (idCuentaOrigen)
        REFERENCES Cuentas (idCuenta),
    idCuentaDestino INT NOT NULL,
    FOREIGN KEY (idCuentaOrigen)
        REFERENCES Cuentas (idCuenta)
);

#Tabla6
CREATE TABLE RetiroSinCuenta (
    folio INT PRIMARY KEY AUTO_INCREMENT,
    contaseña VARCHAR(8) NOT NULL,
    monto DECIMAL(8 , 2 ) NOT NULL,
    fechaHora DATETIME NOT NULL,
    estado ENUM('cancelado', 'retirado', 'pendiente') NOT NULL,
    idCuenta INT NOT NULL,
    FOREIGN KEY (idCuenta)
        REFERENCES Cuentas (idCuenta)
);