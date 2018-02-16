
-- Create product table.
CREATE TABLE `product` (
	`id`	VARCHAR(36) NOT NULL CHECK(length(id) = 36),
	`name`	VARCHAR(100) NOT NULL,
	`description`	VARCHAR(255) NOT NULL,
	`ean13`	VARCHAR(13) NOT NULL CHECK(length(ean13) = 13),
	`stock_qty`	DECIMAL(10,2) NOT NULL,
	`min_stock_qty`	DECIMAL(10,2) NOT NULL,
	`target_stock_qty`	DECIMAL(10,2) NOT NULL CHECK(target_stock_qty > min_stock_qty),
	`created_at`	INTEGER NOT NULL,
	`updated_at`	INTEGER,
	`version`	INTEGER NOT NULL DEFAULT 1,
	`deleted`	INTEGER NOT NULL CHECK(deleted in (0,1)),
	PRIMARY KEY(`id`)
);

-- Create shoppingList table.

-- Create shoppingListItem table.

-- Table for DDD event.
CREATE TABLE DomainEventEntry (
	globalIndex INTEGER PRIMARY KEY AUTOINCREMENT,
	aggregateIdentifier VARCHAR(255) NOT NULL,
	sequenceNumber BIGINT NOT NULL,
	`type` VARCHAR(255),
	eventIdentifier VARCHAR(255) NOT NULL,
	metaData blob,
	payload blob NOT NULL,
	payloadRevision VARCHAR(255),
	payloadType VARCHAR(255) NOT NULL,
	timeStamp VARCHAR(255) NOT NULL,
	UNIQUE (aggregateIdentifier, sequenceNumber),
	UNIQUE (eventIdentifier)
);