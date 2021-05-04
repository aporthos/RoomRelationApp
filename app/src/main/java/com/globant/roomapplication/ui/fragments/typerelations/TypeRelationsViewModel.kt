package com.globant.roomapplication.ui.fragments.typerelations

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.roomapplication.ui.model.ViewState
import com.globant.shared.di.IoDispatcher
import com.globant.shared.domain.model.SchoolAndDirectorDto
import com.globant.shared.domain.model.SchoolWithStudentsDto
import com.globant.shared.domain.model.StudentWithSubjectsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import com.globant.shared.domain.usecase.*
import com.globant.shared.util.executeUseCase
import com.globant.shared.util.onFailure
import com.globant.shared.util.onSuccess
import kotlinx.coroutines.*

class TypeRelationsViewModel @ViewModelInject constructor(
    private val configureDataBaseUseCase: ConfigureDataBaseUseCase,
    private val getOneToOneUseCase: GetOneToOneUseCase,
    private val getOneToManyUseCase: GetOneToManyUseCase,
    private val studentsOfSubjectsManyToManyUseCase: StudentsOfSubjectsManyToManyUseCase,
    private val subjectsOfStudentsManyToManyUseCase: SubjectsOfStudentsManyToManyUseCase,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _schoolAndDirector = MutableLiveData<ViewState<List<SchoolAndDirectorDto>>>()
    val schoolAndDirector: LiveData<ViewState<List<SchoolAndDirectorDto>>>
        get() = _schoolAndDirector

    private val _schoolWithStudents = MutableLiveData<ViewState<List<SchoolWithStudentsDto>>>()
    val schoolWithStudents: LiveData<ViewState<List<SchoolWithStudentsDto>>>
        get() = _schoolWithStudents

    private val _studentWithSubjectsDto = MutableLiveData<ViewState<List<StudentWithSubjectsDto>>>()
    val studentWithSubjectsDto: LiveData<ViewState<List<StudentWithSubjectsDto>>>
        get() = _studentWithSubjectsDto

    private val _subjectWithStudentsDto = MutableLiveData<ViewState<List<SubjectWithStudentsDto>>>()
    val subjectWithStudentsDto: LiveData<ViewState<List<SubjectWithStudentsDto>>>
        get() = _subjectWithStudentsDto

    init {
        loadOneToOne()
        loadOneToMany()
        loadStudentsOfSubjectsManyToMany()
        loadSubjectsOfStudentsManyToMany()
    }

    fun configure() = viewModelScope.launch {
        configureDataBaseUseCase(Unit)
    }

    fun loadOneToOne() {
        _schoolAndDirector.postValue(ViewState.Loading)
        executeUseCase(ioDispatcher) {
            getOneToOneUseCase(Unit)
                .onSuccess {
                    _schoolAndDirector.postValue(ViewState.Success(it))
                }.onFailure {
                    _schoolAndDirector.postValue(ViewState.Error(it))
                }
        }
    }

    fun loadOneToMany() {
        _schoolWithStudents.postValue(ViewState.Loading)
        executeUseCase(ioDispatcher) {
            getOneToManyUseCase("Kotlin School")
                .onSuccess {
                    _schoolWithStudents.postValue(ViewState.Success(it))
                }.onFailure {
                    _schoolWithStudents.postValue(ViewState.Error(it))
                }
        }
    }

    fun loadStudentsOfSubjectsManyToMany() {
        _studentWithSubjectsDto.postValue(ViewState.Loading)
        executeUseCase(ioDispatcher) {
            studentsOfSubjectsManyToManyUseCase("Kotlin School")
                .onSuccess {
                    _studentWithSubjectsDto.postValue(ViewState.Success(it))
                }.onFailure {
                    _studentWithSubjectsDto.postValue(ViewState.Error(it))
                }
        }
    }

    fun loadSubjectsOfStudentsManyToMany() {
        _subjectWithStudentsDto.postValue(ViewState.Loading)
        executeUseCase(ioDispatcher) {
            subjectsOfStudentsManyToManyUseCase("Kotlin School")
                .onSuccess {
                    _subjectWithStudentsDto.postValue(ViewState.Success(it))
                }.onFailure {
                    _subjectWithStudentsDto.postValue(ViewState.Error(it))
                }
        }
    }
}