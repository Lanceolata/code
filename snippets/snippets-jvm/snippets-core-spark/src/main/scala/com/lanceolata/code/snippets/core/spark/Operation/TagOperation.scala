package com.lanceolata.code.snippets.core.spark.Operation

import com.lanceolata.code.snippets.core.common.Constants
import com.lanceolata.code.snippets.core.scala.model.FieldValueTag
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Dataset, Row}

import scala.annotation.meta.param

/**
 * 标签数据处理
 * 扩展DataFrame提供生成标签的方法
 *
 * @param dataFrame
 */
class TagOperation(@(transient @param)dataFrame: DataFrame) extends Serializable {
  /**
   * 生成便签和设备ID数据
   * 注: 需存在 Constants.FIELD_ID 列
   *
   * @return
   */
  def getTagWithId: Dataset[(FieldValueTag, String)] = {
    getTagWithId(dataFrame)
  }

  /**
   * 生成便签和索引数据
   * 注: 需存在 Constants.FIELD_INDEX 列
   *
   * @return
   */
  def getTagWithIndex: Dataset[(FieldValueTag, Int)] = {
    getTagWithIndex(dataFrame)
  }

  /**
   * 生成便签数据
   *
   * @return
   */
  def getTag: Dataset[FieldValueTag] = {
    getTag(dataFrame)
  }

  /**
   * 生成便签和设备ID数据
   * 注: 需存在 Constants.FIELD_ID 列
   *
   * @param df DataFrame
   *
   * @return
   */
  protected def getTagWithId(df: DataFrame): Dataset[(FieldValueTag, String)] = {
    import df.sparkSession.implicits._

    val columns = getProcessColumn(df)
    df.flatMap { row =>
      val id = row.getAs[String](Constants.FIELD_ID)
      getFieldValueTag(columns, row).map(_ -> id)
    }
  }

  /**
   * 生成便签和索引数据
   * 注: 需存在 Constants.FIELD_INDEX 列
   *
   * @param df DataFrame
   *
   * @return
   */
  protected def getTagWithIndex(df: DataFrame): Dataset[(FieldValueTag, Int)] = {
    import df.sparkSession.implicits._

    val columns = getProcessColumn(df)
    df.flatMap { row =>
      val id = row.getAs[Int](Constants.FIELD_INDEX)
      getFieldValueTag(columns, row).map(_ -> id)
    }
  }

  /**
   * 生成便签数据
   *
   * @param df
   *
   * @return
   */
  protected def getTag(df: DataFrame): Dataset[FieldValueTag] = {
    import df.sparkSession.implicits._

    val columns = getProcessColumn(df)
    df.flatMap(row => getFieldValueTag(columns, row))
  }

  /**
   * 获得需要处理的字段(列)
   * id index id_type 非标签列
   *
   * @param df DataFrame
   *
   * @return
   */
  protected def getProcessColumn(df: DataFrame): Seq[StructField] = {
    val ignoreFields = Set(Constants.FIELD_ID, Constants.FIELD_INDEX, Constants.FIELD_ID_TYPE)
    df.schema.filter(s => !ignoreFields.contains(s.name))
  }

  /**
   * 生成标签数据
   *
   * @param processColumns 需要处理的列
   * @param row 数据
   *
   * @return
   */
  protected def getFieldValueTag(processColumns: Seq[StructField], row: Row): Seq[FieldValueTag] = {
    processColumns.flatMap { s =>
      // 按不同数据类型调用处理函数
      s.dataType match {
        case _: ByteType | ShortType | IntegerType | LongType | StringType =>
          processPrimitiveType(row, s.name)
        case _: ArrayType =>
          processArrayType(row, s.name)
        case _ =>
          throw new IllegalArgumentException(s"unsupport column ${s.toString()}.")
      }
    }
  }

  /**
   * 处理基础数据类型
   * 目前仅支持 数字和字符串 相关类型
   * ByteType | ShortType | IntegerType | LongType | StringType
   *
   * @param row 数据
   * @param field 字段名称(列名)
   *
   * @return
   */
  protected def processPrimitiveType(row: Row, field: String): Seq[FieldValueTag] = {
    val value = row.get(row.fieldIndex(field))
    if (value != null) {
      Seq(
        FieldValueTag(field, value.toString),
        FieldValueTag(field, Constants.TAG_ALL)
      )
    } else {
      Seq()
    }
  }

  /**
   * 处理数组类型
   * 目前仅支持String数组
   *
   * @param row  数据
   * @param field  字段名称(列名)
   * @return
   */
  protected def processArrayType(row: Row, field: String): Seq[FieldValueTag] = {
    val values = row.getSeq[String](row.fieldIndex(field))
    if (values != null && values.nonEmpty) {
      values.map(_.trim).map(v => FieldValueTag(field, v)) :+ FieldValueTag(field, Constants.TAG_ALL)
    } else {
      Seq()
    }
  }

  // TODO 其他类型支持
}