//package com.zyurkalov
//
//import org.neo4j.graphdb.{Label, Node, Path, Transaction}
//import org.neo4j.graphdb.traversal.{Evaluation, Evaluator, Evaluators}
//import org.neo4j.logging.Log
//import org.neo4j.procedure._
//
//import java.util.stream.{Stream, StreamSupport}
//
//class TraverseDemoScala {
//  private[zyurkalov] val PERSON = Label.label("Person")
//
//  @Context
//  var tx: Transaction = null
//
//  @Context
//  var log: Log = null
//
//  /**
//   * Uses the Traversal API to return all Person fond by a Depth of 2.
//   * This could be much easier with a simple Cypher statement, but serves as a demo onl.
//   *
//   * @param actorName name of the Person node to start from
//   * @return Stream of Person Nodes
//   */
//  @Procedure(value = "travers.findCoActors", mode = Mode.READ)
//  @Description("traverses starting from the Person with the given name and returns all co-actors")
//  def findCoActors(@Name("actorName") actorName: String): Stream[CoActorRecord] = {
//    val actor = tx.findNodes(PERSON, "name", actorName).stream.findFirst.orElseThrow()
//    val traverse = tx.traversalDescription.depthFirst
//      .evaluator(Evaluators.fromDepth(1))
//      .evaluator(Evaluators.toDepth(2))
//      .evaluator(
//        Evaluators.includeIfAcceptedByAny(
//          new PathLogger(), new LabelEvaluator(PERSON)) )
//      .traverse(actor)
//    StreamSupport.stream(traverse.spliterator, false)
//      .map((p: Path) => p.endNode())
//      .map(new CoActorRecord(_))
//  }
//
//  /**
//   * See <a href="https://neo4j.com/docs/java-reference/4.2/javadocs/org/neo4j/procedure/Procedure.html">Procedure</a>
//   * <blockquote>
//   * A procedure must always return a Stream of Records, or nothing. The record is defined per procedure, as a class
//   * with only public, non-final fields. The types, order and names of the fields in this class define the format of the
//   * returned records.
//   * </blockquote>
//   * This is a record that wraps one of the valid return types (in this case a {@link Node}.
//   */
//  final class CoActorRecord private[zyurkalov](val node: Node) {
//  }
//  /**
//   * Miss-using an evaluator to log out the path being evaluated.
//   */
//  final private class PathLogger extends Evaluator {
//    override def evaluate(path: Path): Evaluation = {
//      log.info(path.toString)
//      Evaluation.EXCLUDE_AND_CONTINUE
//    }
//  }
//
//  final private class LabelEvaluator (val label: Label) extends Evaluator {
//    override def evaluate(path: Path): Evaluation = if (path.endNode.hasLabel(label)) Evaluation.INCLUDE_AND_CONTINUE
//    else Evaluation.EXCLUDE_AND_CONTINUE
//  }
//
//}
