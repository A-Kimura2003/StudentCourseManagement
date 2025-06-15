package StudentCorse.StudentCourseManagement;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CourseRepository {

    @Select("SELECT * FROM course WHERE name = #{name}")
    List<StudentCorse.StudentCourseManagement.Course> searchByName(String name);

    @Insert("INSERT INTO course (name,coursename) VALUES (#{name},#{coursename})")
    void registerCourse(String name, String coursename);

    @Update("UPDATE corse SET coursename = #{coursename} WHERE name = #{name}")
    void updateCourse(String name, String coursename);

    @Delete("DELETE FROM course WHERE name = #{name}")
    void deleteCourse(String name);

    @Select("SELECT * FROM course")
    List<StudentCorse.StudentCourseManagement.Course> findAll();
}
