SELECT
	  sl.id as sl_id
	, sl.comment as sl_comment
	, sl.state as sl_state
	, sl.created_at as sl_created_at
	, sl.updated_at as sl_updated_at
	, sl.version as sl_version
	, sl.deleted as sl_deleted
	, sli.id as sli_id
	, sli.shopping_list_id as sli_shopping_list_id
	, sli.product_id as sli_product_id
	, sli.qty as sli_qty
	, sli.created_at as sli_created_at
	, sli.updated_at as sli_updated_at
	, sli.version as sli_version
	, sli.deleted as sli_deleted
	, p.id as p_id
	, p.name as p_name
	, p.description as p_description
	, p.ean13 as p_ean13
	, p.stock_qty as p_stock_qty
	, p.min_stock_qty as p_min_stock_qty
	, p.target_stock_qty as p_target_stock_qty
	, p.created_at as p_created_at
	, p.updated_at as p_updated_at
	, p.version as p_version
	, p.deleted as p_deleted
FROM shopping_list sl
INNER JOIN shopping_list_item sli on sli.shopping_list_id = sl.id
INNER JOIN product p on p.id = sli.product_id
WHERE sl.state = 'OPENED'