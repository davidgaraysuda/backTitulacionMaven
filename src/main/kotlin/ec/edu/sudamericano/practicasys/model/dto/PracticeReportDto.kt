package ec.edu.sudamericano.practicasys.dto

class PracticeReportDto (
    var startDate: String? = "",
    var endDate: String? = "",
    var studentName: String? = "",
    var studentNui: String? = "",
    var teacherName: String? = "",
    var tutorName: String? = "",
    var activityName: String?="",
    var practiceDetails: List<PracticeDetailDto> = ArrayList()
)