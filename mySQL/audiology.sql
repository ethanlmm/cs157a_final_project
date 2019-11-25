-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Patient` (
  `THC_Num` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `street_address` VARCHAR(45) NOT NULL,
  `zip_code` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `phone_num` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`THC_Num`),
  UNIQUE INDEX `THC_Num_UNIQUE` (`THC_Num` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Visit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Visit` (
  `visit_id` INT NOT NULL AUTO_INCREMENT,
  `date_of_visit` VARCHAR(45) NOT NULL,
  `Patient_THC_Num` INT NOT NULL,
  PRIMARY KEY (`visit_id`),
  UNIQUE INDEX `visit_id_UNIQUE` (`visit_id` ASC),
  INDEX `fk_Visit_Patient1_idx` (`Patient_THC_Num` ASC),
  CONSTRAINT `fk_Visit_Patient1`
    FOREIGN KEY (`Patient_THC_Num`)
    REFERENCES `mydb`.`Patient` (`THC_Num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Chemical_Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Chemical_Category` (
  `chemical_id` INT NOT NULL,
  `chemical_name` VARCHAR(45) NOT NULL,
  `chemical_description` VARCHAR(45) NULL,
  PRIMARY KEY (`chemical_id`),
  UNIQUE INDEX `Chemical_Categorycol_UNIQUE` (`chemical_description` ASC),
  UNIQUE INDEX `chemical_id_UNIQUE` (`chemical_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Audiogram_test_id`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Audiogram_test_id` (
  `Visit_visit_id` INT NOT NULL,
  `Audiologicalcol` VARCHAR(45) NOT NULL,
  INDEX `fk_Audiological_Visit_idx` (`Visit_visit_id` ASC),
  PRIMARY KEY (`Audiologicalcol`),
  CONSTRAINT `fk_Audiological_Visit`
    FOREIGN KEY (`Visit_visit_id`)
    REFERENCES `mydb`.`Visit` (`visit_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Generic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Generic` (
  `generic_ID` INT NOT NULL,
  `generic_name` VARCHAR(45) NOT NULL,
  `generic_description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`generic_ID`),
  UNIQUE INDEX `generic_ID_UNIQUE` (`generic_ID` ASC),
  UNIQUE INDEX `generic_description_UNIQUE` (`generic_description` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Disease`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Disease` (
  `disease_ID` INT NOT NULL,
  `disease_name` VARCHAR(45) NOT NULL,
  `disease_description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`disease_ID`),
  UNIQUE INDEX `idDisease_UNIQUE` (`disease_ID` ASC),
  UNIQUE INDEX `Diseasecol_UNIQUE` (`disease_description` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medicant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medicant` (
  `med_ID` VARCHAR(45) NOT NULL,
  `medicant_name` VARCHAR(45) NOT NULL,
  `medicant_description` VARCHAR(45) NOT NULL,
  `usual_dose` VARCHAR(45) NOT NULL,
  `Medicantcol` VARCHAR(45) NOT NULL,
  `Generic_generic_ID` INT NOT NULL,
  `Disease_disease_ID` INT NOT NULL,
  `Chemical_Category_chemical_id` INT NOT NULL,
  PRIMARY KEY (`med_ID`),
  UNIQUE INDEX `med_ID_UNIQUE` (`med_ID` ASC),
  UNIQUE INDEX `medicant_description_UNIQUE` (`medicant_description` ASC),
  INDEX `fk_Medicant_Generic1_idx` (`Generic_generic_ID` ASC),
  INDEX `fk_Medicant_Disease1_idx` (`Disease_disease_ID` ASC),
  INDEX `fk_Medicant_Chemical_Category1_idx` (`Chemical_Category_chemical_id` ASC),
  CONSTRAINT `fk_Medicant_Generic1`
    FOREIGN KEY (`Generic_generic_ID`)
    REFERENCES `mydb`.`Generic` (`generic_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medicant_Disease1`
    FOREIGN KEY (`Disease_disease_ID`)
    REFERENCES `mydb`.`Disease` (`disease_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medicant_Chemical_Category1`
    FOREIGN KEY (`Chemical_Category_chemical_id`)
    REFERENCES `mydb`.`Chemical_Category` (`chemical_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pharmachology`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pharmachology` (
  `Visit_visit_id` INT NOT NULL,
  `Medicant_med_ID` VARCHAR(45) NOT NULL,
  `dose` VARCHAR(45) NOT NULL,
  `duration` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Visit_visit_id`, `Medicant_med_ID`),
  INDEX `fk_Parmachology_Medicant1_idx` (`Medicant_med_ID` ASC),
  CONSTRAINT `fk_Parmachology_Visit1`
    FOREIGN KEY (`Visit_visit_id`)
    REFERENCES `mydb`.`Visit` (`visit_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parmachology_Medicant1`
    FOREIGN KEY (`Medicant_med_ID`)
    REFERENCES `mydb`.`Medicant` (`med_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
