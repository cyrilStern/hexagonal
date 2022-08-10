SET sql_mode = '';
create table loyalty_status
(
    id                   int unsigned auto_increment
        primary key,
    card_code            varchar(128)                        not null,
    id_individual        int unsigned                        not null,
    id_program           int unsigned                        not null,
    program_join_date    datetime                            not null,
    card_expiration_date datetime                            not null,
    id_tier              int unsigned                        not null,
    tier_join_date       datetime                            not null,
    qpoints              int unsigned                        not null,
    nqpoints             int unsigned                        not null,
    last_compute_date    datetime  default CURRENT_TIMESTAMP not null,
    last_downgrade_check datetime  default CURRENT_TIMESTAMP not null,
    last_update          timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    birthday             date                                not null,
    is_active            tinyint   default 0                 not null,
    c0                   tinytext                            not null,
    c1                   tinytext                            not null,
    c2                   tinytext                            not null,
    c3                   tinytext                            not null,
    c4                   tinytext                            not null,
    c5                   tinytext                            not null,
    c6                   tinytext                            not null,
    c7                   tinytext                            not null,
    c8                   tinytext                            not null,
    c9                   tinytext                            not null,
    c10                  tinytext                            not null,
    c11                  tinytext                            not null,
    c12                  tinytext                            not null,
    c13                  tinytext                            not null,
    c14                  tinytext                            not null,
    c15                  tinytext                            not null,
    c16                  tinytext                            not null,
    c17                  tinytext                            not null,
    c18                  tinytext                            not null,
    c19                  tinytext                            not null,
    c20                  tinytext                            not null,
    c21                  tinytext                            not null,
    c22                  tinytext                            not null,
    c23                  tinytext                            not null,
    c24                  tinytext                            not null,
    c25                  tinytext                            not null,
    c26                  tinytext                            not null,
    c27                  tinytext                            not null,
    c28                  tinytext                            not null,
    c29                  tinytext                            not null,
    c30                  tinytext                            not null,
    c31                  tinytext                            not null,
    constraint card_code
        unique (card_code)
);

create index id_individual
    on loyalty_status (id_individual);

create index loyalty_status_is_active_IDX
    on loyalty_status (is_active);

create index loyalty_status_is_active_card_exp_IDX
    on loyalty_status (is_active, card_expiration_date);

SET SQL_MODE='';

