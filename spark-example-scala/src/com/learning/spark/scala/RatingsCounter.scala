package com.learning.spark.scala

import org.apache.log4j._
import org.apache.spark.SparkContext


object RatingsCounter {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "RatingsCounter")

    val lines = sc.textFile("/Users/panshul/Development/sparkDataDump/ml-100k/u.data")

    val ratings = lines.map(x => x.toString().split("\t")(2))

    val results = ratings.countByValue()

    val sortedResults = results.toSeq.sortBy(_._1)

    sortedResults.foreach(println)
  }

}
