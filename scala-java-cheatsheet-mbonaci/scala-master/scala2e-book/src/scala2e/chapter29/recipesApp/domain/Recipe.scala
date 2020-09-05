package scala2e.chapter29.recipesApp.domain

// entity
class Recipe (
  val name: String,
  val ingredients: List[Food],
  val instructions: String
) {
  override def toString = name
}