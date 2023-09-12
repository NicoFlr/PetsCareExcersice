-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema petscare
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema petscare
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petscare` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `petscare` ;

-- -----------------------------------------------------
-- Table `petscare`.`species`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petscare`.`species` (
  `id` CHAR(36) NOT NULL,
  `name` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `Id_UNIQUE` ON `petscare`.`species` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `petscare`.`breed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petscare`.`breed` (
  `id` CHAR(36) NOT NULL,
  `name` VARCHAR(150) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `species_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Breed_Species`
    FOREIGN KEY (`species_id`)
    REFERENCES `petscare`.`species` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `Id_UNIQUE` ON `petscare`.`breed` (`id` ASC) VISIBLE;

CREATE INDEX `FK_Breed_Species` ON `petscare`.`breed` (`species_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `petscare`.`owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petscare`.`owner` (
  `id` CHAR(36) NOT NULL,
  `owner_id` VARCHAR(15) NOT NULL,
  `phone_number` VARCHAR(15) NULL DEFAULT NULL,
  `country_code` VARCHAR(6) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `birth_date` DATE NULL DEFAULT NULL,
  `address_line_1` VARCHAR(75) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `address_line_2` VARCHAR(75) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `first_name` VARCHAR(50) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `last_name` VARCHAR(50) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `full_name` VARCHAR(101) CHARACTER SET 'utf8mb3' GENERATED ALWAYS AS (concat(`first_name`,_utf8mb3' ',`last_name`)) STORED,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `id_UNIQUE` ON `petscare`.`owner` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `petscare`.`pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petscare`.`pet` (
  `id` CHAR(36) NOT NULL,
  `name` VARCHAR(50) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `date_of_birth` DATE NULL DEFAULT NULL,
  `species_id` CHAR(36) NOT NULL,
  `breed_id` CHAR(36) NOT NULL,
  `notes` VARCHAR(2500) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `owner_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Pet_Breed`
    FOREIGN KEY (`breed_id`)
    REFERENCES `petscare`.`breed` (`id`),
  CONSTRAINT `FK_Pet_Owner`
    FOREIGN KEY (`owner_id`)
    REFERENCES `petscare`.`owner` (`id`),
  CONSTRAINT `FK_Pet_Species`
    FOREIGN KEY (`species_id`)
    REFERENCES `petscare`.`species` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `Id_UNIQUE` ON `petscare`.`pet` (`id` ASC) VISIBLE;

CREATE INDEX `FK_Pet_Breed` ON `petscare`.`pet` (`breed_id` ASC) VISIBLE;

CREATE INDEX `FK_Pet_Owner` ON `petscare`.`pet` (`owner_id` ASC) VISIBLE;

CREATE INDEX `FK_Pet_Species` ON `petscare`.`pet` (`species_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `petscare`.`pet_cardex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petscare`.`pet_cardex` (
  `id` CHAR(36) NOT NULL,
  `visit_date` DATE NULL DEFAULT NULL,
  `pet_id` CHAR(36) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `medication` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Petcardex_Pet`
    FOREIGN KEY (`pet_id`)
    REFERENCES `petscare`.`pet` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `Id_UNIQUE` ON `petscare`.`pet_cardex` (`id` ASC) VISIBLE;

CREATE INDEX `FK_Petcardex_Pet` ON `petscare`.`pet_cardex` (`pet_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
