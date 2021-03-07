package com.lanceolata.code.snippets.core.scala.model

/**
 * 标签相关
 */

/**
 * 通用标签
 *
 * @param key 键
 * @param value 值
 */
case class CommonTag(key: String, value: String)

/**
 * 标签
 * 由字段和取值组成
 *
 * @param field 字段
 * @param value 取值
 */
case class FieldValueTag(field: String, value: String) {
  def toTagString: String = {
    s"$field:$value"
  }
}
