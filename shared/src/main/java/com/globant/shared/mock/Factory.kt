package com.globant.shared.mock

import com.globant.shared.data.model.*

object Factory {
    val directors = listOf(
        DirectorEntity(
            "Mike Litoris",
            "Jake Wharton School"
        ),
        DirectorEntity("Jack Goff", "Kotlin School"),
        DirectorEntity(
            "Chris P. Chicken",
            "JetBrains School"
        )
    )

    val teacher = listOf(
        TeacherEntity("Goku"),
        TeacherEntity("Naruto")
    )

    val schools = listOf(
        SchoolEntity("Jake Wharton School"),
        SchoolEntity("Kotlin School"),
        SchoolEntity("JetBrains School")
    )
    val subjects = listOf(
        SubjectEntity("Dating for programmers"),
        SubjectEntity("Avoiding depression"),
        SubjectEntity("Bug Fix Meditation"),
        SubjectEntity("Logcat for Newbies"),
        SubjectEntity("How to use Google")
    )

    val students = listOf(
        StudentEntity(
            "Beff Jezos",
            2,
            "Kotlin School",
            "Goku"
        ),
        StudentEntity(
            "Mark Suckerberg",
            5,
            "Jake Wharton School",
            "Naruto"
        ),
        StudentEntity(
            "Gill Bates",
            8,
            "Kotlin School",
            "Goku"
        ),
        StudentEntity(
            "Donny Jepp",
            1,
            "Kotlin School",
            "Naruto"
        ),
        StudentEntity(
            "Hom Tanks",
            2,
            "JetBrains School",
            "Goku"
        )
    )

    val studentSubjectRelations = listOf(
        StudentSubjectCrossRef(
            "Beff Jezos",
            "Dating for programmers"
        ),
        StudentSubjectCrossRef(
            "Beff Jezos",
            "Avoiding depression"
        ),
        StudentSubjectCrossRef(
            "Beff Jezos",
            "Bug Fix Meditation"
        ),
        StudentSubjectCrossRef(
            "Beff Jezos",
            "Logcat for Newbies"
        ),
        StudentSubjectCrossRef(
            "Mark Suckerberg",
            "Dating for programmers"
        ),
        StudentSubjectCrossRef(
            "Gill Bates",
            "How to use Google"
        ),
        StudentSubjectCrossRef(
            "Donny Jepp",
            "Logcat for Newbies"
        ),
        StudentSubjectCrossRef(
            "Hom Tanks",
            "Avoiding depression"
        ),
        StudentSubjectCrossRef(
            "Hom Tanks",
            "Dating for programmers"
        )
    )
}