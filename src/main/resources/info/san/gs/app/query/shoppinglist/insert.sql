INSERT INTO shopping_list (
	  id
	, comment
	, state
	, created_at
	, updated_at
	, version
	, deleted
)
VALUES(
	  :id
	, :comment
	, 'OPENED'
	, strftime('%s000','now')
	, null
	, 1
	, 0
)
