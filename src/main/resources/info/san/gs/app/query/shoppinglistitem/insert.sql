INSERT INTO shopping_list_item (
	  id
	, shopping_list_id
	, product_id
	, qty
	, created_at
	, updated_at
	, version
	, deleted
) VALUES (
	  :id
	, :shoppingListId
	, :productId
	, :qty
	, strftime('%s000','now')
	, null
	, 1
	, 0
)
