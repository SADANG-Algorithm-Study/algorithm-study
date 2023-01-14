select p.product_code,sum(os.sales_amount * p.price) as sales
    from product p
        inner join offline_sale os
            on(p.product_id = os.product_id)
    group by p.PRODUCT_CODE
    order by sales desc,p.product_code asc;