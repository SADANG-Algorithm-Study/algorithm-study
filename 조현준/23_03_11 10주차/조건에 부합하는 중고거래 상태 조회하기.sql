-- 코드를 입력하세요
SELECT board_id,writer_id,title,price,CASE
                                          WHEN status = 'DONE' THEN '거래완료'
                                          WHEN status = 'SALE' THEN '판매중'
                                          WHEN status = 'RESERVED' THEN '예약중'
    END as status from USED_GOODS_BOARD where created_date = '2022-10-05' order by board_id desc