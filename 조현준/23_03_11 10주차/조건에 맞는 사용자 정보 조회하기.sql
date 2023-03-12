-- 코드를 입력하세요
with UGB as (
    SELECT writer_id, sum(price) as total from USED_GOODS_BOARD where status = 'DONE' group by writer_id
)

select UGU.user_id,UGU.nickname,UGB.total from USED_GOODS_USER as UGU join UGB on UGU.user_id = UGB.writer_id where UGB.total >= 700000 order by UGB.total asc;