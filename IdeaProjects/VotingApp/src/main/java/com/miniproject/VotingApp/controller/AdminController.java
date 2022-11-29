package com.miniproject.VotingApp.controller;

import com.miniproject.VotingApp.entity.*;
import com.miniproject.VotingApp.request.HomePage;
import com.miniproject.VotingApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<String> adminRegistration(@RequestBody Admin admin)
    {
        Boolean status = adminService.adminRegistration(admin);
        if(status == true)
            return new ResponseEntity("Registered successfully", HttpStatus.CREATED) ;
        return new ResponseEntity<>("You already have the account",HttpStatus.ALREADY_REPORTED);
    }

    @PostMapping("/signIn/{phoneNumber}/{password}")
    public ResponseEntity<Integer> adminLogin(@PathVariable Long phoneNumber, @PathVariable String password)
    {
        return new ResponseEntity(adminService.adminLogin(phoneNumber,password),HttpStatus.ACCEPTED);
    }

    @PostMapping("/wards/{sId}")
    public ResponseEntity<String> addWards(@RequestBody Ward ward, @PathVariable int sId)
    {
       // return new ResponseEntity(adminService.addWards(ward, sId), HttpStatus.CREATED);
         if(adminService.addWards(ward, sId).equalsIgnoreCase("unable to add ward"))
         {
             return new ResponseEntity<>(adminService.addWards(ward, sId),HttpStatus.ALREADY_REPORTED);
         }
         return new ResponseEntity<>("Ward successfully added",HttpStatus.CREATED);
    }

    @DeleteMapping("/logout/{sId}")
    public String adminLogout(@PathVariable int sId)
    {
        return adminService.adminLogout(sId);
    }

    @GetMapping("/voters/{sId}")
    public ResponseEntity<List<Voter>> getVotersInformation(@PathVariable int sId)
    {
        List<Voter> voters = adminService.getVotersInformation(sId);
        if(voters == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(voters));
        }
    }

    @PostMapping("/elections/{sId}")
    public ResponseEntity<String> addElection(@RequestBody Election election, @PathVariable int sId)
    {
        return new ResponseEntity(adminService.addElection(election,sId), HttpStatus.CREATED);
    }

    @GetMapping("/elections/{sId}")
    public ResponseEntity<List<Election>> getElectionInformation(@PathVariable int sId)
    {
        List<Election> election = adminService.getElectionInformation(sId);
        if(election == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(election));
        }
    }

    @GetMapping("/wards/{sId}")
    public ResponseEntity<List<Ward>> getWardsInformation(@PathVariable int sId)
    {
        List<Ward> wards = adminService.getWardsInformation(sId);
        if(wards == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(wards));
        }
    }

    @DeleteMapping("/wards/{sId}")
    public ResponseEntity<String> removeWards(@PathVariable int sId, @RequestBody int wardNumber)
    {
        return  ResponseEntity.status( HttpStatus.ACCEPTED).body(adminService.removeWards(sId, wardNumber));
    }

    @PutMapping("/elections/{sId}")
    public ResponseEntity<String> updateElection(@PathVariable int sId, @RequestBody Election election)
    {
        return new ResponseEntity<>(adminService.rescheduleElection(sId, election), HttpStatus.CREATED);
    }

    @PatchMapping("/electionResult/{sId}")
    public ResponseEntity<String> announceElectionResult(@PathVariable int sId, @RequestBody Election election)
    {
        return new ResponseEntity<>(adminService.announceElectionResult(sId, election), HttpStatus.CREATED);
    }

    @PatchMapping("/wards/{sId}")
    public ResponseEntity<String> updateWards(@PathVariable int sId, @RequestBody Ward ward)
    {
        return new ResponseEntity<>(adminService.updateWards(sId, ward), HttpStatus.CREATED);
    }

    @PostMapping("/parties/{sID}")
    public ResponseEntity<String> addParties(@ModelAttribute Party party, @PathVariable int sID) throws IOException {
        return new ResponseEntity<>(adminService.addParties(party, sID), HttpStatus.CREATED);
    }

    @GetMapping("/Users/{sId}")
    public ResponseEntity<List<User>> viewAllUser(@PathVariable int sId)
    {
        List<User> user = adminService.viewAllUser(sId);
        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(user));
        }
    }

    @GetMapping("/users/{voterId}/{sId}")
    public ResponseEntity<List<Voter>> getVotersByVoterId(@PathVariable String voterId, @PathVariable int sId)
    {
        List<Voter> voters = adminService.getVotersByVoterId(voterId, sId);
        if(voters == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(voters));
        }
    }

    @GetMapping("/elections/{sId}/{electionName}")
    public ResponseEntity<List<Election>> getElectionByName(@PathVariable int sId, @PathVariable String electionName)
    {
        if(adminService.getElectionByName(sId,electionName).size()>0)
        {
            return new ResponseEntity<>(adminService.getElectionByName(sId,electionName), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/existingParty/{sId}")
    public ResponseEntity<List<ExistingParty>> viewAllExistingParty(@PathVariable int sId)
    {
        List<ExistingParty> exists = adminService.viewAllExistingParty(sId);
        if(exists == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(exists));
        }
    }

    @GetMapping("/url/{voterId}/{sId}")
    public ResponseEntity<String> getImageUrl(@PathVariable String voterId, @PathVariable int sId)
    {
        return new ResponseEntity<>(adminService.getImageUrl(voterId, sId), HttpStatus.OK);
    }

    @GetMapping("/logo/{partyName}/{sId}")
    public ResponseEntity<String> getLogoUrl(@PathVariable String partyName, @PathVariable int sId)
    {
        return new ResponseEntity<>(adminService.getLogoUrl(partyName,sId), HttpStatus.OK);
    }



    @GetMapping("/image/{voterId}")
    public ResponseEntity<Resource> getMyProfilePhoto(@PathVariable String voterId) throws IOException
    {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png")).header("Content-Disposition","filename=\"" + voterId + ".png" +"\"").body(new ByteArrayResource(adminService.getProfilePhoto(voterId)));
    }

    @GetMapping("/logo/{partyName}")
    public ResponseEntity<Resource> getPartyLogo(@PathVariable String partyName)
    {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png")).header("Content-Disposition","filename=\"" + partyName + ".png" +"\"").body(new ByteArrayResource(adminService.getPartyLogo(partyName)));
    }

    @DeleteMapping("/voter/{sId}")
    public ResponseEntity<String> removeVoter(@PathVariable int sId, @RequestBody String voterId)
    {
        return  ResponseEntity.status( HttpStatus.ACCEPTED).body(adminService.removeVoter(sId, voterId));
    }

    @GetMapping("/home/{sId}")
    public ResponseEntity<List<HomePage>> homePage(@PathVariable int sId)
    {
        List<HomePage>home = adminService.homePage(sId);
        if(home==null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(home));
        }
    }

    @GetMapping("/{wardNumber}/{sId}")
    public ResponseEntity<List<Voter>> viewVotersByWard(@PathVariable int wardNumber, @PathVariable int sId)
    {
        List<Voter> voters = adminService.viewVotersByWard(wardNumber, sId);
        if(voters == null)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(voters));
        }
    }

    @PostMapping("/existing/{sID}")
    public ResponseEntity<String> addExistingParty(@ModelAttribute ExistingParty existingParty, @PathVariable int sID)
    {
        return new ResponseEntity(adminService.addExistingParty(existingParty, sID),HttpStatus.CREATED);
    }

    @GetMapping("/voters/{wardNumber}/{sId}")
    public ResponseEntity<List<Voter>> getVotersByWard(@PathVariable int wardNumber, @PathVariable int sId)
    {
        if(adminService.getVotersByWard(wardNumber, sId).size()>0)
        {
            return new ResponseEntity<>(adminService.getVotersByWard(wardNumber, sId), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
