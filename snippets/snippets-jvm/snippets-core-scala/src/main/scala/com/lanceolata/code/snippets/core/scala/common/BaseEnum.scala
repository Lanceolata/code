package com.lanceolata.code.snippets.core.scala.common

/**
 * copy from kafka
 */
trait BaseEnum extends Product with Serializable {
  def name: String
}
