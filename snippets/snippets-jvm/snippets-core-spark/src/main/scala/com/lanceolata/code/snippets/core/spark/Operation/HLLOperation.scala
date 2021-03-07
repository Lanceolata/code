package com.lanceolata.code.snippets.core.spark.Operation

import com.lanceolata.code.snippets.core.scala.model.FieldValueTag
import com.lanceolata.code.snippets.core.scala.util.HLLUtils
import com.twitter.algebird.HLL
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Dataset

import scala.annotation.meta.param

/**
 * HLL相关操作
 *
 * @param dataset 标签数据 标签 -> 设备ID
 */
class HLLOperation(@(transient @param)dataset: Dataset[(FieldValueTag, String)]) extends Serializable {
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
        HLLUtils.toHll,
        (h: HLL, i: String) => h + HLLUtils.toHll(i),
        (h1: HLL, h2: HLL) => h1 + h2
      )
  }
}
