package com.wecp.logisticsmanagementandtrackingsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wecp.logisticsmanagementandtrackingsystem.dto.LoginRequest;
import com.wecp.logisticsmanagementandtrackingsystem.entity.*;
import com.wecp.logisticsmanagementandtrackingsystem.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LogisticsManagementAndTrackingSystemApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private TravelDestinationRepository travelDestinationRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@BeforeEach
	public void setUp() {
		// Clear the database before each test
		userRepository.deleteAll();
		reviewRepository.deleteAll();
		travelDestinationRepository.deleteAll();
		customerRepository.deleteAll();
		businessRepository.deleteAll();
	}

	@Test
	public void testRegisterBusiness() throws Exception {
		// Create a User object for registration
		User user = new User();
		user.setUsername("testBlogger");
		user.setPassword("testPassword");
		user.setEmail("test@example.com");
		user.setRole("BLOGGER");

		// Perform a POST request to the /register endpoint using MockMvc
		mockMvc.perform(post("/api/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsBytes(user)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.name").value(user.getUsername()))
				.andExpect(jsonPath("$.email").value(user.getEmail()));

		// Assert business is created in the database
		Business savedBusiness = businessRepository.findAll().get(0);
		assertEquals(user.getUsername(), savedBusiness.getName());
		assertEquals(user.getEmail(), savedBusiness.getEmail());

		// Assert user is created in the database
		User savedUser = userRepository.findAll().get(0);
		assertEquals(user.getEmail(), savedUser.getEmail());
		assertEquals("BLOGGER", savedUser.getRole());
	}

	@Test
	public void testRegisterCustomer() throws Exception {
		// Create a User object for registration
		User user = new User();
		user.setUsername("testTraveller");
		user.setPassword("testPassword");
		user.setEmail("test@example.com");
		user.setRole("TRAVELLER");

		// Perform a POST request to the /register endpoint using MockMvc
		mockMvc.perform(post("/api/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsBytes(user)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.name").value(user.getUsername()))
				.andExpect(jsonPath("$.email").value(user.getEmail()));

		// Assert business is created in the database
		Customer savedCustomer = customerRepository.findAll().get(0);
		assertEquals(user.getUsername(), savedCustomer.getName());
		assertEquals(user.getEmail(), savedCustomer.getEmail());

		// Assert user is created in the database
		User savedUser = userRepository.findAll().get(0);
		assertEquals(user.getEmail(), savedUser.getEmail());
		assertEquals("TRAVELLER", savedUser.getRole());
	}

	@Test
	public void testRegisterDriver() throws Exception {
		// Create a User object for registration
		User user = new User();
		user.setUsername("testLocal");
		user.setPassword("testPassword");
		user.setEmail("test@example.com");
		user.setRole("LOCAL");

		// Perform a POST request to the /register endpoint using MockMvc
		mockMvc.perform(post("/api/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsBytes(user)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.name").value(user.getUsername()))
				.andExpect(jsonPath("$.email").value(user.getEmail()));

		// Assert business is created in the database
		Driver savedDriver = driverRepository.findAll().get(0);
		assertEquals(user.getUsername(), savedDriver.getName());
		assertEquals(user.getEmail(), savedDriver.getEmail());

		// Assert user is created in the database
		User savedUser = userRepository.findAll().get(0);
		assertEquals(user.getEmail(), savedUser.getEmail());
		assertEquals("LOCAL", savedUser.getRole());
	}

	@Test
	public void testLoginUser() throws Exception {
		// Create a user for registration
		User user = new User();
		user.setUsername("user1");
		user.setPassword("password");
		user.setRole("TRAVELLER");
		user.setEmail("user@gmail.com");
		// Register the user
		mockMvc.perform(post("/api/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isOk());

		// Login with the registered user
		LoginRequest loginRequest = new LoginRequest("user1", "password");

		mockMvc.perform(post("/api/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(loginRequest)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.token").exists());
	}

	@Test
	public void testLoginWithWrongUsernameOrPassword() throws Exception {
		// Create a login request with a wrong username
		LoginRequest loginRequest = new LoginRequest("wronguser", "password");

		mockMvc.perform(post("/api/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(loginRequest)))
				.andExpect(status().isUnauthorized()); // Expect a 401 Unauthorized response
	}

	@Test
	@WithMockUser(authorities = "BLOGGER")
	public void testViewCargoStatus() throws Exception {

		TravelDestination travel = new TravelDestination();
		travel.setState("Tamilnadu");
		travel.setHighLights("Good Place to Visit");
		travel.setLocationName("Ooty");

		travel = travelDestinationRepository.save(travel);

		// Performing the request and asserting the response
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/cargo-status")
						.param("cargoId", String.valueOf(cargo.getId()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.cargoId").value(cargo.getId()))
				.andExpect(jsonPath("$.status").value(cargo.getStatus()));

	}

	@Test
	@WithMockUser(authorities = "TRAVELLER")
	public void testUpdateCargoStatus() throws Exception {

		Review review = new Review();
		review.setReviewDetails("Good");
		review.setCustomer("testTraveller");
		review.setTravelDestination("Tamilnadu");

		review = cargoRepository.save(review);

		// Performing the request and asserting the response
		mockMvc.perform(MockMvcRequestBuilders.put("/api/updateReview")
						.param("reviewId", String.valueOf(review.getId()))
						.param("reviewDetails", "Good Place")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

		// Assert the cargo status is updated in the database
		Review updatedReview = reviewRepository.findById(review.getId()).get();
		assertEquals("reviewDetails", updatedReview.getStatus());

	}


	@Test
	public void testPermissionForBloggerEndpoints() throws Exception {
		mockMvc.perform(post("/api/Adddestination"))
				.andExpect(status().isForbidden());
	}

	@Test
	public void testPermissionForTravellerEndpoints() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/review"))
				.andExpect(status().isForbidden());

		mockMvc.perform(MockMvcRequestBuilders.put("/api/updateReview"))
				.andExpect(status().isForbidden());
	}

	@Test
	public void testPermissionForLocalEndpoints() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/review"))
				.andExpect(status().isForbidden());
	}

}
