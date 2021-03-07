package com.lanceolata.code.snippets.core.spark.util

import org.apache.hadoop.fs.{FileSystem, Path}

/**
 * Hdfs工具类
 */
object HdfsUtils {
  /**
   * 路径日期正则
   */
  val datePattern = """\d{8}$""".r

  /**
   * 判断路径是否存在
   *
   * @param path
   * @param fs
   * @return
   */
  def exists(path: String)(implicit fs: FileSystem): Boolean = {
    fs.exists(new Path(path))
  }

  /**
   * 判断是否有Success文件
   *
   * @param path 目录
   * @param fs
   * @return
   */
  def hasSuccess(path: String)(implicit fs: FileSystem): Boolean = {
    fs.exists(new Path(s"$path/_SUCCESS"))
  }

  /**
   * 获得最新有Success文件的目录
   *
   * @param path 目录
   * @param fs
   * @return
   */
  def getLatest(path: String)(implicit fs: FileSystem): String = {
    fs.listStatus(new Path(path))
      .filter(f => (datePattern findAllIn f.getPath.toString).nonEmpty)
      .map(f => f.getPath.toString)
      .reverse
      .toStream
      .find(hasSuccess)
      .get
  }

  /**
   * 修改路径名称
   *
   * @param source
   * @param target
   * @param fs
   * @return
   */
  def rename(source: String, target: String)(implicit fs: FileSystem): Boolean = {
    fs.rename(new Path(source), new Path(target))
  }
}