INSERT INTO data_alfounet.loyalty_status (id, card_code, id_individual, id_program, program_join_date, card_expiration_date, id_tier, tier_join_date, qpoints, nqpoints, last_compute_date, last_downgrade_check, last_update, birthday, is_active, c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31) VALUES (8, '54919726726146466400004', 3028591, 1, '2020-03-19 11:46:30', '0000-00-00 00:00:00', 8, '2020-03-19 11:46:30', 0, 0, '2021-09-08 12:11:28', '2021-09-21 10:32:19', '2021-09-21 10:32:20', CURDATE(), 1, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO data_alfounet.loyalty_status (id, card_code, id_individual, id_program, program_join_date, card_expiration_date, id_tier, tier_join_date, qpoints, nqpoints, last_compute_date, last_downgrade_check, last_update, birthday, is_active, c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31) VALUES (9, 'cardcode_to_update', 3028591, 1, '2020-03-19 11:46:30', '2999-03-19 11:46:30', 8, '2020-03-19 11:46:30', 0, 0, '2021-09-08 12:11:28', '2021-09-21 10:32:19', '2021-09-21 10:32:20', CURDATE(), 0, 'update', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO data_alfounet.loyalty_status (id, card_code, id_individual, id_program, program_join_date, card_expiration_date, id_tier, tier_join_date, qpoints, nqpoints, last_compute_date, last_downgrade_check, last_update, birthday, is_active, c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31) VALUES (15, 'cardcode_to_unsub', 3028591, 1, '2020-03-19 11:46:30', '2999-03-19 11:46:30', 8, '2020-03-19 11:46:30', 0, 0, '2021-09-08 12:11:28', '2021-09-21 10:32:19', '2021-09-21 10:32:20', CURDATE(), 1, 'update', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO data_alfounet.loyalty_status (id, card_code, id_individual, id_program, program_join_date, card_expiration_date, id_tier, tier_join_date, qpoints, nqpoints, last_compute_date, last_downgrade_check, last_update, birthday, is_active, c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31) VALUES (11, 'cardcode_to_nounsub', 3028591, 1, '2020-03-19 11:46:30', '2020-03-19 11:46:30', 8, '2020-03-19 11:46:30', 0, 0, '2020-09-08 12:11:28', '2020-09-21 10:32:19', '2020-09-21 10:32:20', CURDATE(), 0, 'update', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO data_alfounet.loyalty_status (id, card_code, id_individual, id_program, program_join_date, card_expiration_date, id_tier, tier_join_date, qpoints, nqpoints, last_compute_date, last_downgrade_check, last_update, birthday, is_active, c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31) VALUES (10, 'cardcode_to_update_2', 3028591, 1, '2020-03-19 11:46:30', '2999-03-19 11:46:30', 1, '2020-03-19 11:46:30', 0, 0, '2021-09-08 12:11:28', '2021-09-21 10:32:19', '2021-09-21 10:32:20', CURDATE(), 0, 'update', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO data_alfounet.loyalty_status (id, card_code, birthday, id_program, program_join_date, card_expiration_date, id_tier, tier_join_date, is_active) VALUES (29, 'card_code_to_expire', CURDATE(),10, '2020-03-19 11:46:30', '0000-00-00 00:00:00', 1, '2020-03-19 11:46:30', 1);

create table loyalty_programs_history
(
    id                                         int auto_increment
        primary key,
    id_program                                 int                                           not null,
    history_sequence                           int                                           not null,
    history_start_date                         datetime                                      not null,
    history_end_date                           datetime                                      not null,
    name                                       tinytext                                      not null,
    description                                text                                          not null,
    start_date                                 datetime                                      not null,
    end_date                                   datetime                                      not null,
    creation                                   datetime                                      not null,
    status                                     varchar(20)                                   not null,
    type                                       varchar(20)                                   not null,
    replicate_events                           tinyint(4) unsigned default 0                 not null,
    id_user                                    int(10)                                       not null,
    cascading                                  enum ('0', '1')                               not null,
    compute_period                             int(3) unsigned                               not null,
    downgrade_nb_rank                          int(2) unsigned                               not null,
    default_qpoints_validity_is_system_period  tinyint(3)          default 0                 not null,
    default_qpoints_validity_id_period         int unsigned                                  not null,
    default_qpoints_validity_days              int unsigned                                  not null,
    default_nqpoints_validity_is_system_period tinyint(3)          default 0                 not null,
    default_nqpoints_validity_id_period        int unsigned                                  not null,
    default_nqpoints_validity_days             int unsigned                                  not null,
    default_qpoints_holding_days               int unsigned                                  not null,
    default_nqpoints_holding_days              int unsigned                                  not null,
    max_qpoints                                int unsigned                                  not null,
    max_nqpoints                               int unsigned                                  not null,
    rounding_type                              varchar(16)                                   not null,
    default_points_to_amount_ratio             decimal(10, 2) unsigned                       not null,
    auto_generated_card_code                   tinyint                                       not null,
    history_creation_date                      datetime            default CURRENT_TIMESTAMP not null,
    duplicate_events                           tinyint unsigned    default 0                 not null,
    auto_subscribe                             tinyint(1)          default 0                 not null,
    q_refund_mode                              varchar(7)          default 'cancel'          not null,
    nq_refund_mode                             varchar(7)          default 'cancel'          not null
);
SET SQL_MODE='';

INSERT INTO data_alfounet.loyalty_programs_history (id_program, history_sequence, history_start_date, history_end_date, name, description, start_date, end_date, creation, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_is_system_period, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_is_system_period, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, history_creation_date, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (1, 1, '2020-02-19 14:25:09', '9999-03-19 14:25:08', 'test programme', '', '2020-02-19 14:25:06', '9999-12-31 00:00:00', '2020-02-19 14:25:09', 'running', 'simple', 1, 16861, '1', 0, 0, 0, 0, 365, 0, 0, 365, 1, 1, 0, 0, 'round', 1.00, 1, '2020-02-19 14:25:09', 0, 0, 'cancel', 'cancel');

create table loyalty_tiers_history
(
    id                  int unsigned auto_increment
        primary key,
    id_tier             int unsigned                         not null,
    id_program          int unsigned                         not null,
    history_sequence    int                                  not null,
    history_start_date  datetime                             not null,
    history_end_date    datetime                             not null,
    name                tinytext                             not null,
    status              varchar(64)                          not null,
    entry_threshold     int unsigned                         not null,
    downgrade_threshold int unsigned                         not null,
    multiplier_qpoints  decimal(10, 2) unsigned default 1.00 not null,
    multiplier_nqpoints decimal(10, 2) unsigned default 1.00 not null,
    is_point_based      tinyint                 default 1    not null,
    creation            datetime                             not null,
    id_user             int(10)                              not null
);
SET SQL_MODE='';

INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (1, 1, 1, '2019-09-20 16:33:52', '2021-05-25 19:47:36', 'Tiers #1', 'created', 0, 0, 1.00, 1.00, 1, '2019-09-20 16:33:52', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (8, 1, 3, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'First Silver', 'created', 0, 200, 1.60, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (1, 1, 2, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'Silver', 'created', 100, 48, 1.50, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (3, 1, 2, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'Gold', 'created', 200, 150, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (4, 1, 3, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'Green', 'created', 297, 253, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (5, 1, 2, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'Diamond', 'created', 398, 351, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (6, 1, 2, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'Red', 'created', 499, 450, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (7, 1, 3, '2021-05-25 19:47:37', '2021-10-22 14:50:23', 'Blue', 'created', 0, 500, 1.00, 2.00, 0, '2019-04-19 16:10:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (8, 1, 4, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'First Silver', 'created', 0, 200, 1.60, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (1, 1, 3, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'Silver', 'created', 1, 0, 1.50, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (3, 1, 3, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'Gold', 'created', 200, 150, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (4, 1, 4, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'Green', 'created', 297, 253, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (5, 1, 3, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'Diamond', 'created', 398, 351, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (6, 1, 3, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'Red', 'created', 499, 450, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (7, 1, 4, '2021-10-22 14:50:24', '2021-10-22 14:51:37', 'Blue', 'created', 0, 500, 1.00, 2.00, 0, '2019-04-19 16:10:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (8, 1, 5, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'First Silver', 'created', 0, 200, 1.00, 1.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (1, 1, 4, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'Silver', 'created', 1, 0, 1.50, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (3, 1, 4, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'Gold', 'created', 200, 150, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (4, 1, 5, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'Green', 'created', 297, 253, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (5, 1, 4, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'Diamond', 'created', 398, 351, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (6, 1, 4, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'Red', 'created', 499, 450, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (7, 1, 5, '2021-10-22 14:51:38', '2021-10-22 15:05:50', 'Blue', 'created', 0, 500, 1.00, 2.00, 0, '2019-04-19 16:10:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (7, 1, 6, '2021-10-22 15:05:51', '9999-12-01 00:00:00', 'Blue', 'deleted', 0, 500, 1.00, 2.00, 0, '2019-04-19 16:10:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (8, 1, 6, '2021-10-22 15:05:51', '2021-10-22 15:06:49', 'First Silver', 'created', 0, 200, 1.00, 1.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (1, 1, 5, '2021-10-22 15:05:51', '2021-10-23 18:16:05', 'Silver', 'created', 1, 0, 1.50, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (3, 1, 5, '2021-10-22 15:05:51', '2021-10-22 15:06:49', 'Gold', 'created', 200, 150, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (4, 1, 6, '2021-10-22 15:05:51', '2021-10-22 15:06:49', 'Green', 'created', 297, 253, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (5, 1, 5, '2021-10-22 15:05:51', '2021-10-22 15:06:49', 'Diamond', 'created', 398, 351, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (6, 1, 5, '2021-10-22 15:05:51', '2021-10-22 15:06:49', 'Red', 'created', 499, 450, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (8, 1, 7, '2021-10-22 15:06:50', '9999-12-01 00:00:00', 'First Silver', 'created', 0, 200, 1.00, 1.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (1, 1, 6, '2021-10-22 15:06:50', '9999-12-01 00:00:00', 'Silver', 'created', 1, 0, 1.50, 1.75, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (3, 1, 6, '2021-10-22 15:06:50', '9999-12-01 00:00:00', 'Gold', 'created', 200, 150, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (4, 1, 7, '2021-10-22 15:06:50', '9999-12-01 00:00:00', 'Green', 'created', 297, 253, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (5, 1, 6, '2021-10-22 15:06:50', '9999-12-01 00:00:00', 'Diamond', 'created', 398, 351, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);
INSERT INTO data_alfounet.loyalty_tiers_history (id_tier, id_program, history_sequence, history_start_date, history_end_date, name, status, entry_threshold, downgrade_threshold, multiplier_qpoints, multiplier_nqpoints, is_point_based, creation, id_user) VALUES (6, 1, 6, '2021-10-22 15:06:50', '9999-12-01 00:00:00', 'Red', 'created', 499, 450, 1.00, 2.00, 1, '2017-11-23 18:01:57', 0);

create table loyalty_status_expiration_history
(
    id                    int unsigned auto_increment
        primary key,
    id_loyalty_status     int unsigned                       not null,
    history_sequence      int                                not null,
    history_start_date    datetime                           not null,
    history_end_date      datetime                           not null,
    id_individual         int unsigned                       not null,
    id_program            int unsigned                       not null,
    program_join_date     datetime                           not null,
    card_expiration_date  datetime                           not null,
    is_active             tinyint  default 0                 not null,
    history_creation_date datetime default CURRENT_TIMESTAMP not null
);

create index id_loyalty_status
    on loyalty_status_expiration_history (id_loyalty_status);

create index loyalty_status_expiration_history_id_individual_IDX
    on loyalty_status_expiration_history (id_individual);

create table loyalty_events
(
    id                   bigint unsigned auto_increment
        primary key,
    is_system_event_type tinyint unsigned default 1                 not null,
    id_event_type        int unsigned                               not null,
    id_individual        int unsigned     default 0                 not null,
    id_loyalty_status    int unsigned     default 0                 not null,
    event_date           datetime         default CURRENT_TIMESTAMP not null,
    id_matched_rule      int unsigned     default 0                 not null,
    value_date           datetime(6)                                not null,
    processed            tinyint unsigned default 0                 not null,
    json_payload         json                                       not null,
    last_update          timestamp        default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create index id_event_type
    on loyalty_events (id_event_type, processed);

create index id_individual
    on loyalty_events (id_individual, value_date);

create index id_loyalty_status
    on loyalty_events (id_loyalty_status, value_date);

create index id_rule
    on loyalty_events (id_matched_rule, value_date);

create index processed
    on loyalty_events (processed);

create table loyalty_status_tier_history
(
    id                int unsigned auto_increment
        primary key,
    id_loyalty_status int unsigned not null,
    id_program        int unsigned not null,
    tier_change_date  datetime(6)  not null,
    id_previous_tier  int unsigned not null,
    id_new_tier       int unsigned not null,
    context           json         not null
)
    charset = latin1;

create index id_loyalty_status
    on loyalty_status_tier_history (id_loyalty_status, id_program, tier_change_date);

create table loyalty_programs
(
    id                                         int unsigned auto_increment
        primary key,
    name                                       tinytext                                      not null,
    description                                text                                          not null,
    start_date                                 datetime                                      not null,
    end_date                                   datetime                                      not null,
    creation                                   datetime                                      not null,
    last_update                                timestamp           default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    status                                     varchar(20)                                   not null,
    type                                       varchar(20)                                   not null,
    replicate_events                           tinyint(4) unsigned default 0                 not null,
    id_user                                    int(10)                                       not null,
    cascading                                  enum ('0', '1')                               not null,
    compute_period                             int(3) unsigned                               not null,
    downgrade_nb_rank                          int(2) unsigned                               not null,
    default_qpoints_validity_id_period         int unsigned                                  not null,
    default_qpoints_validity_days              int unsigned                                  not null,
    default_nqpoints_validity_id_period        int unsigned                                  not null,
    default_nqpoints_validity_days             int unsigned                                  not null,
    default_qpoints_holding_days               int unsigned                                  not null,
    default_nqpoints_holding_days              int unsigned                                  not null,
    max_qpoints                                int unsigned                                  not null,
    max_nqpoints                               int unsigned                                  not null,
    rounding_type                              varchar(16)                                   not null,
    default_points_to_amount_ratio             decimal(10, 2) unsigned                       not null,
    auto_generated_card_code                   tinyint             default 0                 not null,
    default_qpoints_validity_is_system_period  tinyint(3)          default 0                 not null,
    default_nqpoints_validity_is_system_period tinyint(3)          default 0                 not null,
    duplicate_events                           tinyint unsigned    default 0                 not null,
    auto_subscribe                             tinyint(1)          default 0                 not null,
    q_refund_mode                              varchar(7)          default 'cancel'          not null,
    nq_refund_mode                             varchar(7)          default 'cancel'          not null
);

INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (1, 'PopHat ', '', '2018-01-01 00:00:00', '0000-00-00 00:00:00', '2018-01-01 00:00:00', '2021-12-06 17:43:20', 'running', 'tiered', 1, 0, '0', 1, 1, 1, 0, 0, 60, 1, 1, 0, 0, 'round', 0.00, 1, 0, 0, 0, 1, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (2, 'Programme de Fid 2000', '', '2018-03-15 10:42:05', '0000-00-00 00:00:00', '2018-03-15 10:42:05', '2018-03-15 09:42:05', 'draft', 'tiered', 0, 0, '0', 1, 0, 1, 0, 0, 60, 0, 60, 0, 0, 'round', 10.00, 0, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (3, 'Auto program 2058', '', '2018-03-15 10:42:05', '0000-00-00 00:00:00', '2018-03-15 10:42:05', '2021-01-15 16:26:28', 'running', 'simple', 0, 0, '0', 1, 0, 1, 0, 0, 60, 0, 60, 0, 0, 'round', 10.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (4, 'Automatic sub & Use all events', '', '2020-03-19 14:25:06', '2022-02-11 00:05:00', '2020-03-19 14:25:09', '2021-11-29 10:19:11', 'finished', 'simple', 1, 16861, '1', 0, 0, 0, 365, 0, 365, 1, 2, 0, 0, 'round', 1.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (5, 'aze', '', '2020-03-19 17:47:56', '2020-03-19 17:48:10', '2020-03-19 17:48:01', '2020-03-19 17:48:10', 'deleted', 'tiered', 1, 16937, '1', 0, 1, 0, 365, 0, 365, 1, 1, 0, 0, 'round', 1.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (6, 'test tiered program', '', '2020-04-14 15:51:14', '2021-10-12 13:58:09', '2020-04-14 15:51:16', '2021-10-12 13:58:09', 'deleted', 'tiered', 1, 16861, '1', 0, 1, 0, 365, 0, 365, 0, 0, 0, 0, 'round', 1.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (7, 'test', '', '2020-06-01 23:55:00', '2020-06-02 14:14:10', '2020-06-01 18:17:21', '2020-06-02 14:14:10', 'deleted', 'simple', 1, 16861, '1', 0, 0, 0, 365, 0, 365, 1, 1, 0, 0, 'round', 1.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (8, 'test', '', '2020-06-02 14:15:58', '2021-10-12 13:55:39', '2020-06-02 14:16:07', '2021-10-12 13:55:39', 'deleted', 'simple', 1, 16861, '1', 0, 0, 0, 365, 0, 365, 1, 1, 0, 0, 'round', 1.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (9, 'CMP-4019', '', '2020-06-02 14:24:14', '2021-10-12 13:59:51', '2020-06-02 14:24:29', '2021-10-12 13:59:51', 'deleted', 'simple', 0, 11718, '1', 0, 0, 0, 365, 0, 365, 1, 1, 0, 0, 'round', 1.00, 1, 0, 0, 0, 0, 'cancel', 'cancel');
INSERT INTO data_alfounet.loyalty_programs (id, name, description, start_date, end_date, creation, last_update, status, type, replicate_events, id_user, cascading, compute_period, downgrade_nb_rank, default_qpoints_validity_id_period, default_qpoints_validity_days, default_nqpoints_validity_id_period, default_nqpoints_validity_days, default_qpoints_holding_days, default_nqpoints_holding_days, max_qpoints, max_nqpoints, rounding_type, default_points_to_amount_ratio, auto_generated_card_code, default_qpoints_validity_is_system_period, default_nqpoints_validity_is_system_period, duplicate_events, auto_subscribe, q_refund_mode, nq_refund_mode) VALUES (10, 'test tiered 2', '', '2020-06-03 11:05:00', '2021-12-22 00:00:00', '2020-06-03 10:59:54', '2021-10-14 11:20:42', 'finished', 'tiered', 1, 16861, '1', 0, 1, 0, 1460, 0, 365, 1, 0, 0, 0, 'round', 1.00, 0, 0, 0, 0, 0, 'cancel', 'cancel');

create table loyalty_fields
(
    intid             int unsigned auto_increment
        primary key,
    scope             varchar(20)            not null,
    id                int unsigned           not null,
    nom               tinytext               not null,
    description       tinytext               not null,
    data_type         varchar(32) default '' not null,
    data_type_applied tinyint(1)  default 0  not null,
    constraint scope
        unique (scope, id)
);

INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (1, 'rewards', 0, 'code_1', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (2, 'rewards', 1, 'code_2', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (3, 'rewards', 2, 'code_3', '', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (4, 'rewards', 3, 'code_4', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (5, 'rewards', 4, 'code_5', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (6, 'rewards', 5, 'code_6', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (8, 'loyalty', 1, 'code_2', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (9, 'loyalty', 2, 'code_3', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (10, 'loyalty', 3, 'code_4', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (11, 'loyalty', 4, 'code_5', 'external code', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (12, 'loyalty', 5, 'code_6', '', '', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (13, 'loyalty', 6, 'first_purchase', '', 'date', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (16, 'loyalty', 9, 'date c9', '', 'date', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (18, 'rewards', 6, 'first_purchase', '', 'date', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (14, 'loyalty', 7, 'store_visit', '', 'int', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (15, 'loyalty', 8, 'int c8', '', 'int', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (19, 'rewards', 7, 'store_visit', '', 'int', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (17, 'loyalty', 10, 'string c10', '', 'text', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (20, 'rewards', 8, 'text_definde', '', 'text', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (21, 'rewards', 9, 'gauthier_testing', '', 'text', 0);
INSERT INTO data_alfounet.loyalty_fields (intid, scope, id, nom, description, data_type, data_type_applied) VALUES (22, 'loyalty', 0, 'gauthier', '', 'text', 0);
