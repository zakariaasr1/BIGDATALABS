# TP Spark – Cluster avec Docker

## Objectif
Mettre en place un cluster Spark basé sur Docker avec Hadoop (HDFS + YARN) et exécuter des traitements distribués.

## Environnement
- OS : Debian 11 (VirtualBox)
- Docker & Docker Compose
- Apache Spark
- Apache Hadoop (HDFS, YARN)

## Travaux réalisés
- Lancement du cluster Spark via Docker
- Vérification via Spark UI et YARN UI
- Test SparkPi avec spark-submit
- WordCount avec Spark Shell (Scala)
- WordCount avec PySpark
- Manipulation des DataFrames
- Analyse de données CSV

## Lancement du cluster
```bash
docker-compose up -d
