import com.liusiqi.mapper.ClassesMapper;
import com.liusiqi.mapper.StudentMapper;
import com.liusiqi.mode.Classes;
import com.liusiqi.mode.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init(){
        // 根据全局配置文件创建出SqlSessionFactory
        // SqlSessionFactory:负责创建SqlSession对象的工厂
        // SqlSession:表示跟数据库建议的一次会话
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        //获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取要调用的接口对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //查一条
            Student student = mapper.selectById("000001");
            //查所有
            List<Student> students = mapper.selectAllStudent();
            //增
            student.setStudentId("000009");
            mapper.insertStudent(student);
            //改
            student.setAge("30");
            mapper.updateStudent(student);
            //删
            Student student1 = new Student();
            student1.setStudentId("000009");
            mapper.deleteStudent(student1);
            //事务提交（增、删、改操作需事务提交）
//            sqlSession.commit(true);
            System.out.println(student.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
        StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);
        Classes classes = mapper.selectById("0001");
        List<Student> students = mapper1.selectAllStudent();
        System.out.println(classes);
    }
}
