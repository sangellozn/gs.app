SELECT 
	CASE 
		WHEN COUNT(*) > 0 THEN 'true'
		ELSE 'false'
	END
FROM shopping_list
WHERE state = 'OPENED'
