package StudentCorse.StudentCourseManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentCourseManagementApplication {

	@Autowired
	private StudentCorse.StudentCourseManagement.StudentRepository studentRepository;

	@Autowired
	private StudentCorse.StudentCourseManagement.CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(StudentCourseManagementApplication.class, args);
	}
	@GetMapping("/student")
		public String getStudent(@RequestParam String name){
			StudentCorse.StudentCourseManagement.Student student = studentRepository.searchByName(name);
			if (student == null){
				return "学生が見つかりません";
			}

			List<StudentCorse.StudentCourseManagement.Course> corses = courseRepository.searchByName(name);

			StringBuilder result = new StringBuilder();
			result.append(student.getName())
					.append(" (")
					.append(student.getAge())
					.append("歳) \n");
			for (StudentCorse.StudentCourseManagement.Course course : corses){
				result.append("コース: ")
						.append(course.getCoursename())
						.append("\n");
			}
			return result.toString();
	}

}
