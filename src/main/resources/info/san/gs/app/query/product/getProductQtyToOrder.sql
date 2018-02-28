SELECT 
	  id
	, target_stock_qty - stock_qty as qty
FROM product
WHERE stock_qty <= min_stock_qty