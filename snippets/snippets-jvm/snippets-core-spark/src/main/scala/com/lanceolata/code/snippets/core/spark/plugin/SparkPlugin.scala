package com.lanceolata.code.snippets.core.spark.plugin

import org.apache.hadoop.fs.FileSystem
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * Spark任务插件
 */
trait SparkPlugin {
  @transient
  protected implicit lazy val sparkConf: SparkConf = initSparkConf()
  @transient
  protected implicit lazy val spark = SparkSession.builder().config(sparkConf).getOrCreate()
  @transient
  protected implicit lazy val sc = spark.sparkContext
  @transient
  protected implicit lazy val sqlContext = spark.sqlContext
  @transient
  protected implicit lazy val fs = FileSystem.get(sc.hadoopConfiguration)

  /**
   * 初始化SparkConf
   */
  protected def initSparkConf(): SparkConf = {
    new SparkConf()
      .setAppName(s"${getClass.getName.split("\\.").last}")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.sql.parquet.compression.codec", "snappy")
  }
}
