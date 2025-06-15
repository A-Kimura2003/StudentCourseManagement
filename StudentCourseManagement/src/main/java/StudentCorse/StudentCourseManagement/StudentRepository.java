package StudentCorse.StudentCourseManagement;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM student WHERE name = #{name}")
      StudentCorse.StudentCourseManagement.Student searchByName(String name);

  @Insert("INSERT INTO student (name,age) VALUES (#{name},#{age})")
      void registerStudent(String name, int age);

  @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
      void updateStudent(String name, int age);

  @Select("SELECT * FROM student")
  List<StudentCorse.StudentCourseManagement.Student> findAll();
}
