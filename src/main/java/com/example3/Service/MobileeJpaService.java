package com.example3.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example3.Model.Mobilee;
import com.example3.Repository.MobileeJpaRepository;
import com.example3.Repository.MobileeRepository;

@Service
public class MobileeJpaService implements MobileeRepository
{
	@Autowired
	private MobileeJpaRepository mobileJpaRepository;
	@Override
	public ArrayList<Mobilee> getMobiles()
	{
		List<Mobilee> mobileList=mobileJpaRepository.findAll();
		ArrayList<Mobilee> mobiles=new ArrayList<>(mobileList);
		return mobiles;
	}
	@Override
	public Mobilee getMobileById(int mobileId)
	{
		try
		{
		Mobilee mobile= mobileJpaRepository.findById(mobileId).get();
		return mobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public Mobilee addMobile(Mobilee mobile)
	{
		 mobileJpaRepository.save(mobile);
		 return mobile;
	}
	@Override
	public Mobilee updateMobile(int mobileId, Mobilee mobile) {
		
		try
		{
		Mobilee existingMobile= mobileJpaRepository.findById(mobileId).get();
		if(mobile.getName()!=null)
		{
			existingMobile.setName(mobile.getName());
		}
		if(mobile.getImage()!=null)
		{
			existingMobile.setImage(mobile.getImage());
		}
		 mobileJpaRepository.save(existingMobile);
		return existingMobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public void deleteMobile(int mobileId)
	{
		try
		{
		Mobilee mobile= mobileJpaRepository.findById(mobileId).get();
		if(mobile!=null)
		{
			mobileJpaRepository.deleteById(mobileId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
}

