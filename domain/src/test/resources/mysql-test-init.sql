CREATE TABLE `loyalty_events` (
                                  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                  `is_system_event_type` tinyint(3) unsigned NOT NULL DEFAULT '1',
                                  `id_event_type` int(10) unsigned NOT NULL,
                                  `id_individual` int(10) unsigned NOT NULL DEFAULT '0',
                                  `id_loyalty_status` int(10) unsigned NOT NULL DEFAULT '0',
                                  `event_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `id_matched_rule` int(10) unsigned NOT NULL DEFAULT '0',
                                  `value_date` datetime(6) NOT NULL,
                                  `processed` tinyint(3) unsigned NOT NULL DEFAULT '0',
                                  `json_payload` json NOT NULL,
                                  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  `unique_key` varchar(100) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `unique_key` (`unique_key`),
                                  KEY `id_individual` (`id_individual`,`value_date`),
                                  KEY `id_loyalty_status` (`id_loyalty_status`,`value_date`),
                                  KEY `id_rule` (`id_matched_rule`,`value_date`),
                                  KEY `id_event_type` (`id_event_type`,`processed`),
                                  KEY `processed` (`processed`),
                                  KEY `loyalty_events_idx_id_type_is_type_id_stat_value` (`id_event_type`,`is_system_event_type`,`id_loyalty_status`,`value_date`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT INTO loyalty_events (id, id_event_type, json_payload, value_date, unique_key) VALUES (12, 1, '{}', NOW(), "test_already_existing_unique_key");