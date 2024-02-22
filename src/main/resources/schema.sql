CREATE DATABASE IF NOT EXISTS `grocery_app`;
USE grocery_app;

-- Check if the table grocery_item exists before creating it
CREATE TABLE IF NOT EXISTS `grocery_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `quantity_in_stock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Check if the table roles exists before creating it
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL,
  `name` enum('ROLE_USER','ROLE_ADMIN') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Check if the table roles_seq exists before creating it
CREATE TABLE IF NOT EXISTS `roles_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Check if the table user exists before creating it
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Check if the table order exists before creating it
CREATE TABLE IF NOT EXISTS `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrcaf946w0bh6qj0ljiw3pwpnu` (`user_id`),
  CONSTRAINT `FKrcaf946w0bh6qj0ljiw3pwpnu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Check if the table order_item exists before creating it
CREATE TABLE IF NOT EXISTS `order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `grocery_item_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3egjxcos0tgqr3p7p998g7ehl` (`grocery_item_id`),
  KEY `FK7pv97udw3cbgddveqn6eoosng` (`order_id`),
  CONSTRAINT `FK3egjxcos0tgqr3p7p998g7ehl` FOREIGN KEY (`grocery_item_id`) REFERENCES `grocery_item` (`id`),
  CONSTRAINT `FK7pv97udw3cbgddveqn6eoosng` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Check if the table user_roles exists before creating it
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FK7ivp84f52aa3vd7ndq0oh0279` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
