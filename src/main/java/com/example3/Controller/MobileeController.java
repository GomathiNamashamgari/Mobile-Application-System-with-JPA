package com.example3.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example3.Model.Mobilee;
import com.example3.Service.MobileeJpaService;

@RestController
public class MobileeController
{
	@Autowired
	private MobileeJpaService  mobileService;
  
   @GetMapping("/mobiles")
   public ArrayList<Mobilee> getMobiles()
	{
	  return mobileService.getMobiles();
	}
  
   @GetMapping("mobiles/{mobileId}")
   public Mobilee getMobileById(@PathVariable("mobileId") int mobileId)
	{
		return mobileService.getMobileById(mobileId);
	}
 
   @PostMapping("/mobiles/addnewmobile")
   public Mobilee addMobile(@RequestBody Mobilee mobile)
	{
		return mobileService.addMobile(mobile);
	}
  
   @PutMapping("mobiles/{mobileId}")
   public Mobilee updateMobile(@PathVariable("mobileId") int mobileId, @RequestBody Mobilee mobile)
   {
		return mobileService.updateMobile(mobileId, mobile);
   }
  
   @DeleteMapping("mobiles/{mobileId}")
   public void deleteMobile(@PathVariable("mobileId") int mobileId)
   {
   	mobileService.deleteMobile(mobileId);
   }
}

