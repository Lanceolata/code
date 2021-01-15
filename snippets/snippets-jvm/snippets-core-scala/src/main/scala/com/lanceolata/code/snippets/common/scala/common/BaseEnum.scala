package com.lanceolata.code.snippets.common.scala.common

/**
 * copy from kafka
 */
trait BaseEnum extends Product with Serializable {
  def name: String
}
