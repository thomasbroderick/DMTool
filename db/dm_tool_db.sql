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

GRANT SELECT, INSERT, UPDATE, DELETE on dm_tool_db.* to student;

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
  CONSTRAINT `fk_campaign_note`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `dm_tool_db`.`campaign` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_campaign_note_idx` ON `dm_tool_db`.`campaign_note` (`campaign_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`player` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`player` (
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
  CONSTRAINT `fk_player_campaign`
    FOREIGN KEY (`campaign_id`)
    REFERENCES `dm_tool_db`.`campaign` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_player_campaign_idx` ON `dm_tool_db`.`player` (`campaign_id` ASC);


-- -----------------------------------------------------
-- Table `dm_tool_db`.`player_note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dm_tool_db`.`player_note` ;

CREATE TABLE IF NOT EXISTS `dm_tool_db`.`player_note` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `player_id` INT(11) NOT NULL,
  `text` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_player_note`
    FOREIGN KEY (`player_id`)
    REFERENCES `dm_tool_db`.`player` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_player_note_idx` ON `dm_tool_db`.`player_note` (`player_id` ASC);


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
  `rng` VARCHAR(45) NULL DEFAULT NULL,
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
  `constitution_save` INT(11) NULL DEFAULT NULL,
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
  `rng` VARCHAR(45) NULL DEFAULT NULL,
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
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_town_campaign_idx` ON `dm_tool_db`.`town` (`campaign_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`user` (`id`, `email`, `password`, `role`, `enabled`) VALUES (1, 'admin@admin.com', 'admin', 'admin', 1);
INSERT INTO `dm_tool_db`.`user` (`id`, `email`, `password`, `role`, `enabled`) VALUES (2, 'standard@standard.com', 'standard', 'standard', 1);
INSERT INTO `dm_tool_db`.`user` (`id`, `email`, `password`, `role`, `enabled`) VALUES (3, 'disabled@disabled.com', 'disabled', 'standard', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`campaign`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`campaign` (`id`, `name`, `user_id`) VALUES (1, 'test campaign', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`campaign_note`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`campaign_note` (`id`, `campaign_id`, `text`) VALUES (1, 1, 'Boss fight coming up!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`player`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`player` (`id`, `campaign_id`, `name`, `max_hp`, `current_hp`, `initiative`, `ac`, `perception`, `investigation`, `insight`, `image_url`) VALUES (1, 1, 'Legolas the Original', 30, 30, 1, 18, 6, 2, 0, NULL);
INSERT INTO `dm_tool_db`.`player` (`id`, `campaign_id`, `name`, `max_hp`, `current_hp`, `initiative`, `ac`, `perception`, `investigation`, `insight`, `image_url`) VALUES (2, 1, 'Gimli the Null', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`player_note`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`player_note` (`id`, `player_id`, `text`) VALUES (1, 1, 'Best player evar!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`item`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`item` (`id`, `user_id`, `name`, `equipment_category`, `weapon_category`, `rng`, `cost`, `damage`, `weight`, `properties`, `description`, `image_url`) VALUES (1, 2, 'Testhammer', 'Weapon', 'Hammer', 'Melee', '50 gold', '1d10', '50 kg', 'testy', 'Much hammer', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`monster`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`monster` (`id`, `user_id`, `name`, `size`, `type`, `subtype`, `alignment`, `armor_class`, `hit_points`, `hit_dice`, `speed`, `strength`, `dexterity`, `intelligence`, `wisdom`, `charisma`, `constitution`, `dexterity_save`, `charisma_save`, `constitution_save`, `wisdom_save`, `stealth`, `damage_vulnerabilities`, `damage_resistances`, `damage_immunities`, `condition_immunities`, `senses`, `languages`, `challenge_rating`, `special_abilities`, `actions`, `legendary_actions`, `image_url`) VALUES (1, 1, 'Goblin', 'Medium', 'Goblinoid', NULL, NULL, 10, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`npc`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`npc` (`id`, `campaign_id`, `name`, `description`, `monster_id`, `image_url`) VALUES (1, 1, 'Lord Testerson', 'Testy', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`spell`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`spell` (`id`, `user_id`, `name`, `description`, `rng`, `components`, `material`, `ritual`, `duration`, `concentration`, `casting_time`, `level`, `school`, `classes`, `higher_lvl`) VALUES (1, 2, 'Test Spell', 'Tests the darkness', '10 feet', 'V', 'S', 'None', 'Years', 'No', 'Long', 1, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dm_tool_db`.`town`
-- -----------------------------------------------------
START TRANSACTION;
USE `dm_tool_db`;
INSERT INTO `dm_tool_db`.`town` (`id`, `campaign_id`, `name`, `description`) VALUES (1, 1, 'Towny McTownface', 'No place like home');

COMMIT;
