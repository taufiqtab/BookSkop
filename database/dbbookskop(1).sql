-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2016 at 09:35 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbookskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `bangku`
--

CREATE TABLE `bangku` (
  `id` int(11) NOT NULL,
  `nomor_studio` char(1) NOT NULL,
  `bioskop` varchar(20) NOT NULL,
  `a1` int(11) NOT NULL,
  `a2` int(11) NOT NULL,
  `a3` int(11) NOT NULL,
  `a4` int(11) NOT NULL,
  `b1` int(11) NOT NULL,
  `b2` int(11) NOT NULL,
  `b3` int(11) NOT NULL,
  `b4` int(11) NOT NULL,
  `c1` int(11) NOT NULL,
  `c2` int(11) NOT NULL,
  `c3` int(11) NOT NULL,
  `c4` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bangku`
--

INSERT INTO `bangku` (`id`, `nomor_studio`, `bioskop`, `a1`, `a2`, `a3`, `a4`, `b1`, `b2`, `b3`, `b4`, `c1`, `c2`, `c3`, `c4`) VALUES
(1, '1', 'Detos XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, '1', 'Plaxa XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, '1', 'Margo XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, '2', 'Detos XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, '2', 'Plaza XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, '2', 'Margo XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, '3', 'Detos XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, '3', 'Plaza XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, '3', 'Margo XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(10, '4', 'Detos XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(11, '4', 'Plaza XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(12, '4', 'Margo XXI', 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1),
(13, '5', 'Detos XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(14, '5', 'Plaza XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(15, '5', 'Margo XXI', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bioskop`
--

CREATE TABLE `bioskop` (
  `id` int(11) NOT NULL,
  `nama_bioskop` varchar(30) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  `daerah` varchar(30) NOT NULL,
  `nomor_studio` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bioskop`
--

INSERT INTO `bioskop` (`id`, `nama_bioskop`, `alamat`, `daerah`, `nomor_studio`) VALUES
(1, 'Detos XXI', 'Depok Detos', 'Depok', 1),
(3, 'Plaza XXI', 'Plaza Ramayana', 'Depok', 3),
(4, 'Margo XXI', 'Margonda', 'Depok', 2);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `judul` varchar(120) NOT NULL,
  `sutradara` varchar(70) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `durasi` varchar(15) NOT NULL,
  `tanggal` date NOT NULL,
  `jam_mulai` time NOT NULL,
  `jam_selesai` time NOT NULL,
  `harga` int(11) NOT NULL,
  `nama_bioskop` varchar(30) NOT NULL,
  `nomor_studio` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id`, `judul`, `sutradara`, `kategori`, `durasi`, `tanggal`, `jam_mulai`, `jam_selesai`, `harga`, `nama_bioskop`, `nomor_studio`) VALUES
(1, 'My Stupid Bos', 'Falcon Picture', 'Drama Parody', '2', '2016-06-02', '08:00:00', '10:00:00', 25000, 'Detos XXI', 2),
(2, 'Final Fantasy VII', 'Squarenix', 'Fantasy', '3', '2016-06-23', '11:00:00', '14:00:00', 30000, 'Plaza XXI', 1),
(3, 'Naruto Taubat', 'Uzumaki Fakhri', 'Parody', '2', '2016-12-12', '01:00:15', '01:00:20', 100, 'Margo XXI', 3),
(6, 'Tahu Bulat TheMovie', 'Yusuf Mata Air', 'Parody', '3', '2016-12-13', '02:00:15', '04:00:20', 60000, 'Plaza XXI', 5),
(9, 'Dora Explorer', 'ucup', 'lawak', '2', '2016-04-12', '12:00:01', '14:00:01', 25500, 'Detos XXI', 1),
(11, 'London Has Molen', 'Brian Swimmer', 'Drama horor', '3', '2016-05-12', '13:00:01', '16:00:01', 31000, 'Plaza XXI', 2),
(14, 'X-Women', 'Jhon Thor', 'Action', '2', '2016-05-18', '12:00:02', '14:00:02', 35000, 'Margo XXI', 4),
(15, 'Rumah Kepemimpinan', 'Bahri Sutejo', 'Romance', '3', '2016-07-11', '11:00:02', '14:00:03', 40000, 'Detos XXI', 5);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(70) NOT NULL,
  `nama_bioskop` varchar(30) NOT NULL,
  `nomor_studio` char(1) NOT NULL,
  `judul` varchar(120) NOT NULL,
  `waktu_pemesanan` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tanggal` date NOT NULL,
  `waktu_mulai` time NOT NULL,
  `waktu_selesai` time NOT NULL,
  `baris` char(1) NOT NULL,
  `nomor_bangku` varchar(3) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `nama_bioskop`, `nomor_studio`, `judul`, `waktu_pemesanan`, `tanggal`, `waktu_mulai`, `waktu_selesai`, `baris`, `nomor_bangku`, `harga`) VALUES
(1, 'Abang', 'Margo', '2', 'Boss', '2016-06-09 15:01:36', '2016-06-15', '05:00:00', '08:00:00', '3', 'A', 200000),
(2, 'my', 'Margoz', '5', 'my', '2016-06-09 15:03:59', '2016-06-12', '02:00:00', '03:00:00', '1', 'A', 200000),
(3, 'Yusuf', 'Plaza XXI', '5', 'Tahu Bulat TheMovie', '2016-06-10 06:15:39', '2016-12-13', '02:00:15', '04:00:20', 'a', '3', 60000),
(4, 'Pakri', 'Plaza XXI', '1', 'Final Fantasy VII', '2016-06-10 06:15:46', '2016-06-23', '11:00:00', '14:00:00', 'b', '2', 30000),
(5, 'Taufiq', 'Margo XXI', '3', 'Naruto Taubat', '2016-06-10 06:16:35', '2016-06-23', '11:00:00', '14:00:00', 'c', '3', 30000),
(6, 'Abdie', 'Detos XXI', '2', 'My Stupid Bos', '2016-06-10 06:23:09', '2016-06-02', '08:00:00', '10:00:00', 'c', '4', 25000),
(7, 'Wahyu', 'Margo XXI', '3', 'Naruto Taubat', '2016-06-10 06:24:35', '2016-06-23', '11:00:00', '14:00:00', 'a', '1', 30000),
(8, 'Test', 'Plaza XXI', '1', 'Final Fantasy VII', '2016-06-10 06:25:40', '2016-06-23', '11:00:00', '14:00:00', 'b', '4', 30000),
(9, 'Dodi', 'Plaza XXI', '5', 'Tahu Bulat TheMovie', '2016-06-10 06:46:49', '2016-12-13', '02:00:15', '04:00:20', 'c', '2', 60000),
(10, 'Khalid', 'Plaza XXI', '1', 'London Has Molen', '2016-06-21 15:16:12', '2016-05-12', '13:00:01', '16:00:01', 'a', '2', 31000),
(11, '', 'Detos XXI', '5', 'Rumah Kepemimpinan', '2016-06-21 16:03:39', '2016-07-11', '11:00:02', '14:00:03', 'a', '4', 40000),
(12, 'AAA', 'Plaza XXI', '5', 'Tahu Bulat TheMovie', '2016-06-21 16:31:24', '2016-12-13', '02:00:15', '04:00:20', 'b', '1', 60000),
(13, 'Aswee', 'Plaza XXI', '5', 'Tahu Bulat TheMovie', '2016-06-21 16:32:36', '2016-12-13', '02:00:15', '04:00:20', 'c', '3', 60000),
(14, 'Aswee2', 'Plaza XXI', '5', 'Tahu Bulat TheMovie', '2016-06-21 16:32:56', '2016-12-13', '02:00:15', '04:00:20', 'a', '3', 60000),
(15, 'CACA', 'Detos XXI', '2', 'My Stupid Bos', '2016-06-21 16:36:33', '2016-05-18', '12:00:02', '14:00:02', 'a', '1', 35000),
(16, 'CACA', 'Detos XXI', '2', 'My Stupid Bos', '2016-06-21 16:36:42', '2016-05-18', '12:00:02', '14:00:02', 'a', '2', 35000),
(17, 'CACA', 'Detos XXI', '2', 'My Stupid Bos', '2016-06-21 16:36:47', '2016-05-18', '12:00:02', '14:00:02', 'a', '3', 35000),
(18, 'CACA', 'Detos XXI', '2', 'My Stupid Bos', '2016-06-21 16:36:50', '2016-05-18', '12:00:02', '14:00:02', 'a', '4', 35000),
(19, 'Ucup', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:50:57', '2016-05-18', '12:00:02', '14:00:02', 'a', '1', 35000),
(20, 'Ucup', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:00', '2016-05-18', '12:00:02', '14:00:02', 'a', '2', 35000),
(21, 'Ucup', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:03', '2016-05-18', '12:00:02', '14:00:02', 'a', '3', 35000),
(22, 'Ucup', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:06', '2016-05-18', '12:00:02', '14:00:02', 'c', '4', 35000),
(23, 'Tab', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:14', '2016-05-18', '12:00:02', '14:00:02', 'c', '1', 35000),
(24, 'Tab', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:17', '2016-05-18', '12:00:02', '14:00:02', 'a', '4', 35000),
(25, 'Tab', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:19', '2016-05-18', '12:00:02', '14:00:02', 'b', '4', 35000),
(26, 'Tab', 'Margo XXI', '4', 'X-Women', '2016-06-21 16:51:22', '2016-05-18', '12:00:02', '14:00:02', 'b', '2', 35000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nama_bioskop` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `username`, `password`, `nama`, `nama_bioskop`) VALUES
(1, 'admin', 'admin', 'si admin', ''),
(2, 'taufiq', 'tab', 'Taufiq Abdullah', 'Detos'),
(3, 'yusuf', 'ucup', 'yusuf matahari', 'margo'),
(4, 'fakhri', 'pakri', 'm fakhri', 'dor');

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE `studio` (
  `id` int(11) NOT NULL,
  `nomor_studio` char(1) NOT NULL,
  `judul` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`id`, `nomor_studio`, `judul`) VALUES
(1, '1', 'Final Fantasy VII'),
(2, '2', 'My Stupid Bos'),
(3, '3', 'Naruto Taubat'),
(4, '4', 'Final Fantasy VII'),
(5, '5', 'Final Fantasy VII');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bangku`
--
ALTER TABLE `bangku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bioskop`
--
ALTER TABLE `bioskop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `judul` (`judul`),
  ADD UNIQUE KEY `waktu_mulai` (`jam_mulai`),
  ADD UNIQUE KEY `waktu_selesai` (`jam_selesai`),
  ADD UNIQUE KEY `tanggal` (`tanggal`),
  ADD UNIQUE KEY `harga` (`harga`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nomor_studio` (`nomor_studio`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bangku`
--
ALTER TABLE `bangku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `bioskop`
--
ALTER TABLE `bioskop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `studio`
--
ALTER TABLE `studio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
