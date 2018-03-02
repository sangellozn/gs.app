INSERT INTO product (
	  id
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
) VALUES (
	  :id
	, :name
	, :description
	, :ean13
	, :stockQty
	, :minStockQty
	, :targetStockQty
	, strftime('%s000','now')
	, null
	, 1
	, 0
)