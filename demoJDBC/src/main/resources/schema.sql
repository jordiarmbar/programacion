CREATE DATABASE IF NOT EXISTS bbdd_jdbc_sb;

USE bbdd_jdbc_sb;

CREATE TABLE Producto (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  precio DOUBLE,
  stock INT
);
