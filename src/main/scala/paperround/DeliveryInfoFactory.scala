package paperround

import scala.io.Source

case class DeliveryInfo(housesOrdered: Seq[Int], numOfCrossings: Int)

class DeliveryInfoFactory(houseNumbers: Seq[Int]) {
  def getDeliveryInfo(approach: Int): DeliveryInfo = {
    approach match {
      case 1 => DeliveryInfo(
        houseNumbers.sortWith { (a, b) => if (a % 2 == 0 && b % 2 == 0) a > b else a % 2 > b % 2 },
        1
      )
      case 2 => DeliveryInfo(
        houseNumbers,
        houseNumbers.sliding(2).count { i => i.head % 2 != i.last % 2 }
      )
    }
  }
}

object DeliveryInfoFactory {
  def apply(specFilePath: String): DeliveryInfoFactory = {
    val houseNumbers = Source.fromFile(specFilePath).getLines.mkString.split(" ").map(_.toInt).toSeq
    new DeliveryInfoFactory(houseNumbers)
  }
}

