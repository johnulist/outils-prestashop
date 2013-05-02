CREATE TABLE `relaisdu_image_update_info` (
  `id_update` int(10) unsigned NOT NULL auto_increment,
  `id_image` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_update`),
  FOREIGN KEY (`id_image`) REFERENCES `relaisduson`.`relaisdu_image`(`id_image`)
) DEFAULT CHARSET=utf8;