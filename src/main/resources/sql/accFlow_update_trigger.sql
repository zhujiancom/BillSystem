DELIMITER $$

USE `reconciliation2`$$

DROP TRIGGER /*!50032 IF EXISTS */ `accflow_update_trigger`$$

CREATE
    /*!50017 DEFINER = 'reconciliation'@'localhost' */
    TRIGGER `accflow_update_trigger` AFTER UPDATE ON `bus_tb_account_flow` 
    FOR EACH ROW BEGIN
	DECLARE diffAmount DECIMAL(19,2);
	SET diffAmount = new.amount-old.amount;
	UPDATE `reconciliation2`.`bus_tb_account`  SET earning_amount=earning_amount+diffAmount,balance=balance+diffAmount WHERE accId=old.acc_id;
    END;
$$

DELIMITER ;