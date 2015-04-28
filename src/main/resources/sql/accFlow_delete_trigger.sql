DELIMITER $$

USE `reconciliation2`$$

DROP TRIGGER /*!50032 IF EXISTS */ `accflow_delete_trigger`$$

CREATE
    /*!50017 DEFINER = 'reconciliation'@'localhost' */
    TRIGGER `accflow_delete_trigger` AFTER DELETE ON `bus_tb_account_flow` 
    FOR EACH ROW BEGIN 
 	UPDATE `reconciliation2`.`bus_tb_account`  SET earning_amount=earning_amount-old.amount,balance=balance-old.amount WHERE accId=old.acc_id;
    END;
$$

DELIMITER ;