SELECT id
	, name
	, description
	, ean13
	, stock_qty
	, min_stock_qty
	, target_stock_qty
	, created_at
	, updated_at
	, version
	, deleted
FROM product 
WHERE id = :id