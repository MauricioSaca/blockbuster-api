package com.blockbuster.api.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blockbuster.api.enums.RoleEnum;
import com.blockbuster.api.models.Authorities;
import com.blockbuster.api.models.ConfirmationToken;
import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.pojos.ApiResponse;
import com.blockbuster.api.pojos.JwtAuthenticationResponse;
import com.blockbuster.api.pojos.LoginRequest;
import com.blockbuster.api.pojos.SignUpRequest;
import com.blockbuster.api.repository.ConfirmationTokenRepository;
import com.blockbuster.api.repository.UserPrincipalRepository;
import com.blockbuster.api.security.jwt.config.JwtTokenProvider;
import com.blockbuster.api.service.UserPrincipalService;
import com.blockbuster.api.service.impl.EmailSenderService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/auth")
@Getter
@Setter
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserPrincipalRepository userPrincipalRepository;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private UserPrincipalService userPrincipalService;

	@Value("${app.from.mail}")
	private String fromMail;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		if (userPrincipalRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (userPrincipalRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		UserPrincipal user = new UserPrincipal();
		String password = new BCryptPasswordEncoder().encode(signUpRequest.getPassword());
		user.setName(signUpRequest.getName());
		user.setLastName(signUpRequest.getLastName());
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(password);
		user.setEmail(signUpRequest.getEmail());
		user.setEnabled(false);

		Authorities auth = new Authorities();
		auth.setUserPrincipal(user);
		auth.setRole(RoleEnum.USER);

		UserPrincipal result = userPrincipalService.saveUserPrincipal(user, auth);
		ConfirmationToken confirmationToken = new ConfirmationToken(result);
		confirmationTokenRepository.save(confirmationToken);
		StringBuilder sb = new StringBuilder();
		sb.append("o confirm your account, please click here : ");
		sb.append("http://localhost:8080/api/auth/confirm-account?token=");
		sb.append(confirmationToken.getConfirmationToken());

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(result.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom(fromMail);
		mailMessage.setText(sb.toString());

		emailSenderService.sendEmail(mailMessage);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered"));
	}

	@PatchMapping("/confirm-account")
	public ResponseEntity<?> confirmUser(@RequestParam("token") String confirmationToken) {
		ApiResponse result = new ApiResponse();
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			UserPrincipal user = userPrincipalRepository.findByEmailIgnoreCase(token.getUserPrincipal().getEmail());
			user.setEnabled(true);
			userPrincipalRepository.save(user);
			result.setSuccess(true);
			result.setMessage("User registered successfully");
		} else {
			result.setSuccess(false);
			result.setMessage("User not confirmed");
		}

		return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
	}

}
