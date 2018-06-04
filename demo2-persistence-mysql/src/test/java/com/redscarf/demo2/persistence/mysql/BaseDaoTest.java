package com.redscarf.demo2.persistence.mysql;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/12/01
 * <p>Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseConfiguration.class)
//@SpringApplicationConfiguration(BaseConfiguration.class)
//@Transactional
//@Rollback
@ActiveProfiles("test")
public abstract class BaseDaoTest {

}
