package paperround

object Main {
  def main(args: Array[String]): Unit = {
    val streetSpecification = args(0)

    val streetTracker = StreetTracker(streetSpecification)
    streetTracker.validate()
    println(s"Number of houses in the street is ${streetTracker.getNumberOfHouses}")
    println(s"Number of houses on left hand side of the street is ${streetTracker.getNumberOfNorthernHouses}")
    println(s"Number of houses on right hand side of the street is ${streetTracker.getNumberOfSouthernHouses}")

    val deliveryInfoFactory = DeliveryInfoFactory(streetSpecification)
    val approachOneDeliveryInfo = deliveryInfoFactory.getDeliveryInfo(1)
    println(
      s"""Delivery information for approach one:
         |Order of houses: ${approachOneDeliveryInfo.housesOrdered.mkString(" ")}
         |Number of crossings: ${approachOneDeliveryInfo.numOfCrossings}""".stripMargin)

    val approachTwoDeliveryInfo = deliveryInfoFactory.getDeliveryInfo(2)
    println(
      s"""Delivery information for approach two:
         |Order of houses: ${approachTwoDeliveryInfo.housesOrdered.mkString(" ")}
         |Number of crossings: ${approachTwoDeliveryInfo.numOfCrossings}""".stripMargin)

  }
}
