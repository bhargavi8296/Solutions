# Write your MySQL query statement below
select s.name from SalesPerson s where sales_id not in (select o.sales_id from Company c inner join Orders o on o.com_id=c.com_id where o.com_id in (select co.com_id from company co where co.name='RED'))