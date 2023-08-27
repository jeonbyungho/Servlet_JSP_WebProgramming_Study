CREATE TABLE temp (
	"id" NUMBER(6,0),
	"name" VARCHAR2(25)
);

SELECT *
FROM TEMP t ;

INSERT INTO TEMP t VALUES (1, '자바');
INSERT INTO TEMP t VALUES (2, 'html');
INSERT INTO TEMP t VALUES (3, 'servlet');
INSERT INTO TEMP t VALUES (4, '데이터 베이스');
INSERT INTO TEMP t VALUES (5, 'jsp');
INSERT INTO TEMP t VALUES (6, 'mybatis');
INSERT INTO TEMP t VALUES (0, 'Web Programming');

SELECT * FROM temp t WHERE t."id" = 1;