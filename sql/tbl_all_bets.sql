DROP TABLE IF EXISTS `tbl_all_bets`;
CREATE TABLE `tbl_all_bets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bettor` varchar(128) NOT NULL,
  `rollunder` int(11) NOT NULL DEFAULT 0,
  `bet` decimal(40,4) NOT NULL DEFAULT '0.000000000',
  `roll` int(11) DEFAULT 0,
  `payout` decimal(40,4) NOT NULL DEFAULT '0.000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;