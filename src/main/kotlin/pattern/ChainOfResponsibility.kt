package pattern

import model.Difficulty
import model.Question
import model.Student

interface DifficultyHandler<T>{

    var nextInChain: DifficultyHandler<T>?

    val hard: Difficulty
        get() = Difficulty.HARD
    val medium: Difficulty
        get() = Difficulty.MEDIUM
    val easy: Difficulty
        get() = Difficulty.EASY

    fun setDifficulty (question: Question, student: Student): T
}

class EasyDifficulty(override var nextInChain: DifficultyHandler<Unit>?): DifficultyHandler<Unit> {
    override fun setDifficulty(question: Question, student: Student) {
        val questionDifficulty: Difficulty = question.difficulty
        val age: Int = student.age
        if ((questionDifficulty == hard || questionDifficulty == medium) && age < 15) {
            question.difficulty = easy
        } else nextInChain?.setDifficulty(question, student)
    }
}

class MediumDifficulty(override var nextInChain: DifficultyHandler<Unit>?): DifficultyHandler<Unit> {
    override fun setDifficulty(question: Question, student: Student) {
        val questionDifficulty: Difficulty = question.difficulty
        val age: Int = student.age
        if ((questionDifficulty == hard || questionDifficulty == easy) && (age in 16..20)) {
            question.difficulty = medium
        } else nextInChain?.setDifficulty(question, student)
    }
}

class HardDifficulty  (override var nextInChain: DifficultyHandler<Unit>?): DifficultyHandler<Unit>  {
    override fun setDifficulty(question: Question, student: Student) {
        val questionDifficulty: Difficulty = question.difficulty
        val age: Int = student.age
        if ((questionDifficulty == easy || questionDifficulty == medium) && age > 20) {
            question.difficulty = hard
        } else nextInChain?.setDifficulty(question, student)
    }
}

class QuestionDifficultyHandler {
    private val hard: HardDifficulty = HardDifficulty(null)
    private val medium: MediumDifficulty = MediumDifficulty(hard)
    private val easy: EasyDifficulty = EasyDifficulty(medium)

    fun startChain (question: Question, student: Student) {
        easy.setDifficulty(question,student)
    }
}