DROP TABLE IF EXISTS `tbl_huge_wins`;
CREATE TABLE `tbl_huge_wins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bettor` varchar(128) NOT NULL,
  `rollunder` int(11) NOT NULL DEFAULT 0,
  `bet` decimal(40,4) NOT NULL DEFAULT '0.000000000',
  `roll` int(11) DEFAULT 0,
  `payout` decimal(40,4) NOT NULL DEFAULT '0.000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;