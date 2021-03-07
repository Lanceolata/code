package com.lanceolata.code.snippets.core.spark.Operation

import com.lanceolata.code.snippets.core.model.HLL
import com.lanceolata.code.snippets.core.scala.model.FieldValueTag
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Dataset

import scala.annotation.meta.param

/**
 * HLL相关操作
 *
 * @param dataset 标签数据 标签 -> 设备ID
 */
class HLLV2Operation(@(transient @param)dataset: Dataset[(FieldValueTag, String)]) extends Serializable {
  /**
   * 生成HLL数据
   *
   * @return
   */
  def getHLLRDD: RDD[(FieldValueTag, HLL)] = {
    getHLLRDD(dataset)
  }

  /**
   * 生成HLL数据
   *
   * @param ds
   *
   * @return
   */
  protected def getHLLRDD(ds: Dataset[(FieldValueTag, String)]): RDD[(FieldValueTag, HLL)] = {
    ds
      .rdd
      .combineByKey(
        (s: String) => new HLL().update(s),
        (h: HLL, i: String) => h.update(i),
        (h1: HLL, h2: HLL) => h1.union(h2)
      )
  }
}
