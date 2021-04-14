create table tblTruong(
	MaTruong	varchar(5) not null,
	TenTruong	varchar(50) not null,
    primary key (MaTruong)
);

create table tblNhanVien(
	MaNV	varchar(10) not null,
	TenNV	varchar(50) not null,
    DienThoaiCoDinh	varchar(12) null unique
		check(DienThoaiCoDinh like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	DienThoaiDiDong	varchar(10) null unique
		check(DienThoaiDiDong like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Email nchar(30) null unique
		check(Email like '[A-Za-z]%@gmail.com'),
	primary key (MaNV)
);

create table tblKhoa(
	MaKhoa	varchar(5) not null primary key,
	TenKhoa	varchar(50) not null,
	MaTruong	varchar(5) not null,
    foreign key (MaKhoa) references tblTruong(MaTruong)
);

create table tblLopSinhHoat(
	MaLSH	varchar(5) not null primary key,
	TenLSH	varchar(50) not null,
    MaKhoa	varchar(5) not null,
    foreign key (MaKhoa) references tblKhoa(MaKhoa)
);

create table tblSinhVien(
	MaSV		varchar(10) not null,
	MatKhau		varchar(20) not null,
	HoLot		varchar(50) not null,
	Ten			varchar(50) not null,
	NgaySinh	date not null,
	GioiTinh	char(1) null
		check(GioiTinh in ('M','F')),
	QueQuan		varchar(50) null,
	MaLSH		varchar(5) not null,
    primary key (MaSV),
    foreign key (MaLSH) references tblLopSinhHoat(MaLSH)
);

create table tblSach(
	MaSach		varchar(5) not null,
	TenSach		varchar(50) not null,
	NoiDungTomTat	text null,
	ThuocLinhVuc	varchar(50) null,
	TacGia			varchar(50) null,
	NhaXuatBan		varchar(50) null,
	NamXuatBan		int null,
	SoLuongCon		int not null,
	GiaTien			decimal(20,2) not null
		check(GiaTien > 0),
	primary key (MaSach)
);

create table tblDangKyMuon(
	MaSV	varchar(10) not null,
	foreign key (MaSV) references tblSinhVien(MaSV),
	MaSach	varchar(5) not null,
    foreign key (MaSach) references tblSach(MaSach),
	NgayDangKy		date not null,
	primary key(MaSV,MaSach,NgayDangKy),
	DatMuon			char(1) null,
	TinhTrangMuon	char(1) null
	check(TinhTrangMuon in ('M','T','K'))
);

create table tblMuonTra(
	MaSV		varchar(10) not null, 
	foreign key (MaSV) references  tblSinhVien(MaSV),
	MaSach		varchar(5) not null,
    foreign key (MaSach) references tblSach(MaSach),
	NgayMuon	date not null,
	MaNV		varchar(10) not null,
    foreign key (MaNV) references tblNhanVien(MaNV),
	primary key(MaSV,MaSach,NgayMuon),
	NgayHenTra		date null,
		check(NgayHenTra >= NgayMuon),
	NgayThucTra		date null,
	check(NgayThucTra <= NgayHenTra),
	CoQuaHan		char(1) null
		check(CoQuaHan in ('Y','N')),
	CoHuHong		char(1) null
		check(CoHuHong in ('Y','N')),
	CoMatSach		char(1) null
		check(CoMatSach in ('Y','N')),
	TienPhatCuonSach decimal(20,2) null
		check(TienPhatCuonSach >= 0)
)
