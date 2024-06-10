import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    System.setProperty("spark.driver.memory", "2g")
    val spark = SparkSession.builder()
      .appName("vehicle-data")
      .master("local[*]")
      .config("hadoop.native.lib","false")
      .getOrCreate()
    val path = "../vehicleAnalysis/src/main/resources/vehicleMH.csv"
    val data = spark.read.option("header", "true").option("inferSchema", "true").csv(path).cache()
    data.printSchema()
    data.count()
    data.show(5,false)
  }
}