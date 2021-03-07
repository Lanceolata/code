package com.lanceolata.code.snippets.core.scala.util

import com.twitter.algebird.{HLL, HyperLogLog, HyperLogLogMonoid}

/**
 * HyperLogLog工具类
 */
object HLLUtils {
  private val hllMonoid = new HyperLogLogMonoid(11)

  /**
   * 0 HLL
   *
   * @return
   */
  def zeroHll: HLL = {
    hllMonoid.zero
  }

  /**
   * String生成HLL
   *
   * @param s
   * @return
   */
  def toHll(s: String): HLL = {
    hllMonoid.toHLL(s)
  }

  /**
   * Int生成HLL
   *
   * @param i
   * @return
   */
  def toHll(i: Int): HLL = {
    hllMonoid.toHLL(i)
  }

  /**
   * HLL序列化为byte
   *
   * @param hll
   * @return
   */
  def toBytes(hll: HLL): Array[Byte] = {
    HyperLogLog.toBytes(hll)
  }

  /**
   * byte反序列化为HLL
   *
   * @param bytes
   * @return
   */
  def fromBytes(bytes: Array[Byte]): HLL = {
    HyperLogLog.fromBytes(bytes)
  }

  /**
   * 预估
   *
   * @param hll
   * @return
   */
  def estimate(hll: HLL): Long = {
    hllMonoid.estimateSize(hll).toLong
  }

  /**
   * 预估交集
   *
   * @param hlls
   * @return
   */
  def estimateIntersection(hlls: Seq[HLL]): Long = {
    hllMonoid.intersectionSize(hlls).estimate
  }
}
