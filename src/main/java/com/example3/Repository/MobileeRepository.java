package com.example3.Repository;

import java.util.ArrayList;

import com.example3.Model.Mobilee;

public interface MobileeRepository
{
	ArrayList<Mobilee> getMobiles();
	Mobilee getMobileById(int mobileId);
	Mobilee addMobile(Mobilee mobile);
	Mobilee updateMobile(int mobileId, Mobilee mobile);
	void deleteMobile(int mobileId);
}

