package com.example.homeworkweek4_2

class StudentInfo(name: String, var birthday: String, classr: String, var gender: String) {
    var fullname: String = name
    var classroom: String = classr

    override fun toString(): String {
        return fullname + birthday + classroom + gender
    }
}