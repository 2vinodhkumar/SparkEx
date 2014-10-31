import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.{Seconds, StreamingContext}
object StreamingExample {
val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
val ssc = new StreamingContext(conf, Seconds(1))
def main(args: Array[String]){

  val lines=ssc.socketTextStream("localhost", 9999)
  val words=lines.flatMap(_.split(" "))
  val pairs=words.map(word => (word,1))
  val wordCounts=pairs.reduceByKey(_+_)
 println("========================================================")
  wordCounts.print()
  println("=======================================================")
ssc.start()
ssc.awaitTermination()
  
}

}