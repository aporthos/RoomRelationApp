package com.globant.shared.data.mapper

import com.globant.shared.data.model.DirectorEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.DirectorDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DirectorMapper @Inject constructor():  Transform<DirectorEntity, DirectorDto>() {
    override fun transform(value: DirectorEntity): DirectorDto = DirectorDto(
        directorName = value.directorName,
        schoolOwnerName = value.schoolOwnerName
    )
}