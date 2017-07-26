-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 26, 2017 at 10:49 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `belajar`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_mhs` int(11) NOT NULL,
  `nama_mhs` varchar(45) NOT NULL,
  `kelas_mhs` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mhs`, `nama_mhs`, `kelas_mhs`) VALUES
(10, 'ahmad rosid', 'networking'),
(11, 'taufik hidayah', 'programming'),
(13, 'farid savarudin', 'programming'),
(14, 'husni', 'networking'),
(15, 'nabil', 'networking'),
(16, 'fauzan noor', 'sysadmin '),
(17, 'wisnu', 'ccie'),
(18, 'ade', 'ccie'),
(23, 'hugo irwanto', 'sysadmin'),
(28, 'x', 'x');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_mhs` int(11) NOT NULL,
  `nama_member` varchar(20) NOT NULL,
  `alamat_member` text NOT NULL,
  `nohp_member` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_mhs`, `nama_member`, `alamat_member`, `nohp_member`) VALUES
(3, 'jadkdnsdk', 'sdns dwkd', 68689),
(7, 's', 'a', 23),
(8, 'sff', 'afdf', 23);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(900) NOT NULL,
  `key` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `email`, `password`, `key`) VALUES
(2, '0', '0', 'd41d8cd98f00b204e9800998ecf8427e', '0'),
(3, 'farid', 'farid@gmail.com', 'farid', ''),
(4, 'lupa', 'farid@gmail.com', 'lupa', ''),
(5, 'savarudin', 'savarudin@gmail.com', 'cfbbc8036de25d2daea7a081dd3dc22b', ''),
(7, 'heeh', 'heeh@gmail.com', 'd033187f2e2ce98a8bde0a9ca2678c76', ''),
(8, 'heeh', 'heeh@gmail.com', 'd033187f2e2ce98a8bde0a9ca2678c76', ''),
(9, 'baru', 'baru', '5ef035d11d74713fcb36f2df26aa7c3d', ''),
(11, 'aaa', 'cx', '25ed1bcb423b0b7200f485fc5ff71c8e', ''),
(12, 'cek', 'cek@cek.com', '6ab97dc5c706cfdc425ca52a65d97b0d', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_mhs`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_mhs`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id_mhs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id_mhs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
