package com.onimurasame.myresume.data

import org.springframework.data.domain.AuditorAware
import java.util.*

data class ResumeAuditor(var auditor: String = "Admin") : AuditorAware<String> {
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor
     */
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.of(this.auditor)
    }
}