package com.lanceolata.code.snippets.core.spark.function

import com.lanceolata.code.snippets.core.scala.util.IdUtils
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.types.{LongType, StructField, StructType}

/**
 * Spark公共UDF
 */
object Functions {
  /**
   * 有效imeimd5或oaid
   *
   * @return
   */
  def isValidImeimd5OrOaid = udf { id: String =>
    IdUtils.isValidImeimd5OrOaid(id)
  }

  /**
   * 有效imeimd5
   *
   * @return
   */
  def isValidImeimd5 = udf { id: String =>
    IdUtils.isValidImeimd5(id)
  }

  /**
   * 通过将Dataframe转换成RDD，来实现zipWithId
   *
   * @param df
   */
  implicit class DataFrameIndex(df: DataFrame) {
    def zipWithId(idColumnName: String = "id") = {
      val schema = df.schema
      val rows = df.rdd.zipWithIndex.map {
        case (r: Row, id: Long) => Row.fromSeq(id +: r.toSeq)
      }

      df.sqlContext.createDataFrame(rows, StructType(StructField(idColumnName, LongType, false) +: schema.fields))
    }
  }
}
