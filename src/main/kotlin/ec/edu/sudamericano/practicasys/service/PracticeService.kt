
package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.dto.PracticeReportDto
import ec.edu.sudamericano.practicasys.model.Practice
import ec.edu.sudamericano.practicasys.model.PracticeView
import ec.edu.sudamericano.practicasys.repository.PracticeRepository
import ec.edu.sudamericano.practicasys.repository.PracticeViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDate

@Service
class PracticeService {
    @Autowired
    lateinit var practiceRepository: PracticeRepository
    @Autowired
    lateinit var practiceViewRepository: PracticeViewRepository
    @Autowired
    lateinit var studentService: StudentService
    @Autowired
    lateinit var tutorService: TutorService
    @Autowired
    lateinit var practiceDetailService: PracticeDetailService
    @Autowired
    lateinit var teacherService: TeacherService
    @Autowired
    lateinit var activityService: ActivityService


    fun list(): List<Practice> {

        return practiceRepository.findAll()
    }
    fun listEstudiante(): List<PracticeView> {

        return practiceViewRepository.findAll()
    }

    fun listById (id:Long?): Practice?{
        return practiceRepository.findById(id)
    }
    fun listByStudent (studentId:Long): List<PracticeView>{
        return practiceViewRepository.listPracticeByStudent(studentId)
    }

    fun listWeekPractice (id:Long, dateStart:String, dateEnd:String): PracticeReportDto{
        val response = PracticeReportDto()
        val dateStartFormat=LocalDate.parse(dateStart.substring(0,4)+'-'+dateStart.substring(4,6)+'-'+dateStart.substring(6,8))
        val dateEndFormat=LocalDate.parse(dateEnd.substring(0,4)+'-'+dateEnd.substring(4,6)+'-'+dateEnd.substring(6,8))

        val practice =listById(id)
        val student = studentService.listById(practice?.studentId)
        val teacher = teacherService.listById(practice?.teacherId)
        val tutor= tutorService.listById(practice?.tutorId)

        response.apply {
            var simpleDateFormat = SimpleDateFormat("LLLL")
            simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
            startDate=simpleDateFormat.format(practice?.startDate).toString()
            endDate=simpleDateFormat.format(practice?.endDate).toString()
            studentNui=student?.nui.toString()
            studentName=student?.name + ' ' +student?.lastname
            teacherName=teacher?.name
            tutorName=tutor?.name
            practiceDetails=practiceDetailService.listDetailByPracticeToDto(id,dateStartFormat,dateEndFormat)
        }
        return response
    }

    fun save(practice:Practice):Practice{
        practice.apply { praStatus=true }
        return practiceRepository.save(practice)
    }
    fun update(practice:Practice):Practice {
        val response =practiceRepository.findById(practice.id)
        if (response==null){
            throw Exception()
        }else{
            return practiceRepository.save(practice)
        }
    }

    fun delete(id:Long):Boolean{
        practiceRepository.deleteById(id)
        return true
    }
}

