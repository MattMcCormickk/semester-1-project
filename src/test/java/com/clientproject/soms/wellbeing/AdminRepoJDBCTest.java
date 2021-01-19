package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.model.ContactAdminMapper;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;

import static org.junit.Assert.assertEquals;


@JdbcTest
@Sql({"soms_wellbeing.sql", "test-data.sql"})
public class AdminRepoJDBCTest {
    @Autowired
    @Mock
    JdbcTemplate jdbcTemplate;

    @Autowired
    AdminRepoJDBCTest adminRepoJDBCTest;

/*        @Test
        public void TestfindAllSerPro() {
            ServiceProviderDTO spDTO = new ServiceProviderDTO("LitterHeroes", "0934032590", "city rd", "cf35 gdfj", "596");
            ReflectionTestUtils.setField(spDTO, "jdbcTemplate", jdbcTemplate);
            assertEquals("LitterHeroes", spDTO.getName());


        }*/

/*        @Test
        public void TestfindMessageByID(){
            ContactAdminDTO contactAdminDTO = new ContactAdminDTO(5, 5, "LitterHeroes", "litterheroes@charity.com",
                    "help", "12/12/2019", "low", "ok", "1.2. 2019", "admin", true);
            Assert.assertEquals(contactAdminDTO.getMessageID(), adminRepoJDBCTest.findMessageByID(5));
        }*/

    }



