
-- Create product table.
CREATE TABLE `product` (
	`id`	TEXT NOT NULL CHECK(length(id) = 36),
	`name`	TEXT NOT NULL,
	`description`	TEXT NOT NULL,
	`ean13`	TEXT NOT NULL,
	`stock_qty`	NUMERIC NOT NULL,
	`min_stock_qty`	NUMERIC NOT NULL,
	`target_stock_qty`	NUMERIC NOT NULL CHECK(target_stock_qty > min_stock_qty),
	`created_at`	INTEGER NOT NULL,
	`updated_at`	INTEGER,
	`version`	INTEGER NOT NULL DEFAULT 1,
	`deleted`	INTEGER NOT NULL CHECK(deleted in (0,1)),
	PRIMARY KEY(`id`)
);

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

-- Create shoppingList table.

-- Create shoppingListItem table.