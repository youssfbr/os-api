ALTER TABLE `os`.`service_order` 
CHANGE COLUMN `openDate` `open_date` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `finishDate` `finish_date` DATETIME NULL DEFAULT NULL ;