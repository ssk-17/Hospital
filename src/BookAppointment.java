import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookAppointment {

    Hospital bookAppointment(HospitalType issue, float radius, Location homeLocation, int days){
        //fetch all hospitals
        List<Hospital> allHospitals = getAllHospitals();

        //firstly filter the hospitals with given issue type and radius
        List<Hospital> filteredHospitals = new ArrayList<>();
        for(Hospital hospital: allHospitals){
            if(hospital.type==issue ||
                    Location.getDistance(hospital.hospitalLocation, homeLocation)<=radius)
                filteredHospitals.add(hospital);
        }

        //sort the hospitals based on the criteria
        Collections.sort(filteredHospitals, (h1, h2)-> {
            //first give preference to rating and then to distance
            return h1.rating!=h2.rating?(int)(h2.rating-h1.rating):
                    (int)(Location.getDistance(homeLocation, h1.hospitalLocation)-
                            Location.getDistance(homeLocation, h2.hospitalLocation));
        });

        //iterate through the hospitals to find the available timeSlot
        for(Hospital hospital: filteredHospitals){
            if(hospital.isSlotAvailable(days))
                return hospital;
        }
        return null;
    }


    List<Hospital> getAllHospitals(){

        //In production level code, this list will be fetched from database.
        Hospital h1 = new Hospital("1", 4.3, HospitalType.ORTHOPEDICS, new Location());
        Hospital h2 = new Hospital("2", 3.5, HospitalType.ORTHOPEDICS, new Location());
        Hospital h3 = new Hospital("3", 4.4, HospitalType.DENTAL, new Location());
        Hospital h4 = new Hospital("4", 4.4, HospitalType.PAEDIATRIC, new Location());

        List<Hospital> list = new ArrayList<>();
        list.add(h1);list.add(h2);
        list.add(h3);list.add(h4);

        return list;
    }
}
