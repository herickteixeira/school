package com.school.infrastructure.student;

import com.school.core.domain.student.Cpf;
import com.school.core.domain.student.Email;
import com.school.core.domain.student.interfaces.IStudentRepository;
import com.school.core.domain.student.Student;
import com.school.core.domain.student.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final Connection connection;

    public StudentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCpf());
            ps.execute();

            sql = "INSERT INTO TELEPHONE VALUES(?)";
            ps = connection.prepareStatement(sql);
            for (Phone phone : student.getPhones()) {
                ps.setString(1, phone.getNumber());
                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getByCpf(Cpf cpf) {
        try {
            String sql = "SELECT id, name, email FROM student WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            if (!found) {
                throw new RuntimeException("NOT FOUND");
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student founded = new Student(name, email, cpf);

            Long id = rs.getLong("id");
            sql = "SELECT number FROM phone WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                founded.addPhone(number);
            }

            return founded;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudentList() {
        try {
            String sql = "SELECT id, name, email, cpf FROM student";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                Cpf cpf = new Cpf(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(name, email, cpf);

                Long id = rs.getLong("id");
                sql = "SELECT number FROM phone WHERE student_id = ?";
                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();
                while (rsPhone.next()) {
                    String number = rsPhone.getString("number");
                    student.addPhone(number);
                }

                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
