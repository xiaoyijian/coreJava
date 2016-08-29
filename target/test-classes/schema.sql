CREATE TABLE `m_users` (
  `user_id` varchar(36)  NOT NULL ,
  `name` varchar(50)  NOT NULL ,
  `code` varchar(50)  DEFAULT NULL,
);
CREATE TABLE `m_users2` (
  `user_id` varchar(36)  NOT NULL ,
  `password` varchar(50)  NOT NULL
);