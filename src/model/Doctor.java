package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Attributes
    private String speciality;
    private ArrayList<AvailableAppointment> AvailableAppointments = new ArrayList<>();

    public Doctor(String name, String email, String speciality){
        super(name,email);
        this.speciality = speciality;
    }

    //comportment
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public void addAvailableAppointment(String date, String time){

        AvailableAppointments.add(new AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return AvailableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nspeciality: "+ speciality+"\nAvailable: "+AvailableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointment \nDate: "+date+"\nTime: "+time;
        }
    }
}
