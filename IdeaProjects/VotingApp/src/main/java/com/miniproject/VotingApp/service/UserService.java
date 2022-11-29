package com.miniproject.VotingApp.service;
import com.miniproject.VotingApp.entity.*;
import com.miniproject.VotingApp.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserDetailsService
{
    @Autowired
    JdbcTemplate jdbcTemplate;


    // **************************************USER REGISTRATION*********************************
    public String userRegistration(User user)
    {
        try
        {
            String user_signup = "insert into user(phoneNumber,password,email,secretQuestion) values(?,?,?,?)";
            jdbcTemplate.update(user_signup, user.getPhoneNumber(), user.getPassword(), user.getEmail(),"Favourite colour");
            return "Registered successfully";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "You already have the account";
        }
    }

   // **************************************FORGET PASSWORD*********************************
   public SecreteQuestionResponse getSecretQuestion(Long phoneNumber)
   {
           try
           {
               String get_secrete_question = "select secretQuestion from user where phoneNumber = " + phoneNumber;
               return jdbcTemplate.queryForObject(get_secrete_question, new BeanPropertyRowMapper<>(SecreteQuestionResponse.class));
           }
           catch(Exception e)
           {
               System.out.println(e);
               return null;
           }
   }

    public String backupAnswer(User user)
    {
        try {
            jdbcTemplate.update("update user set secretAnswer=? where phoneNumber=?", user.getSecretAnswer(), user.getPhoneNumber());
            System.out.println(user.getSecretQuestion());
            return "Answer saved successfully";
        }catch (Exception e)
        {
            System.out.println(e);
            return "Plz...Correctly enter your answer";
        }
    }

    public String forgetPassword(Long phoneNumber, String secretAnswer, String password)
    {
            try
            {
                String check_if_answer_correct = "select secretAnswer from user where phoneNumber = " + phoneNumber;
                String answer = jdbcTemplate.queryForObject(check_if_answer_correct, String.class);
                System.out.println(answer);
                System.out.println(secretAnswer);
                if (answer.equalsIgnoreCase(secretAnswer))
                {
                    String update_password= "update user set password ='"+ password +"' where phoneNumber = " + phoneNumber;
                    jdbcTemplate.update(update_password);
                    return "Password changed successfully";
                }
                else
                {
                    return "Answer does not match the secret answer";
                }
            } catch (Exception e)
            {
                System.out.println(e);
                return null;
            }
    }

    // **************************************VOTER REGISTRATION*********************************
    public String voterRegistration(Voter voter)        //voter registration
    {
            String name = getUserNameFromToken();
        System.out.println(name);
            String voterId=jdbcTemplate.queryForObject("select voterId from voter where phoneNumber=?",String.class, new Object[]{name});
        System.out.println(voterId);
        System.out.println(voter.getVoterId());
            if(voterId.equals(voter.getVoterId()))
            {
                String fileName = StringUtils.cleanPath(voter.getProfilePhoto().getOriginalFilename());
                String downloadURL;
                if (voter.getAge() < 18)
                {
                    return "Age is below 18";
                }
                try
                {
                    if (fileName.contains(".."))
                    {
                        throw new Exception("No such file" + fileName);
                    }
                    downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/admin/image/")
                            .path(voter.getVoterId())
                            .toUriString();
                    String finalDownloadURL = downloadURL;
                    String voter_registration = "insert into voter(voterId,fullName,age,aadhaarNumber,phoneNumber,address,wardNumber,profilePhoto,photoUrl,gender) values(?,?,?,?,?,?,?,?,?,?)";
                    jdbcTemplate.update(voter_registration, voterId, voter.getFullName(), voter.getAge(), voter.getAadhaarNumber(), voter.getPhoneNumber(), voter.getAddress(), voter.getWardNumber(), voter.getProfilePhoto().getBytes(), finalDownloadURL, voter.getGender());
                    return "Voter registration successfully completed";
                }
                catch (Exception e)
                {
                    System.out.println("could not save file" + fileName);
                    e.printStackTrace();
                    return "Unable to register / Incorrect Information";
                }
            }
             return "Voter registration successfully completed";
    }

//    *****************************************   ELECTION    ****************************************************
    public List<Election> getElectionInformation()     // view election
    {
       try {
           String get_election_info = "select electionName,additionInformation,startDateTime,endDateTime from  election ";
           return jdbcTemplate.query(get_election_info, new BeanPropertyRowMapper<>(Election.class));
       }catch (Exception e)
       {
           System.out.println(e);
           return null;
       }

    }

    //__________________________________________________________________________________________________________________
    public List<Election> getElectionByName(String electionName)         //get election by election name
    {
        try
        {
            String get_election_info = "select electionName,startDateTime,startDateTime,endDateTime from  election where electionName='" + electionName + "'";
            return jdbcTemplate.query(get_election_info, new BeanPropertyRowMapper<>(Election.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //*********************************************    CANDIDATES  *****************************************************
    public List<Party> viewCandidatesByWard(int wardNumber,String electionName)         //get candidates information based on wards
    {
        try {
            String get_election_info = "select partyName,fullName,logoUrl,wardNumber,gender,age,electionName,partyStatus from party where wardNumber = " + wardNumber + " and electionName ='" + electionName + "'";
            return jdbcTemplate.query(get_election_info, new BeanPropertyRowMapper<>(Party.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //***********************************************************    HOME   ****************************************************************
    public List<HomePage> homePage()        //home page
    {
        try
        {
            LocalDateTime now = LocalDateTime.now();
            String HOME_SCREEN = "select electionName, startDateTime from election where startDateTime > '" + now + " 'order by  startDateTime asc";
            return jdbcTemplate.query(HOME_SCREEN, new BeanPropertyRowMapper<>(HomePage.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    // **************************************************************************  VOTING DETAILS   ***************************************************************************************
    public String castVote(Vote vote)
    {
        try
        {
            LocalDateTime now = LocalDateTime.now();
            Timestamp timings = Timestamp.valueOf(now);
            String get_startDate = "select startDateTime from election where electionName='" + vote.getElectionName() + "'";
            String get_endDate = "select endDateTime from election where electionName='" + vote.getElectionName() + "'";
            Timestamp startTime = jdbcTemplate.queryForObject(get_startDate, Timestamp.class);
            Timestamp endTime = jdbcTemplate.queryForObject(get_endDate, Timestamp.class);
            System.out.println(startTime);
            System.out.println(endTime);
            System.out.println(timings.after(startTime));
            System.out.println(timings.before(endTime));
            if (timings.after(startTime) && timings.before(endTime))
            {
                Candidate voter_details = jdbcTemplate.queryForObject("select wardNumber from voter where voterId ='" + vote.getVoterId() + "'", new BeanPropertyRowMapper<>(Candidate.class));
                Party party = jdbcTemplate.queryForObject("select wardNumber from party where partyName='" + vote.getPartyName() + "' and electionName = '" + vote.getElectionName() + "' and wardNumber ="+vote.getWardNumber(), new BeanPropertyRowMapper<>(Party.class));
                if (voter_details.getWardNumber() == vote.getWardNumber())
                {
                    if (party.getWardNumber() == vote.getWardNumber())
                    {
                        String cast_vote = "insert into vote(electionName,wardNumber,voterId,partyName) values(?,?,?,?)";
                        jdbcTemplate.update(cast_vote, vote.getElectionName(), vote.getWardNumber(), vote.getVoterId(), vote.getPartyName());
                        String get_count = "select voteCount from party where partyName = '" + vote.getPartyName() + "' and electionName ='" + vote.getElectionName() + "' and wardNumber = " + vote.getWardNumber() + "";
                        String vote_count = "update party set voteCount = voteCount + 1 where partyName = '" + vote.getPartyName() + "' and electionName = '" + vote.getElectionName() + "'  and wardNumber = " + vote.getWardNumber();
                        jdbcTemplate.update(vote_count);
                        return "You voted to " + vote.getPartyName() + " successfully";
                    }
                }
                return "Ward number does not match";
            }
            return "Date does not match..Election is closed now..";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "You have already voted or Incorrect Information";
        }
    }

    //___________________________________________________________________________________________________________________________________________________________________________
   public VotingPanel viewVotingPanel(String electionName, String wardNumber)
   {
       try
       {
           VotingPanel panel = jdbcTemplate.queryForObject("select electionName,startDateTime from election where electionName='" + electionName + "'", new BeanPropertyRowMapper<>(VotingPanel.class));
           List<VotingResponse> voting_response = jdbcTemplate.query("select party.logoUrl,party.partyName from party where electionName ='" + electionName + "' and wardNumber =" + wardNumber, new BeanPropertyRowMapper<>(VotingResponse.class));
           panel.setVotingResponse(voting_response);
           return panel;
       }
       catch (Exception e)
       {
           System.out.println(e);
           return  null;
       }

   }

    // ****************************************************************RESULT DETAILS*********************************************************************

    public List<ResultPage> resultPage()                                                                //result page
    {
        try
        {
            LocalDateTime now = LocalDateTime.now();
            String HOME_SCREEN = "select electionName,startDateTime from election where endDateTime < '" + now + " 'order by  startDateTime asc";
            return jdbcTemplate.query(HOME_SCREEN, new BeanPropertyRowMapper<>(ResultPage.class));
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //____________________________________________________________________________________________________________________________________________________
   public Winner winner(String electionName, int wardNumber)                                   //winner of the election
   {
       try
           {
               String winner = "select party.fullName,party.wardNumber,partyName,photoUrl,voteCount from party inner join voter on voter.voterId = party.voterId where voteCount = (select max(VoteCount) from party where electionName = '"+electionName+"' and party.wardNumber ="+wardNumber+") and electionName = '"+electionName+"'and party.wardNumber = "+wardNumber;
               return jdbcTemplate.queryForObject(winner, new BeanPropertyRowMapper<>(Winner.class));
           }catch (Exception e)
           {
               System.out.println(e);
               return null;
           }

   }

   //___________________________________________________________________________________________________________________________________________________________
    public ResultDetailsPanel resultDetails(String electionName, int wardNumber)                 //results of election
    {
            try
            {
                ResultDetailsPanel result_panel = jdbcTemplate.queryForObject("select electionName,startDateTime from election  where electionName = '" + electionName + "'", new BeanPropertyRowMapper<>(ResultDetailsPanel.class));
                List<ResultDetailsResponse> result_details = jdbcTemplate.query("select electionName,partyName,voteCount,fullname,wardNumber,party.logoUrl from party  where electionName = '" + electionName + "' and wardNumber=" + wardNumber + " order by voteCount desc", new BeanPropertyRowMapper<>(ResultDetailsResponse.class));
                result_panel.setResultResponse(result_details);
                return result_panel;
                //                String result_details = "select electionName,partyName,voteCount,fullname,wardNumber,party.logoUrl from party  where electionName = '" + electionName + "' and wardNumber=" + wardNumber + " order by voteCount desc";
//                return jdbcTemplate.query(result_details, new BeanPropertyRowMapper<>(ResultDetailsPanel.class));
            }
            catch (Exception e)
            {
                System.out.println(e);
                return null;
            }
    }

    //***************************************************    JWT    ******************************************************
    @Override
    public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException
    {
        String emailId = jdbcTemplate.queryForObject("select phoneNumber from user where phoneNumber=?", String.class, new Object[]{mobileNumber});
        String password = jdbcTemplate.queryForObject("select password from user where phoneNumber=?", String.class, new Object[]{mobileNumber});
        return new org.springframework.security.core.userdetails.User(emailId, password, new ArrayList<>());
    }


    //******************************************************  OTP  ****************************************************************************************
    public void update2FAProperties(String email, String tfacode)
    {
        jdbcTemplate.update("update user set twoFCode=?, expiryTime=? where email=?", new Object[]
                {
                        tfacode,(System.currentTimeMillis()/1000)+60,email
                });
    }

    //************************************************ VERIFY OTP AND UPDATE PASSWORD  ***********************************************************************
    public boolean checkCode(String phoneNumber,String code, String password)
    {
        try {
            boolean user_info = jdbcTemplate.queryForObject("select count(*) from user where twoFCode=? and phoneNumber=? and expiryTime>=?", new Object[]{code, phoneNumber, System.currentTimeMillis() / 1000}, Integer.class) > 0;
            String update_password = "update user set password ='" + password + "' where phoneNumber = '" + phoneNumber + "'";
            jdbcTemplate.update(update_password);
            return user_info;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public String getUserNameFromToken()
    {
        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        if (principal instanceof UserDetails)
        {
            String username = ((UserDetails)principal). getUsername();
            System.out.println(username);
            return username;
        }
        else
        {
            String username = principal.toString();
            return username;
        }
    }

}
