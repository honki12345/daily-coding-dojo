SET @HOUR = -1;

SELECT 
	(@HOUR := @HOUR + 1) AS HOUR,
	(
    	SELECT
        	COUNT(HOUR(datetime))
        FROM
        	ANIMAL_OUTS
        WHERE HOUR(datetime) = @HOUR
    ) AS COUNT
FROM ANIMAL_OUTS outs
WHERE @HOUR < 23;
