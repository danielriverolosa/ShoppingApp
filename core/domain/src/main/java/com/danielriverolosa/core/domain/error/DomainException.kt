package com.danielriverolosa.core.domain.error

class DomainException(override val message: String) : RuntimeException(message)