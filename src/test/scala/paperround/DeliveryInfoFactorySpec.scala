package paperround

import org.scalatest.{FunSpec, Matchers}

class DeliveryInfoFactorySpec extends FunSpec with Matchers {
  describe("Delivery Planner") {
    val deliveryPlanner = new DeliveryInfoFactory(Seq(1, 2, 3, 4, 5, 7))

    it("should return correct delivery Info") {
      deliveryPlanner.getDeliveryInfo(1) shouldEqual DeliveryInfo(Seq(1, 3, 5, 7, 4, 2), 1)
      deliveryPlanner.getDeliveryInfo(2) shouldEqual DeliveryInfo(Seq(1, 2, 3, 4, 5, 7), 4)
    }
  }
}
