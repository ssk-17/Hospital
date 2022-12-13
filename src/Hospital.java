public class Hospital {
    //unique id to identify the hospital
    String hospitalId;
    //4.3 out of 5
    Double rating;
    //DENTAL
    HospitalType type;

    Location hospitalLocation;

    Hospital(String id, Double rating, HospitalType type, Location loc){
        this.hospitalId = id;
        this.rating=rating;
        this.type = type;
        this.hospitalLocation=loc;
    }

    boolean isSlotAvailable(int num){
        //this will have logic to determine if the slot is available within the "num" days
        return true;
    }
}

enum HospitalType{
    DENTAL,
    ORTHOPEDICS,
    PAEDIATRIC
    // And more hospital types follow here
}

