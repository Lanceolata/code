package com.lanceolata.code.snippets.spark.operator

import com.lanceolata.code.snippets.common.scala.model.FieldValueTag
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Dataset
import org.roaringbitmap.RoaringBitmap

import scala.annotation.meta.param

/**
 * Bitmap相关操作
 *
 * @param dataset 标签数据 标签 -> 索引
 */
class BitmapOperator(@(transient @param)dataset: Dataset[(FieldValueTag, Int)]) extends Serializable {
  /**
   * 生成标签对应的Bitmap数据
   *
   * @return
   */
  def getBitmapRDD: RDD[(FieldValueTag, RoaringBitmap)] = {
    getBitmapRDD(dataset)
  }

  /**
   * 生成标签对应的Bitmap数据
   *
   * @param ds 标签数据
   *
   * @return
   */
  protected def getBitmapRDD(ds: Dataset[(FieldValueTag, Int)]): RDD[(FieldValueTag, RoaringBitmap)] = {
    ds
      .rdd
      .combineByKey(
        (i: Int) => RoaringBitmap.bitmapOf(i),
        (r: RoaringBitmap, i: Int) => {
          r.add(i)
          r
        },
        (r1: RoaringBitmap, r2: RoaringBitmap) => {
          r1.or(r2)
          r1
        }
      )
  }
}
