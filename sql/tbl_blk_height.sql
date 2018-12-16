DROP TABLE IF EXISTS `tbl_blk_height`;
CREATE TABLE `tbl_blk_height` (
  `blkheight` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`blkheight`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;