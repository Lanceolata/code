package com.lanceolata.code.snippets.common.scala.model

/**
 * 标签相关
 */

/**
 * 标签
 * 由字段和取值组恒
 *
 * TODO
 *  1. 迁移java
 *  2. 后续优化/替换 MultiKVItem
 *
 * @param field 字段
 * @param value 取值
 */
case class FieldValueTag(field: String, value: String) {
  def toTagString: String = {
    s"$field:$value"
  }
}
