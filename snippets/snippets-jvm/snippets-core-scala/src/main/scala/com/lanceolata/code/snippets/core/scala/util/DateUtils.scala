package com.lanceolata.code.snippets.core.scala.util

import java.time.{LocalDate, LocalDateTime, LocalTime, ZoneOffset}
import java.time.format.DateTimeFormatter

/**
 * 日期工具类
 */
object DateUtils {
  private val Y4M2D2 = DateTimeFormatter.ofPattern("yyyyMMdd")
  private val Y4M2D2H2M2S2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def dateBefore(date: String, n: Int): String = {
    val localDate = LocalDate.parse(date, Y4M2D2)
    localDate.minusDays(n).format(Y4M2D2)
  }

  def dateAfter(date: String, n: Int): String = {
    val localDate = LocalDate.parse(date, Y4M2D2)
    localDate.plusDays(n).format(Y4M2D2)
  }

  def dateBeforeMonth(date: String, n: Int): String = {
    val localDate = LocalDate.parse(date, Y4M2D2)
    localDate.minusMonths(n).format(Y4M2D2)
  }

  def date2Millis(date: String): Long = LocalDateTime.of(LocalDate.parse(date, Y4M2D2), LocalTime.of(0, 0, 0, 0)).toEpochSecond(ZoneOffset.of("+8")) * 1000

  def timestamp2DateString(timestamp: Long): String = LocalDateTime.ofEpochSecond(timestamp / 1000L, 0, ZoneOffset.of("+8")).format(Y4M2D2)

  def timestamp2String(timestamp: Long): String = LocalDateTime.ofEpochSecond(timestamp / 1000L, 0, ZoneOffset.of("+8")).format(Y4M2D2H2M2S2)

  def getFirstDayOfMonth(date: String): String = {
    val localDate = LocalDate.parse(date, Y4M2D2)
    localDate.minusDays(localDate.getDayOfMonth - 1).format(Y4M2D2)
  }
  /**
   * 获得date之前n天的日期(含date日期)
   * @param date 开始日期
   * @param n 天数
   * @return
   */
  def durationDatesBefore(date: String, n: Int): Seq[String] = {
    if (n <= 0) {
      throw new IllegalArgumentException(s"n[$n] must > 0")
    }
    (0 until n).map(i => dateBefore(date, i))
  }
}
