package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Meeting;
import com.Blacat.Ouc.Repositories.MeetingRepository;

@Service
public class MeetingService {
	@Autowired
	private MeetingRepository meetingRepository;
	


}
