SELECT * FROM USER

SELECT * FROM account
SELECT * FROM role

SELECT u.*,r.* FROM user_role ur
INNER JOIN USER u ON ur.uid = u.id
INNER JOIN role r ON ur.rid = r.r_id WHERE u.id = #{}