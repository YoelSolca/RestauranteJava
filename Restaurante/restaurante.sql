-- Seleccionar la base de datos
USE sql10742365;

-- Crear tabla salones
CREATE TABLE IF NOT EXISTS salones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  mesas INT NOT NULL
);

-- Crear tabla pedidos
CREATE TABLE IF NOT EXISTS pedidos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_salon INT NOT NULL,
  num_mesa INT NOT NULL,
  fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  total DECIMAL(10, 2) NOT NULL,
  estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
  usuario VARCHAR(255) NOT NULL,
  FOREIGN KEY (id_salon) REFERENCES salones(id)
);

-- Crear tabla detalle_pedidos
CREATE TABLE IF NOT EXISTS detalle_pedidos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  precio DECIMAL(10, 2) NOT NULL,
  cantidad INT NOT NULL,
  comentario TEXT,
  id_pedido INT NOT NULL,
  FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
);

-- Crear tabla config
CREATE TABLE IF NOT EXISTS config (
  id INT PRIMARY KEY AUTO_INCREMENT,
  ruc VARCHAR(20) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  mensaje TEXT NOT NULL
);

-- Crear tabla platos
CREATE TABLE IF NOT EXISTS platos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  precio DECIMAL(10, 2) NOT NULL,
  fecha DATE
);

-- Crear tabla clientes
CREATE TABLE IF NOT EXISTS clientes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL
);

-- Crear tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  correo VARCHAR(255) NOT NULL,
  pass VARCHAR(255) NOT NULL,
  rol VARCHAR(50) NOT NULL
);

-- Inserciones en las tablas

-- Tabla salones
INSERT INTO salones (id, nombre, mesas) VALUES (1, 'SALON PRINCIPAL', 15);
INSERT INTO salones (id, nombre, mesas) VALUES (2, 'SEGUNDO PISO', 10);

-- Tabla pedidos
INSERT INTO pedidos (id, id_salon, num_mesa, fecha, total, estado, usuario) VALUES (1, 1, 2, '2022-05-18 00:31:52', 78.00, 'FINALIZADO', 'ANGEL SIFUENTES');
INSERT INTO pedidos (id, id_salon, num_mesa, fecha, total, estado, usuario) VALUES (2, 2, 8, '2022-05-18 00:32:20', 30.00, 'PENDIENTE', 'ANGEL SIFUENTES');
INSERT INTO pedidos (id, id_salon, num_mesa, fecha, total, estado, usuario) VALUES (3, 1, 9, '2022-05-18 00:32:29', 28.00, 'PENDIENTE', 'ANGEL SIFUENTES');
INSERT INTO pedidos (id, id_salon, num_mesa, fecha, total, estado, usuario) VALUES (4, 1, 11, '2022-05-18 01:04:47', 20.00, 'PENDIENTE', 'ANGEL SIFUENTES');

-- Tabla detalle_pedidos
INSERT INTO detalle_pedidos (nombre, precio, cantidad, comentario, id_pedido) VALUES
            ('Asado', 25.0, 1, 'Bien jugoso', 1),
            ('Empanadas', 8.0, 3, 'Con carne y aceitunas', 1),
            ('Milanesa con papas fritas', 12.0, 2, 'Extra papas', 2),
            ('Provoleta', 10.0, 1, 'Con orégano y ají molido', 2),
            ('Pizza de muzzarella', 15.0, 1, 'Con doble queso', 3),
            ('Choripán', 7.0, 4, 'Con chimichurri', 3),
            ('Locro', 20.0, 1, 'Especial 25 de mayo', 4),
            ('Humita en chala', 9.0, 1, 'Hecho a la parrilla', 4);

-- Tabla config
INSERT INTO config (id, ruc, nombre, telefono, direccion, mensaje) VALUES (1, '65479877', 'Restaurante la Delicia', '957847894', 'Lima - Perú', 'Gracias por la compra');

-- Tabla platos
INSERT INTO platos (id, nombre, precio, fecha) VALUES (1, 'ARROZ CON POLLO', 10.00, '2022-05-17');
INSERT INTO platos (id, nombre, precio, fecha) VALUES (2, 'CHAUFA', 20.00, '2022-05-17');
INSERT INTO platos (id, nombre, precio, fecha) VALUES (3, 'GASEOSA COCA COLA 1.5 LITROS', 8.00, '2022-05-17');

-- Tabla usuarios
INSERT INTO usuarios (id, nombre, correo, pass, rol) VALUES (1, 'ANGEL SIFUENTES', 'info@angelsifuentes.com', 'admin', 'Administrador');

-- Tabla clientes
INSERT INTO clientes (id, nombre, apellido) VALUES (1, 'DANIEL', 'PEREZ');
