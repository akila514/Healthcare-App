CREATE DATABASE IF NOT EXISTS `healthcare` ;
USE `healthcare` ;

CREATE TABLE IF NOT EXISTS `doctor` (
    `dId` VARCHAR(15) NOT NULL,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    `address` TEXT NULL DEFAULT NULL,
    `contact` VARCHAR(15) NULL DEFAULT NULL,
    PRIMARY KEY (`dId`));

CREATE TABLE IF NOT EXISTS `patient` (
    `pId` VARCHAR(15) NOT NULL,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    `address` TEXT NULL DEFAULT NULL,
    `contact` VARCHAR(15) NULL DEFAULT NULL,
    PRIMARY KEY (`pId`));