package usermanagement.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import usermanagement.entity.Person;

public class TransformServiceTest {

    private static final Integer Person1ID = 123456;
    private static final String Person1FirstName = "Ali";
    private static final String Person1MiddleName = "Zand";
    private static final String Person1LastName = "Hasani";
    private static final String CompanyName = "TestCompany";
    private final Person person1 = new Person();
    private final User person1EquivalentUser = new User();


    private final TransformService transformer = new TransformService();

    @Before
    public void setup() {
        person1.setPersonId(Person1ID);
        person1.setfName(Person1FirstName);
        person1.setmName(Person1MiddleName);
        person1.setlName(Person1LastName);
        person1.setCompanyName(CompanyName);

        person1EquivalentUser.setUserId(Person1ID);
        person1EquivalentUser.setFirstName(Person1FirstName);
        person1EquivalentUser.setLastName(Person1LastName);
        person1EquivalentUser.setCompanyName(CompanyName);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void convertUserToPersonTest() {
        User user = transformer.toUserDomain(person1);
        Assert.assertEquals(person1EquivalentUser, user);
    }

    @Test
    public void convertPersonToUserTest() {
        Person person = transformer.toUserEntity(person1EquivalentUser);
        Assert.assertEquals(person1.getPersonId(), person.getPersonId());
        Assert.assertEquals(person1.getfName(), person.getfName());
        Assert.assertEquals(person1.getlName(), person.getlName());
        Assert.assertNull(person.getmName());
        Assert.assertEquals(person1.getCompanyName(), person.getCompanyName());
    }

}
