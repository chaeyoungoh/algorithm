-- 코드를 입력하세요
SELECT date_format(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount
from ONLINE_SALE 
where date_format(sales_date, '%Y-%m') = '2022-03'
union
SELECT date_format(sales_date, '%Y-%m-%d') sales_date, product_id, null 'user_id', sales_amount
from OFFLINE_SALE 
where date_format(sales_date, '%Y-%m') = '2022-03'

order by sales_date, product_id, user_id

# SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') SALES_DATE,PRODUCT_ID,USER_ID,SALES_AMOUNT
# from ONLINE_SALE
# WHERE DATE_FORMAT(SALES_DATE,'%Y-%m')='2022-03'
# UNION
# SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') SALES_DATE,PRODUCT_ID,NULL 'USER_NAME',SALES_AMOUNT
# from OFFLINE_SALE
# WHERE DATE_FORMAT(SALES_DATE,'%Y-%m')='2022-03'

# ORDER BY SALES_DATE,PRODUCT_ID,USER_ID