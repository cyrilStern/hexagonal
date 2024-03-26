 CREATE TABLE IF NOT EXISTS  `race` (
                                  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `name` varchar(50) NOT NULL,
                                  `number` int(10) unsigned NOT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `unique_key` (`date`, `number`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
 CREATE INDEX `index_date_number` ON `race` (date, number);
INSERT INTO race (date, name, number) VALUES (NOW(), 'first_race', 1);
