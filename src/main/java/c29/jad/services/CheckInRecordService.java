package c29.jad.services;

import c29.jad.forms.CheckInRecordForm;
import c29.jad.models.CheckInRecordModel;
import c29.jad.repositories.CheckInRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Date;
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


        newCheckInRecord.setCheckInDate(new Date());
        newCheckInRecord.setCheckInAt(new Date());

//        if(checkInRecordForm.getCheckOutAt() != null){
//            newCheckInRecord.setCheckOutAt((checkInRecordForm.getCheckOutAt()));
//        }

        return checkInRecordRepository.saveAndFlush(newCheckInRecord);


    }

    public void updateCheckOutTime(Integer userId, Integer gymRoomId) {
        checkInRecordRepository.updateCheckOutTime(userId,gymRoomId);
    }

    public List<CheckInRecordModel> getAllRecords(Date startDate, Date endDate) {
        return checkInRecordRepository.getVisitor(startDate, endDate);
    }

    public List<CheckInRecordModel> getLiveCounts() {
        return checkInRecordRepository.getAllFlows();
    }

    public List<CheckInRecordModel> getOwnRecord(Integer userId) {
        return checkInRecordRepository.getCheckInTime(userId);
    }

    public List<String> getLastCheckInDate(Integer userId) {
        return checkInRecordRepository.getLastCheckIn(userId);
    }
}
