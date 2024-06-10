import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    System.setProperty("spark.driver.memory", "2g")
    val spark = SparkSession.builder()
      .appName("vehicle-data")
      .master("local[*]")
      .config("hadoop.native.lib","false")
      .getOrCreate()
    val data = spark.read.option("header", "true").option("inferSchema", "true").csv("C:\\Users\\rahul\\Downloads\\vehicleMH.csv").cache()
    data.printSchema()
    data.count()
    data.show(5,false)
  }
}