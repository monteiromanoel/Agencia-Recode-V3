-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: agencia_viagem_v2
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'12345-123','Suzano','1996-02-28','123.456.789-23','manoel1@email.com','Rua 1, 110 - Centro','Manoel Monteiro','$2a$10$ct62yoHRTIpH/X.GlHSfSuF9G7UN6mFnSgtahkiPQlYcgC7KqNFLm','(11) 96852-2292','SP',NULL),(2,'32134-512','Santos','1990-08-12','214.214.212-15','maria@email.com','Rua 123, 5 - Bairro Alto','Maria Cardoso','$2a$10$gb7rTWc5B.JO1fscMrIZfeTypEU/Y9W8zlGAm2FJHNn/VzoiPFe1i','(11) 12345-6789','SP',NULL),(3,'98765-022','Rio de Janeiro','1975-10-05','4.321.345-64','alberto@email.com','Rua 3, 200 - Centro','Alberto dos Santos','$2a$10$pfi9wFJRgcKb6MImS4dmre89pU8e7dewx1UOlGhKHtmf2edz73GCC','(09) 12345-678','RJ',NULL),(5,'23123-141','São Paulo','1989-12-05','123.123.512-31','fabioAmaral@email.com','Rua das Flores, 150','Fabio Amaral','$2a$10$QrOUOTwElnz0OuISBpk09eHr.jKY4ibcTMsCViD2aHCtTGx7QMilK','(21) 12312-3412','SP',NULL),(6,'12341-234','Belo Horizonte','1995-06-12','565.623.456-23','rosanaSantos@email.com','Rua das Rosas, 200','Rosana Santos','$2a$10$4JWyMZKOmPzRx3MSPoajIuKHacRYETjCe.lFTQRNwVS6i7SNl2BXi','(32) 11231-4141','MG',NULL),(11,'12345-678','São Paulo','1996-02-28','123.123.123-12','admin@email.com','Rua Administrador, 100','admin','$2a$10$imyEnI0rkrPFMhsG6tbBI.bYPX.X4gMVWETVf9582Mu8/ujB3ZAa6','(11) 91234-5678','SP',NULL),(16,'12345-678','cidade teste','2000-01-01','222.123.114-12','teste12345@email.com','Rua teste','teste','$2a$10$Vs4CqwW9VQEsACG7ZddmMurf0D5swMuv9YRg1ndJK8UEg4gz3Ids2','(11) 11111-1111','SC',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_reserva` date DEFAULT NULL,
  `num_passageiros` int DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `id_cliente` bigint DEFAULT NULL,
  `id_viagem` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33h3i3oapwncc68x5n11si6dc` (`id_cliente`),
  KEY `FKb6m7wyhljyjtm7slwbwxqy5ti` (`id_viagem`),
  CONSTRAINT `FK33h3i3oapwncc68x5n11si6dc` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKb6m7wyhljyjtm7slwbwxqy5ti` FOREIGN KEY (`id_viagem`) REFERENCES `viagem` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (2,'2023-12-05',1,13350,1,5),(4,'2023-12-10',1,1150,1,6);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint DEFAULT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2y4ogc01et900snmoyb772nwh` (`user_id`),
  CONSTRAINT `FK2y4ogc01et900snmoyb772nwh` FOREIGN KEY (`user_id`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (11,1),(1,2),(2,2),(3,2),(5,2),(6,2),(11,2),(16,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viagem`
--

DROP TABLE IF EXISTS `viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viagem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adicional` varchar(255) DEFAULT NULL,
  `data_ida` date DEFAULT NULL,
  `data_volta` date DEFAULT NULL,
  `descricao_curta` varchar(255) DEFAULT NULL,
  `descricao_longa` longtext,
  `destino` varchar(255) DEFAULT NULL,
  `imagem` longtext,
  `imagem2` longtext,
  `imagem3` longtext,
  `imagem4` longtext,
  `label_promocao` varchar(255) DEFAULT NULL,
  `localidade` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `preco_antigo` double DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viagem`
--

LOCK TABLES `viagem` WRITE;
/*!40000 ALTER TABLE `viagem` DISABLE KEYS */;
INSERT INTO `viagem` VALUES (2,'Hospedagem e Tour','2023-11-05','2023-11-17','Aproveite as belezas de Veneza','<p>Explore a magia de Veneza, uma cidade que parece ter emergido diretamente de um conto de fadas. Com suas pitorescas ruas de paralelep&iacute;pedos e canais sinuosos que serpenteiam pela cidade, Veneza &eacute; verdadeiramente &uacute;nica no mundo. Ao passear pelas pontes hist&oacute;ricas e pra&ccedil;as encantadoras, voc&ecirc; ser&aacute; envolvido pela rica heran&ccedil;a art&iacute;stica e cultural que permeia cada canto desta cidade.</p>\r\n<p>Sinta a atmosfera rom&acirc;ntica enquanto faz um passeio de g&ocirc;ndola pelos canais, sob as pontes ornamentadas e ao lado das elegantes fachadas dos pal&aacute;cios venezianos. Explore os famosos pontos tur&iacute;sticos, como a deslumbrante Bas&iacute;lica de S&atilde;o Marcos e o ic&ocirc;nico Pal&aacute;cio Ducal, que contam hist&oacute;rias de uma era de esplendor e poder.</p>\r\n<p>Deleite-se com a culin&aacute;ria veneziana, onde pratos de frutos do mar frescos s&atilde;o preparados com maestria. N&atilde;o se esque&ccedil;a de experimentar o \"risotto al nero di seppia\", um arroz negro delicadamente temperado com tinta de lula, uma especialidade local.</p>\r\n<p>&Agrave; noite, enquanto o sol se p&otilde;e sobre os canais, Veneza ganha uma aura m&aacute;gica. As luzes suaves refletem na &aacute;gua, criando um cen&aacute;rio verdadeiramente rom&acirc;ntico. Percorra as ruas &agrave; luz de lanternas e descubra pequenas trattorias e bares de vinho, onde voc&ecirc; pode saborear um bom vinho italiano e se perder no charme inigual&aacute;vel de Veneza.</p>\r\n<p>Em Veneza, cada esquina revela uma nova surpresa, cada canal conta uma hist&oacute;ria e cada vista &eacute; uma obra de arte. Esta cidade &eacute; uma experi&ecirc;ncia que ficar&aacute; gravada na mem&oacute;ria para sempre.</p>','Veneza','https://i.postimg.cc/9Xk4wKKY/veneza-1.jpg','https://h8f7z4t2.stackpathcdn.com/wp-content/uploads/2015/10/grand-canal-veneza-e1596744121749.jpg',NULL,NULL,'','Itália',9899,0,'convencional'),(3,'Hospedagem e alimentação','2023-12-10','2023-12-25','Divirta-se no mundo mágico da Disney','\n<strong>Experiência Mágica na Disney:</strong>\n\n\nEmbarque em uma jornada inesquecível para o mundo encantado da Disney! Nosso pacote de viagem exclusivo oferece uma imersão completa no reino da magia, onde sonhos se tornam realidade.\n\n\nDestaques:\n\nAlojamento Confortável: Hospede-se em acomodações cuidadosamente selecionadas, proporcionando conforto e conveniência após os dias cheios de aventuras.\n\nIngressos Park Hopper: Acesse os parques temáticos icônicos da Disney à vontade, aproveitando a liberdade de visitar múltiplos parques no mesmo dia.\n\nEncontros com Personagens: Conheça e cumprimente seus personagens favoritos, capturando momentos preciosos com fotos memoráveis.\n\nShows Espetaculares: Maravilhe-se com espetáculos emocionantes, paradas coloridas e fogos de artifício deslumbrantes, criando memórias que durarão para sempre.\n\nExperiências Gastronômicas: Delicie-se com uma variedade de opções culinárias, desde pratos internacionais até guloseimas icônicas da Disney.\n\nTransporte Conveniente: Desfrute de transporte seguro e confortável entre o aeroporto, os parques e outras atrações selecionadas.\n\nAssistência Personalizada: Nossa equipe dedicada está sempre disponível para garantir que sua viagem seja perfeita em todos os detalhes.\n\n\nExtras Opcionais:\n\nEncontros VIP com Personagens: Desfrute de encontros exclusivos e personalizados com personagens especiais, garantindo momentos mágicos inesquecíveis.\n\nExperiências Exclusivas nos Bastidores: Descubra os segredos e a magia por trás dos bastidores dos parques temáticos.\n\nEsta é sua chance de criar memórias que durarão toda a vida em um dos destinos mais mágicos do mundo. Reserve agora e embarque em uma jornada inesquecível para a Disney!\n\n','Disney World','https://i.postimg.cc/d18WZGt8/disney-1-1.jpg',NULL,NULL,NULL,'Pacote Familiar','Orlando',11890.99,13050,'promocional'),(4,'Hospedagem e tour','2023-12-10','2023-12-25','Visite Las Vegas, a cidade que nunca dorme',NULL,'Las Vegas','https://i.postimg.cc/PJSQ1yG8/lasvegas-1-1.jpg',NULL,NULL,NULL,NULL,'Nevada',7299.5,NULL,'convencional'),(5,'Hospedagem e tour','2023-12-10','2023-12-25','Conheça o Japão',NULL,'Tokio','https://i.postimg.cc/zfh74Th9/japao-1.jpg',NULL,NULL,NULL,'Tour Completo','Japão',13350,15999,'promocional'),(6,'Hospedagem e alimentação','2023-11-08','2023-11-18','Conheça Balneário e suas praias','<p>Conhecida por suas deslumbrantes praias e paisagens costeiras, &eacute; um dos destinos tur&iacute;sticos mais populares da regi&atilde;o sul do pa&iacute;s. Com uma mistura encantadora de belezas naturais e infraestrutura urbana bem desenvolvida, Balne&aacute;rio Cambori&uacute; oferece uma experi&ecirc;ncia &uacute;nica para visitantes de todas as idades.</p>\r\n<p>Suas praias de areias finas e &aacute;guas cristalinas s&atilde;o o ponto alto da cidade. A Praia Central &eacute; o cora&ccedil;&atilde;o do movimento, com uma ampla orla que convida a caminhadas relaxantes e pr&aacute;tica de esportes &agrave; beira-mar. Al&eacute;m disso, o telef&eacute;rico que liga a Praia Central ao Morro da Aguada proporciona uma vista panor&acirc;mica espetacular, revelando a exuberante beleza da regi&atilde;o.</p>\r\n<p>Balne&aacute;rio Cambori&uacute; tamb&eacute;m &eacute; conhecida por sua vida noturna agitada e diversificada. A Avenida Atl&acirc;ntica, que margeia a praia, abriga uma infinidade de bares, restaurantes e casas noturnas, oferecendo op&ccedil;&otilde;es para todos os gostos e estilos.</p>\r\n<p>Al&eacute;m das praias e vida noturna, a cidade conta com uma variada oferta de entretenimento e lazer. O Parque Unipraias &eacute; uma atra&ccedil;&atilde;o imperd&iacute;vel, proporcionando aventuras em meio &agrave; natureza, com trilhas e tirolesas que revelam paisagens deslumbrantes.</p>\r\n<p>Com uma atmosfera vibrante e acolhedora, Balne&aacute;rio Cambori&uacute; se destaca como um destino completo, capaz de agradar tanto aos que buscam relaxamento &agrave; beira-mar quanto aos que procuram atividades emocionantes e uma vida noturna animada. &Eacute; um lugar onde a natureza se une &agrave; modernidade, oferecendo uma experi&ecirc;ncia memor&aacute;vel a todos que t&ecirc;m a oportunidade de explorar seus encantos.</p>','Balneário Camboriú','https://i.postimg.cc/52d6nvxH/balneario-1.jpg','https://www.bc.sc.gov.br/arquivos/imprensa/UY3JE9NG.jpg','https://i0.statig.com.br/bancodeimagens/6w/jj/88/6wjj88wjxf5i48g1fwma3j8vj.jpg',NULL,'-15%','Brasil',1150,1389,'convencional'),(7,'Hospedagem e Tour','2023-12-10','2023-12-25','Visite a maravilhosa Madrid',NULL,'Roma','https://i.postimg.cc/x8XcF3Jm/roma-1-1.jpg',NULL,NULL,NULL,'Cultura e Lazer','Madrid',9835,11090,'promocional'),(8,'Hospedagem e Tour','2023-11-01','2023-11-15','Montanhas e Charme em São Paulo','<p>Campos do Jord&atilde;o, localizada no estado de S&atilde;o Paulo, &eacute; um ref&uacute;gio encantador nas montanhas da Serra da Mantiqueira. Conhecida como a \"Su&iacute;&ccedil;a Brasileira\", a cidade atrai visitantes o ano todo com seu clima ameno, ar puro e paisagens deslumbrantes. Durante o inverno, as baixas temperaturas criam um ambiente acolhedor, perfeito para desfrutar de fondues, chocolate quente e lareiras acesas. Al&eacute;m disso, a cidade oferece uma rica variedade de trilhas, parques e jardins bem cuidados, proporcionando aos visitantes a oportunidade de explorar a natureza exuberante da regi&atilde;o. Com sua arquitetura europeia e charmosos vilarejos, Campos do Jord&atilde;o tamb&eacute;m &eacute; famosa por seus festivais de m&uacute;sica cl&aacute;ssica e eventos culturais. &Eacute; o destino ideal para quem busca uma escapada rom&acirc;ntica, contato com a natureza e uma experi&ecirc;ncia &uacute;nica de montanha no cora&ccedil;&atilde;o do Brasil.</p>','Campos do Jordão','https://conteudo.imguol.com.br/c/entretenimento/4d/2021/08/09/campos-do-jordao-1628534716035_v2_4x3.jpg','https://a.cdn-hotels.com/gdcs/production73/d639/bbc78384-7a78-4cf9-967b-939d031b432d.jpg',NULL,NULL,'Descanso e Sofisticação','Brasil',3256,3899,'promocional');
/*!40000 ALTER TABLE `viagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'agencia_viagem_v2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11 20:58:51
