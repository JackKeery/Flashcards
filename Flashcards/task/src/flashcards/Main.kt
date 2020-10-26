package flashcards

fun main() {
    // User specifies the number of cards to create
    println("Input the number of cards: ")
    val numCards = readLine()!!.toInt()

    // Creating two arrays of type string for terms and defs
    val termArray = Array<String?>(numCards) { null }
    val defArray = Array<String?>(numCards) { null }

    // Creating the flash cards
    createCards(numCards, termArray, defArray)

    // Testing the user on their flashcards
    for (i in 0 until numCards) {
        println("Print the definition of \"${termArray[i]}\": ")
        checkAnswer(defArray[i], readLine()!!)
    }
}

/*
  This function runs a loop creating a new card until the number of cards created meets the user input
  @param numCards - number of cards to create
  @param termArray - the empty array of terms
  @param defArray - the empty array of definitions
 */
fun createCards(numCards: Int, termArray: Array<String?>, defArray: Array<String?>) {
    for (i in 1..numCards) {
        newCard(i, termArray, defArray)
    }
}

/*
  This function creates a new card. It asks for a term and then the corresponding definition and saves them in arrays.
  @param cardNum - number of card we are creating
  @param termArray - blank array of terms
  @param defArray - blank array of definitions
 */
fun newCard(cardNum: Int, termArray: Array<String?>, defArray: Array<String?>) {
    println("Card #$cardNum: ")
    val term = readLine()!!
    println("The definition for card #$cardNum: ")
    val def = readLine()!!
    termArray[cardNum-1] = term
    defArray[cardNum-1] = def
}

/*
  This function compares the users answer with the one saved in the array.
  @param def - correct answer
  @param answer - user's answer
 */
fun checkAnswer(def: String?, answer: String) {
    if (def == answer) {
        println("Correct!")
    } else {
        println("Wrong. The right answer is \"$def\".")
    }
}