-- 코드를 입력하세요
SELECT product_code, 
    price*SUM(sales_amount) AS sales
FROM OFFLINE_SALE
    INNER JOIN PRODUCT
            ON PRODUCT.product_id = OFFLINE_SALE.product_id
GROUP by product_code
ORDER BY sales DESC, product_code ASC;