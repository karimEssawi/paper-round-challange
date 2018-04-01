package paperround

import scala.io.Source

class StreetTracker(houseNumbers: Seq[Int]) {
  private val isEven = (houseNumber: Int) => houseNumber % 2 == 0
  private val northernHouses = houseNumbers.filterNot { isEven }
  private val southernHouses = houseNumbers.filter { isEven }

  def getNumberOfHouses: Int = houseNumbers.size

  def getNumberOfNorthernHouses: Int = northernHouses.size

  def getNumberOfSouthernHouses: Int = southernHouses.size

  def validate(): Unit = {
    require(noDuplicates, "No number can be used more than once")
    require(isConsecutive, "No number can be skipped on either side")
  }

  private[paperround] def noDuplicates: Boolean = houseNumbers.toSet.size == houseNumbers.size

  private[paperround] def isConsecutive: Boolean = {
    def isConsecutive(seq: Seq[Int]) = seq.sliding(2).forall { i => i.head + 2 == i.last }
    isConsecutive(southernHouses) && isConsecutive(northernHouses)
  }
}

object StreetTracker {
  def apply(specFilePath: String): StreetTracker = {
    val houseNumbers = Source.fromFile(specFilePath).getLines.mkString.split(" ").map(_.toInt).toSeq
    new StreetTracker(houseNumbers)
  }
}
