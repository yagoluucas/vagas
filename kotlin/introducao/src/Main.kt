fun main() {
    var faculdade = "FIAP"
    println(faculdade)
    faculdade = "Faculdade de administração e informática paulista"
    println(faculdade)
    // faculdade = 1 erro de sintaxe porque o valor inicial desta variável é string

    val fruits = ArrayList<String>()
    fruits.addAll(listOf("Banana", "Orange", "Apple"))
    for(fruit in fruits) {
        println("$fruit is a delicius fruit")
    }
}