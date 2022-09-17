package ru.pushkarev.city.dao;

import ru.pushkarev.city.domain.PersonResponse;
import ru.pushkarev.city.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {

    public static final String SQL_REQUEST = "";

    public PersonResponse checkPerson(PersonResponse request) throws PersonCheckException {
        PersonResponse  response = new PersonResponse();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_REQUEST)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }

        } catch (SQLException s) {
            throw new PersonCheckException(s);
        }
        return response;
    }

    private Connection getConnection() {
        return null;
    }
}
