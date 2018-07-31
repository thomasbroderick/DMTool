-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dm_tool_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dm_tool_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dm_tool_db` DEFAULT CHARACTER SET utf8 ;
USE `dm_tool_db` ;

GRANT SELECT, INSERT, UPDATE, DELETE on dm_tool_db.* to student@localhost;
-- -----------------------------------------------------
-- Table `dm_tool_db`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`user` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL DEFAULT 'standard',
  `enabled` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `email_UNIQUE` ON `dm_tool_db`.`user` (`email` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`campaign`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`campaign` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`campaign` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_campaign_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `dm_tool_db`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_campaign_user_idx` ON `dm_tool_db`.`campaign` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`campaign_note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`campaign_note` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`campaign_note` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `campaign_id` INT(11) NOT NULL,
  `text` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_campaign_notes`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `dm_tool_db`.`campaign` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_campaign_notes_idx` ON `dm_tool_db`.`campaign_note` (`campaign_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`character`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`character` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`character` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `campaign_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `max_hp` INT(11) NULL DEFAULT NULL,
  `current_hp` INT(11) NULL DEFAULT NULL,
  `initiative` INT(11) NULL DEFAULT '0',
  `ac` INT(11) NULL DEFAULT NULL,
  `perception` INT(11) NULL DEFAULT NULL,
  `investigation` INT(11) NULL DEFAULT NULL,
  `insight` INT(11) NULL DEFAULT NULL,
  `image_url` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_character_campaign`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `dm_tool_db`.`campaign` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_character_campaign_idx` ON `dm_tool_db`.`character` (`campaign_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`character_note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`character_note` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`character_note` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `character_id` INT(11) NOT NULL,
  `text` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_character_notes`
    FOREIGN KEY (`character_id`)
    REFERENCES `dm_tool_db`.`character` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_character_notes_idx` ON `dm_tool_db`.`character_note` (`character_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`item` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `equipment_category` VARCHAR(45) NULL DEFAULT NULL,
  `weapon_category` VARCHAR(45) NULL DEFAULT NULL,
  `range` VARCHAR(45) NULL DEFAULT NULL,
  `cost` VARCHAR(45) NULL DEFAULT NULL,
  `damage` VARCHAR(45) NULL DEFAULT NULL,
  `weight` VARCHAR(45) NULL DEFAULT NULL,
  `properties` MEDIUMTEXT NULL DEFAULT NULL,
  `description` MEDIUMTEXT NULL DEFAULT NULL,
  `image_url` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_item_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `dm_tool_db`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_item_user_idx` ON `dm_tool_db`.`item` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`monster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`monster` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`monster` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `size` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `subtype` VARCHAR(45) NULL DEFAULT NULL,
  `alignment` VARCHAR(45) NULL DEFAULT NULL,
  `armor_class` INT(11) NULL DEFAULT NULL,
  `hit_points` INT(11) NULL DEFAULT NULL,
  `hit_dice` INT(11) NULL DEFAULT NULL,
  `speed` VARCHAR(45) NULL DEFAULT NULL,
  `strength` INT(11) NULL DEFAULT NULL,
  `dexterity` INT(11) NULL DEFAULT NULL,
  `intelligence` INT(11) NULL DEFAULT NULL,
  `wisdom` INT(11) NULL DEFAULT NULL,
  `charisma` INT(11) NULL DEFAULT NULL,
  `constitution` INT(11) NULL DEFAULT NULL,
  `dexterity_save` INT(11) NULL DEFAULT NULL,
  `charisma_save` INT(11) NULL DEFAULT NULL,
  `wisdom_save` INT(11) NULL DEFAULT NULL,
  `stealth` INT(11) NULL DEFAULT NULL,
  `damage_vulnerabilities` MEDIUMTEXT NULL DEFAULT NULL,
  `damage_resistances` MEDIUMTEXT NULL DEFAULT NULL,
  `damage_immunities` MEDIUMTEXT NULL DEFAULT NULL,
  `condition_immunities` MEDIUMTEXT NULL DEFAULT NULL,
  `senses` MEDIUMTEXT NULL DEFAULT NULL,
  `languages` MEDIUMTEXT NULL DEFAULT NULL,
  `challenge_rating` INT(11) NULL DEFAULT NULL,
  `special_abilities` MEDIUMTEXT NULL DEFAULT NULL,
  `actions` MEDIUMTEXT NULL DEFAULT NULL,
  `legendary_actions` MEDIUMTEXT NULL DEFAULT NULL,
  `image_url` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_monster_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `dm_tool_db`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_monster_user_idx` ON `dm_tool_db`.`monster` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`npc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`npc` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`npc` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `campaign_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT NULL DEFAULT NULL,
  `monster_id` INT(11) NOT NULL,
  `image_url` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_npc_campaign`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `dm_tool_db`.`campaign` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_npc_monster`
    FOREIGN KEY (`monster_id`)
    REFERENCES `dm_tool_db`.`monster` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_npc_campaign_idx` ON `dm_tool_db`.`npc` (`campaign_id` ASC);

CREATE INDEX `fk_npc_monster_idx` ON `dm_tool_db`.`npc` (`monster_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`spell`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`spell` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`spell` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` MEDIUMTEXT NULL DEFAULT NULL,
  `range` VARCHAR(45) NULL DEFAULT NULL,
  `components` MEDIUMTEXT NULL DEFAULT NULL,
  `material` MEDIUMTEXT NULL DEFAULT NULL,
  `ritual` VARCHAR(45) NULL DEFAULT NULL,
  `duration` VARCHAR(45) NULL DEFAULT NULL,
  `concentration` VARCHAR(45) NULL DEFAULT NULL,
  `casting_time` VARCHAR(45) NULL DEFAULT NULL,
  `level` INT(11) NULL DEFAULT NULL,
  `school` MEDIUMTEXT NULL DEFAULT NULL,
  `classes` MEDIUMTEXT NULL DEFAULT NULL,
  `higher_lvl` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_spell_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `dm_tool_db`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_spell_user_idx` ON `dm_tool_db`.`spell` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`town`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`town` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`town` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `campaign_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_town_campaign`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `dm_tool_db`.`campaign` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_town_campaign_idx` ON `dm_tool_db`.`town` (`campaign_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
