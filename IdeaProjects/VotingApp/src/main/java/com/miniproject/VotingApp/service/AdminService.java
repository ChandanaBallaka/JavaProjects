package com.miniproject.VotingApp.service;

import com.miniproject.VotingApp.entity.*;
import com.miniproject.VotingApp.request.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class AdminService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    boolean exist = false;
    int sessionId;

    //*************************************************  ADMIN REGISTRATION    *******************************************************
    public Boolean adminRegistration(Admin admin)               //admin registration
    {
        try {
            String admin_signup = "insert into admin(adminName,email,phoneNumber,password) values(?,?,?,?)";
            jdbcTemplate.update(admin_signup, admin.getAdminName() ,admin.getEmail() ,admin.getPhoneNumber(), admin.getPassword());
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }

    }

    // **************************************************       ADMIN LOGIN    ***************************************************
   public int adminLogin( Long phoneNumber, String password)
   {
       try
       {
           String admin_login = "select * from admin where phoneNumber = '" + phoneNumber + "' and password ='" + password + "'";
           jdbcTemplate.query(admin_login, new BeanPropertyRowMapper<>(String.class));
           sessionId = new Random().nextInt(1,100);
           return sessionId;
       }
       catch(Exception e)
       {
           System.out.println("User does not exist");
           return -1;
       }
   }

   // *********************************************************   ADMIN LOGOUT   *****************************************************************
   public String adminLogout(int sId)
   {
       if(sId == sessionId)
       {
           sessionId = 0;
           return "Logout successfully";
       }
       return "Incorrect Sid";
   }

   //**********************************************************     WARDS     ****************************************************************
   public String addWards(Ward ward, int sId)    //adding wards
   {
       if(sId == sessionId)
       {
           try
           {
               String insert_into_wards = "insert into ward(wardName) values (?)";
               jdbcTemplate.update(insert_into_wards, ward.getWardName());
               return "Ward successfully added";
           }
           catch(Exception e)
           {
                return "unable to add ward";
           }
       }
      return "Incorrect Session Id";
   }

    //_____________________________________________________________________________________________________________________________________________
   public String removeWards(int sId, int wardNumber)        //deleting wards
   {
       if(sId == sessionId)
       {
           try
           {
              String remove_wards = "delete from ward where wardNumber = " + wardNumber;
              int res=  jdbcTemplate.update(remove_wards);
              if(res == 0)
              {
                 return "Ward does not exist";
              }
               return "ward deleted successfully";
           }
           catch (Exception e)
           {
                return "Ward does not exist";
           }
       }
       return "Incorrect sessionId";
   }

   //__________________________________________________________________________________________________________________________________________________
    public List<Ward> getWardsInformation(int sId)              //view all wards
    {
        if(sId == sessionId)
        {
            String get_ward_info = "select * from ward ";
            return jdbcTemplate.query(get_ward_info ,new BeanPropertyRowMapper<>(Ward.class));
        }
        return null;
    }

    //____________________________________________________________________________________________________________________________________________________________
    public String updateWards(int sId, Ward ward)       //Edit wards
    {
        if(sId == sessionId)
        {
            try
            {
                String fetch_wardNumber = "select wardNumber from ward where wardNumber = " + ward.getWardNumber() ;
                int count = jdbcTemplate.queryForObject(fetch_wardNumber, Integer.class);
                 if(count > 0)
                 {
                     String update_wards = "update ward set wardName ='" + ward.getWardName() + "' where  wardNumber =" + ward.getWardNumber();
                     jdbcTemplate.update(update_wards);
                     return "Successfully changed ward name";
                 }
                 return "Please enter correct ward number";
            }
            catch (Exception e)
            {
                return "Enter valid ward number";
            }
        }
        return "Incorrect session Id";
    }

    //*******************************************************     VOTER    *****************************************************************************
    public String removeVoter(int sId, String voterId)         //removing voter from the list
    {
        if(sId == sessionId)
        {
            try
            {
                String remove_voter = "delete from voter where voterId = '"  + voterId + "'";
                int res =jdbcTemplate.update(remove_voter);
                if(res == 0)
                {
                    return "Voter does not exist in the list";
                }
                return "Voter removed from the list";
            }
            catch (Exception e)
            {
                return "Voter does not exist";
            }
        }
        return "Incorrect sessionId";
    }

    //********************************************************      ADD EXISTING PARTY     **************************************************************
    public String addExistingParty(ExistingParty existingParty, int sID)    //add existing party
    {
        if (sID == sessionId)
        {
            String fileName = StringUtils.cleanPath(existingParty.getPartyLogo().getOriginalFilename());
            String downloadURL;
            try
            {
                if(fileName.contains(".."))
                {
                    throw new Exception("No such file" + fileName);
                }
                downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/admin/logo/")
                        .path(existingParty.getPartyName())
                        .toUriString();
                String finalDownloadURL = downloadURL;
                String existing_party = "insert into existingparty(partyName,partyLogo,logoUrl) values(?,?,?)";
                jdbcTemplate.update(existing_party,existingParty.getPartyName(),existingParty.getPartyLogo().getBytes(),finalDownloadURL);
                return "Party added ";
            } catch (Exception e) {
                System.out.println("could not save file" + fileName);
                e.printStackTrace();
                return  "Party already exist";
            }
        }
        return "Incorrect sessionId";
    }

    //__________________________________________________________________________________________________________________________________________________________________
    public List<ExistingParty> viewAllExistingParty(int sId)
    {
        if(sId == sessionId)
        {
            try
            {
                String view_existing_party = "select partyName,logoUrl from existingparty";
                return jdbcTemplate.query(view_existing_party, new BeanPropertyRowMapper<>(ExistingParty.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }
    public byte[] getPartyLogo(String partyName)     //get party logo
    {
        String get_image = "select partyLogo from existingparty where partyName='" + partyName + "'";
        return jdbcTemplate.queryForObject(get_image,byte[].class);
    }

    public String getLogoUrl(String partyName, int sId)       //get party url
    {
        if(sId == sessionId)
        {
            try {
                String url = "select logoUrl from  existingparty where partyName='" + partyName + "'";
                return jdbcTemplate.queryForObject(url, String.class);
            }
            catch (Exception e)
            {
                return "Party does not exist";
            }
        }
        return "Incorrect SessionId";
    }

    //*******************************************************************     ELECTION    ********************************************************************************
    public String addElection(Election election, int sId)        //adding election
    {
        if(sId == sessionId)
        {
            System.out.println(sessionId);
            System.out.println(sId);
            try
            {
                String insert_into_election = "insert into election(electionName,additionInformation,startDateTime,endDateTime) values (?,?,?,?)";
                jdbcTemplate.update(insert_into_election,election.getElectionName(),election.getAdditionInformation(),election.getStartDateTime(),election.getEndDateTime());
                return "Election successfully added";
            }
            catch(Exception e)
            {
                System.out.println(e);
                return "Election already added";
            }
        }
        return "Incorrect Session Id";
    }

    //__________________________________________________________________________________________________________________________________________________________________________________________
    public List<Election> getElectionInformation(int sId)        //view election
    {
        if(sId == sessionId)
        {
            try
            {
                String get_election_info = "select electionName,additionInformation,startDateTime,endDateTime from election ";
                return jdbcTemplate.query(get_election_info, new BeanPropertyRowMapper<>(Election.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }

    //______________________________________________________________________________________________________________________________________________________________________________________________
    public List<Election> getElectionByName(int sId, String electionName)       // view election by name
    {
        if(sId == sessionId)
        {
            try
            {
                String get_election_info = "select electionName,startDateTime,startDateTime,endDateTime from election where electionName='" + electionName + "'";
                return jdbcTemplate.query(get_election_info, new BeanPropertyRowMapper<>(Election.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }

    //__________________________________________________________________________________________________________________________________________________________________________________________
    public String rescheduleElection(int sId, Election election)     //update election start date and endd ate
    {
        if(sId == sessionId)
        {
            try
            {
                String fetch_name = "select count(electionName) from election where electionName ='" + election.getElectionName() +"'";
                int count = jdbcTemplate.queryForObject(fetch_name, Integer.class);
                if(count > 0)
                {
                    String update_elections = "update election set startDateTime ='" + election.getStartDateTime() + "', endDateTime='" + election.getEndDateTime() + "' where electionName ='" + election.getElectionName() + "'";
                    jdbcTemplate.update(update_elections);
                    return "Election Rescheduled to " + election.getStartDateTime();
                }
                return "Election name does not exist, Please enter the correct Election name.";
            }
            catch (Exception e)
            {
                System.out.println(e);
                return "Election name does not exist";
            }
        }
        return "Incorrect session Id";
    }

    //________________________________________________________________________________________________________________________________________________________________________________________________________
    public String announceElectionResult(int sId, Election election)
    {
        if(sId == sessionId)
        {
            try {
                String fetch_name = "select count(electionName) from election where electionName ='" + election.getElectionName() + "'";
                int count = jdbcTemplate.queryForObject(fetch_name, Integer.class);
                if (count > 0) {
                    String announce_result = "update election set resultDateTime ='" + election.getResultDateTime() +  "' where electionName ='" + election.getElectionName() + "'";
                    jdbcTemplate.update(announce_result);
                    return "Election result will be announced on " + election.getResultDateTime();
                }
                return "Election name does not exist, Please enter the correct Election name.";
            } catch (Exception e)
            {
                System.out.println(e);
                return "Please enter the correct Election name";
            }
        }
        return "Incorrect Session Id";
    }

    //*********************************************************      VOTER        ***********************************************************************
    public List<Voter> getVotersInformation(int sId)     //get voter information
   {
        if(sId == sessionId)
        {
            try {
                String get_voter_info = "select voterId,fullName,address,aadhaarNumber,phoneNumber,wardNumber,gender,age,photoUrl from voter ";
                return jdbcTemplate.query(get_voter_info, new BeanPropertyRowMapper<>(Voter.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
       return null;
   }

   //______________________________________________________________________________________________________________________________________________________
    public List<Voter> viewVotersByWard(int wardNumber, int sId)      //view voters based on wards
    {
        if(sId == sessionId)
        {
            try {
                String get_voter_info = "select voterId,fullName,age,aadhaarNumber,phoneNumber,address,wardNumber from voter where wardNumber = '" + wardNumber + "'";
                return jdbcTemplate.query(get_voter_info, new BeanPropertyRowMapper<>(Voter.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }

   //___________________________________________________________________________________________________________________________________________________
   public List<Voter> getVotersByVoterId(String voterId, int sId)         //get voters by voter id
   {
       if(sId == sessionId)
       {
           try {
               String get_voter_info = "select voterId,fullName,address,aadhaarNumber,phoneNumber,wardNumber,gender,age,photoUrl from voter where voterId = '" + voterId + "'";
               return jdbcTemplate.query(get_voter_info, new BeanPropertyRowMapper<>(Voter.class));
           }catch (Exception e)
           {
               System.out.println(e);
           }
       }
       return null;
   }

   //_____________________________________________________________________________________________________________________________________________________________
    public List<Voter> getVotersByWard(int wardNumber, int sId)         //get voters by ward
    {
        if(sId == sessionId)
        {
            try {
                String get_voter_info = "select voterId,fullName,address,aadhaarNumber,phoneNumber,wardNumber,gender,age,photoUrl from voter where wardNumber = " + wardNumber;
                return jdbcTemplate.query(get_voter_info, new BeanPropertyRowMapper<>(Voter.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }



   //*****************************************************         USER         *********************************************************************
    public List<User> viewAllUser(int sId)      //view all users
    {
        if(sId == sessionId)
        {
            try {
                String view_users = "select * from user ";
                return jdbcTemplate.query(view_users, new BeanPropertyRowMapper<>(User.class));
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }

    //*******************************************************          PARTY             *******************************************************************
    public String addParties(Party party, int sID) throws IOException          //add candidates to party
    {
        if (sID == sessionId)
        {
            try {
                if (party.getPartyStatus().equalsIgnoreCase("existing")) {
                    int party_count = jdbcTemplate.queryForObject("select count(*) from existingparty where partyName ='" + party.getPartyName() + "'", Integer.class);
                    if (party_count > 0) {
                        exist = true;
                    }
                } else {
                    if (party.getPartyStatus().equalsIgnoreCase("new")) {
                        String URL = ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("/admin/logo/")
                                .path(party.getPartyName())
                                .toUriString();
                        String existing_party = "insert into existingparty(partyName,partyLogo,logoUrl) values(?,?,?)";
                        jdbcTemplate.update(existing_party, party.getPartyName(), party.getPartyLogo().getBytes(), URL);
                    }
                    exist = true;
                }
                if (exist)
                {
                    String fileName = StringUtils.cleanPath(party.getPartyLogo().getOriginalFilename());
                    String downloadURL;
                    String get_voter_info = "select fullName,age,gender,wardNumber from voter where voterId='" + party.getVoterId() + "'";
                    Candidate candidate = jdbcTemplate.queryForObject(get_voter_info, new BeanPropertyRowMapper<>(Candidate.class));
                    if (party.getAge() < 18) {
                        System.out.println("Age is less than 18");
                        return "Age is less than 18";
                    }
                    try {
                        if (fileName.contains("..")) {
                            throw new Exception("No such file" + fileName);
                        }
                        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("/admin/logo/")
                                .path(party.getPartyName())
                                .toUriString();
                        String finalDownloadURL = downloadURL;
                        if (candidate.getFullName().equalsIgnoreCase(party.getFullName()) && candidate.getAge() == party.getAge() && candidate.getGender().equalsIgnoreCase(party.getGender()) && candidate.getWardNumber() == party.getWardNumber()) {
                            String add_party = "insert into party(partyName,fullName,wardNumber,electionName,partyLogo,logoUrl,voterId,gender,age,voteCount,partyStatus) values(?,?,?,?,?,?,?,?,?,?,?)";
                            jdbcTemplate.update(add_party, party.getPartyName(), party.getFullName(), party.getWardNumber(),party.getElectionName(), party.getPartyLogo().getBytes(), finalDownloadURL, party.getVoterId(), party.getGender(), party.getAge(), party.getVoteCount(), party.getPartyStatus());
                            return "Party successfully added";
                        }
                    } catch (Exception e) {
                        System.out.println("could not save file" + fileName);
                        e.printStackTrace();
                        return "Unable to save file";
                    }
                }
                return "Party exists / Incorrect Information";
            } catch (Exception e) {
                System.out.println(e);
                return "Duplicate entry";
            }
        }
        return "Invalid Session Id";
    }

    //______________________________________________________________________________________________________________________________________________________________________________________
    public byte[] getProfilePhoto(String voterId)                   //get profile photo
    {
        try
        {
            String get_image = "select profilePhoto from voter where voterId='" + voterId + "'";
            return jdbcTemplate.queryForObject(get_image, byte[].class);
        }catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //________________________________________________________________________________________________________________________________________________________________________________________________
    public String getImageUrl(String voterId, int sId)             //get profile url
    {
        if(sId == sessionId)
        {
            try
            {
                String url = "select photoUrl from voter where voterId='" + voterId + "'";
                return jdbcTemplate.queryForObject(url, String.class);
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return "Incorrect SessionId";
    }

    //*************************************************************        HOME        **************************************************************
    public List<HomePage> homePage(int sId)                        //home page
    {
        if(sId==sessionId)
        {
            try
            {
                LocalDateTime now = LocalDateTime.now();
                LocalDate date = LocalDate.now();
                System.out.println(date);
                String HOME_SCREEN = "select electionName, startDateTime from election where startDateTime > '" + now + " 'order by  startDateTime asc";
                return jdbcTemplate.query(HOME_SCREEN, new BeanPropertyRowMapper<>(HomePage.class));
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return null;
    }
}
