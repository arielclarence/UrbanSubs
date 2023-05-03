-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Nov 2021 pada 08.36
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javadb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dtrans`
--

CREATE TABLE `dtransmaincourse` (
  `idtrans` int(11) NOT NULL,
  `idroti` int(11) NOT NULL,
  `iddaging`int(11) NOT NULL,
  `topping` varchar(50),
  `jumlahmaincourse` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `dtransmaincourse` (`idtrans`, `idroti`, `iddaging`, `topping`,`jumlahmaincourse`,`subtotal`) VALUES
(1,1,6,null,2,56000),
(2,2,8,11,1,28000);





CREATE TABLE `dtransiminuman`(
  `idtrans` int(11) NOT NULL,
  `idminuman` int(11) NOT NULL,
  `jumlahminuman` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `dtransiminuman` (`idtrans`, `idminuman`, `jumlahminuman`, `subtotal`) VALUES
(1,16,1,8500),
(2,17,2,18000);


CREATE TABLE `htrans` (
  `idtrans` int(11) NOT NULL,
  `customer` varchar(255) NOT NULL,
  `tanggal` date NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `htrans` (`idtrans`, `customer`, `tanggal`, `total`) VALUES
(1, 'budi', '2021-11-16', 64500),
(2, 'asdsad', '2021-10-16',46000);


CREATE TABLE `menu` (
  `idmenu` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `idkategori` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `menu` (`idmenu`, `nama`, `harga`, `idkategori`,`stok`) VALUES
(1, 'roti gandum',8000,1,100),
(2, 'roti tawar',6000,1,100),
(3, 'roti keju',10000,1,100),
(4, 'roti honey oat',11000,1,100),
(5, 'roti wijen',9000,1,100),
(6, 'Ayam BBQ',20000,2,100),
(7, 'Sapi Black Pepper',22000,2,100),
(8, 'Ayam Teriyaki',18000,2,100),
(9, 'Tuna Melt',16000,2,100),
(10, 'Sapi Panggang',23000,2,100),
(11, 'Keju',4000,3,100),
(12, 'Jamur',3000,3,100),
(13, 'Acar',3000,3,100),
(14, 'Bawang Bombay',2000,3,100),
(15, 'Bacon',5000,3,100),
(16, 'Coca cola',8500,4,100),
(17, 'Sprite',9000,4,100),
(18, 'Orange Juice',8000,4,100),
(19, 'Teh Manis',7000,4,100),
(20, 'Mineral Water',6000,4,100);

CREATE TABLE `kategori` (
  `idkategori` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `kategori` (`idkategori`, `nama`) VALUES
(1, 'roti'),
(2, 'daging'),
(3, 'topping'),
(4, 'minuman');

--
-- Dumping data untuk tabel `dtrans`
--




-- --------------------------------------------------------

--
-- Struktur dari tabel `htrans`
--


--
-- Dumping data untuk tabel `htrans`
--








-- --------------------------------------------------------

--
-- Struktur dari tabel `kendaran`
--



--
-- Dumping data untuk tabel `kendaran`
--






--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dtrans`


--
-- Indeks untuk tabel `htrans`
--

--
-- Indeks untuk tabel `kendaran`
--
ALTER TABLE `htrans`
  ADD PRIMARY KEY (`idtrans`);

ALTER TABLE `menu`
  ADD PRIMARY KEY (`idmenu`);

ALTER TABLE `kategori`
ADD PRIMARY KEY (`idkategori`);

ALTER TABLE `dtransmaincourse`
ADD PRIMARY KEY (`idtrans`);

ALTER TABLE `dtransiminuman`
ADD PRIMARY KEY (`idtrans`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `htrans`
--
ALTER TABLE `htrans`
  MODIFY `idtrans` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `kendaran`
--
ALTER TABLE `menu`
  MODIFY `idmenu` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `dtrans`
--

ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`idkategori`) REFERENCES `kategori` (`idkategori`);
ALTER TABLE `dtransmaincourse`
  ADD CONSTRAINT `dtransma_ibfk_1idtrans` FOREIGN KEY (`idtrans`) REFERENCES `htrans` (`idtrans`);
ALTER TABLE `dtransiminuman`
  ADD CONSTRAINT `dtransmi_ibfk_1idtrans` FOREIGN KEY (`idtrans`) REFERENCES `htrans` (`idtrans`);
ALTER TABLE `dtransmaincourse`
  ADD CONSTRAINT `dtransma_ibfk_1roti` FOREIGN KEY (`idroti`) REFERENCES `menu` (`idmenu`);
ALTER TABLE `dtransmaincourse`
  ADD CONSTRAINT `dtransma_ibfk_2daging` FOREIGN KEY (`iddaging`) REFERENCES `menu` (`idmenu`);
ALTER TABLE `dtransiminuman`
  ADD CONSTRAINT `dtransmi_ibfk_1minum` FOREIGN KEY (`idminuman`) REFERENCES `menu` (`idmenu`);
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
