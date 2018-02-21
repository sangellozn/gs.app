UPDATE product
SET name = :name
	, description = :description
	, ean13 = :ean13
	, stock_qty = :stockQty
	, min_stock_qty = :minStockQty
	, target_stock_qty = :targetStockQty
	, updated_at = strftime('%s000','now')
	, version = version + 1
WHERE id = :id