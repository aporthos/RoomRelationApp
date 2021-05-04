package com.globant.shared.domain

abstract class Transform<T1, T2> {
    abstract fun transform(value: T1): T2
}