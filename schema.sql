CREATE DATABASE ventas;
USE ventas;

CREATE TABLE ventas.cliente (
    dni int NOT NULL,
    nombre varchar(50) NOT NULL,
    apellido varchar(50),
    PRIMARY KEY (dni)
);

CREATE TABLE ventas.producto (
	productoid int NOT NULL AUTO_INCREMENT,
    codigo int NOT NULL,
    descripcion varchar(255) NOT NULL,
    stock int,
    precio FLOAT(10, 2),
    PRIMARY KEY (productoid)
);
CREATE TABLE ventas.item (
    itemId int NOT NULL AUTO_INCREMENT,
	cantidad int,
    descripcion varchar(255) NOT NULL,
    precio FLOAT(10, 2),
    comprobanteid int NOT NULL,
    productoid int NOT NULL,
    PRIMARY KEY (itemid),
    CONSTRAINT FK_comprobante FOREIGN KEY (comprobanteid)
    REFERENCES comprobante(comprobanteid),
    CONSTRAINT FK_producto FOREIGN KEY (productoid)
    REFERENCES producto(productoid)
);

CREATE TABLE ventas.comprobante (
    comprobanteid int NOT NULL AUTO_INCREMENT,
    cantidad int,
    fecha DATETIME,
    total FLOAT(10, 2),
    estado int,
    dni int,
    itemId int,
    PRIMARY KEY (comprobanteid),
    CONSTRAINT FK_cliente FOREIGN KEY (dni)
    REFERENCES cliente(dni)
);

