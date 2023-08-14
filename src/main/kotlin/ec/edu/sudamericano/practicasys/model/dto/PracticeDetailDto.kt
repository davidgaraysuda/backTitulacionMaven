package ec.edu.sudamericano.practicasys.dto

import ec.edu.sudamericano.practicasys.model.ActivityDetailView

class PracticeDetailDto (
        var currentDate: String? = "",
        var startTime: String? = "",
        var endTime: String? = "",
        var totalHours: String? = "",
        var activityDetails: List<ActivityDetailView> = ArrayList(),
        var observations: String? = "",

        )