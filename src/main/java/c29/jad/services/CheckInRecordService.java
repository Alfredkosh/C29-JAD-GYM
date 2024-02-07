package c29.jad.services;

import c29.jad.forms.CheckInRecordForm;
import c29.jad.models.CheckInRecordModel;
import c29.jad.repositories.CheckInRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.AuthenticationException;
import java.util.List;

@Service
public class CheckInRecordService {

    @Autowired
    CheckInRecordRepository checkInRecordRepository;

    public CheckInRecordModel checkIn(CheckInRecordForm checkInRecordForm) throws AuthenticationException{
        var newCheckInRecord = new CheckInRecordModel();
        if(checkInRecordForm.getUserId() != null){
            newCheckInRecord.setUserId((checkInRecordForm.getUserId()));
        }

        if(checkInRecordForm.getGymRoomId() != null){
            newCheckInRecord.setGymRoomId((checkInRecordForm.getGymRoomId()));
        }

        if(checkInRecordForm.getCheckInDate() != null){
            newCheckInRecord.setCheckInDate((checkInRecordForm.getCheckInDate()));
        }

        if(checkInRecordForm.getCheckInAt() != null){
            newCheckInRecord.setCheckInAt((checkInRecordForm.getCheckInAt()));
        }
        if(checkInRecordForm.getCheckOutAt() != null){
            newCheckInRecord.setCheckOutAt((checkInRecordForm.getCheckOutAt()));
        }

        return checkInRecordRepository.saveAndFlush(newCheckInRecord);


    }

    public List<CheckInRecordModel> getAllRecords(Integer gymRoomId) {

        return checkInRecordRepository.getVisitor(gymRoomId);
    }
}
