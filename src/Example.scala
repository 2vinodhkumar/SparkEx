import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object Example {
val conf = new SparkConf().setAppName("SparkExample").setMaster("local")
new SparkContext(conf)
def main(args: Array[String]){
  println("Hello, world!")
}
  
}