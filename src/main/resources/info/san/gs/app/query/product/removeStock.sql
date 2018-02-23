UPDATE product
SET stock_qty = stock_qty - :qty,
	version = version + 1,
	updated_at = strftime('%s000','now')
WHERE id = :id