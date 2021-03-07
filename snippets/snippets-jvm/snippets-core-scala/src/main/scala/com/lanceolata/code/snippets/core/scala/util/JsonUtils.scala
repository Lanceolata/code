package com.lanceolata.code.snippets.core.scala.util

import org.json4s.native.Serialization

/**
 * Json工具类型
 * 封装json4s
 */
object JsonUtils {
  implicit val formats = org.json4s.DefaultFormats

  /**
   * 对象转Json字符串
   *
   * @param obj
   * @return
   */
  def toJson(obj: AnyRef): String = {
    Serialization.write(obj)
  }

  /**
   * 对象转Json字符串
   *
   * @param obj
   * @return
   */
  def toJsonPretty(obj: AnyRef): String = {
    Serialization.writePretty(obj)
  }

  /**
   * Json字符串转对象
   *
   * @param json
   * @tparam T
   * @return
   */
  def read[T: Manifest](json: String): T = {
    Serialization.read[T](json)
  }

  /**
   * Json字符串转对象
   *
   * @param json
   * @tparam T
   * @return
   */
  def readOption[T: Manifest](json: String): Option[T] = {
    try {
      Some(Serialization.read[T](json))
    } catch {
      case _: Throwable =>
        None
    }
  }
}
