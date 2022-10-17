import model.Difficulty
import model.Question
import model.Student
import pattern.QuestionDifficultyHandler

fun main(args: Array<String>) {

    // Case 1
    val student     = Student   ("A00368238", "Alexander","12345678","alexssjr2002@gmail.com",20,premium = false, "")
    val question    = Question  ("00112233","Matermáticas", listOf("a","b","c","d"),"b",Difficulty.EASY)

    println("Vieja dificultad: ${question.difficulty}")

    QuestionDifficultyHandler().startChain(question,student)

    println("Nueva dificultad: ${question.difficulty}")

    println()

    // Case 2
    val student2     = Student   ("A00368239", "Sebastian","1234","itssebas18@gmail.com",25,premium = true, "")
    val question2   = Question  ("00112233","Programación", listOf("a","b","c","d"),"d",Difficulty.EASY)

    println("Vieja dificultad: ${question2.difficulty}")

    QuestionDifficultyHandler().startChain(question2,student2)

    println("Nueva dificultad: ${question2.difficulty}")

}