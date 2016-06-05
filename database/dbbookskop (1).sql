-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Jun 2016 pada 00.01
-- Versi Server: 10.1.9-MariaDB
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
-- Struktur dari tabel `bangku`
--

CREATE TABLE `bangku` (
  `id` int(11) NOT NULL,
  `nomor_studio` char(1) NOT NULL,
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
-- Dumping data untuk tabel `bangku`
--

INSERT INTO `bangku` (`id`, `nomor_studio`, `a1`, `a2`, `a3`, `a4`, `b1`, `b2`, `b3`, `b4`, `c1`, `c2`, `c3`, `c4`) VALUES
(1, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, '2', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `bioskop`
--

CREATE TABLE `bioskop` (
  `id` int(11) NOT NULL,
  `nama_bioskop` varchar(30) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  `daerah` varchar(30) NOT NULL,
  `nomor_studio` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bioskop`
--

INSERT INTO `bioskop` (`id`, `nama_bioskop`, `alamat`, `daerah`, `nomor_studio`) VALUES
(1, 'Detosz', 'Depok', 'Depok', '1'),
(2, 'Margonda', 'Depok', 'Depok', '2'),
(3, 'Depok XXI', 'Plaza Ramayana', 'Depok', '4');

-- --------------------------------------------------------

--
-- Struktur dari tabel `film`
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
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `film`
--

INSERT INTO `film` (`id`, `judul`, `sutradara`, `kategori`, `durasi`, `tanggal`, `jam_mulai`, `jam_selesai`, `harga`) VALUES
(1, 'My Stupid Bos', 'Falcon Picture', 'Drama Parody', '2', '2016-06-02', '08:00:00', '10:00:00', 25000),
(2, 'Final Fantasy VII', 'Squarenix', 'Fantasy', '3', '2016-06-23', '11:00:00', '14:00:00', 30000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
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

-- --------------------------------------------------------

--
-- Struktur dari tabel `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nama_bioskop` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `staff`
--

INSERT INTO `staff` (`id`, `username`, `password`, `nama`, `nama_bioskop`) VALUES
(1, 'admin', 'admin', 'si admin', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `studio`
--

CREATE TABLE `studio` (
  `no` int(11) NOT NULL,
  `nomor_studio` char(1) NOT NULL,
  `judul` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `studio`
--

INSERT INTO `studio` (`no`, `nomor_studio`, `judul`) VALUES
(1, '1', 'Final Fantasy VII'),
(2, '2', 'My Stupid Bos');

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nama_bioskop` (`nama_bioskop`);

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
  ADD PRIMARY KEY (`no`),
  ADD UNIQUE KEY `nomor_studio` (`nomor_studio`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bangku`
--
ALTER TABLE `bangku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bioskop`
--
ALTER TABLE `bioskop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `studio`
--
ALTER TABLE `studio`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
