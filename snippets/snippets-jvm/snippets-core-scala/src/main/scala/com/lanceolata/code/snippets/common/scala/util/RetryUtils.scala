package com.lanceolata.code.snippets.common.scala.util

import scala.util.Try

/**
 * 重试工具类
 */
object RetryUtils {
  /**
   * 重试
   *
   * @param retries 重试次数
   * @param fun 函数
   * @tparam T 返回值
   * @return
   */
  def withRetries[T](retries: Int)(fun: => T): Try[T] = {
    val stream = (0 until retries).toStream.map(_ => Try(fun))
    stream.find(_.isSuccess) getOrElse stream.last
  }
}
