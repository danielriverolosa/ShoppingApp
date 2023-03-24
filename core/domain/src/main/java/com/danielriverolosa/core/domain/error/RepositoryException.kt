package com.danielriverolosa.core.domain.error

class RepositoryException(override val message: String) : RuntimeException(message)