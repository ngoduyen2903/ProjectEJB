USE [master]
GO
/****** Object:  Database [AssignmentA20173]    Script Date: 11/27/2022 2:32:30 AM ******/
CREATE DATABASE [AssignmentA20173]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AssignmentA20173', FILENAME = N'E:\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\AssignmentA20173.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'AssignmentA20173_log', FILENAME = N'E:\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\AssignmentA20173_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [AssignmentA20173] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AssignmentA20173].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AssignmentA20173] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AssignmentA20173] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AssignmentA20173] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AssignmentA20173] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AssignmentA20173] SET ARITHABORT OFF 
GO
ALTER DATABASE [AssignmentA20173] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AssignmentA20173] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AssignmentA20173] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AssignmentA20173] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AssignmentA20173] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AssignmentA20173] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AssignmentA20173] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AssignmentA20173] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AssignmentA20173] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AssignmentA20173] SET  ENABLE_BROKER 
GO
ALTER DATABASE [AssignmentA20173] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AssignmentA20173] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AssignmentA20173] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AssignmentA20173] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AssignmentA20173] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AssignmentA20173] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AssignmentA20173] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AssignmentA20173] SET RECOVERY FULL 
GO
ALTER DATABASE [AssignmentA20173] SET  MULTI_USER 
GO
ALTER DATABASE [AssignmentA20173] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AssignmentA20173] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AssignmentA20173] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AssignmentA20173] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [AssignmentA20173] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [AssignmentA20173] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'AssignmentA20173', N'ON'
GO
ALTER DATABASE [AssignmentA20173] SET QUERY_STORE = OFF
GO
USE [AssignmentA20173]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Fullname] [nvarchar](255) NOT NULL,
	[Username] [nvarchar](255) NOT NULL,
	[Password] [nvarchar](255) NOT NULL,
	[Email] [nvarchar](255) NOT NULL,
	[Phone] [nvarchar](20) NOT NULL,
	[Status] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [bigint] IDENTITY(10000,1) NOT NULL,
	[CategoryName] [nvarchar](255) NOT NULL,
	[CategoryDescription] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[ID] [bigint] IDENTITY(10000,1) NOT NULL,
	[OrderID] [bigint] NOT NULL,
	[ProID] [bigint] NOT NULL,
	[PriceEach] [money] NOT NULL,
	[QuantityOrdered] [int] NOT NULL,
	[TotalPrice] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [bigint] IDENTITY(10000,1) NOT NULL,
	[ID] [int] NOT NULL,
	[OrderDate] [date] NOT NULL,
	[PhoneShip] [nvarchar](255) NOT NULL,
	[AddressShip] [nvarchar](255) NOT NULL,
	[Note] [nvarchar](255) NOT NULL,
	[TotalAmount] [int] NOT NULL,
	[OrderStatus] [nvarchar](255) NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProID] [bigint] IDENTITY(10000,1) NOT NULL,
	[ProductName] [nvarchar](255) NOT NULL,
	[SupID] [bigint] NOT NULL,
	[CategoryID] [bigint] NOT NULL,
	[UnitPrice] [money] NOT NULL,
	[Quantity] [int] NULL,
	[Image] [nvarchar](255) NULL,
	[StatusSale] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[SupID] [bigint] IDENTITY(10000,1) NOT NULL,
	[SupplierName] [nvarchar](255) NOT NULL,
	[Address] [nvarchar](255) NULL,
	[Phone] [nvarchar](255) NULL,
	[HomePage] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[SupID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 11/27/2022 2:32:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Fullname] [nvarchar](255) NOT NULL,
	[Username] [nvarchar](255) NOT NULL,
	[Password] [nvarchar](255) NOT NULL,
	[Email] [nvarchar](255) NOT NULL,
	[Phone] [nvarchar](20) NOT NULL,
	[Status] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (1, N'Ngô Thị Cẩm Duyên ', N'ngoduyen', N'admin', N'ngothicamduyen2903@gmail.com', N'0387090621', NULL)
