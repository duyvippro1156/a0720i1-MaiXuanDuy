-- 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
SELECT *,  SUBSTRING_INDEX(name, ' ', -1) AS Name
 FROM employee
 HAVING (Name LIKE 'h%'
 	OR Name LIKE 't%'
    OR Name LIKE 'k%')
    AND LENGTH(name) <= 15;

-- 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.  */
   select *, year(curdate()) - year(birthday) AS Age 
    from customer
    where address = 'da nang' 
		or address = 'quang tri' 
	having Age between 18 and 50;
    
-- 4: Đếm tương ứng mỗi khách hàng từng đặt phòng bao nhiêu lần. KQ hiểu thị tăng dần theo số lần đặt. Chỉ đếm customer có loại khách là "Dinamond"
SELECT  count(contract.id_customer) AS Amount, customer.id, customer.name, type_customer.name
from customer left join contract on customer.id = contract.id_customer
				join type_customer on customer.id =  type_customer.id
where type_customer.name = 'Diamond'
group by customer.id
order by Amount;

/* 5: Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
	TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, SoLuong và Giá là từ bảng DichVuDiKem
	cho tất cả các Khách hàng đã từng đặt phòng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
*/
SELECT 
customer.id,
customer.name,
type_customer.name,
contract.id,
contract.start_date,
contract.end_date,
services.name,
(services.price + contract_detail.amount * services_include.price) AS Total
FROM customer
left JOIN  
type_customer ON customer.id = type_customer.id
left join
contract on contract.id_customer = customer.id
left join
contract_detail on contract.id = contract_detail.id_contract
left join
services_include on services_include.id = contract_detail.id_services_include
left join 
services on services.id = contract.id_services
group by customer.name;
   
/* 6: Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt 
từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
*/
select services.id, services.name, services.area, services.price, type_services.name, temp.start_date
from services 
left join (select * from contract
	where contract.start_date between '2019-01-01' and '2019-03-31') AS Temp
	on services.id = temp.id_services
inner join type_services on services.id_type_services = type_services.id
group by services.name
having temp.start_date is null;

/* 7: Hiển thị IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
tất cả loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
*/
select services.id, services.name,services.area, services.amounts,services.price,
		type_services.name
from services
	inner join type_services on services.id_type_services = type_services.id
	inner join (select * from contract where year(start_date) = 2018) AS contract2018 
		on services.id = contract2018.id_services
	left join (select * from contract where year(start_date) = 2019) AS contract2019
		on services.id = contract2019.id_services
where contract2019.id_services is null;

/* 8: Hiển thị HoTenKhachHang không trùng nhau (làm 3 cách)*/
-- cách 1
select distinct customer.name
from customer;

-- cách 2
select customer.name
from customer
group by customer.name;

/*9: Thực hiện thống kê doanh thu theo tháng trong năm 2019, có bao nhiêu khách đặt phòng */            
select month(contract2019.start_date) as months,  (services.price + (contract_detail.amount * services_include.price)) as total,
		count(contract2019.id_customer) as count
from (select * from contract
		where year(contract.start_date) = 2019) as contract2019
join services on services.id = contract2019.id_services
join contract_detail on contract_detail.id_contract = contract2019.id
join services_include on services_include.id = contract_detail.id_services_include
group by months;

/*10: Hiển thị thông tin tương ứng Hợp đồng sử dụng bao nhiêu Dịch vụ đi kèm. 
	IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
	(được tính dựa trên việc count các IDHopDongChiTiet */
select contract.id, contract.start_date, contract.end_date, contract.deposit, count(contract_detail.id_services_include) as count
from contract
	join contract_detail on contract.id = contract_detail.id_contract
    join services_include on services_include.id = contract_detail.id_services_include
group by contract.id
order by contract.id;

/*11: Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và 
		có địa chỉ là “Da Lat” hoặc “Quảng Ngãi”.*/
select services_include.id, services_include.name, services_include.price, customer.id as id_customer, customer.name, type_customer.name
from services_include
	join contract_detail on contract_detail.id_services_include = services_include.id
	join contract on contract.id = contract_detail.id_contract
	join customer on contract.id_customer = customer.id
	join type_customer on type_customer.id = customer.id_type_customer
where type_customer.name = 'Diamond' and (customer.address = 'da nang' or customer.address = 'da lat')
group by services_include.id, customer.id;

/*12: Hiển thị IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem tính trên tổng Hợp đồng chi tiết, tienDatCoc 
	đặt 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/

select * 
from (select distinct contract.id  from contract where contract.start_date between '2019-10-01' and '2019-12-31') as contract1
	left join
		(select distinct contract.id  from contract where contract.start_date between '2019-01-01' and '2019-06-01')  as contract2
	on contract1.id = contract2.id
where contract2.id is null;

/*13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất 
bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
select * , count(contract_detail.id_services_include) as count
from services_include
join contract_detail on contract_detail.id_services_include = services_include.id
group by id_services_include
order by count desc;

/*14: Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất
 Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
 select contract.id, services.name as nameServices, services_include.name, count(contract_detail.id_services_include) as amount
 from  services_include
 join contract_detail on contract_detail.id_services_include = services_include.id
 join contract on contract.id = contract_detail.id_contract
 join services on services.id = contract.id_services
 group by contract.id
 having amount = 1;
 
  /*15: Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
 mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
select employee.id, employee.name, exp_employee.name, department_employee.name, employee.phone_number, count(contract.id_employee) as count,
year(start_date) st, year(end_date) as ed
from employee
join department_employee on department_employee.id = employee.id_department_employee
join exp_employee on exp_employee.id = employee.id_level_employee
join contract on contract.id_employee = employee.id
group by employee.id
having count <= 3 and (st between '2018' and '2019');

 /*16: Xóa những Nhân viên chưa từng lập được hợp đồng từ năm 2017 đến năm 2019.*/
 delete from employee
 where employee.id not in 
	(select contract.id_employee
		from contract
        where year(contract.start_date) between 2017 and 2019);

 /*17: Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
 chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/
 update customer
 set customer.id_type_customer = 1
 where customer.id_type_customer = 2 and customer.id_type_customer in
	(select contract.id_customer 
     from contract
     where contract.total >= 10000000 and year(contract.start_date) = 2019);
     
/*18: Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).*/
 delete from customer
 where customer.id in  
	(select contract.id_customer 
	from contract
	where year(contract.start_date) < 2016);

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update services_include as dvdk,
(select contract_detail.id_services_include, count(contract_detail.id) as SoLanSuDung 
from contract inner join contract_detail on contract.id = contract_detail.id_contract
where Year(contract.start_date) = 2019
group by contract_detail.id_services_include) as DichVuDiKem2019
set dvdk.price = dvdk.price * 2
where dvdk.id = DichVuDiKem2019.id_services_include
and dvdk.unit > 10;

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select concat('NV - ',id), name, email, phone_number, birthday, address from employee
union all
select concat('KH - ',id), name, email, phone_number, birthday, address from customer;