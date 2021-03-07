package com.lanceolata.code.snippets.core.scala.util

import org.apache.commons.lang3.StringUtils

/**
 * 设备ID工具类
 */
object IdUtils {
  /**
   * 判断是否为有效imeimd5或oaid
   *
   * @param id
   * @return
   */
  def isValidImeimd5OrOaid(id: String): Boolean = {
    StringUtils.isNotBlank(id) && id.matches("^[A-Fa-f0-9]*$")
  }

  /**
    * 判断是否为有效imeimd5
   *
    * @param id
    * @return
    */
  def isValidImeimd5(id: String): Boolean = {
    StringUtils.isNotBlank(id) && id.matches("^[A-Fa-f0-9]{32}$")
  }
}
