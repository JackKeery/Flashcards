package flashcards

fun main() {
    // User specifies the number of flashcards they want to create.
    println("Input the number of cards: ")
    val numCards = readLine()!!.toInt()

    // Creating a map to hold all of the data of these flashcards.
    val cards = mutableMapOf<String, String>()

    // Creating the cards
    createCards(numCards, cards)

    // Testing the user's knowledge based on the created flashcards.
    for ((term, def) in cards) {
        println("Print the definition of \"$term\": ")
        checkAnswer(cards, def, readLine()!!)
    }
}

/*
  This function runs a loop creating a new card until the number of cards created meets the user input.
  @param numCards - number of cards to create
  @param cards - empty map of cards
*/
fun createCards(numCards: Int, cards: MutableMap<String, String>) {
    for (i in 1..numCards) {
        newCard(i, cards)
    }
}

/*
  This function creates a new card. It asks for a term and then the corresponding definition and saves them in the map.
  @param cardNum - number of card we are creating
  @param cards - empty map of cards
*/
fun newCard(cardNum: Int, cards: MutableMap<String, String>) {
    var dupeTerm: Boolean = true
    var dupeDef: Boolean = true
    var term: String = ""
    var def: String = ""

    println("Card #$cardNum: ")
    while (dupeTerm) {
        term = readLine()!!
        if (!cards.containsKey(term)) {
            dupeTerm = false
        } else {
            println("The card \"$term\" already exists. Try again: ")
        }
    }
    println("The definition for card #$cardNum: ")
    while (dupeDef) {
        def = readLine()!!
        if (!cards.containsValue(def)) {
            dupeDef = false
        } else {
            println("The definition \"$def\" already exists. Try again: ")
        }
    }
    cards[term] = def
}

/*
  This function compares the users answer with the one saved in the array.
  @param def - correct answer
  @param answer - user's answer
*/
fun checkAnswer(cards: MutableMap<String, String>, def: String, answer: String) {
    if (def == answer) {
        println("Correct!")
    } else if (cards.containsValue(answer)) {
        println("Wrong. The right answer is \"$def\", but your definition is correct for \"${findKey(cards, answer)}\".")
    } else {
        println("Wrong. The right answer is \"$def\".")
    }
}

/*
  This function finds the key for a certain value in the map.
  @param map - the map of flashcards
  @param target - the value for the key you are searching for
  @return key/null - returns the key for the value
*/
fun findKey(map: MutableMap<String, String>, target: String): String? {
    for ((key, value) in map) {
        if (target == value) {
            return key
        }
    }
    return null
}