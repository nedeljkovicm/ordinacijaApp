/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.4.11-MariaDB : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `seminarski`;

/*Table structure for table `karton` */

DROP TABLE IF EXISTS `karton`;

CREATE TABLE `karton` (
  `SifraKarton` int(11) NOT NULL AUTO_INCREMENT,
  `JMBG` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KontaktTelefon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DatumRodjenja` date NOT NULL,
  `KrvnaGrupa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Zanimanje` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PrviPregled` date NOT NULL,
  `PoslednjiPregled` date NOT NULL,
  `LBO` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Dijagnoza` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Alergije` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Napomene` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SifraKarton`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `karton` */

insert  into `karton`(`SifraKarton`,`JMBG`,`Prezime`,`Ime`,`KontaktTelefon`,`DatumRodjenja`,`KrvnaGrupa`,`Zanimanje`,`PrviPregled`,`PoslednjiPregled`,`LBO`,`Dijagnoza`,`Alergije`,`Napomene`) values 
(1,'2401996123454','Petrovic','Petra','0618889564','1996-01-24','A','pravnik','2019-02-11','2020-02-19','12345678','Psorijaza','',''),
(2,'2602994123456','Markovic','Marko','0627689012','1994-02-26','Bneg','programer','2016-06-11','2020-05-01','88344255','Onihomikoza','',''),
(16,'0412990123456','Tomic','Teodora','0638780023','1990-12-04','O','sportista - atletika','2009-12-31','2020-06-17','99045633','Cistične akne ','',''),
(17,'0607998123456','Ilic','Ivan','0645671192','1994-07-06','A','student','2020-01-22','2020-05-02','97421357','Akne','polen',''),
(18,'1501961123456','Stefanovic','Sara','0654559262','1961-01-15','Oneg','lekar','2019-08-21','2020-06-19','22345098','Rozacea','',''),
(19,'1204976342523','Milanovic','Milan','0667589567','1976-04-12','AB','stolar','2020-06-03','2020-06-04','12345673','Dermatitis','',''),
(20,'1212992245671','Antic','Ana','0665678932','1992-12-12','Bneg','glumica','2016-06-06','2020-06-08','3457789456','Ekcem','polen','');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) DEFAULT NULL,
  `Prezime` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Snezana','Nedeljkovic','sned','1234'),
(2,'Danilo','Stevanoic','dstev','5678');

/*Table structure for table `lek` */

DROP TABLE IF EXISTS `lek`;

