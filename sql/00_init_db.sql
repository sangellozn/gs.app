
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

-- Create shoppingList table.

-- Create shoppingListItem table.