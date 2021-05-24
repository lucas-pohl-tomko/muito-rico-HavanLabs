-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cambios
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cambios
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cambios` DEFAULT CHARACTER SET latin1 ;
USE `cambios` ;

-- -----------------------------------------------------
-- Table `cambios`.`cambio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cambios`.`cambio` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `moeda_origem` VARCHAR(255) NOT NULL,
  `moeda_destino` VARCHAR(255) NOT NULL,
  `data_cambio` VARCHAR(255) NOT NULL,
  `valor_original` FLOAT NOT NULL,
  `valor_convertido` FLOAT NULL DEFAULT NULL,
  `taxa` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 82
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
