UPDATE product
SET deleted = 1,
	updated_at = strftime('%s000','now')
WHERE id = :id