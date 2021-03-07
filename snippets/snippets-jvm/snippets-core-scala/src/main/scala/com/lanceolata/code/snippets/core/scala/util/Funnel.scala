package com.lanceolata.code.snippets.core.scala.util

import com.twitter.scalding.Args

/**
 * 包装Args
 */
object Funnel {
  var args: Args = _

  def apply(array: Array[String]): Unit = {
    args = Args(array)
  }
}