SET IDENTITY_INSERT [dbo].[Admin] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [CategoryDescription]) VALUES (10007, N'Home Design', N'Decoration and design for the space at home')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [CategoryDescription]) VALUES (10008, N'Office Design', N'Decoration and design for the space at the office')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [CategoryDescription]) VALUES (10009, N'Terrarium', N'Decoration and design for space at cafe, home, gift')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [CategoryDescription]) VALUES (10010, N'Pots', N'Decoration and design for space at cafe, home, gift')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [CategoryDescription]) VALUES (10011, N'Stone Lotus', N'Decoration and design for space at cafe, home, gift')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [CategoryDescription]) VALUES (10012, N'Cactus', N'Decoration and design for space at cafe, home, gift')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 

INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10001, 10006, 10021, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10002, 10007, 10020, 2.0000, 1, 2.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10003, 10007, 10021, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10004, 10008, 10022, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10005, 10008, 10024, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10006, 10009, 10022, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10007, 10009, 10024, 100.0000, 2, 200.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10008, 10010, 10019, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10009, 10010, 10029, 100.0000, 3, 300.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10010, 10011, 10019, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10011, 10011, 10029, 100.0000, 3, 300.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10012, 10012, 10019, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10013, 10012, 10029, 100.0000, 3, 300.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10014, 10014, 10019, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10016, 10015, 10020, 2.0000, 1, 2.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10017, 10015, 10012, 3.0000, 1, 3.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10018, 10016, 10019, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10019, 10017, 10017, 10.0000, 2, 20.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10020, 10017, 10021, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10021, 10018, 10020, 2.0000, 1, 2.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10022, 10018, 10012, 3.0000, 3, 9.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10023, 10019, 10020, 2.0000, 1, 2.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10024, 10019, 10023, 100.0000, 1, 100.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10025, 10020, 10024, 100.0000, 4, 400.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10026, 10021, 10013, 3.0000, 1, 3.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10027, 10022, 10013, 3.0000, 1, 3.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10028, 10023, 10013, 3.0000, 1, 3.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10029, 10024, 10014, 3.0000, 1, 3.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10030, 10025, 10020, 2.0000, 1, 2.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10031, 10025, 10025, 100.0000, 2, 200.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10032, 10026, 10016, 10.0000, 2, 20.0000)
INSERT [dbo].[OrderDetails] ([ID], [OrderID], [ProID], [PriceEach], [QuantityOrdered], [TotalPrice]) VALUES (10033, 10026, 10029, 100.0000, 1, 100.0000)
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10000, 1, CAST(N'2022-11-20' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'That''s my note', 1, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10001, 1, CAST(N'2022-11-20' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'That''s my note', 1, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10002, 1, CAST(N'2022-11-20' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'That''s my note', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10003, 1, CAST(N'2022-11-20' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'That''s my note', 1, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10004, 1, CAST(N'2022-11-20' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'That''s my note', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10005, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'That''s my note', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10006, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'That''s my note', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10007, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'That''s my note', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10008, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'That''s my note', 2, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10009, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'That''s my note', 2, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10010, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'No notes', 2, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10011, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 2, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10012, 1, CAST(N'2022-11-21' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'No notes', 2, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10014, 1, CAST(N'2022-11-23' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 2, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10015, 1, CAST(N'2022-11-24' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 2, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10016, 1, CAST(N'2022-11-24' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10017, 1, CAST(N'2022-11-24' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 2, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10018, 1, CAST(N'2022-11-25' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'No notes', 2, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10019, 1, CAST(N'2022-11-25' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 2, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10020, 1, CAST(N'2022-11-25' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10021, 1, CAST(N'2022-11-25' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 1, N'1')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10022, 1, CAST(N'2022-11-26' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'No notes', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10023, 11, CAST(N'2022-11-26' AS Date), N'0387090621', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'No notes', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10024, 11, CAST(N'2022-11-26' AS Date), N'0349334717', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'No notes', 1, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10025, 1, CAST(N'2022-11-26' AS Date), N'0387090621', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'No notes', 2, N'2')
INSERT [dbo].[Orders] ([OrderID], [ID], [OrderDate], [PhoneShip], [AddressShip], [Note], [TotalAmount], [OrderStatus]) VALUES (10026, 1, CAST(N'2022-11-27' AS Date), N'0387090621', N'Cần Thơ', N'This is my note', 2, N'2')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10012, N'Sen Đá Vỉ', 10003, 10007, 2.0000, 50, N'uploads\sendavi.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10013, N'Sen Đá Chuỗi Ngọc Đứng', 10003, 10011, 3.0000, 500, N'uploads\chuoingocdung.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10014, N'Sen Đá Chuỗi Ngọc', 10003, 10011, 3.0000, 50, N'uploads\chuoingoc.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10015, N'Sen Đá Nâu', 10003, 10011, 10.0000, 40, N'uploads\sendanau.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10016, N'Sen Đá Phật Bà Xanh', 10003, 10011, 10.0000, 40, N'uploads\phatbaxanh.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10017, N'Sen Đá Phật Bà Đỏ', 10003, 10011, 3.0000, 40, N'uploads\phatbado.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10019, N'Sen Đá Chuỗi Ngọc', 10004, 10011, 100.0000, 40, N'img/shop/senda/chuoingoc.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10020, N'Sen Đá Giva', 10003, 10007, 2.0000, 40, N'img/shop/senda/giva.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10021, N'Móng Rồng', 10004, 10011, 100.0000, 40, N'img/shop/senda/mongrong.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10022, N'Sen Đá Sedum', 10004, 10011, 100.0000, 40, N'img/shop/senda/sedum.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10023, N'Xương Rồng Khế Bụi Vàng', 10004, 10012, 100.0000, 40, N'img/shop/xuongrong/buivang.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10024, N'Xương Rồng Khế Xanh Bụi', 10004, 10012, 100.0000, 40, N'img/shop/xuongrong/buixanh.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10025, N'Xương Rồng Lông Thiên Nga Bụi', 10004, 10012, 100.0000, 40, N'img/shop/xuongrong/thiennga.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10026, N'Xương Rồng Bóng Vàng Bụi', 10004, 10012, 100.0000, 40, N'img/shop/xuongrong/bongvangbui.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10027, N'Xương Rồng Hồng Tử Đinh', 10004, 10012, 100.0000, 40, N'img/shop/xuongrong/tudinh.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10028, N'Chậu Gốm Vân Đá Trụ Tròn', 10004, 10010, 100.0000, 40, N'img/shop/pot/vanda.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10029, N'Chậu Gốm Chữ Nhật Khóm Hoa', 10004, 10010, 100.0000, 2, N'img/shop/pot/khomhoa.jpg', 1)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10067, N'Chậu Sen Đá Tiểu Cảnh', 10006, 10009, 11.0000, 20, N'uploads\tieucanh.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10068, N'Chậu Sen Đá Tiểu Cảnh 100', 10006, 10007, 10.0000, 23, N'uploads\tieucanh1.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10069, N'Chậu Sen Đá Tiểu Cảnh 101', 10006, 10009, 12.0000, 12, N'uploads\tieucanh2.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10070, N'Chậu Sen Đá Tiểu Cảnh 102', 10006, 10009, 11.0000, 50, N'uploads\tieucanh3.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10071, N'Chậu Sen Đá Tiểu Cảnh 105', 10006, 10009, 13.0000, 25, N'uploads\tieucanh4.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10072, N'Chậu Sen Đá Tiểu Cảnh 106', 10006, 10009, 14.0000, 20, N'uploads\tieucanh5.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10073, N'Chậu Sen Đá Tiểu Cảnh 107', 10006, 10009, 12.0000, 30, N'uploads\tieucanh6.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10074, N'Sen Đá Đô La Hồng', 10005, 10011, 12.0000, 30, N'uploads\dolahong.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10075, N'Xương Rồng Mix', 10005, 10012, 7.0000, 30, N'uploads\xuongrong.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10076, N'Xương Rồng Có Hoa', 10003, 10012, 4.0000, 30, N'uploads\xuongrong1.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10077, N'Xương Rồng Mix', 10003, 10012, 8.0000, 50, N'uploads\xuongrong2.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10078, N'Xương Rồng Mắc Áo', 10003, 10012, 3.0000, 40, N'uploads\xuongrong3.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10079, N'Xương Rồng Thanh Sơn', 10003, 10012, 3.0000, 60, N'uploads\xuongrong4.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10080, N'Sen Đá Ngọc', 10003, 10011, 3.0000, 40, N'uploads\sendangoc.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10081, N'Sen Đá Hồng Dâu', 10003, 10011, 2.0000, 50, N'uploads\hongdau.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10082, N'Sen Đá Xanh', 10003, 10011, 4.0000, 60, N'uploads\xanh.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10083, N'Sen Đá Kim', 10005, 10011, 3.0000, 50, N'uploads\kim.jpg', NULL)
INSERT [dbo].[Products] ([ProID], [ProductName], [SupID], [CategoryID], [UnitPrice], [Quantity], [Image], [StatusSale]) VALUES (10084, N'Sen Đá Viền Đỏ', 10003, 10011, 5.0000, 90, N'uploads\viendo.jpg', NULL)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Suppliers] ON 

INSERT [dbo].[Suppliers] ([SupID], [SupplierName], [Address], [Phone], [HomePage]) VALUES (10003, N'Marvin', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'0387090621', N'marvin.vn')
INSERT [dbo].[Suppliers] ([SupID], [SupplierName], [Address], [Phone], [HomePage]) VALUES (10004, N'Kathy', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'0387090621', N'kathy.vn')
INSERT [dbo].[Suppliers] ([SupID], [SupplierName], [Address], [Phone], [HomePage]) VALUES (10005, N'Marvin', N'My Loi A, Huynh Huu Nghia Town, My Tu, Soc Trang', N'0387090621', N'marvin.vn')
INSERT [dbo].[Suppliers] ([SupID], [SupplierName], [Address], [Phone], [HomePage]) VALUES (10006, N'Terrarium', N'28/60 Mau Than, An Hoa, Ninh Kieu, Can Tho', N'0349334717', N'terrarium.vn')
SET IDENTITY_INSERT [dbo].[Suppliers] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (1, N'Duyên Ngô Thị Cẩm', N'ngoduyen', N'user', N'ngothicamduyen2903@gmail.com', N'0387090621', NULL)
INSERT [dbo].[Users] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (10, N'Doraemon', N'doraemon', N'user', N'ngothicamduyen2903@gmail.com', N'0387090621', NULL)
INSERT [dbo].[Users] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (11, N'Nobi Nobita', N'nobita', N'user', N'ngothicamduyen2903@gmail.com', N'0387090621', N'')
INSERT [dbo].[Users] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (12, N'Cẩm Duyên', N'camduyen', N'user', N'ngothicamduyen2002@gmail.com', N'0387090621', NULL)
INSERT [dbo].[Users] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (13, N'Shizuka', N'shizuka', N'user', N'ngothicamduyen2903@gmail.com', N'0387090621', NULL)
INSERT [dbo].[Users] ([ID], [Fullname], [Username], [Password], [Email], [Phone], [Status]) VALUES (14, N'Ngô Thị Cẩm Duyên', N'ngothicamduyen2903', N'user', N'ntcduyen2903@gmail.com', N'0387090621', NULL)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Products] ADD  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[Products] ADD  DEFAULT ((0)) FOR [StatusSale]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Orders] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Orders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_pro] FOREIGN KEY([ProID])
REFERENCES [dbo].[Products] ([ProID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_pro]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Us] FOREIGN KEY([ID])
REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Us]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Cate] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Cate]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Sup] FOREIGN KEY([SupID])
REFERENCES [dbo].[Suppliers] ([SupID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Sup]
GO
USE [master]
GO
ALTER DATABASE [AssignmentA20173] SET  READ_WRITE 
GO
