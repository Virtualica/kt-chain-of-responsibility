package model

class Question {
    var id: String
    var topic: String
    var options: List<String>
    var correctAnswers: String
    var difficulty: Difficulty

    constructor(id: String, topic: String, options: List<String>, correctAnswers: String, difficulty: Difficulty) {
        this.id = id
        this.topic = topic
        this.options = options
        this.correctAnswers = correctAnswers
        this.difficulty = difficulty
    }

}