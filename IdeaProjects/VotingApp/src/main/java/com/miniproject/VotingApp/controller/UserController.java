package com.miniproject.VotingApp.controller;
import com.miniproject.VotingApp.entity.*;
import com.miniproject.VotingApp.request.*;
import com.miniproject.VotingApp.service.EmailService;
import com.miniproject.VotingApp.service.SmsService;
import com.miniproject.VotingApp.service.UserService;
import com.miniproject.VotingApp.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtility jwtUtility;

    @PostMapping("/signup")
    public ResponseEntity<String> userRegistration(@RequestBody User user)
    {
        if(userService.userRegistration(user).equalsIgnoreCase("You already have the account")) {
            return new ResponseEntity(userService.userRegistration(user), HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<>("Registration completed.Thank you for registering", HttpStatus.CREATED);
    }


    @PutMapping("/forgetPassword/{phoneNumber}")
    public String forgetPassword(@PathVariable Long phoneNumber, @RequestParam String secretAnswer, @RequestParam String password)
    {
        return userService.forgetPassword(phoneNumber, secretAnswer, password);
    }

    @GetMapping("/home")
    public ResponseEntity<List<HomePage>> homePage()
    {
        List<HomePage>home = userService.homePage();
        if(home==null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(home));
        }
    }


    @PostMapping("/voterSignup")
    public ResponseEntity<String> voterRegistration(@ModelAttribute Voter voter)
    {
        return new ResponseEntity<>(userService.voterRegistration(voter),HttpStatus.OK);
    }


    @GetMapping("/elections")
    public ResponseEntity<List<Election>> getElectionInformation()
    {
        List<Election> election = userService.getElectionInformation();
        if(election == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(election));
        }
    }

    @GetMapping("/parties/{wardNumber}/{electionName}")
    public ResponseEntity<List<Party>> viewCandidatesByWard(@PathVariable int wardNumber, @PathVariable String electionName)
    {
        if(userService.viewCandidatesByWard(wardNumber, electionName).size()>0)
        {
            return  new ResponseEntity<>(userService.viewCandidatesByWard(wardNumber, electionName), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/elections/{electionName}")
    public ResponseEntity<List<Election>> getElectionByName(@PathVariable String electionName)
    {
        if(userService.getElectionByName(electionName).size()>0)
        {
            return new ResponseEntity<>(userService.getElectionByName(electionName), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/resultPage")
    public ResponseEntity<List<ResultPage>> resultPage()
    {
        List<ResultPage> resultPages = userService.resultPage();
        if(resultPages == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(resultPages));
        }
    }

    @PostMapping("/vote")
    public ResponseEntity<String> castVote(@RequestBody Vote vote)
    {

        return new ResponseEntity(userService.castVote(vote),HttpStatus.CREATED);
    }

    @GetMapping("/winner/{electionName}/{wardNumber}")
    public ResponseEntity<?> winner(@PathVariable String electionName, @PathVariable int wardNumber)
    {
        Winner  winner = userService.winner(electionName, wardNumber);
        if(winner == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(winner));
        }

    }

    @GetMapping("/results/{electionName}/{wardNumber}")
    public ResponseEntity<ResultDetailsPanel> resultDetails(@PathVariable String electionName, @PathVariable int wardNumber)
    {
        return  new ResponseEntity<>(userService.resultDetails(electionName, wardNumber), HttpStatus.OK);
    }

    @GetMapping("/votingPanel/{electionName}/{wardNumber}")
    public ResponseEntity<VotingPanel> viewVotingPanel(@PathVariable String electionName, @PathVariable String wardNumber)
    {
        return new ResponseEntity<>(userService.viewVotingPanel(electionName, wardNumber),HttpStatus.OK);
    }

    @GetMapping("/secretQuestion/{phoneNumber}")
    public ResponseEntity<?> getSecretQuestion(@PathVariable Long phoneNumber)
    {
        SecreteQuestionResponse question = userService.getSecretQuestion(phoneNumber);
        if(question == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(question));
        }
    }


    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception
    {

        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getPhoneNumber(),
                            jwtRequest.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getPhoneNumber());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JWTResponse(token);
    }

    //**************************otp*******************


    @Autowired

    EmailService emailService;

    @Autowired
    SmsService smsService;


    @PutMapping("/send2faCodeInEmail")
    public ResponseEntity<Object> send2faCodeInEmail( @RequestParam String email, @RequestParam String phoneNumber) throws MessagingException {
        String tfaCode =String.valueOf(new Random().nextInt(9999)+1000);
        emailService.sendEmail(email,tfaCode);
        userService.update2FAProperties(phoneNumber,tfaCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/send2faCodeInSMS/{email}")
    public ResponseEntity<Object> send2faCodeInSMS( @PathVariable String email, @RequestBody String phoneNumber)
    {
        String tfaCode =String.valueOf(new Random().nextInt(9999)+1000);
        smsService.sendSms(phoneNumber,tfaCode);
        userService.update2FAProperties(email,tfaCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/verify")
    public ResponseEntity<Object> verify(@RequestParam String phoneNumber, @RequestParam String code, @RequestParam String password)
    {
        boolean isValid = userService.checkCode(phoneNumber, code, password);
        if (isValid) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/verifyAnswer")
    public ResponseEntity<String> backupAnswer(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.backupAnswer(user),HttpStatus.OK);
    }
}
