package org.nbu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nbu.entities.Task;
import org.nbu.entities.User;
import org.nbu.services.TaskService;
import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogisticsCompanyApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDb() {
      	/*
    	  {
    		  User newUser = new User("testUser@mail.com", "testUser", "123456");
    		  userService.createUser(newUser); 
    	  }
    	  {
    		  User newUser = new User("testAdmin@mail.com", "testAdmin", "123456");
    		  userService.createUser(newUser); 
    	  }
    	  
    	  Task userTask = new Task("03/01/2018", "00:11", "11:00", "You need to work today");
    	  User user = userService.findOne("testUser@mail.com");
    	  taskService.addTask(userTask, user);
      	 */
    }

    @Test
    public void testUser() {
      	/*
    	  User user = userService.findOne("testUser@mail.com");
          assertNotNull(user);
    	  User admin = userService.findOne("testAdmin@mail.com");
    	  assertEquals(admin.getEmail(),"testAdmin@mail.com");
      	 */
    }

    @Test
    public void testTask() {
      	/*
    	  User user = userService.findOne("testUser@mail.com");
    	  List<Task> task = taskService.findUserTask(user);
    	  assertNotNull(task); 
		*/
    }
}
