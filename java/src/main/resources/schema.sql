DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `person_id` bigint(20) NOT NULL,
  `start_date` datetime,
  `end_date` datetime,
  `organization` varchar(50),
  `role` varchar(50),
  `role_description` varchar(50),
  `yrs_to_retirement` varchar(50),
  `committee` varchar(50),
  `last_comp` NUMERIC(15,3),
  `liquid_wealth` NUMERIC(15,3),
  `total_wealth` NUMERIC(15,3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;