/*
 * package com.admin.register.controllerTest;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import java.util.List;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.core.ParameterizedTypeReference; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.admin.register.model.AdminLogin;
 * 
 * @SpringBootTest()
 * 
 * @RunWith(SpringRunner.class) public class AdminLoginControllerTest {
 * 
 * // @Mock // AdminLogin adminLogin;
 * 
 * @Test public void getAdmin() {
 * 
 * RestTemplate template = new RestTemplate();
 * 
 * ResponseEntity<List<AdminLogin> >list=
 * template.exchange("http://localhost:8000/getAdmin",HttpMethod.GET,null,new
 * ParameterizedTypeReference <List<AdminLogin>>(){});
 * List<AdminLogin>listAdmin=list.getBody();
 * //assertArrayEquals(listAdmin.size(), 4); assertEquals(listAdmin.size(), 3);
 * // for(AdminLogin login:listAdmin) { // // }
 * 
 * } }
 */