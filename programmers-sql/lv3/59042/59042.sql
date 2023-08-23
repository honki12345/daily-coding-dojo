SELECT
	outs.ANIMAL_ID, outs.NAME
FROM
	ANIMAL_OUTS outs
LEFT JOIN ANIMAL_INS ins
	ON outs.ANIMAL_ID = ins.ANIMAL_ID
WHERE ins.ANIMAL_ID IS NULL
ORDER BY outs.ANIMAL_ID asc
;