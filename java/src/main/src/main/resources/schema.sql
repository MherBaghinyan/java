CREATE DATABASE access_log;

DROP TABLE IF EXISTS `request_data`;
CREATE TABLE `request_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_date` datetime,
  `ip` varchar(50),
  `comment` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SELECT r.ip FROM request_data r
GROUP BY r.ip, r.start_date
HAVING r.start_date BETWEEN ('2017-01-01.13:00:00' AND '2017-01-01.14:00:00')
       AND count(r.ip) > 100;

SELECT * FROM request_data
WHERE ip = '192.168.77.101';