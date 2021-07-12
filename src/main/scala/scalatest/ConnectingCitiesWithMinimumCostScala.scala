package scalatest
import zyurkalov.DisjointSet



class ConnectingCitiesWithMinimumCostScala {
  val NODE1 = 0
  val NODE2 = 1

  def minimumCost(n: Int, connections: Array[Array[Int]]): Int = {
    val disjointSet = new DisjointSet(n)
    connections
      .sortWith((a,b) => a(2) < b(2))
      .map((connection: Array[Int]) => Array(connection(0) - 1, connection(1) - 1, connection(2)))
      .filter(connection => {
        val isInTheSameGroup = !disjointSet.isInTheSameGroup(connection(0), connection(1))
        if (isInTheSameGroup)
          disjointSet.union(connection(0),connection(1))
        isInTheSameGroup
      })
      .map(connection => connection(2))
      .sum
  }

}
object ConnectingCitiesWithMinimumCostScala extends App {
  println(
    new ConnectingCitiesWithMinimumCostScala().minimumCost(3,
      Array(
        Array(1,2,5),
        Array(1,3,6),
        Array(2,3,1)
      )
    )
  )


}
