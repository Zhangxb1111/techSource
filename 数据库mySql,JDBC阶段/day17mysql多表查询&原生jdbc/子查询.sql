SELECT p.* FROM products p , category c WHERE p.category_id = c.cid AND c.cname = '化妆品';

SELECT p.* , FROM products p WHERE category_id = (SELECT cid FROM category c WHERE c.cname = '化妆品');

SELECT p.* FROM products WHERE category_id = (SELECT cid FROM category WHERE catergory.cname = '化妆品');

SELECT cid FROM category WHERE cname IN ('家电','化妆品');

SELECT * FROM product WHERE category_id IN('c001','c003') AND flag = '2';

SELECT * FROM products WHERE category_id IN(SELECT cid FROM category WHERE cname IN('化妆品','家电')) AND flag = '1';