CREATE TABLE `lek` (
  `SifraLek` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Koncentracija` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GrupaLekova` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Namena` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Sastav` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Kontraindikacije` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SifraLek`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lek` */

insert  into `lek`(`SifraLek`,`Naziv`,`Koncentracija`,`GrupaLekova`,`Namena`,`Sastav`,`Kontraindikacije`) values 
(5,'Amoksiciklin','250 mg/5 ml,granule za oralnu suspenziju, ','penicilinski antibiotik','Lecenje infekcija čiji su izazivači bakterije osetljive na amoksicilin','aktivna supstanca amoksicilin, trihidrat','Alergijska reakcija u vidu svraba i ospe po koži, otoka lica, usana, jezika ili drugih delova tela,'),
(6,'Eritromicin','250 mg,  film tablete','antibiotik iz grupe makrolida','Lecenje infekcija kože i mekog tkiva: furunkuli i karbunkuli, paronihia,apscesi, gnojne akne, impetigo, erizipel','eritromicinetilsukcinat','Crvenilo,zatezanje'),
(7,'Sinoderm',' 0,25 mg/g, krem','kortikosteroidi','Lečenje zapaljenjskih, pruriginoznih i alergijskih oboljenja - ekcem, dermatitis, prurigo, psorijaza, lihen planus i\ndiskoidni eritemski lupus.\n','fluocinolonacetonid, propilenglikol, propilparahidroksibenzoat, metilparahidroksibenzoat\ncetostearilalkohol\n','alergijska reakcija na krem (praćena svrabom),\n iritacija,\n pogoršanje akni,\n rosacea-e i dermatitisa oko usta, \ndepigmentacija,\n lokalizovano pojačana maljavost');

/*Table structure for table `pregled` */

DROP TABLE IF EXISTS `pregled`;

CREATE TABLE `pregled` (
  `SifraPregled` int(11) NOT NULL AUTO_INCREMENT,
  `Datum` date NOT NULL,
  `Dijagnoza` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Realizacija` tinyint(1) NOT NULL,
  `Vreme` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SifraKarton` int(11) NOT NULL,
  PRIMARY KEY (`SifraPregled`),
  KEY `pregled_ibfk_1` (`SifraKarton`),
  CONSTRAINT `pregled_ibfk_1` FOREIGN KEY (`SifraKarton`) REFERENCES `karton` (`SifraKarton`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pregled` */

insert  into `pregled`(`SifraPregled`,`Datum`,`Dijagnoza`,`Realizacija`,`Vreme`,`SifraKarton`) values 
(46,'2020-05-01','Gljivicna infekcija',1,'12:30',2),
(47,'2020-04-30','Akne',1,'15:15',17),
(48,'2020-05-10','Akne',1,'11:45',18),
(49,'2020-05-02','Ekcem',1,'12:30',16),
(50,'2020-05-02','',1,'14:00',17),
(51,'2020-05-05','aknee',1,'13:15',18),
(52,'2020-06-02','Gljivicna infekcija',1,'16:00',2),
(53,'2020-06-05','Ekcem',1,'14:00',16),
(54,'2020-06-13','Ekcem',0,'17:15',16),
(55,'2020-06-09','',0,'10:00',1),
(56,'2020-06-09','',0,'00:00',1),
(57,'2020-06-13','Akne',0,'00:00',18),
(58,'2020-06-13','Ekcem',0,'14:15',16),
(59,'2020-06-07','Akne',0,'09:30',17),
(60,'2020-06-07','Gljivicna infekcija',0,'12:30',2),
(61,'2020-06-07','Akne',0,'10:30',18),
(62,'2020-06-17','',0,'12:45',19),
(63,'2020-06-17','Cistične akne ',1,'12:15',16),
(64,'2020-06-17','Gljivicna infekcija',0,'10:30',2),
(65,'2020-06-19','Akne',1,'09:30',18),
(66,'2020-06-17','Cistične akne ',0,'15:00',16);

/*Table structure for table `recept` */

DROP TABLE IF EXISTS `recept`;

CREATE TABLE `recept` (
  `SifraPregled` int(11) NOT NULL,
  `SifraRecept` int(11) NOT NULL AUTO_INCREMENT,
  `Uputstvo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PotpisLekara` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SifraLek` int(11) NOT NULL,
  PRIMARY KEY (`SifraRecept`,`SifraPregled`),
  KEY `recept_ibfk_1` (`SifraPregled`),
  KEY `recept_ibfk_2` (`SifraLek`),
  CONSTRAINT `recept_ibfk_3` FOREIGN KEY (`SifraPregled`) REFERENCES `pregled` (`SifraPregled`),
  CONSTRAINT `recept_ibfk_4` FOREIGN KEY (`SifraLek`) REFERENCES `lek` (`SifraLek`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `recept` */

insert  into `recept`(`SifraPregled`,`SifraRecept`,`Uputstvo`,`PotpisLekara`,`SifraLek`) values 
(50,1,'Mazati svaki dan na zahvaceno podrucje.','dr Snezana Nedeljkovic',7),
(63,1,'Uzimati dva puta dnevno, nakon obroka.','dr Snezana Nedeljkovic',5),
(65,1,'Mazati 3 puta dnevno.','dr Snezana Nedeljkovic',7),
(63,2,'Mazati jednom dnevno, posle umivanja, na akne.','dr Snezana Nedeljkovic',7),
(65,2,'Uzimati 2 puta dnevno, nakon obroka, naredne dve nedelje.','dr Snezana Nedeljkovic',5);

/*Table structure for table `tipanalize` */

DROP TABLE IF EXISTS `tipanalize`;

CREATE TABLE `tipanalize` (
  `SifraAnaliza` int(11) NOT NULL AUTO_INCREMENT,
  `NazivAnaliza` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SifraAnaliza`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tipanalize` */

insert  into `tipanalize`(`SifraAnaliza`,`NazivAnaliza`) values 
(1,'Analiza krvi'),
(2,'Analiza urina'),
(3,'Analiza stolice');

/*Table structure for table `uput` */

DROP TABLE IF EXISTS `uput`;

CREATE TABLE `uput` (
  `SifraPregled` int(11) NOT NULL,
  `SifraUput` int(11) NOT NULL,
  `Opis` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SifraAnaliza` int(11) NOT NULL,
  PRIMARY KEY (`SifraUput`,`SifraPregled`),
  KEY `uput_ibfk_1` (`SifraPregled`),
  KEY `uput_ibfk_2` (`SifraAnaliza`),
  CONSTRAINT `uput_ibfk_3` FOREIGN KEY (`SifraPregled`) REFERENCES `pregled` (`SifraPregled`),
  CONSTRAINT `uput_ibfk_4` FOREIGN KEY (`SifraAnaliza`) REFERENCES `tipanalize` (`SifraAnaliza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `uput` */

insert  into `uput`(`SifraPregled`,`SifraUput`,`Opis`,`SifraAnaliza`) values 
(50,1,'Krvna slika',1),
(63,1,'Proveriti  nivoe hormona u krvi -testosteron, AMH  i SHBG.',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
